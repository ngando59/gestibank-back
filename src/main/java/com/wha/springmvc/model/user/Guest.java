package com.wha.springmvc.model.user;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("guest")
public class Guest extends Utilisateur implements Serializable {

	public Guest() {
		super();
	}

	public Guest(int id, String identifiant, String motDePasse, String email, String nom, String prenom,
			String telephone) {
		super(id, identifiant, motDePasse, email, nom, prenom, telephone);
	}

}
