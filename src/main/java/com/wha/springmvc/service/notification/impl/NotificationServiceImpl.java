package com.wha.springmvc.service.notification.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wha.springmvc.model.notification.Notification;
import com.wha.springmvc.service.notification.INotificationService;

public class NotificationServiceImpl implements INotificationService {

	@Autowired
	private INotificationService dao;
	
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
