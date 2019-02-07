package com.wha.springmvc.model.demande.newclient;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.model.user.Client;

@SuppressWarnings("serial")
@Entity
public class DemandeCreationDeCompte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JoinColumn(name = "idAgent")
	private Agent agent;

	@ManyToOne(fetch = FetchType.EAGER)
	private Client idClient;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "demande")
	@Fetch(FetchMode.SUBSELECT)
	private List<Document> documents;

	public DemandeCreationDeCompte() {
		super();
	}

	public DemandeCreationDeCompte(long id, Agent agent, List<Document> documents) {
		super();
		this.id = id;
		this.agent = agent;
		this.documents = documents;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Client getIdClient() {
		return idClient;
	}

	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}

}
