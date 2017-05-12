package fr.liloudini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.liloudini.dao.EtudiantRepository;
import fr.liloudini.entities.Etudiant;

@Controller
@RequestMapping(value="/Etudiant")
public class EtudiantController {
	
	@Autowired
	private EtudiantRepository etr;
	
	@RequestMapping(value="/etudiants")
	public String index(Model model){
		List<Etudiant> etudiants = etr.findAll();
		System.out.println(etudiants.size());
		model.addAttribute("etudiants", etudiants);
		return "etudiants";
	}

}
