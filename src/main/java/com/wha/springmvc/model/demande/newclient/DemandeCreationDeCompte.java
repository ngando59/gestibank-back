package com.wha.springmvc.model.demande.newclient;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import com.wha.springmvc.model.user.Guest;

@SuppressWarnings("serial")
@Entity
public class DemandeCreationDeCompte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "numero")
	private String numero;

	@JoinColumn(name = "idAgent")
	@ManyToOne
	private Agent agent;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Guest guest;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "demande", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Document> documents;

	public DemandeCreationDeCompte() {
		super();
	}

	public DemandeCreationDeCompte(long id, Agent agent, Guest guest, List<Document> documents) {
		super();
		this.id = id;
		this.guest = guest;
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

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
