package com.wha.springmvc.model.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.model.compte.Compte;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("client")
public class Client extends Utilisateur implements Serializable {

	private int nbEnfants;
	private String situationMatrimoniale;
	@OneToMany
	private List<Compte> comptes;

	public Client() {
		super();
	}

	public Client(int id, String identifiant, String motDePasse, String email, String nom, String prenom,
			String telephone, TypeUtilisateur type, Adresse adresse) {
		super(id, identifiant, motDePasse, email, nom, prenom, telephone, type, adresse);
		this.setType(TypeUtilisateur.CLIENT);
	}

	public int getNbEnfants() {
		return nbEnfants;
	}

	public void setNbEnfants(int nbEnfants) {
		this.nbEnfants = nbEnfants;
	}

	public String getSituationMatrimoniale() {
		return situationMatrimoniale;
	}

	public void setSituationMatrimoniale(String situationMatrimoniale) {
		this.situationMatrimoniale = situationMatrimoniale;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

}
