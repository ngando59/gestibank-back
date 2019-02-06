package com.wha.springmvc.dao.user.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.user.IAdminDao;
import com.wha.springmvc.model.user.Admin;

@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
	}

	@Override
	public Admin findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Admin.class, id);
	}

	@Override
	public List<Admin> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Admin> cq = cb.createQuery(Admin.class);
		Root<Admin> root = cq.from(Admin.class);
		cq.select(root);
		Query<Admin> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		Admin admin2 = session.byId(Admin.class).load(id);
		admin2.setIdentifiant(admin.getIdentifiant());
		admin2.setMotDePasse(admin.getMotDePasse());
		admin2.setEmail(admin.getEmail());
		admin2.setNom(admin.getNom());
		admin2.setPrenom(admin.getPrenom());
		admin2.setTelephone(admin.getTelephone());
		admin2.setType(admin.getType());
		admin2.setAdresse(admin.getAdresse());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Admin admin = session.byId(Admin.class).load(id);
		session.delete(admin);
	}

}
