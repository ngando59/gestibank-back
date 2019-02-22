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

	public Admin(int id, String motDePasse, String email, String nom, String prenom, String telephone) {
		super(id, motDePasse, email, nom, prenom, telephone);
	}

	public Admin(String motDePasse, String email, String nom, String prenom, String telephone) {
		super(motDePasse, email, nom, prenom, telephone);
	}
}
