package com.wha.springmvc.dao.user;

import java.util.List;

import com.wha.springmvc.model.user.Admin;

public interface IAdminDao {
	void save(Admin user);

	Admin findOneById(long id);

	List<Admin> findAll();

	void update(long id, Admin user);

	void delete(long id);
}