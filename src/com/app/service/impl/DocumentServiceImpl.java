package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
import com.app.sevice.IDocumentService;
@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	private IDocumentDao documentDao;
	
	@Override
	public int saveDocument(Document doc) {
		return documentDao.saveDocument(doc);
	}
@Override
public List<Document> getAllDocs() {
	// TODO Auto-generated method stub
	return documentDao.getAllDocs();
}

@Override
public List<Object[]> getDocumentIdAndName() {
	return documentDao.getDocumentIdAndName();
}
@Override
public Document getDocumentById(int docId) {


	return documentDao.getDocumentById(docId);
}
}
