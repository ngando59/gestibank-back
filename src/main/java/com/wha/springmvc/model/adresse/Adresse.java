package com.wha.springmvc.model.adresse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.wha.springmvc.model.user.Utilisateur;

@Entity(name = "Adresse")
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "rue")
	private String rue;

	@Column(name = "complementAdresse")
	private String complementAdresse;

	@Column(name = "codePostal")
	private String codePostal;

	@Column(name = "ville")
	private String ville;

	@Column(name = "departement")
	private String departement;

	@Column(name = "pays")
	private String pays;

	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;

	public Adresse() {
		super();
	}

	public Adresse(long id, String rue, String complementAdresse, String codePostal, String ville, String departement,
			String pays, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.rue = rue;
		this.complementAdresse = complementAdresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.departement = departement;
		this.pays = pays;
		this.utilisateur = utilisateur;
	}

	public Adresse(String rue, String complementAdresse, String codePostal, String ville, String departement,
			String pays, Utilisateur utilisateur) {
		super();
		this.rue = rue;
		this.complementAdresse = complementAdresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.departement = departement;
		this.pays = pays;
		this.utilisateur = utilisateur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplementAdresse() {
		return complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

}
