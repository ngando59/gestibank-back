package com.wha.springmvc.dao.operation;

import java.util.List;

import com.wha.springmvc.model.operation.Debit;

public interface IDeditDao {

	void save(Debit operation);

	Debit findOneById(long id);

	List<Debit> findAll();

	void update(long id, Debit newOperation);

	void delete(long id);

}
