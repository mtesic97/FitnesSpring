package com.FitnesWeb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FitnesWeb.repository.KomentarRepository;
import com.FitnesWeb.repository.TrenerRepository;
import com.FitnesWeb.repository.TreningRepository;

import model.Komentar;
import model.Trener;
import model.Trening;

@Controller
@RequestMapping(value="/trener")
public class TrenerController {

	@Autowired
	TrenerRepository trenerRepository;
	
	@Autowired
	TreningRepository treningRepository;
	
	@Autowired
	KomentarRepository komentarRepository;
	
	public Trener ulogovan;

	@RequestMapping(value="/login", method={RequestMethod.POST,RequestMethod.GET}) 
	public String login(String email,String password,Model m,HttpServletRequest request){
		ulogovan = trenerRepository.login(email, password);
		if(ulogovan != null){
			request.setAttribute("ulogovan", ulogovan);
			return "/ulogovanTrener";
		}else{
			m.addAttribute("porukaLogin", "Uneli ste pogresne podatke");
			return "/loginTrener";
		}
		
	}
	
	@RequestMapping(value="pregledTreningaTrener", method={RequestMethod.POST,RequestMethod.GET}) 
	public String pregledTreningaTrener(HttpServletRequest request) { 
		List<Trening> treninzi = treningRepository.sviTrenizniZaTrenera(ulogovan);
		request.getSession().setAttribute("treninzi", treninzi);
		return "/pregledTreningaTrener";
	}
	
	@RequestMapping(value="pregledKomentaraTrener", method={RequestMethod.POST,RequestMethod.GET}) 
	public String pregledKomentaraTrener(HttpServletRequest request) { 
		List<Komentar> komentari = komentarRepository.sviKomentariZaTrenera(ulogovan);
		request.getSession().setAttribute("komentari", komentari);
		return "/pregledKomentaraTrener";
	}
	
	
}
