package com.packages.controllers;

import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packages.entities.Livre;
import com.packages.repositories.LivreRepository;
import com.packages.services.LivreService;

@RestController
@RequestMapping("/livres")
public class LivreController {

	@Autowired
	private LivreService livreService;

	@PostMapping("/save")
	public ResponseEntity<Livre> addLivre(@RequestBody Livre livre) {
		livreService.saveLivre(livre);
		return new ResponseEntity<>(livre, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livre> getLivreById(@PathVariable int id) {
		Livre livre = livreService.findById(id);
		return ResponseEntity.ok(livre);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Livre>> findAll() {
		List<Livre> livres = livreService.findAllLivres();
		return ResponseEntity.ok(livres);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
		livreService.findById(id);
		livreService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/affect/livre/{idLivre}/toAuteur/{idAuteur}")
	public void affectLivreToAuteur(@PathVariable int idLivre, @PathVariable int idAuteur) {
		livreService.affectLivreToAuteur(idLivre, idAuteur);
	}

	@GetMapping("/auteur/{id}")
	public Collection<Livre> findAllByAuteur(@PathVariable int id) {
		return livreService.findAllByAuteur(id);
	}

	@Autowired
	private LivreRepository livreRepository;

	@GetMapping("/date-edition-between")
	public List<Livre> findByDateEditionBetween(
			@RequestParam("start-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("end-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		return livreRepository.findByDateEditionBetween(startDate, endDate);
	}

	/*
	 * @GetMapping("/livres/par-date") public ResponseEntity<List<Livre>>
	 * getLivresByDate(
	 * 
	 * @RequestParam("debut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date debut,
	 * 
	 * @RequestParam("fin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fin) {
	 * List<Livre> livres = livreService.findLivreByDateBetween(debut, fin); return
	 * ResponseEntity.ok(livres); }
	 */
}