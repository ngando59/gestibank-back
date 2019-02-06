package com.wha.springmvc.dao.notification.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.notification.INotificationDAO;
import com.wha.springmvc.model.notification.Notification;

@Repository
public class NotificationDaoImpl implements INotificationDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Notification notification) {
		sessionFactory.getCurrentSession().save(notification);
	}

	@Override
	public Notification findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Notification.class, id);
	}

	@Override
	public List<Notification> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Notification> cq = cb.createQuery(Notification.class);
		Root<Notification> root = cq.from(Notification.class);
		cq.select(root);
		Query<Notification> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Notification newNotification) {
		Session session = sessionFactory.getCurrentSession();
		Notification notification = session.byId(Notification.class).load(id);
		notification.setId(newNotification.getId());
		notification.setObjet(newNotification.getObjet());
		notification.setContenu(newNotification.getContenu());
		notification.setLu(newNotification.isLu());
		notification.setDate(newNotification.getDate());
		notification.setUtilisateur(newNotification.getUtilisateur());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Notification notification = session.byId(Notification.class).load(id);
		session.delete(notification);
	}
}
