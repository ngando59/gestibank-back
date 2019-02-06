package com.wha.springmvc.model.demande;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("demandecarte")
public class DemandeCarte extends DemandeClient implements Serializable {

	public DemandeCarte() {
		super();
		this.setTypeDemande(TypeDemande.CARTE);
	}

}
