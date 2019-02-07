package com.wha.springmvc.dao.notification;

import java.util.List;

import com.wha.springmvc.model.notification.Notification;

public interface INotificationDao {
	
	void save(Notification notification);

	Notification findOneById(long id);

	List<Notification> findAll();

	void update(long id, Notification newNotification);

	void delete(long id);

}
