package fr.liloudini;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.liloudini.dao.EtudiantRepository;
import fr.liloudini.entities.Etudiant;

@SpringBootApplication
public class EcoleSpringMvcApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = SpringApplication.run(EcoleSpringMvcApplication.class, args);	
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Etudiant etudiant = new Etudiant("Liloudini", "Aziz", df.parse("1993-01-07"));
	    EtudiantRepository etr = context.getBean(EtudiantRepository.class);
	    etr.save(etudiant);
	}
}
