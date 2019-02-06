package com.wha.springmvc.service.operation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wha.springmvc.dao.operation.IDeditDao;
import com.wha.springmvc.model.operation.Debit;
import com.wha.springmvc.service.operation.IDebitService;

public class DebitServiceImpl implements IDebitService {

	@Autowired
	private IDeditDao dao;

	@Override
	public void save(Debit operation) {
		dao.save(operation);
	}

	@Override
	public Debit findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Debit> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Debit newDebit) {
		dao.update(id, newDebit);

	}

	@Override
	public void delete(long id) {
		dao.delete(id);

	}

}
