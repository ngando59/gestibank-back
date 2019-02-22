package com.wha.springmvc.controller.demande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.dao.demande.newclient.IDemandeCreationDeCompteDao;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;

@RestController
public class DemandeController {

	@Autowired
	private IDemandeCreationDeCompteDao demandeCreationDeCompteDao;

	/*---Add demande de création compte ---*/
	@PostMapping("/creationcompte")
	public ResponseEntity<?> save(@RequestBody DemandeCreationDeCompte demande) {
		demandeCreationDeCompteDao.save(demande);
		return ResponseEntity.ok().body("demande créer! ");
	}

	/**
	 * Suppresion d'une demande
	 */
	@DeleteMapping("/supprime-demande/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> deleteDemande(@PathVariable("id") long id) {
		demandeCreationDeCompteDao.delete(id);
		return ResponseEntity.ok().body("demande effacée!");
	}

}
