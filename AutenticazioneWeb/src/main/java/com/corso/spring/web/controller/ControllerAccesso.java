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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ControllerAccesso {

	@Autowired
	UtenteService utenteService;

	@GetMapping(path={"/", "/index"})
	public String index() {
	public String index(HttpServletRequest httpreq) {
		System.out.println("passaggio dal controller metodo index");
		return "index";
	}

	@GetMapping("/Logout")
	public String faiLogout(HttpServletRequest httpreq) {
		HttpSession session = httpreq.getSession();
		session.removeAttribute("email");
	}


	@PostMapping("/loginUser")
	public String logingUser(HttpServletRequest httpreq) {
		// session attributes
		HttpSession session = httpreq.getSession();
		//String emailSession = (String) session.getAttribute("email");
		String emailParam = httpreq.getParameter("email");
		String passParam = httpreq.getParameter("password");
		System.out.println("Controller arguments email and password : "+ emailParam + passParam);
		boolean trovatoInDb =  utenteService.Login(emailParam,passParam) ;
		if (trovatoInDb) {
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

		Utente utente = utenteService.getUtenteByEmail(email);
		return "profilo";
	}


	@GetMapping(path = {"/formRegistrazione"})
	public String formRegistrazione(Model model) {

		model.addAttribute("utente", new FormRegistrazione());

		return "formRegistrazione";
		//return "redirect:/"
	}

	@PostMapping("/add")
	public String add(HttpServletRequest httpreq ,@ModelAttribute("utente") @Valid FormRegistrazione registrazione,
					  BindingResult bindingResult, Model model) {
		HttpSession session = httpreq.getSession();

		// Verifica se ci sono errori di validazione
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Ci sono errori, ricompila!!");
			return "formRegistrazione";
		}

		RegistrazioneBE rBE = new RegistrazioneBE();
		BeanUtils.copyProperties(registrazione, rBE);
		System.out.println("dto: " + rBE);

		Utente utente = new Utente(rBE.getEmail(), rBE.getPassword(), rBE.getNome(), rBE.getCognome(),
				rBE.getNazione(), rBE.getTelefono());

		utenteService.addUtente(utente);
		model.addAttribute("utente", utente);
		//session.setAttribute("email",utente.getEmail());
		return "login";
	}


}