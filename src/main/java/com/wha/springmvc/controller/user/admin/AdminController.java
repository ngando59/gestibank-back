package com.wha.springmvc.controller.user.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.service.demande.newclient.IDemandeCreationDeCompteService;
import com.wha.springmvc.service.user.IAdminService;
import com.wha.springmvc.service.user.IAgentService;

@RestController
public class AdminController {

	@Autowired
	IAdminService adminService;

	@Autowired
	IAgentService agentService;

	@Autowired
	IDemandeCreationDeCompteService demandeCreationService;

	/*--- Creation d'un agent ---*/
	@PostMapping("/admin/creer-agent")
	public ResponseEntity<?> createAgent(@RequestBody Agent agent) {
		long id = adminService.createAgent(agent);
		Agent insertAgent = agentService.findOneById(id);
		return ResponseEntity.ok().body("agent N° " + insertAgent.getMatricule() + " créer par admin ! ");
	}

	/*--- liste des demandes de création de compte ---*/
	@GetMapping("/admin/liste-demande-creation-compte")
	public ResponseEntity<Object> listDemandeCreationDeCompte() {
		List<DemandeCreationDeCompte> demandes = adminService.listeDemandesCreationCompte();
		List<Object> json = new ArrayList<Object>();
		for (DemandeCreationDeCompte demande : demandes) {
			HashMap<Object, Object> entity = new HashMap<>();
			entity.put("id", demande.getId());
			entity.put("numero", demande.getNumero());
			json.add(entity);
		}
		return new ResponseEntity<Object>(json, HttpStatus.OK);
	}

	/*-- Affectation de demande de création de compte DemandeCreation/Agent --*/
	@GetMapping("/admin/affectation-demande-creation-compte/{idDemande}/{idAgent}")
	public ResponseEntity<?> affectationOuvertureCompte(@PathVariable("idDemande") long idDemande,
			@PathVariable("idAgent") long idAgent) {
		Agent agent = agentService.findOneById(idAgent);
		DemandeCreationDeCompte demande = demandeCreationService.findOneById(idDemande);
		adminService.affectationOuvertureCompte(idDemande, idAgent);
		return ResponseEntity.ok()
				.body("Demande N° " + demande.getNumero() + " affectée à l'agent N° " + agent.getMatricule() + " !");
	}

	/*-- Liste des demandes non affectées  --*/
	@GetMapping("/admin/liste-demande-non-affectees")
	public ResponseEntity<Object> listeDemandesNonAffectees() {
		List<DemandeCreationDeCompte> demandes = adminService.listeDemandesNonAffectees();
		List<Object> json = new ArrayList<Object>();
		for (DemandeCreationDeCompte demande : demandes) {
			HashMap<Object, Object> entity = new HashMap<>();
			entity.put("id", demande.getId());
			entity.put("numero", demande.getNumero());
			json.add(entity);
		}
		return new ResponseEntity<Object>(json, HttpStatus.OK);
	}

	/*-- Liste des demandes affectées  --*/
	@GetMapping("/admin/liste-demande-affectees")
	public ResponseEntity<Object> listeDemandesAffectees() {
		List<DemandeCreationDeCompte> demandes = adminService.listeDemandesAffectees();
		List<Object> json = new ArrayList<Object>();
		for (DemandeCreationDeCompte demande : demandes) {
			HashMap<Object, Object> entity = new HashMap<>();
			entity.put("id", demande.getId());
			entity.put("numero", demande.getNumero());
			json.add(entity);
		}
		return new ResponseEntity<Object>(json, HttpStatus.OK);
	}

	/*-- rechercher agent par nom --*/
	@GetMapping("/admin/rechercher-agent-par-nom/{nom}")
	public ResponseEntity<?> rechercherAgentParNom(@PathVariable("nom") String nom) {
		List<Agent> agents = adminService.rechercherAgentParNom(nom);
		List<Object> json = new ArrayList<Object>();
		for (Agent agent : agents) {
			HashMap<Object, Object> entity = new HashMap<>();
			entity.put("id", agent.getId());
			entity.put("email", agent.getEmail());
			entity.put("identifiant", agent.getIdentifiant());
			entity.put("motDePasse", agent.getMotDePasse());
			entity.put("nom", agent.getNom());
			entity.put("prenom", agent.getPrenom());
			entity.put("telephone", agent.getTelephone());
			entity.put("debutEmbauche", agent.getDebutEmbauche());
			entity.put("matricule", agent.getMatricule());
			json.add(entity);
		}
		return new ResponseEntity<Object>(json, HttpStatus.OK);
	}

	/*-- rechercher agent par nom --*/
	@GetMapping("/admin/rechercher-agent-par-matricule/{matricule}")
	public ResponseEntity<?> rechercherAgentParMatricule(@PathVariable("matricule") String matricule) {
		Agent agent = adminService.rechercherAgentParMatricule(matricule);
		List<Object> json = new ArrayList<Object>();
		HashMap<Object, Object> entity = new HashMap<>();
		if (agent != null) {
			entity.put("id", agent.getId());
			entity.put("email", agent.getEmail());
			entity.put("identifiant", agent.getIdentifiant());
			entity.put("motDePasse", agent.getMotDePasse());
			entity.put("nom", agent.getNom());
			entity.put("prenom", agent.getPrenom());
			entity.put("telephone", agent.getTelephone());
			entity.put("debutEmbauche", agent.getDebutEmbauche());
			entity.put("matricule", agent.getMatricule());
			json.add(entity);
		}
		return new ResponseEntity<Object>(json, HttpStatus.OK);
	}

	/*-- Affectation Agent/Client --*/
	@GetMapping("/affectCtoA/{idAgent}/{idClient}")
	public ResponseEntity<?> affectClientToAgent(@PathVariable("idAgent") long idAgent,
			@PathVariable("idClient") long idClient) {
		adminService.affectationClientToAgent(idAgent, idClient);
		return ResponseEntity.ok().body("Affectation faite!");
	}

}
