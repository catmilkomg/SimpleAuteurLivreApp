package com.packages.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packages.entities.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Integer> {
	Auteur findById(int id);

	Auteur findByCin(String cin);

	Auteur findByDateNaissance(Date dateNaissance);
}
