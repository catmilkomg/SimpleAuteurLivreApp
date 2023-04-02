package com.packages.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packages.entities.Auteur;
import com.packages.entities.Livre;
import com.packages.repositories.AuteurRepository;
import com.packages.repositories.LivreRepository;

@Service
public class LivreService {
	@Autowired
	private LivreRepository livreRepository;
	@Autowired
	private AuteurRepository auteurRepository;

	public Livre saveLivre(Livre livre) {
		return livreRepository.save(livre);
	}

	public List<Livre> findAllLivres() {
		return livreRepository.findAll();
	}

	public void deleteById(int id) {
		livreRepository.deleteById(id);
	}

	public Livre findById(int id) {
		return livreRepository.findById(id);
	}

	public Collection<Livre> findAllByAuteur(int id) {
		return auteurRepository.findAll().stream().filter(auteur -> auteur.getId() == id).findFirst().orElse(null)
				.getLivre();
	}

	public void affectLivreToAuteur(int idLivre, int idAuteur) {
		Livre livre = livreRepository.findById(idLivre);
		Auteur auteur = auteurRepository.findById(idAuteur);
		auteur.getLivre().add(livre);
		auteurRepository.save(auteur);
	}

}
