package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveDocument(Document doc) {
		return (Integer)ht.save(doc);
	}
@Override
public List<Document> getAllDocs() {
	// TODO Auto-generated method stub
	return ht.loadAll(Document.class);
}
@Override
public List<Object[]> getDocumentIdAndName() {
	String hql="select docId,docName from com.app.model.Document";
	@SuppressWarnings("unchecked")
	List<Object[]> find = (List<Object[]>)ht.find(hql);
	return find;
}
@Override
public Document getDocumentById(int docId) {
	// TODO Auto-generated method stub
	return ht.get(Document.class, docId);
}
}
