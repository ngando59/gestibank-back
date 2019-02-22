package com.wha.springmvc.model.user;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.wha.springmvc.model.adresse.Adresse;

@SuppressWarnings("serial")
@Entity
public class Guest implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "motDePasse")
	private String motDePasse;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "telephone")
	private String telephone;

	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adresse;
	private int nbEnfants;
	private String situationMatrimoniale;

	public Guest() {
		super();
	}

	public Guest(String motDePasse, String email, String nom, String prenom, String telephone, Adresse adresse,
			int nbEnfants, String situationMatrimoniale) {
		super();
		this.motDePasse = motDePasse;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.nbEnfants = nbEnfants;
		this.situationMatrimoniale = situationMatrimoniale;
	}

	public Guest(String motDePasse, String email, String nom, String prenom, String telephone, int nbEnfants,
			String situationMatrimoniale) {
		super();
		this.motDePasse = motDePasse;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.nbEnfants = nbEnfants;
		this.situationMatrimoniale = situationMatrimoniale;
	}

	public Guest(long id, String motDePasse, String email, String nom, String prenom, String telephone, Adresse adresse,
			int nbEnfants, String situationMatrimoniale) {
		super();
		this.id = id;
		this.motDePasse = motDePasse;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.nbEnfants = nbEnfants;
		this.situationMatrimoniale = situationMatrimoniale;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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

}
