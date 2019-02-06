package com.wha.springmvc.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.wha.springmvc.model.adresse.Adresse;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("agent")
public class Agent extends Utilisateur implements Serializable {

	public String matricule;
	public Date debutEmbauche;

	public Agent() {
		super();
	}

	public Agent(int id, String identifiant, String motDePasse, String email, String nom, String prenom,
			String telephone, TypeUtilisateur type, Adresse adresse) {
		super(id, identifiant, motDePasse, email, nom, prenom, telephone, type, adresse);
		this.setType(TypeUtilisateur.AGENT);
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Date getDebutEmbauche() {
		return debutEmbauche;
	}

	public void setDebutEmbauche(Date debutEmbauche) {
		this.debutEmbauche = debutEmbauche;
	}

}
