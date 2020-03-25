package com.FitnesWeb.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FitnesWeb.repository.ClanRepository;
import com.FitnesWeb.repository.RadnikRepository;
import com.FitnesWeb.repository.TrenerRepository;
import com.FitnesWeb.repository.TreningRepository;

import model.Clan;
import model.Radnik;
import model.Trener;
import model.Trening;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value="/radnik")
public class RadnikController {

	@Autowired
	RadnikRepository radnikRepository;
	
	@Autowired
	TrenerRepository trenerRepository;
	
	@Autowired
	ClanRepository clanRepository;
	
	@Autowired
	TreningRepository treningRepository;
	
	
	public Radnik ulogovan;

	@RequestMapping(value="/login", method={RequestMethod.POST,RequestMethod.GET}) 
	public String login(String username,String password,Model m,HttpServletRequest request){
		ulogovan = radnikRepository.login(username, password);
		if(ulogovan != null){
			request.setAttribute("ulogovan", ulogovan);
			return "/ulogovanRadnik";
		}else{
			m.addAttribute("porukaLogin", "Uneli ste pogresne podatke");
			return "/loginRadnik";
		}
	}
	@PostMapping(value="dodajTrenera")
	public String dodajTrenera(Trener t ,Model m){
		try{
			t= trenerRepository.save(t);
			if(t != null){
				m.addAttribute("t", t);
				m.addAttribute("poruka", "Uspesno ste dodali trenera.");
			}else{
				m.addAttribute("porukaR", "Greska prilikom dodavanja trenera");
				return "/dodajTrenera"; 
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		 return "/dodajTrenera";
	}
	@RequestMapping(value="pregledSvihTreningaRadnik", method={RequestMethod.POST,RequestMethod.GET}) 
	public String pregledSvihTreningaRadnik(HttpServletRequest request) { 
		List<Trening> treninzi =treningRepository.findAll();
		request.getSession().setAttribute("treninzi", treninzi);
		return "/pregledSvihTreningaRadnik";
	}
	
	@RequestMapping(value="pregledSvihClanova", method={RequestMethod.POST,RequestMethod.GET}) 
	public String pregledSvihClanova(HttpServletRequest request) { 
		List<Clan> clanovi =clanRepository.findAll();
		request.getSession().setAttribute("clanovi", clanovi);
		return "/pregledClanovaRadnik";
	}
	
	@RequestMapping(value="sviTreneri", method={RequestMethod.POST,RequestMethod.GET}) 
	public String sviTreneri(HttpServletRequest request) { 
		List<Trener> treneri =trenerRepository.findAll();
		request.getSession().setAttribute("treneri", treneri);
		return "/izvestajSviTreninziTrenera";
	}
	
	@RequestMapping(value="izvestajSviTreninziTrenera", method=RequestMethod.GET) 
	public void izvestajSviTreninziTrenera(HttpServletRequest request, HttpServletResponse response, Trener trener) throws Exception { 
		List<Trening> treninzi = treningRepository.sviTrenizniZaTrenera(trener);
		response.setContentType("text/html");
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(treninzi);
		InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/treneroviTreninzi.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		String t="";
			t=treninzi.get(0).getVremeTreninga();
		if(treninzi!=null && treninzi.size()>0)
			params.put("t", t);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		
		response.setContentType("application/x-download");
		response.addHeader("Content-disposition", "attachment; filename=Treninzi.pdf");
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,out); 
	}
	
	
	@RequestMapping(value="izvestajSviClanovi", method=RequestMethod.GET) 
	public void izvestajSviClanovi(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		List<Clan> clanovi = clanRepository.findAll();
		response.setContentType("text/html");
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clanovi);
		InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/sviClanovi.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		String c="";
			c=clanovi.get(0).getIme();
		if(clanovi!=null && clanovi.size()>0)
			params.put("c", c);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		
		response.setContentType("application/x-download");
		response.addHeader("Content-disposition", "attachment; filename=Clanovi.pdf");
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,out); 
	}

}
