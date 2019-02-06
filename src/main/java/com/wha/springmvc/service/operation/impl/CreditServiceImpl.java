package com.wha.springmvc.service.operation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wha.springmvc.dao.operation.ICreditDao;
import com.wha.springmvc.model.operation.Credit;
import com.wha.springmvc.service.operation.ICreditService;

public class CreditServiceImpl implements ICreditService {

	@Autowired
	private ICreditDao dao;

	@Override
	public void save(Credit operation) {
		dao.save(operation);
	}

	@Override
	public Credit findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Credit> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Credit newCredit) {
		dao.update(id, newCredit);

	}

	@Override
	public void delete(long id) {
		dao.delete(id);

	}

}
