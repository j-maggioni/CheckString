package com.corso.spring.web.controller;

import com.corso.converters.*;
import com.corso.enums.GiochiEnum;
import com.corso.model.Utente;
import com.corso.service.GiocoService;
import com.corso.service.UtenteService;
import com.corso.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

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
		model.addAttribute("registerOK", "none");
		model.addAttribute("existingEmail", "none");

		boolean emailHasErrors = bindingResult.hasFieldErrors("email");

		if (!emailHasErrors && utenteService.getUtenteByEmail(registrazione.getEmail()) != null) {
			model.addAttribute("existingEmail", "inline");
			bindingResult.rejectValue("existingEmailError", "error.utente",
					"E-mail associata ad un account");
		}

		if (bindingResult.hasErrors()) {
			return "formRegistrazione";
		} else {
			Utente utente = ConverterFormRegistrazioneToUtente.convert(registrazione);

			if (utenteService.addUtente(utente)) {
				model.addAttribute("registerOK", "inline");
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

		boolean emailHasErrors = bindingResult.hasFieldErrors("email");
		boolean passwordHasErrors = bindingResult.hasFieldErrors("password");

        if (emailHasErrors) {
			String error;
			model.addAttribute("path", "globalError");
            if (passwordHasErrors) {
                error = "Accesso non eseguito! Inserisci delle credenziali valide.";
            } else  {
				error = "Accesso non eseguito! Inserire una e-mail valida";
            }
			bindingResult.rejectValue("globalError", "error.utente", error);
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

				UtenteVO utenteVO = ConverterUtenteToUtenteVO.convert(utente);

				session.setAttribute("utente",utenteVO);

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
		UtenteVO utenteVO = (UtenteVO) session.getAttribute("utente");
		model.addAttribute("utente",utenteVO);

		// PROVA DEL RIEMPIMENTO DELLA TABELLA DEI PUNTEGGI
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Map<String,List<GiocoVO>> giochi = new HashMap<>();
		List<GiocoVO> bandieraList = new ArrayList<>();
		bandieraList.add(new GiocoVO(dateFormat.format(currentDate),0,GiochiEnum.IndovinaBandiera));
		bandieraList.add(new GiocoVO(dateFormat.format(currentDate),0,GiochiEnum.IndovinaBandiera));
		bandieraList.add(new GiocoVO(dateFormat.format(currentDate),0,GiochiEnum.IndovinaBandiera));
//		bandieraList = ConverterGiocoToGiocoVO.convertList(giocoService.getUserAllBest(utenteVO.getEmail(),
//				GiochiEnum.IndovinaBandiera));

		List<GiocoVO> capitaleList = new ArrayList<>();
		capitaleList.add(new GiocoVO(dateFormat.format(currentDate),0,GiochiEnum.IndovinaCapitale));
		capitaleList.add(new GiocoVO(dateFormat.format(currentDate),0,GiochiEnum.IndovinaCapitale));
		capitaleList.add(new GiocoVO(dateFormat.format(currentDate),0,GiochiEnum.IndovinaCapitale));
//		capitaleList = ConverterGiocoToGiocoVO.convertList(giocoService.getUserAllBest(utenteVO.getEmail(),
//				GiochiEnum.IndovinaCapitale));

		List<GiocoVO> nazioneList = new ArrayList<>();
		nazioneList.add(new GiocoVO(dateFormat.format(currentDate),0,GiochiEnum.IndovinaNazione));
		nazioneList.add(new GiocoVO(dateFormat.format(currentDate),0,GiochiEnum.IndovinaNazione));
		nazioneList.add(new GiocoVO(dateFormat.format(currentDate),0,GiochiEnum.IndovinaNazione));
//		nazioneList = ConverterGiocoToGiocoVO.convertList(giocoService.getUserAllBest(utenteVO.getEmail(),
//				GiochiEnum.IndovinaNazione));

		giochi.put(GiochiEnum.IndovinaBandiera.name(), bandieraList);
		giochi.put(GiochiEnum.IndovinaCapitale.name(), capitaleList);
		giochi.put(GiochiEnum.IndovinaNazione.name(), nazioneList);

		model.addAttribute("giochi",giochi);

		return "profilo";
	}


	@GetMapping(path={"/modifica_profilo"})
	public String modificaProfilo(HttpSession session, Model model) {
		System.out.println("passaggio dal controller metodo formModificaProfilo");
		model.addAttribute("editOK", "none");
		model.addAttribute("utente",
				ConverterUtenteVOToFormModificaProfilo.convert((UtenteVO) session.getAttribute("utente")));

		return "formModificaProfilo";
	}

	@PostMapping({"/modifica"})
	public String modificaProfilo(HttpSession session,
								  @ModelAttribute("utente")
								  @Validated({EmptyPasswordValidator.class,
										  MatchingPasswordValidator.class}) FormUtenteModificato formUtenteModificato,
								  BindingResult bindingResult, Model model) {
		System.out.println("passaggio dal controller metodo modificaProfilo");
		model.addAttribute("editOK", "none");

		System.out.println(bindingResult.getFieldErrors());
		/*if(!formUtenteModificato.getPassword().isEmpty() && formUtenteModificato.getConfermaPassword().isEmpty()){
			bindingResult.reject("confermaPassword",
					"Le password non corrispondono");
		}*/

		if (bindingResult.hasErrors()) {
			return "formModificaProfilo";
		} else {
			String email = ((UtenteVO) session.getAttribute("utente")).getEmail();
			Utente utente = ConverterFormModificaProfiloToUtente.convert(formUtenteModificato,email);

			if (utenteService.updateUtente(utente)) {
				model.addAttribute("editOK", "inline");
				System.out.println(model.getAttribute("editOK"));
				UtenteVO utenteVO = ConverterUtenteToUtenteVO.convert(utente);
				model.addAttribute(utenteVO);
				session.setAttribute("utente", utenteVO);
				return "redirect:/profilo";
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