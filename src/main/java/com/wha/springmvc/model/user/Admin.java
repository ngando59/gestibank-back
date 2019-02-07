package com.wha.springmvc.model.user;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("admin")
public class Admin extends Utilisateur implements Serializable {

	public Admin() {
		super();
	}

	public Admin(int id, String identifiant, String motDePasse, String email, String nom, String prenom,
			String telephone) {
		super(id, identifiant, motDePasse, email, nom, prenom, telephone);
	}

	public Admin(String identifiant, String motDePasse, String email, String nom, String prenom, String telephone) {
		super(identifiant, motDePasse, email, nom, prenom, telephone);
	}
}
