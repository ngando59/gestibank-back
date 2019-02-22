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
	}

	public CompteRemunere(int id, String rib, Date dateCreation, Client client, double montantSeuil) {
		super(id, rib, dateCreation);
		this.montantSeuil = montantSeuil;
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
