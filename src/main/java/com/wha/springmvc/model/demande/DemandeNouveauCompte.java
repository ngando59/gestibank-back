package com.wha.springmvc.model.demande;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("demandenouveaucompte")
public class DemandeNouveauCompte extends DemandeClient implements Serializable {

	public DemandeNouveauCompte() {
		super();
		this.setTypeDemande(TypeDemande.DEMANDENOUVEAUCOMPTE);
	}

}
