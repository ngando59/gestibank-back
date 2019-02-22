package com.wha.springmvc.controller.user;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.service.user.IAdminService;
import com.wha.springmvc.service.user.IAgentService;
import com.wha.springmvc.service.user.IClientService;
import com.wha.springmvc.service.user.IGuestService;

@RestController
public class UserController {

	@Autowired
	private IGuestService guestService;
	@Autowired
	private IClientService clientService;
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IAgentService agentService;

	/*--- connexion ---*/
	@PostMapping("/connexion")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> save(@RequestBody HashMap<Object, Object> json) {
		String email = (String) json.get("email");
		String password = (String) json.get("motDePasse");

		long idAdmin = 0;
		long idGuest = 0;
		long idAgent = 0;
		long idClient = 0;

		idAdmin = adminService.login(email, password);
		idGuest = guestService.login(email, password);
		idAgent = agentService.login(email, password);
		idClient = clientService.login(email, password);

		if (idAdmin > 0) {
			return ResponseEntity.ok().body("Administrateur " + idAdmin + " connecté");
		} else if (idGuest > 0) {
			return ResponseEntity.ok().body("Guest " + idGuest + " connecté");
		} else if (idAgent > 0) {
			return ResponseEntity.ok().body("Agent " + idAgent + " connecté");
		} else if (idClient > 0) {
			return ResponseEntity.ok().body("Client " + idClient + " connecté");
		}
		return ResponseEntity.ok().body("mauvais login ou mot de passe");
	}
}
