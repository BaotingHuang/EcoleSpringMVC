package fr.liloudini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.liloudini.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	
}
