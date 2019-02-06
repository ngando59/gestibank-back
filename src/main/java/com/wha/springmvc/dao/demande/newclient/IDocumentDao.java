package com.wha.springmvc.dao.demande.newclient;

import java.util.List;

import com.wha.springmvc.model.demande.oldclient.Document;

public interface IDocumentDao {

	void save(Document document);

	Document findOneById(long id);

	List<Document> findAll();

	void update(long id, Document newDocument);

	void delete(long id);
}
