package com.wha.springmvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.user.Client;
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

	/*
	 * @GetMapping("/user/{id}") public ResponseEntity<Utilisateur>
	 * get(@PathVariable("id") long id) { Utilisateur utilisateur =
	 * service.findOneById(id); return ResponseEntity.ok().body(utilisateur); }
	 * 
	 * 
	 * @GetMapping("/users") public ResponseEntity<List<Utilisateur>> list() {
	 * List<Utilisateur> utilisateurs = service.findAll(); return
	 * ResponseEntity.ok().body(utilisateurs); }
	 * 
	 * 
	 * @PutMapping("/user/{id}") public ResponseEntity<?> update(@PathVariable("id")
	 * long id, @RequestBody Utilisateur utilisateur) { service.update(id,
	 * utilisateur); return
	 * ResponseEntity.ok().body("utilisateur mis à jour avec succès!"); }
	 * 
	 * 
	 * @DeleteMapping("/user/{id}") public ResponseEntity<?>
	 * delete(@PathVariable("id") long id) { service.delete(id); return
	 * ResponseEntity.ok().body("utilisateur supprimé avec succès!"); }
	 */
}
