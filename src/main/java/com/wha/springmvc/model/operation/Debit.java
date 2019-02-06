package com.wha.springmvc.model.operation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.wha.springmvc.model.compte.Compte;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("debit")
public class Debit extends Operation implements Serializable {

	public Debit() {
		super();
		this.setType(TypeOperation.DEBIT);
	}

	public Debit(int id, TypeOperation type, double montant, Date date, String libelle, Compte idCompte) {
		super(id, type, montant, date, libelle, idCompte);
		this.setType(TypeOperation.DEBIT);
	}

}
