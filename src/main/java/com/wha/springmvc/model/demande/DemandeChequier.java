package com.wha.springmvc.model.demande;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("demandechequier")
public class DemandeChequier extends DemandeClient {

	public DemandeChequier() {
		super();
		this.setTypeDemande(TypeDemande.CHEQUIER);
	}

}
