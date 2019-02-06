package com.wha.springmvc.service.operation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wha.springmvc.model.operation.Operation;
import com.wha.springmvc.service.operation.IOperationService;

public class DebitServiceImpl implements IOperationService {

	@Autowired
	private IOperationService dao;
	
	@Override
	public void save(Operation operation) {
		dao.save(operation);
	}

	@Override
	public Operation findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Operation> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Operation newOperation) {
		dao.update(id, newOperation);
		
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
		
	}

}
