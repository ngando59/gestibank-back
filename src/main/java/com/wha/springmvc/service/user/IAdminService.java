package com.wha.springmvc.service.user;

import java.util.List;

import com.wha.springmvc.model.user.Admin;

public interface IAdminService {
	void save(Admin admin);

	Admin findOneById(long id);

	List<Admin> findAll();

	void update(long id, Admin admin);

	void delete(long id);
}
