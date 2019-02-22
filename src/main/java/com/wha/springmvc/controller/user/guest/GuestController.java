package com.wha.springmvc.controller.user.guest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.service.user.IGuestService;
import com.wha.springmvc.utils.Reponse;

@RestController
public class GuestController {

	@Autowired
	private IGuestService guestService;

	/*--- demande d'ouverture de compte  ---*/
	@PostMapping("/ouvrir-compte")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> save(@RequestBody HashMap<Object, Object> json) {
		String motDePasse = (String) json.get("motDePasse");
		String email = (String) json.get("email");
		String nom = (String) json.get("nom");
		String prenom = (String) json.get("prenom");
		String telephone = (String) json.get("telephone");
		int nbEnfants = (int) json.get("nbEnfants");
		String situationMatrimoniale = (String) json.get("situationMatrimoniale");
		String rue = (String) json.get("rue");
		String codePostal = (String) json.get("codePostal");
		String ville = (String) json.get("ville");
		String pays = (String) json.get("pays");

		Reponse rep = guestService.demandeCreationDeCompte(motDePasse, email, nom, prenom, telephone, nbEnfants,
				situationMatrimoniale, rue, codePostal, ville, pays);

		String message = "";

		switch (rep) {
		case SUCCESS:
			message = "Votre demande de création de compte a été envoyé!<br>Nous reviendrons vers vous bientôt après étude de votre dossier!";
			break;
		case FAILURE:
			message = "Erreur serveur lors de la création de votre compte!<br>Veuillez reesayer ultérieurement!";
		case ALREADY:
			message = "Vous avez une demande en cours ou vous possedez déjà un compte chez nous !";
		default:
			break;
		}
		HashMap<Object, Object> entity = new HashMap<>();
		entity.put("response", message);
		return new ResponseEntity<Object>(entity, HttpStatus.OK);
	}

}
