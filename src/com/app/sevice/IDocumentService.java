package com.app.sevice;

import java.util.List;

import com.app.model.Document;

public interface IDocumentService {
	public int saveDocument(Document doc);
	public List<Document>getAllDocs();
	public List<Object[]>getDocumentIdAndName();
	public Document getDocumentById(int docId);
}
