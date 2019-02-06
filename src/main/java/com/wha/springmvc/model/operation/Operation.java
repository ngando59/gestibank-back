package com.wha.springmvc.model.operation;

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

import com.wha.springmvc.model.compte.Compte;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("operation")
public abstract class Operation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "type")
	private TypeOperation type;

	@Column(name = "montant")
	private double montant;

	@Column(name = "date")
	private Date date;

	@Column(name = "libelle")
	private String libelle;

	@JoinColumn(name = "idCompte")
	@ManyToOne
	private Compte idCompte;

	public Operation() {
		super();
	}

	public Operation(int id, TypeOperation type, double montant, Date date, String libelle, Compte idCompte) {
		super();
		this.id = id;
		this.type = type;
		this.montant = montant;
		this.date = date;
		this.libelle = libelle;
		this.idCompte = idCompte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeOperation getType() {
		return type;
	}

	public void setType(TypeOperation type) {
		this.type = type;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Compte getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Compte idCompte) {
		this.idCompte = idCompte;
	}

}
