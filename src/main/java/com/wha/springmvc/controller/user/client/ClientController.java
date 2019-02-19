package com.wha.springmvc.controller.user.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ClientController {

	@Autowired
	private IClientService service;

	/**
	 * Liste des clients
	 */
	@GetMapping("/clients")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Client>> listClient() {
		List<Client> clients = service.findAll();
		return ResponseEntity.ok().body(clients);
	}

	/**
	 * @return client par id
	 */
	@GetMapping("/client/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Utilisateur> getClient(@PathVariable("id") long id) {
		Client client = service.findOneById(id);
		return ResponseEntity.ok().body(client);
	}

	/**
	 * Création d'un client
	 */
	@PostMapping("/client")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> createClient(@RequestBody Client client) {
		System.out.println("debut creation client " + client.getNom());
		long id = service.save(client);
		return ResponseEntity.ok().body("client " + id + " créer ! ");
	}

	/**
	 * Mise à jour d'un client
	 */
	@PutMapping("/client/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> updateClient(@PathVariable("id") long id, @RequestBody Client client) {
		service.update(id, client);
		return ResponseEntity.ok().body("Client mis à jour avec succès!");
	}

	/**
	 * Suppresion d'un client
	 */
	@DeleteMapping("/client/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> deleteClient(@PathVariable("id") long id) {
		service.delete(id);
		return ResponseEntity.ok().body("client supprimé avec succès!");
	}
}
