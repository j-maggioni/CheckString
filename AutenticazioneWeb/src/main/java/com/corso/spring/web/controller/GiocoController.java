package com.corso.spring.web.controller;

import com.corso.service.GiocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GiocoController {

	@Autowired
	GiocoService giocoService;

	@GetMapping(path={"/indovina_bandiera"})
	public String gioco1() {
		System.out.println("passaggio dal controller metodo gioco1");
		return "gioco1";
	}

	@GetMapping(path={"/indovina_capitale"})
	public String gioco2() {
		System.out.println("passaggio dal controller metodo gioco2");
		return "gioco2";
	}

	@GetMapping(path={"/indovina_nazione"})
	public String gioco3() {
		System.out.println("passaggio dal controller metodo gioco3");
		return "gioco3";
	}

	/*@GetMapping(path={"/home"})
	public String homeLogged(HttpSession session) {
		System.out.println("passaggio dal controller metodo home");

		Utente utente = (Utente) session.getAttribute("utente");
		System.out.println(utente);
		if (utente != null) {
			//model.addAttribute("utente", utente);
			return "home";
		} else {
			System.out.println("Utente non trovato nella sessione.");
			return "redirect:/";
		}
	}

	// da sistemare
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("passaggio dal controller metodo logout");
		session.removeAttribute("utente");
		session.invalidate();
		return "login";
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

		if (giocoService.addUtente(utente)){
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

		boolean trovatoInDb =  giocoService.login(login.getEmail(),login.getPassword()) ;
		if (trovatoInDb) {

			Utente utente = giocoService.getUtenteByEmail(login.getEmail());
			session.setAttribute("utente",utente);
			//model.addAttribute(utente);

			return "redirect:/home";
		} else {
			model.addAttribute("message", "Credenziali errate");
			return "formLogin";
		}
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

		if (giocoService.updateUtente(utente)){
			session.removeAttribute("modificaUtente");
			session.setAttribute("utente", utente);
			model.addAttribute(utente);
			return "profilo";
		} else {
			return "formModificaProfilo";
		}
	}

	@PutMapping("/deleteProfilo")
	public String deleteProfile (HttpSession session) {
		boolean cancellato = giocoService.delete( (Utente) session.getAttribute("utente")) ;
		if (cancellato) {
			return "home" ;
		}
		else {
			return "profilo" ;
		}
	}*/

}