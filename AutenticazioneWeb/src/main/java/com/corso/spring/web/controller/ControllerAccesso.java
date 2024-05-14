package com.corso.spring.web.controller;

import com.corso.spring.web.model.Utente;
import com.corso.spring.web.vo.FormRegistrazione;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import javax.validation.Valid;

@Controller
//@RequestMapping("/zero")
public class ControllerAccesso {
	
//	@RequestMapping(
//			path={"/get.do", "/post.html"},
//			method= {RequestMethod.GET, RequestMethod.POST}
//	)
	@GetMapping(path={"/", "/index.html"})
	public String home() {
		
		System.out.println("passaggio dal controller metodo home"); 
		
		return "index";
	}

	@GetMapping("login.html")
	public String login() {

		System.out.println("passaggio dal controller metodo login");

		return "login";
	}

	@GetMapping("registrati.html")
	public String registrati() {

		System.out.println("passaggio dal controller metodo registrati");

		return "registrati";
	}

	@GetMapping("Accedi.html")
	public String accedi() {

		System.out.println("passaggio dal controller metodo accedi");

		return "Accedi";
	}

	@GetMapping("profilo.html")
	public String profilo() {

		System.out.println("passaggio dal controller metodo profilo");

		return "profilo";
	}

	@PostMapping("/profilo")
	public String add(@ModelAttribute("utente") @Valid FormRegistrazione registrazione, BindingResult bindingResult, Model model) {

		// Verifica se ci sono errori di validazione
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Ci sono errori, ricompila!!");
			return "profilo";
		}

		Utente dto = new Utente();

		org.springframework.beans
				.BeanUtils.copyProperties(registrazione, dto);

		System.out.println("form:" + registrazione);
		System.out.println("dto: " + dto);

//		Utente c = service.creaCategoria(dto);
//		System.out.println("creata:" + c);
//		model.addAttribute("utente", c);

		return "profilo";
	}


}
