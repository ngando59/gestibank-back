package com.wha.springmvc.model.demande.oldclient;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wha.springmvc.model.demande.TypeDemande;
import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.model.user.Client;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("demandeclient")
public abstract class DemandeClient implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "dateDemande")
	private Date dateDemande;

	@Column(name = "type")
	private TypeDemande typeDemande;

	@JoinColumn(name = "idClient", insertable = false, updatable = false)
	@ManyToOne
	private Client idClient;

	@JoinColumn(name = "idAgent", insertable = false, updatable = false)
	@ManyToOne
	private Agent idAgent;

	public DemandeClient() {
		super();
	}

	public DemandeClient(long id, Date dateDemande, TypeDemande typeDemande, Client idClient, Agent idAgent) {
		super();
		this.id = id;
		this.dateDemande = dateDemande;
		this.typeDemande = typeDemande;
		this.idClient = idClient;
		this.idAgent = idAgent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}

	public Client getIdClient() {
		return idClient;
	}

	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}

	public Agent getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(Agent idAgent) {
		this.idAgent = idAgent;
	}

}
