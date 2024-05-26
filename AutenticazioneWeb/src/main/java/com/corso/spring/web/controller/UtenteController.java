package com.corso.spring.web.controller;

import com.corso.converters.ConverterFormRegistrazioneToUtente;
import com.corso.converters.ConverterFromGiocoVoToGioco;
import com.corso.converters.ConverterFromUtenteToUtenteVO;
import com.corso.enums.GiochiEnum;
import com.corso.model.Gioco;
import com.corso.model.Utente;
import com.corso.service.GiocoService;
import com.corso.service.UtenteService;
import com.corso.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	@Autowired
	GiocoService giocoService;

	@GetMapping(path={"/","/home"})
	public String home(HttpSession session) {
		System.out.println("passaggio dal controller metodo home");

		return "home";
	}

	@GetMapping(path={"/registrazione"})
	public String formRegistrazione(Model model) {
		System.out.println("passaggio dal controller metodo formRegistrazione");
		model.addAttribute("registerOK", "none");
		model.addAttribute("existingEmail", "none");
		model.addAttribute("utente", new FormRegistrazione());

		return "formRegistrazione";
	}

	@PostMapping("/add")
	public String add(HttpSession session, @ModelAttribute("utente") @Valid FormRegistrazione registrazione,
					  BindingResult bindingResult, Model model) {
		System.out.println("passaggio dal controller metodo add");

		if (!registrazione.getEmail().isEmpty() && utenteService.getUtenteByEmail(registrazione.getEmail()) != null) {
			model.addAttribute("registerOK", "none");
			model.addAttribute("existingEmail", "inline");
			bindingResult.rejectValue("existingEmailError", "error.utente",
					"E-mail associata ad un account");
		}
		else {
			model.addAttribute("registerOK", "none");
			model.addAttribute("existingEmail", "none");
		}

		if (bindingResult.hasErrors()) {
			return "formRegistrazione";
		} else {
			Utente utente = ConverterFormRegistrazioneToUtente.converterFormRegistrazioneToUtente(registrazione);
			System.out.println(utente);

			if (utenteService.addUtente(utente)) {
				model.addAttribute("registerOK", "inline");
				model.addAttribute("existingEmail", "none");
				return "redirect:/login";
			} else {
				return "formRegistrazione";
			}
		}
	}

	@GetMapping(path={"/login"})
	public String login(Model model) {
		System.out.println("passaggio dal controller metodo formLogin");
		model.addAttribute("hasErrors", "none");
		model.addAttribute("utente", new FormLogin());

		return "formLogin";
	}

	@PostMapping("/accedi")
	public String accedi(HttpSession session, @ModelAttribute("utente") @Valid FormLogin login,
					  BindingResult bindingResult, Model model) {
		System.out.println("passaggio dal controller metodo login");

		if (login.getEmail().isEmpty() && login.getPassword().isEmpty()) {
			model.addAttribute("path", "globalError");
			bindingResult.rejectValue("globalError", "error.utente",
					"Accesso non eseguito! Inserisci delle credenziali valide.");
		} else {
			model.addAttribute("path", "*");
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("hasErrors", "inline");
			return "formLogin";
		} else {
			boolean trovatoInDb =  utenteService.login(login.getEmail(),login.getPassword()) ;
			if (trovatoInDb) {
				Utente utente = utenteService.getUtenteByEmail(login.getEmail());

				UtenteVO utenteVO = ConverterFromUtenteToUtenteVO.convertUtenteToUtenteVO(utente);

				session.setAttribute("utente",utenteVO);

				/*Date currentDate = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

				List<GiocoVO> giochi = new ArrayList<GiocoVO>();
				giochi.add(new GiocoVO(dateFormat.format(currentDate),0, GiochiEnum.IndovinaBandiera));
				giochi.add(new GiocoVO(dateFormat.format(currentDate),0, GiochiEnum.IndovinaCapitale));
				giochi.add(new GiocoVO(dateFormat.format(currentDate),0, GiochiEnum.IndovinaNazione));

				session.setAttribute("giochi",giochi);*/

				session.setMaxInactiveInterval(1000*120); // durata timeout
				return "home";
			} else {
				model.addAttribute("hasErrors", "inline");
				bindingResult.reject("globalError",
						"Accesso non eseguito! Email e/o password errate.");
				return "formLogin";
			}
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