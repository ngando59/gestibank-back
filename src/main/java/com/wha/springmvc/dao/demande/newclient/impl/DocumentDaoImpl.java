package com.wha.springmvc.dao.demande.newclient.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.wha.springmvc.dao.demande.newclient.IDocumentDao;
import com.wha.springmvc.model.demande.newclient.Document;

public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Document document) {
		sessionFactory.getCurrentSession().save(document);
	}

	@Override
	public Document findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Document.class, id);
	}

	@Override
	public List<Document> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Document> cq = cb.createQuery(Document.class);
		Root<Document> root = cq.from(Document.class);
		cq.select(root);
		Query<Document> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Document newDocument) {
		Session session = sessionFactory.getCurrentSession();
		Document doc = session.byId(Document.class).load(id);
		doc.setLibelle(newDocument.getLibelle());
		doc.setLien(newDocument.getLien());
		doc.setDemande(newDocument.getDemande());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Document doc = session.byId(Document.class).load(id);
		session.delete(doc);
	}
}
