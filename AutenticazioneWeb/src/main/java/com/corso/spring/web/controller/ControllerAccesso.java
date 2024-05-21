package com.corso.spring.web.controller;

import com.corso.model.Utente;
import com.corso.service.UtenteService;
import com.corso.vo.FormUtenteModificato;
import com.corso.vo.FormRegistrazione;
import com.corso.vo.RegistrazioneBE;
import com.corso.vo.UtenteModificatoBE;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ControllerAccesso {

	@Autowired
	UtenteService utenteService;

	@GetMapping(path={"/", "/index"})
	public String index(HttpServletRequest httpreq) {
		System.out.println("passaggio dal controller metodo index");
		return "index";
	}

	@GetMapping("/Logout")
	public String faiLogout(HttpServletRequest httpreq) {
		HttpSession session = httpreq.getSession();
		session.removeAttribute("email");
		session.invalidate();
		return "index";
	}

	// Use Web Param
	// Use as Argument HttpSession instead of using HttpServlet Request
	@PostMapping("/loginUser")
	public String logingUser(HttpServletRequest httpreq) {
		// session attributes
		HttpSession session = httpreq.getSession();
		session.setMaxInactiveInterval(1000*120) ; // durata timeout
		//String emailSession = (String) session.getAttribute("email");
		String emailParam = httpreq.getParameter("email");
		String passParam = httpreq.getParameter("password");
		System.out.println("Controller arguments email and password : "+ emailParam + passParam);
		boolean trovatoInDb =  utenteService.Login(emailParam,passParam) ;
		if (trovatoInDb) {
			// DA RIVEDERE
			session.setAttribute("email",emailParam);
			session.setAttribute("password",passParam);
			System.out.println("trovato nel db");
			return "home" ;
		}
		return "login";
	}
	// solo la pagina login
	@GetMapping(path={"/login", "/login.html"})
	public String login(HttpServletRequest httpreq) {
        HttpSession session = httpreq.getSession();
		String emailsession = (String) session.getAttribute("email");
		// se è stato gia settato nella session l'attributo email , passa al home subito
		if (emailsession != null) {
			return "home" ;
		}
		return "login" ;
	}

	@GetMapping("/home")
	public String home() {
		System.out.println("passaggio dal controller metodo home");
		return "home";
	}

	@PostMapping("/editProfilo")
	public String editProfilo (HttpSession session ,@ModelAttribute("utenteModificatro") @Valid FormUtenteModificato utenteModificato,
							   BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Ci sono errori, ricompila!!");
			return "profilo";
		}

		UtenteModificatoBE uBE = new UtenteModificatoBE();
		BeanUtils.copyProperties(utenteModificato, uBE);
		String email = ((Utente) session.getAttribute("utente")).getEmail() ;
		Utente utente = new Utente(email, uBE.getPassword(), uBE.getNome(), uBE.getCognome(),
				uBE.getNazione(), uBE.getPrefisso(), uBE.getTelefono());

		utenteService.updateUtente(utente) ;
		session.setAttribute("utente", utente);

		/*session.setAttribute("email",utente.getEmail());
		session.setAttribute("password",utente.getPassword());
		session.setAttribute("nome",utente.getNome());
		session.setAttribute("cognome",utente.getCognome());
		session.setAttribute("telefonoAndprefisso", utente.getPrefisso().concat(utente.getTelefono()));
		session.setAttribute("telofono",utente.getTelefono());
		session.setAttribute("prefisso",utente.getPrefisso());
		session.setAttribute("nazione", utente.getNazione());
		Utente utenteDettagliSession = new Utente((String) session.getAttribute("email"),
                (String) session.getAttribute("password"),
                (String) session.getAttribute("nome"),
                (String) session.getAttribute("cognome"),
                (String) session.getAttribute("nazione"),
                (String) session.getAttribute("telefono"),
                (String) session.getAttribute("prefisso")
        );
		session.setAttribute("userdetails",utenteDettagliSession);*/
		return "login";
//		boolean modificato = utenteService.updateUtente(utenteModificato) ;
//		if (modificato) {
//             session.setAttribute("message" , "Utente " + utenteModificato.getEmail() + "è stato aggiornato con sucesso");
//			return "profilo" ;
//		}
//		else {
//			session.setAttribute("message" , "Utente " + utenteModificato.getEmail() + " non è stato aggiornato, prova di nuovo");
//			return "profilo" ;
//		}
	}

	@PutMapping("/deleteProfilo")
	public String deleteProfile (HttpSession session) {
		boolean cancellato = utenteService.delete( (Utente) session.getAttribute("utente")) ;
		if (cancellato) {
			return "index" ;
		}
		else {
			return "profilo" ;
		}
	}


	@GetMapping("/profilo" )
	// Todo : Controllare chi è il piu veloce nel recuperare l'utente, se via db o via session ?
	public String profilo(HttpServletRequest httpreq ) {
		HttpSession session = httpreq.getSession();
		Utente UserSession = (Utente) session.getAttribute("utente");
		// via la session
		if (!(UserSession == null)) { // se la session ha memorizzato un userDetails (nel metodo add)
			httpreq.setAttribute("utente",UserSession);
			return "profilo" ;
        }
		else {
			// via il db
			String emailsession = (String) session.getAttribute("email") ;
			Utente utenteDB = utenteService.getUtenteByEmail(emailsession);
			httpreq.setAttribute("utente",utenteDB);
			return "profilo";
		}
	}

	@GetMapping(path = {"/formRegistrazione"})
	public String formRegistrazione(Model model) {

		model.addAttribute("utente", new FormRegistrazione());

		return "formRegistrazione";
		//return "redirect:/"
	}

	@PostMapping("/add")
	public String add(HttpSession session ,@ModelAttribute("utente") @Valid FormRegistrazione registrazione,
					  BindingResult bindingResult, Model model) {
		String emailsession = (String) session.getAttribute("email") ;

		// Verifica se ci sono errori di validazione
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Ci sono errori, ricompila!!");
			return "formRegistrazione";
		}

		RegistrazioneBE rBE = new RegistrazioneBE();
		BeanUtils.copyProperties(registrazione, rBE);
		System.out.println("dto: " + rBE);

		Utente utente = new Utente(rBE.getEmail(), rBE.getPassword(), rBE.getNome(), rBE.getCognome(),
				rBE.getNazione(), rBE.getPrefisso(), rBE.getTelefono());

		utenteService.addUtente(utente);
		//model.addAttribute("utente", utente);
		session.setAttribute("utente", utente);

		/*session.setAttribute("email",utente.getEmail());
		session.setAttribute("password",utente.getPassword());
		session.setAttribute("nome",utente.getNome());
		session.setAttribute("cognome",utente.getCognome());
		session.setAttribute("telefonoAndprefisso", utente.getPrefisso().concat(utente.getTelefono()));
		session.setAttribute("telofono",utente.getTelefono());
		session.setAttribute("prefisso",utente.getPrefisso());
		session.setAttribute("nazione", utente.getNazione());
		Utente utenteDettagliSession = new Utente((String) session.getAttribute("email"),
                (String) session.getAttribute("password"),
                (String) session.getAttribute("nome"),
                (String) session.getAttribute("cognome"),
                (String) session.getAttribute("nazione"),
                (String) session.getAttribute("telefono"),
                (String) session.getAttribute("prefisso")
        );
		session.setAttribute("userdetails",utenteDettagliSession);*/
		return "login";
	}


}