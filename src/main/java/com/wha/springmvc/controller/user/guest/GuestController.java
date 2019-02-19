package com.wha.springmvc.controller.user.guest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.user.Guest;
import com.wha.springmvc.service.adresse.IAdresseService;
import com.wha.springmvc.service.demande.newclient.IDemandeCreationDeCompteService;
import com.wha.springmvc.service.user.IGuestService;

@RestController
public class GuestController {

	@Autowired
	private IDemandeCreationDeCompteService demandeService;

	@Autowired
	private IGuestService guestService;

	@Autowired
	private IAdresseService adresseService;

	/*--- demande d'ouverture de compte  ---*/
	@PostMapping("/ouvrir-compte")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> save(@RequestBody HashMap<Object, Object> json) {
		String identifiant = (String) json.get("identifiant");
		String motDePasse = (String) json.get("motDePasse");
		String email = (String) json.get("email");
		String nom = (String) json.get("nom");
		String prenom = (String) json.get("prenom");
		String telephone = (String) json.get("telephone");
		String rue = (String) json.get("rue");
		String codePostal = (String) json.get("codePostal");
		String ville = (String) json.get("ville");
		String departement = (String) json.get("departement");
		String pays = (String) json.get("pays");

		// guest
		Guest guest = new Guest(identifiant, motDePasse, email, nom, prenom, telephone);
		long idGuest = guestService.save(guest);
		// adresse
		Adresse adresse = new Adresse(rue, "", codePostal, ville, departement, pays, null);
		long idAdresse = adresseService.save(adresse);
		// Enregistrement demande ouverture compte
		DemandeCreationDeCompte demandeCreationDeCompte = new DemandeCreationDeCompte();
		long idDemande = demandeService.save(demandeCreationDeCompte);

		// M.A.J
		guest.setAdresse(adresse);
		adresse.setUtilisateur(guest);
		demandeCreationDeCompte.setGuest(guest);
		guestService.update(idGuest, guest);
		adresseService.update(idAdresse, adresse);
		demandeService.update(idDemande, demandeCreationDeCompte);

		return ResponseEntity.ok().body("demande N° " + demandeCreationDeCompte.getNumero() + " crée");
	}

	/*--- listes demandes d'ouverture de compte  ---*/

	/*--- demande d'ouverture de compte par id  ---*/

}
