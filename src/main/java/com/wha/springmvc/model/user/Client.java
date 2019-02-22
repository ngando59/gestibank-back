package com.wha.springmvc.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.wha.springmvc.model.compte.Compte;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("client")
public class Client extends Utilisateur implements Serializable {

	private int nbEnfants;
	private String situationMatrimoniale;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Compte> comptes;

	@ManyToOne(fetch = FetchType.EAGER)
	private Agent agent;

	public Client() {
		super();
		comptes = new ArrayList<Compte>();
	}

	public Client(int id, String motDePasse, String email, String nom, String prenom, String telephone, int nbEnfants,
			String situationMatrimoniale) {
		super(id, motDePasse, email, nom, prenom, telephone);
		this.nbEnfants = nbEnfants;
		this.situationMatrimoniale = situationMatrimoniale;
		comptes = new ArrayList<Compte>();
	}

	public Client(String motDePasse, String email, String nom, String prenom, String telephone, int nbEnfants,
			String situationMatrimoniale) {
		super(motDePasse, email, nom, prenom, telephone);
		this.nbEnfants = nbEnfants;
		this.situationMatrimoniale = situationMatrimoniale;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public void addCompte(Compte compte) {
		comptes.add(compte);
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
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
