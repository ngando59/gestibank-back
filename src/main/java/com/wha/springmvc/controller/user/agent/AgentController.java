package com.wha.springmvc.controller.user.agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.service.demande.newclient.IDemandeCreationDeCompteService;
import com.wha.springmvc.service.user.IAgentService;

@RestController
public class AgentController {

	@Autowired
	IAgentService agentService;

	@Autowired
	IDemandeCreationDeCompteService demandeService;

	/*--- liste des demandes de création de compte affectées à idAgent ---*/
	@GetMapping("/agent/{id}/liste-demande-creation-compte")
	public ResponseEntity<Object> listDemandeCreationDeCompte(@PathVariable("id") long idAgent) {
		List<DemandeCreationDeCompte> demandes = agentService.listeDemandeDeCreationDeCompte(idAgent);
		List<Object> json = new ArrayList<Object>();
		for (DemandeCreationDeCompte demande : demandes) {
			HashMap<Object, Object> entity = new HashMap<>();
			entity.put("id", demande.getId());
			entity.put("numero", demande.getNumero());
			entity.put("nom", demande.getGuest().getNom());
			entity.put("prenom", demande.getGuest().getPrenom());
			json.add(entity);
		}
		return new ResponseEntity<Object>(json, HttpStatus.OK);
	}

	/*--- valide la demande de création d'un compte ---*/
	@GetMapping("/agent/valider-demande-creation-compte/{id}")
	public ResponseEntity<?> validerDemandeCreationDeCompte(@PathVariable("id") long idDemande) {
		DemandeCreationDeCompte demande = demandeService.findOneById(idDemande);
		agentService.validerDemandeCreationDeCompte(idDemande);
		return ResponseEntity.ok().body("demande N° " + demande.getNumero() + " validée ! ");
	}

}
