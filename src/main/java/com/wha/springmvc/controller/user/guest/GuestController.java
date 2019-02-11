package com.wha.springmvc.controller.user.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	private IGuestService guestService;

	@Autowired
	private IAdresseService adresseService;

	@Autowired
	private IDemandeCreationDeCompteService demandeService;

	/*--- Creation d'agent ---*/
	@PostMapping("/newcompte")
	public ResponseEntity<?> createAgent(@RequestParam("identifiant") String identifiant,
			@RequestParam("motDePasse") String motDePasse, @RequestParam("telephone") String telephone,
			@RequestParam("email") String email, @RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
			@RequestParam("rue") String rue, @RequestParam("codePostal") String codePostal,
			@RequestParam("ville") String ville, @RequestParam("departement") String departement,
			@RequestParam("pays") String pays) {

		Guest guest = new Guest(identifiant, motDePasse, email, nom, prenom, telephone);
		Adresse adresse = new Adresse(rue, "", codePostal, ville, departement, pays, guest);

		DemandeCreationDeCompte demandeCreationDeCompte = new DemandeCreationDeCompte();
		demandeCreationDeCompte.setGuest(guest);

		guestService.save(guest);
		adresseService.save(adresse);
		long id = demandeService.save(demandeCreationDeCompte);

		return ResponseEntity.ok().body("demande ID=" + id + " ! ");
	}
}
