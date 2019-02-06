package com.wha.springmvc.service.demande.newclient;

import java.util.List;

import com.sun.xml.internal.txw2.Document;
import com.wha.springmvc.model.adresse.Adresse;

public interface IDocumentService {
	void save(Document document);

	Adresse findOneById(long id);

	List<Document> findAll();

	void update(long id, Document document);

	void delete(long id);
}
