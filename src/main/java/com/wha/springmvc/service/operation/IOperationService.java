package com.wha.springmvc.service.operation;

import java.util.List;

import com.wha.springmvc.model.operation.Operation;

public interface IOperationService {
	
	void save(Operation operation);

	Operation findOneById(long id);

	List<Operation> findAll();

	void update(long id, Operation newOperation);

	void delete(long id);

}
