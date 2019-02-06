package com.wha.springmvc.service.operation;

import java.util.List;

import com.wha.springmvc.model.operation.Debit;

public interface IDebitService {

	void save(Debit operation);

	Debit findOneById(long id);

	List<Debit> findAll();

	void update(long id, Debit newDebit);

	void delete(long id);

}
