package com.wha.springmvc.service.demande.newclient;

import java.util.List;

import com.wha.springmvc.model.demande.newclient.Document;

public interface IDocumentService {
	void save(Document document);

	Document findOneById(long id);

	List<Document> findAll();

	void update(long id, Document document);

	void delete(long id);
}
