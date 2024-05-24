package com.corso.spring.web.controller;

import com.corso.model.Utente;
import com.corso.service.UtenteService;
import com.corso.vo.FormLogin;
import com.corso.vo.FormUtenteModificato;
import com.corso.vo.FormRegistrazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	@GetMapping(path={"/","/home"})
	public String home(HttpSession session) {
		System.out.println("passaggio dal controller metodo home");

		return "home";
	}

	@GetMapping(path={"/registrazione"})
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

	@GetMapping(path={"/login"})
	public String login(Model model) {
		System.out.println("passaggio dal controller metodo formLogin");
		model.addAttribute("loginUtente", new FormLogin());

		return "formLogin";
	}

	@PostMapping("/accedi")
	public String accedi(HttpSession session, @ModelAttribute("loginUtente") @Valid FormLogin login,
					  BindingResult bindingResult, Model model) {
		System.out.println("passaggio dal controller metodo login");
		session.setMaxInactiveInterval(1000*120) ; // durata timeout

		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Non è possibile effettuare il login");
			return "formLogin";
		}

		boolean trovatoInDb =  utenteService.login(login.getEmail(),login.getPassword()) ;
		if (trovatoInDb) {

			Utente utente = utenteService.getUtenteByEmail(login.getEmail());
			session.setAttribute("utente",utente);
			//model.addAttribute(utente);

			return "redirect:/home";
		} else {
			model.addAttribute("message", "Credenziali errate");
			return "formLogin";
		}
	}

	@GetMapping(path={"/profilo"})
	public String profilo(HttpSession session, Model model) {
		Utente userSession = (Utente) session.getAttribute("utente");
		model.addAttribute(userSession);
		return "profilo";
	}


	@GetMapping(path={"/modifica_profilo"})
	public String modificaProfilo(HttpSession session, Model model) {
		System.out.println("passaggio dal controller metodo formModificaProfilo");
		Utente u = (Utente)session.getAttribute("utente");
		model.addAttribute("modificaUtente", u);

		return "formModificaProfilo";
	}

	@PostMapping({"/modifica"})
	public String modificaProfilo(HttpSession session, @ModelAttribute("utenteModificato") @Valid FormUtenteModificato formUtenteModificato, BindingResult bindingResult, Model model) {
		System.out.println("passaggio dal controller metodo modificaProfilo");
		Utente u = (Utente)session.getAttribute("utente");
		String email = u.getEmail();
		session.removeAttribute("utente");
		String psw = "";
		String nome = "";
		String cognome = "";
		String nazione = "";
		String prefisso = "";
		String tel = "";
		System.out.println("nostra signora d'europa per Farouk: " + formUtenteModificato.getPassword());
		if (formUtenteModificato.getPassword().equals("")) {
			psw = u.getPassword();
		} else {
			psw = formUtenteModificato.getPassword();
		}

		if (formUtenteModificato.getNome().equals("")) {
			nome = u.getNome();
		} else {
			nome = formUtenteModificato.getNome();
		}

		if (formUtenteModificato.getCognome().equals("")) {
			cognome = u.getCognome();
		} else {
			cognome = formUtenteModificato.getCognome();
		}

		if (formUtenteModificato.getNazione().equals("")) {
			nazione = u.getNazione();
		} else {
			nazione = formUtenteModificato.getNazione();
		}

		if (formUtenteModificato.getPrefisso().equals("")) {
			prefisso = u.getPrefisso();
		} else {
			prefisso = formUtenteModificato.getPrefisso();
		}

		if (formUtenteModificato.getTelefono().equals("")) {
			tel = u.getTelefono();
		} else {
			tel = formUtenteModificato.getTelefono();
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Ci sono errori, ricompila!!");
			return "formModificaProfilo";
		} else {
			System.out.println("dto: " + formUtenteModificato);
			Utente utente = new Utente(email, psw, nome, cognome, nazione, prefisso, tel);
			if (this.utenteService.updateUtente(utente)) {
				session.removeAttribute("modificaUtente");
				session.setAttribute("utente", utente);
				model.addAttribute(utente);
				return "profilo";
			} else {
				return "formModificaProfilo";
			}
		}
	}


	@GetMapping("/elimina_utente")
	public String eliminaUtente(HttpSession session) {
		Utente utente = (Utente) session.getAttribute("utente");
		utenteService.delete(utente.getEmail());
		session.removeAttribute("utente");
		session.invalidate();
		return "home";

	}


	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("passaggio dal controller metodo logout");
		session.removeAttribute("utente");
		session.invalidate();
		return "home";
	}

}