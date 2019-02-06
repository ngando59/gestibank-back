package com.wha.springmvc.service.operation;

import java.util.List;

import com.wha.springmvc.model.operation.Credit;

public interface ICreditService {

	void save(Credit operation);

	Credit findOneById(long id);

	List<Credit> findAll();

	void update(long id, Credit newCredit);

	void delete(long id);

}
