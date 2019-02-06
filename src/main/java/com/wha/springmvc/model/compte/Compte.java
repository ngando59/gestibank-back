package com.wha.springmvc.model.compte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;

import com.wha.springmvc.model.operation.Operation;
import com.wha.springmvc.model.user.Client;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("compte")
public abstract class Compte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rib")
	private String rib;

	@Column(name = "type")
	private TypeCompte typeCompte;

	@Column(name = "dateCreation")
	private Date dateCreation;

	@JoinColumn(name = "idClient", insertable = false, updatable = false)
	@ManyToOne
	private Client client;

	@OneToMany(mappedBy = "idCompte")
	private List<Operation> operations;

	public Compte() {
		super();
	}

	public Compte(int id, String rib, TypeCompte typeCompte, Date dateCreation, Client client) {
		super();
		this.id = id;
		this.rib = rib;
		this.typeCompte = typeCompte;
		this.dateCreation = dateCreation;
		this.client = client;
		operations = new ArrayList<Operation>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}
