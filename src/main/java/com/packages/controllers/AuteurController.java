package com.packages.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packages.entities.Auteur;

import com.packages.services.AuteurService;

@RestController
@RequestMapping("/auteurs")
public class AuteurController {

	@Autowired
	private AuteurService auteurService;

	@PostMapping("/save")
	public ResponseEntity<Auteur> saveAuteur(@RequestBody Auteur auteur) {
		auteurService.saveAuteur(auteur);
		return new ResponseEntity<>(auteur, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Auteur>> findAll() {
		List<Auteur> auteurs = auteurService.findAllAuteurs();
		return ResponseEntity.ok(auteurs);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteAuteur(@PathVariable("id") int id) {
		auteurService.findAuteurById(id);
		auteurService.deleteAuteurById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{cin}")
	public Auteur getAuteurByCin(@PathVariable String cin) {
		Auteur auteur = auteurService.findAuteurByCin(cin);
		return auteur;
	}

	@GetMapping("/dateNaissance/{dateNaissance}")
	public Auteur getAuteurByDateNaissance(
			@PathVariable("dateNaissance") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateNaissance) {
		Auteur auteur = auteurService.getAuteurByDateNaissance(dateNaissance);

		return auteur;

	}

	/*
	 * @GetMapping("/{id}") public Auteur getAuteurById(@PathVariable int id) {
	 * Auteur auteur = auteurService.findAuteurById(id); return auteur; }
	 */

	/*
	 * @GetMapping("/dateNaissance/{date}") public ResponseEntity<List<Auteur>>
	 * findAuteurByDateNaissance(
	 * 
	 * @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
	 * List<Auteur> auteurs = auteurService.findAuteurByDateNaissance(date); if
	 * (auteurs.isEmpty()) { return ResponseEntity.notFound().build(); } return
	 * ResponseEntity.ok(auteurs); }
	 * 
	 * @GetMapping("/auteur/{id}/livres") public ResponseEntity<List<Livre>>
	 * getLivresByAuteur(@PathVariable("id") String auteurId) { List<Livre> livres =
	 * auteurService.findLivresByAuteur(auteurId); return ResponseEntity.ok(livres);
	 * }
	 * 
	 * @PutMapping("/{id}/livres/{idLivre}") public ResponseEntity<Void>
	 * assignerLivre(@PathVariable String id, @PathVariable String idLivre) {
	 * auteurService.affecterLivre(id, idLivre); return ResponseEntity.ok().build();
	 * }
	 * 
	 * 
	 * @PostMapping("/{cin}/livres") public ResponseEntity<Void>
	 * addLivreToAuteur(@PathVariable String cin, @RequestBody Livre livre) { Auteur
	 * auteur = auteurService.findByCin(cin); auteurService.addLivreToAuteur(auteur,
	 * livre); return ResponseEntity.ok().build(); }
	 */
}
