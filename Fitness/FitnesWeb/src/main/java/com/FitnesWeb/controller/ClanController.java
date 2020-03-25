package com.FitnesWeb.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FitnesWeb.repository.ClanRepository;
import com.FitnesWeb.repository.KomentarRepository;
import com.FitnesWeb.repository.TrenerRepository;
import com.FitnesWeb.repository.TreningRepository;

import model.Clan;
import model.Komentar;
import model.Trener;
import model.Trening;

@Controller
@RequestMapping(value="/clan")
public class ClanController {

	@Autowired
	ClanRepository clanRepository;

	@Autowired
	TreningRepository treningRepository;
	
	@Autowired
	TrenerRepository trenerRepository;
	
	@Autowired
	KomentarRepository komentarRepository;
	
	public Clan ulogovan;

	@RequestMapping(value="/login", method={RequestMethod.POST,RequestMethod.GET}) 
	public String login(String email,String password,Model m,HttpServletRequest request){
		ulogovan = clanRepository.login(email, password);
		if(ulogovan != null){
			request.getSession().setAttribute("ulogovan", ulogovan);
			return "/ulogovaniClan";
		}else{
			m.addAttribute("porukaLogin", "Uneli ste pogresne podatke");
			return "/loginClana";
		}
	}
	@PostMapping(value="registracija")
	public String registracija(Clan c ,HttpServletRequest request){
		try{
			c= clanRepository.save(c);
			if(c != null){
				request.getSession().setAttribute("porukaR", "Uspesno ste registrovani.");
				return "/ulogovaniClan";
			}else{
				request.getSession().setAttribute("porukaR", "Greska prilikom registracije");
				return "/registracija"; 
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/registracija";	
	}
	@RequestMapping(value="sviTreneri", method={RequestMethod.POST,RequestMethod.GET}) 
	public String sviTreneri(HttpServletRequest request) { 
		List<Trener> trener =trenerRepository.findAll();
		request.getSession().setAttribute("trener", trener);
		return "/zakaziTrening";
	}
	@PostMapping(value="zakaziTrening")
	public String zakaziTrening(Trening t ,Model m,String datumTreninga){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date d =null;
		try {
			d = sdf.parse(datumTreninga);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Date tod = new Date();
		if(d.compareTo(tod) <=0 ){
			m.addAttribute("greska", "Ne mozete da zakazete trening ,datum nije validan.");
		}else{
			try{
				t.setClan(ulogovan);
				t= treningRepository.save(t);
				if(t != null){ 
					m.addAttribute("t", t);
					m.addAttribute("poruka", "Uspesno ste zakazali trening");
				}else{
					m.addAttribute("t", t);
					m.addAttribute("porukaGreska", "Greska prilikom zakazivanje");
					return "/zakaziTrening"; 
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		 return "/zakaziTrening";
	}
	@RequestMapping(value="pregledTreningaClan", method={RequestMethod.POST,RequestMethod.GET}) 
	public String pregledTreningaClan(HttpServletRequest request) { 
		List<Trening> treninzi =treningRepository.sviTrenizni(ulogovan);
		request.getSession().setAttribute("treninzi", treninzi);
		return "/pregledTreningaClan";
	}
	@RequestMapping(value="sviTreneriKomentar", method={RequestMethod.POST,RequestMethod.GET}) 
	public String sviTreneriKomentar(HttpServletRequest request) { 
		List<Trener> sviTreneri =trenerRepository.findAll();
		request.getSession().setAttribute("sviTreneri", sviTreneri);
		return "/dodajKomentar";
	}
	@PostMapping(value="dodajKomentarZaTrenera")
	public String dodajKomentarZaTrenera(Komentar k ,HttpServletRequest request,Model m){
		try{
			k.setClan(ulogovan);
			k= komentarRepository.save(k);
			if(k != null){
				request.getSession().setAttribute("k", k);
				m.addAttribute("poruka", "Uspesno ste ostavili komentar.");
			}else{
				return "/dodajKomentar"; 
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/dodajKomentar";	
	}
	
}
