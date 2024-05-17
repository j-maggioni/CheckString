package com.corso.spring.web.controller;

import com.corso.config.Beans1;
import com.corso.model.Utente;
import com.corso.service.UtenteService;
import com.corso.vo.FormRegistrazione;
import com.corso.vo.RegistrazioneBE;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ControllerAccesso {

	@Autowired
	UtenteService utenteService;

	@GetMapping(path={"/", "/index"})
	public String index() {
		System.out.println("passaggio dal controller metodo index");
		
		return "index";
	}

	@GetMapping(path={"/login", "/login.html"})
	public String login() {

		System.out.println("passaggio dal controller metodo login");

		return "login";
	}

	@GetMapping("/home")
	public String home() {

		System.out.println("passaggio dal controller metodo home");

		return "home";
	}

	@GetMapping("/profilo")
	public String profilo(@RequestParam("email")  @WebParam(name="email")  String email, Model model ) {
		System.out.println("passaggio dal controller metodo profilo");
		System.out.println("parametro passato: " + email);

		Utente utente = utenteService.getUtenteByEmail(email);

		model.addAttribute("utente",utente);

		return "profilo";
	}

	@GetMapping(path = {"/formRegistrazione"})
	public String formRegistrazione(Model model) {

		System.out.println("passaggio dal controller metodo registrazione");
		model.addAttribute("utente", new FormRegistrazione());

		return "formRegistrazione";
		//return "redirect:/"
	}

	@PostMapping("/add")
	public String add(@ModelAttribute("utente") @Valid FormRegistrazione registrazione,
					  BindingResult bindingResult, Model model) {
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
		model.addAttribute("utente", utente);

		return "login";
	}


}
