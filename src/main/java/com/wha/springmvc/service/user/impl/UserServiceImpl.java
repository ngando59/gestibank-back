package com.wha.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.user.IUtilisateurDao;
import com.wha.springmvc.model.user.Utilisateur;
import com.wha.springmvc.service.user.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUtilisateurDao dao;

	@Override
	public void save(Utilisateur utilisateur) {
		dao.save(utilisateur);
	}

	@Override
	public Utilisateur findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Utilisateur> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Utilisateur utilisateur) {
		dao.update(id, utilisateur);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
