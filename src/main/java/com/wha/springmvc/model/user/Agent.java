package com.wha.springmvc.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.demande.oldclient.DemandeClient;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("agent")
public class Agent extends Utilisateur implements Serializable {

	public String matricule;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date debutEmbauche;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "agent")
	@Fetch(FetchMode.SUBSELECT)
	private List<Client> clients;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "agent")
	@Fetch(FetchMode.SUBSELECT)
	private List<DemandeCreationDeCompte> demandesCreationDeCompte;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idAgent")
	@Fetch(FetchMode.SUBSELECT)
	private List<DemandeClient> demandesClient;

	public Agent() {
		super();
	}

	public Agent(int id, String motDePasse, String email, String nom, String prenom, String telephone, String matricule,
			Date debutEmbauche) {
		super(id, motDePasse, email, nom, prenom, telephone);
		this.matricule = matricule;
		this.debutEmbauche = debutEmbauche;
		clients = new ArrayList<Client>();
	}

	public Agent(String motDePasse, String email, String nom, String prenom, String telephone, String matricule,
			Date debutEmbauche) {
		super(motDePasse, email, nom, prenom, telephone);
		this.matricule = matricule;
		this.debutEmbauche = debutEmbauche;
		clients = new ArrayList<Client>();
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

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<DemandeCreationDeCompte> getDemandesCreationDeCompte() {
		return demandesCreationDeCompte;
	}

	public void setDemandesCreationDeCompte(List<DemandeCreationDeCompte> demandesCreationDeCompte) {
		this.demandesCreationDeCompte = demandesCreationDeCompte;
	}

	public List<DemandeClient> getDemandesClient() {
		return demandesClient;
	}

	public void setDemandesClient(List<DemandeClient> demandesClient) {
		this.demandesClient = demandesClient;
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public void addDemandeCreationDeCompte(DemandeCreationDeCompte demandeCreationDeCompte) {
		demandesCreationDeCompte.add(demandeCreationDeCompte);
	}

	public void addDemandesClient(DemandeClient demandeClient) {
		demandesClient.add(demandeClient);
	}
}
