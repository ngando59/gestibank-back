package com.wha.springmvc.model.compte;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("comptecourant")
public class CompteCourant extends Compte {

	private boolean autorisationDecouvert;
	private double montantDecouvert;

	private static final double tauxInteret = 0.18;
	private static final double seuilDecouvert = 0.4;

	public CompteCourant() {
		super();
	}

	public CompteCourant(int id, String rib, Date dateCreation, boolean autorisationDecouvert,
			double montantDecouvert) {
		super(id, rib, dateCreation);
		this.autorisationDecouvert = autorisationDecouvert;
		this.montantDecouvert = montantDecouvert;
	}

	public boolean isAutorisationDecouvert() {
		return autorisationDecouvert;
	}

	public void setAutorisationDecouvert(boolean autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}

	public double getMontantDecouvert() {
		return montantDecouvert;
	}

	public void setMontantDecouvert(double montantDecouvert) {
		this.montantDecouvert = montantDecouvert;
	}

	public static double getTauxinteret() {
		return tauxInteret;
	}

	public static double getSeuildecouvert() {
		return seuilDecouvert;
	}

}
