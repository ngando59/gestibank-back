package com.wha.springmvc.model.compte;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.wha.springmvc.model.user.Client;

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
		this.setTypeCompte(TypeCompte.COURANT);
	}

	public CompteCourant(int id, String rib, TypeCompte typeCompte, Date dateCreation, Client client,
			boolean autorisationDecouvert, double montantDecouvert) {
		super(id, rib, typeCompte, dateCreation, client);
		this.autorisationDecouvert = autorisationDecouvert;
		this.montantDecouvert = montantDecouvert;
		this.setTypeCompte(TypeCompte.COURANT);
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
