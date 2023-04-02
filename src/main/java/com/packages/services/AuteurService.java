package com.packages.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packages.entities.Auteur;

import com.packages.repositories.AuteurRepository;

@Service
public class AuteurService {
	@Autowired
	private AuteurRepository auteurRepository;

	public Auteur saveAuteur(Auteur auteur) {
		return auteurRepository.save(auteur);
	}

	public List<Auteur> findAllAuteurs() {
		return auteurRepository.findAll();
	}

	public void deleteAuteurById(int id) {
		auteurRepository.deleteById(id);
	}

	public Auteur findAuteurById(int id) {
		return auteurRepository.findById(id);
	}

	public Auteur findAuteurByCin(String cin) {
		return auteurRepository.findByCin(cin);
	}

	public Auteur getAuteurByDateNaissance(Date dateNaissance) {
		return auteurRepository.findByDateNaissance(dateNaissance);
	}

}
