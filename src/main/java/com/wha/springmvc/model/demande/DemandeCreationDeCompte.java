package com.wha.springmvc.model.demande;

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
	private int id;

	@JoinColumn(name = "idAgent")
	private Agent agent;

	@JoinColumn(name = "documents")
	@OneToMany
	private List<Document> documents;
}
