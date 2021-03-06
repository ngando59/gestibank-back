package com.wha.springmvc.model.demande.newclient;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Document implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "libelle")
	private String libelle;

	@Column(name = "lien")
	private String lien;

	@JoinColumn(name = "idDemande")
	@ManyToOne
	private DemandeCreationDeCompte demande;

	public Document() {
		super();

	}

	public Document(long id, String libelle, String lien, DemandeCreationDeCompte demande) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.lien = lien;
		this.demande = demande;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public DemandeCreationDeCompte getDemande() {
		return demande;
	}

	public void setDemande(DemandeCreationDeCompte demande) {
		this.demande = demande;
	}

}
