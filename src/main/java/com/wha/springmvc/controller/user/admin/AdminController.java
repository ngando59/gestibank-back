package com.wha.springmvc.controller.user.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.service.user.IAdminService;

@RestController
public class AdminController {
	@Autowired
	IAdminService adminService;

	/*--- Creation d'agent ---*/
	@PostMapping("/createAgent")
	public ResponseEntity<?> createAgent(@RequestBody Agent agent) {
		long id = adminService.createAgent(agent);
		return ResponseEntity.ok().body("agent ID=" + id + " créer par admin! ");
	}

	/*-- Affectation Agent/Client --*/
	@GetMapping("/affectCtoA/{idAgent}/{idClient}")
	public ResponseEntity<?> affectClientToAgent(@PathVariable("idAgent") long idAgent,
			@PathVariable("idClient") long idClient) {
		adminService.affectationClientToAgent(idAgent, idClient);
		return ResponseEntity.ok().body("Affectation faite!");
	}

}
