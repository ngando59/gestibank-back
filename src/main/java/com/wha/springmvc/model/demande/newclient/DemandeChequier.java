package com.wha.springmvc.model.demande.newclient;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.wha.springmvc.model.demande.TypeDemande;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("demandechequier")
public class DemandeChequier extends DemandeClient {

	public DemandeChequier() {
		super();
		this.setTypeDemande(TypeDemande.CHEQUIER);
	}

}
