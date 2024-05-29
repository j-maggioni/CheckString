package com.corso.spring.web.controller;

import com.corso.converters.ConverterUtenteVOToUtente;
import com.corso.enums.GiochiEnum;
import com.corso.model.Gioco;
import com.corso.model.Utente;
import com.corso.service.GiocoService;
import com.corso.vo.FormLogin;
import com.corso.vo.GiocoVO;
import com.corso.vo.UtenteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GiocoController {

	@Autowired
	GiocoService giocoService;

	@GetMapping(path={"/indovina_bandiera"})
	public String gioco1(Model model) {
		System.out.println("passaggio dal controller metodo gioco1");

		model.addAttribute("partita", istanziaPartita(GiochiEnum.indovina_bandiera));
		System.out.println(model.getAttribute("partita"));

		return "gioco1";
	}

	@GetMapping(path={"/indovina_capitale"})
	public String gioco2(Model model) {
		System.out.println("passaggio dal controller metodo gioco2");

		model.addAttribute("partita", istanziaPartita(GiochiEnum.indovina_capitale));

		return "gioco2";
	}

	@GetMapping(path={"/indovina_nazione"})
	public String gioco3(Model model) {
		System.out.println("passaggio dal controller metodo gioco3");

		model.addAttribute("partita", istanziaPartita(GiochiEnum.indovina_nazione));

		return "gioco3";
	}

	@PostMapping(path={"/salvaScore"})
	public String salvaPunteggio(HttpSession session, @ModelAttribute("partita") @Valid GiocoVO partita,
								 BindingResult bindingResult, Model model){
		System.out.println("passaggio dal controller metodo salvaScore");

		model.addAttribute("partita" , partita);
		UtenteVO utenteVO = (UtenteVO) session.getAttribute("utente");
		Utente utente = ConverterUtenteVOToUtente.convert(utenteVO);
		giocoService.addGiocata(new Gioco(partita.getData(), partita.getPunti(), utente, partita.getGioco()));

		model.addAttribute("gioco_prec",partita.getGioco().name());
		return "visualizzaScore";

	}

	private GiocoVO istanziaPartita(GiochiEnum gioco){
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return new GiocoVO(dateFormat.format(currentDate),0, gioco);
	}

}