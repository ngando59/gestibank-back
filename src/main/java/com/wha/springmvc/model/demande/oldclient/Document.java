package com.wha.springmvc.model.demande.oldclient;

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
	private int id;

	@Column(name = "libelle")
	private String libelle;

	@Column(name = "lien")
	private String lien;

	@JoinColumn(name = "idDemande")
	@ManyToOne
	private DemandeCreationDeCompte demande;
}
