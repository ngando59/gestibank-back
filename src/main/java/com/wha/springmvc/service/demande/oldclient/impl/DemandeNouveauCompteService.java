package com.wha.springmvc.service.demande.oldclient.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.model.demande.oldclient.DemandeClient;
import com.wha.springmvc.service.demande.oldclient.IDemandeClientService;

@Service
@Transactional
public class DemandeNouveauCompteService implements IDemandeClientService {

	@Override
	public void save(DemandeClient demandeClient) {
		// TODO Auto-generated method stub

	}

	@Override
	public Adresse findOneById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemandeClient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, DemandeClient demandeClient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
