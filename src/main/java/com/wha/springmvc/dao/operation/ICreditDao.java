package com.wha.springmvc.dao.operation;

import java.util.List;

import com.wha.springmvc.model.operation.Credit;

public interface ICreditDao {

	void save(Credit operation);

	Credit findOneById(long id);

	List<Credit> findAll();

	void update(long id, Credit newOperation);

	void delete(long id);

}
