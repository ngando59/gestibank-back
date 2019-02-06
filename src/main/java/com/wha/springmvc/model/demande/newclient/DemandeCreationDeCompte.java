package com.wha.springmvc.model.demande.newclient;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.wha.springmvc.model.user.Agent;

@SuppressWarnings("serial")
@Entity
public class DemandeCreationDeCompte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JoinColumn(name = "idAgent")
	private Agent agent;

	@JoinColumn(name = "documents")
	@OneToMany
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

}
