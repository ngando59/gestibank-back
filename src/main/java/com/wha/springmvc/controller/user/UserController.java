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

import com.wha.springmvc.model.user.Client;
import com.wha.springmvc.model.user.Utilisateur;
import com.wha.springmvc.service.user.IClientService;

@RestController
public class UserController {
	@Autowired
	private IClientService service;

	/*---Add new user ---*/
	@PostMapping("/client")
	public ResponseEntity<?> save(@RequestBody Client client) {
		service.save(client);
		return ResponseEntity.ok().body("client créer! ");
	}

	@GetMapping("/client/{id}")
	public ResponseEntity<Utilisateur> get(@PathVariable("id") long id) {
		Client client = service.findOneById(id);
		return ResponseEntity.ok().body(client);
	}

	@GetMapping("/clients")
	public ResponseEntity<List<Client>> list() {
		List<Client> clients = service.findAll();
		return ResponseEntity.ok().body(clients);
	}

	@PutMapping("/client/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Client utilisateur) {
		service.update(id, utilisateur);
		return ResponseEntity.ok().body("utilisateur mis à jour avecsuccès!");
	}

	@DeleteMapping("/client/{id}")
	public ResponseEntity<?>

			delete(@PathVariable("id") long id) {
		service.delete(id);
		return ResponseEntity.ok().body("utilisateur supprimé avec succès!");
	}

}
