package com.corso.spring.web.controller;

import com.corso.model.Utente;
import com.corso.service.UtenteService;
import com.corso.vo.FormLogin;
import com.corso.vo.FormUtenteModificato;
import com.corso.vo.FormRegistrazione;
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
public class ControllerUtente {

	@Autowired
	UtenteService utenteService;

	@GetMapping(path={"/", "/home.html"})
	public String home(HttpSession session) {
		System.out.println("passaggio dal controller metodo home");
		return "home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("passaggio dal controller metodo logout");
		session.removeAttribute("utente");
		session.invalidate();
		return "home";
	}

	@GetMapping(path={"/formRegistrazione.html"})
	public String formRegistrazione(Model model) {
		System.out.println("passaggio dal controller metodo formRegistrazione");
		model.addAttribute("registrazioneUtente", new FormRegistrazione());

		return "formRegistrazione";
	}

	@PostMapping("/add")
	public String add(HttpSession session, @ModelAttribute("registrazioneUtente") @Valid FormRegistrazione registrazione,
					  BindingResult bindingResult, Model model) {
		System.out.println("passaggio dal controller metodo add");
		// Verifica se ci sono errori di validazione
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Ci sono errori, ricompila!!");
			return "formRegistrazione";
		}

		System.out.println("dto: " + registrazione);

		Utente utente = new Utente(registrazione.getEmail(), registrazione.getPassword(),
				registrazione.getNome(), registrazione.getCognome(), registrazione.getNazione(),
				registrazione.getPrefisso(), registrazione.getTelefono());

		if (utenteService.addUtente(utente)){
			session.removeAttribute("registrazioneUtente");
			session.setAttribute("utente", utente);
			return "formLogin";
		} else {
			// visualizzare che la mail è già presente nel db
			return "formRegistrazione";
		}
	}

	@GetMapping(path={"/formLogin.html"})
	public String formLogin(Model model) {
		System.out.println("passaggio dal controller metodo formLogin");
		model.addAttribute("loginUtente", new FormLogin());

		return "formLogin";
	}

	@PostMapping("/login")
	public String login(HttpSession session, @ModelAttribute("loginUtente") @Valid FormLogin login,
					  BindingResult bindingResult, Model model) {
		System.out.println("passaggio dal controller metodo login");
		session.setMaxInactiveInterval(1000*120) ; // durata timeout

		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Non è possibile effettuare il login");
			return "formLogin";
		}

		System.out.println("dto: " + login);

		boolean trovatoInDb =  utenteService.login(login.getEmail(),login.getPassword()) ;
		if (trovatoInDb) {
			session.removeAttribute("loginUtente");

			Utente utente = utenteService.getUtenteByEmail(login.getEmail());
			session.setAttribute("utente",utente);
			model.addAttribute(utente);

			return "home";
		}
		return "formLogin";
	}

	@GetMapping(path={"/profilo.html"})
	public String profilo(HttpSession session, Model model) {
		Utente userSession = (Utente) session.getAttribute("utente");
		model.addAttribute(userSession);
		return "profilo";
	}


	@GetMapping(path={"/formModificaProfilo.html"})
	public String formModificaProfilo(Model model) {
		System.out.println("passaggio dal controller metodo formModificaProfilo");
		model.addAttribute("modificaUtente", new FormUtenteModificato());

		return "formModificaProfilo";
	}

	@PostMapping("/modificaProfilo")
	public String modificaProfilo(HttpSession session,
								  @ModelAttribute("utenteModificato") @Valid FormUtenteModificato formUtenteModificato,
								  BindingResult bindingResult, Model model) {
		System.out.println("passaggio dal controller metodo modificaProfilo");

		String email = ((Utente)session.getAttribute("utente")).getEmail();
		session.removeAttribute("utente");

		// Verifica se ci sono errori di validazione
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Ci sono errori, ricompila!!");
			return "formModificaProfilo";
		}

		System.out.println("dto: " + formUtenteModificato);

		Utente utente = new Utente(email,formUtenteModificato.getPassword(), formUtenteModificato.getNome(),
				formUtenteModificato.getCognome(), formUtenteModificato.getNazione(),
				formUtenteModificato.getPrefisso(), formUtenteModificato.getTelefono());

		if (utenteService.updateUtente(utente)){
			session.removeAttribute("modificaUtente");
			session.setAttribute("utente", utente);
			model.addAttribute(utente);
			return "profilo";
		} else {
			return "formModificaProfilo";
		}
	}

	/*@PostMapping("/editProfilo")
	public String editProfilo (HttpSession session ,@ModelAttribute("utenteModificato") @Valid FormUtenteModificato utenteModificato,
							   BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Ci sono errori, ricompila!!");
			return "profilo";
		}

		String email = ((Utente) session.getAttribute("utente")).getEmail() ;
		Utente utente = new Utente(email, utenteModificato.getPassword(), utenteModificato.getNome(),
				utenteModificato.getCognome(), utenteModificato.getNazione(), utenteModificato.getPrefisso(),
				utenteModificato.getTelefono());

		utenteService.updateUtente(utente) ;
		session.setAttribute("utente", utente);



	}*/

	@PutMapping("/deleteProfilo")
	public String deleteProfile (HttpSession session) {
		boolean cancellato = utenteService.delete( (Utente) session.getAttribute("utente")) ;
		if (cancellato) {
			return "home" ;
		}
		else {
			return "profilo" ;
		}
	}







}