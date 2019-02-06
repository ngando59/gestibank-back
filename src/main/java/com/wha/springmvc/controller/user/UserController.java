package com.wha.springmvc.controller.user;

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

import com.wha.springmvc.model.user.Utilisateur;
import com.wha.springmvc.service.user.IUserService;

@RestController
public class UserController {
	@Autowired
	private IUserService service;

	/*---Add new user ---*/
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody Utilisateur utilisateur) {
		service.save(utilisateur);
		return ResponseEntity.ok().body("Nouvel utilisateur créer! ");
	}

	/*---Get a user by id---*/
	@GetMapping("/user/{id}")
	public ResponseEntity<Utilisateur> get(@PathVariable("id") long id) {
		Utilisateur utilisateur = service.findOneById(id);
		return ResponseEntity.ok().body(utilisateur);
	}

	/*---get all user ---*/
	@GetMapping("/users")
	public ResponseEntity<List<Utilisateur>> list() {
		List<Utilisateur> utilisateurs = service.findAll();
		return ResponseEntity.ok().body(utilisateurs);
	}

	/*---Update a user by id---*/
	@PutMapping("/user/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Utilisateur utilisateur) {
		service.update(id, utilisateur);
		return ResponseEntity.ok().body("utilisateur mis à jour avec succès!");
	}

	/*---Delete a user by id---*/
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		service.delete(id);
		return ResponseEntity.ok().body("utilisateur supprimé avec succès!");
	}
}
