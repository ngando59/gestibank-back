package com.wha.springmvc.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.model.user.Admin;
import com.wha.springmvc.service.user.IAdminService;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Override
	public void save(Admin admin) {
		// TODO Auto-generated method stub
	}

	@Override
	public Admin findOneById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
