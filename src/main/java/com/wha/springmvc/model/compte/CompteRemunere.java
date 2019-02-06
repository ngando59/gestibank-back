package com.wha.springmvc.model.compte;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.wha.springmvc.model.user.Client;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("compteremunere")
public class CompteRemunere extends Compte {

	private static final double tauxInteret = 0.02;
	private double montantSeuil;

	public CompteRemunere() {
		super();
		this.setTypeCompte(TypeCompte.REMUNERE);
	}

	public CompteRemunere(int id, String rib, TypeCompte typeCompte, Date dateCreation, Client client,
			double montantSeuil) {
		super(id, rib, typeCompte, dateCreation, client);
		this.montantSeuil = montantSeuil;
		this.setTypeCompte(TypeCompte.REMUNERE);
	}

	public double getMontantSeuil() {
		return montantSeuil;
	}

	public void setMontantSeuil(double montantSeuil) {
		this.montantSeuil = montantSeuil;
	}

	public static double getTauxinteret() {
		return tauxInteret;
	}

}
