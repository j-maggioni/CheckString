package com.corso.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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


}
