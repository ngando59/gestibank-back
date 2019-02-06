package com.wha.springmvc.controller.adresse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.service.adresse.IAdresseService;

@RestController
public class AdresseController {
	@Autowired
	private IAdresseService service;

	/*---Add new adresse ---*/
	@PostMapping("/adresse")
	public ResponseEntity<?> save(@RequestBody Adresse adresse) {
		service.save(adresse);
		return ResponseEntity.ok().body("Nouvelle adresse sauvegardée! ");
	}

	/*---Get a adresse by id---*/
	@GetMapping("/adresse/{id}")
	public ResponseEntity<Adresse> get(@PathVariable("id") long id) {
		Adresse adresse = service.findOneById(id);
		return ResponseEntity.ok().body(adresse);
	}

	/*---get all adresses ---*/
	@GetMapping("/adresse")
	public ResponseEntity<List<Adresse>> list() {
		List<Adresse> adresses = service.findAll();
		return ResponseEntity.ok().body(adresses);
	}

	/*---Update a adresse by id---*/
	@PutMapping("/adresse/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Adresse adresse) {
		service.update(id, adresse);
		return ResponseEntity.ok().body("adresse mis à jour avec succès!");
	}

	/*---Delete a adresse by id---*/
	@DeleteMapping("/adresse/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		service.delete(id);
		return ResponseEntity.ok().body("adresse supprimée avec succès!");
	}
}
