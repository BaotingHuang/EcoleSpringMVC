package fr.liloudini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.liloudini.dao.EtudiantRepository;
import fr.liloudini.entities.Etudiant;

@Controller
@RequestMapping(value="/Etudiant")
public class EtudiantController {
	
	@Autowired
	private EtudiantRepository etr;
	
	@RequestMapping(value="/etudiants")
	public String index(Model model,
						@RequestParam(name="pc",defaultValue="0")Integer pageCourante){
		
		Page<Etudiant> etudiants = etr.findAll(new PageRequest(pageCourante,5));
		System.out.println();
		
		Integer[] pages = new Integer[etudiants.getTotalPages()];
		for (int i = 0; i < pages.length; i++) {pages[i]=i;}
		model.addAttribute("nombrePage", pages.length);
		model.addAttribute("pages", pages);
		model.addAttribute("pageLast",etudiants.getTotalPages());
		model.addAttribute("pageCourante",pageCourante);
		model.addAttribute("etudiants", etudiants);
		return "etudiants";
	}

}
