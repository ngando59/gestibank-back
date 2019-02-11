package com.wha.springmvc.service.demande.newclient.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.demande.newclient.IDocumentDao;
import com.wha.springmvc.model.demande.newclient.Document;
import com.wha.springmvc.service.demande.newclient.IDocumentService;

@Service
@Transactional
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	private IDocumentDao dao;

	@Override
	public void save(Document document) {
		dao.save(document);
	}

	@Override
	public Document findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Document> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Document document) {
		dao.update(id, document);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
