package com.wha.springmvc.service.notification.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wha.springmvc.dao.notification.INotificationDAO;
import com.wha.springmvc.model.notification.Notification;

public class NotificationServiceImpl implements INotificationDAO {

	@Autowired
	private INotificationDAO dao;
	
	@Override
	public void save(Notification notification) {
		dao.save(notification);
	}

	@Override
	public Notification findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Notification> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Notification newNotification) {
		dao.update(id, newNotification);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
