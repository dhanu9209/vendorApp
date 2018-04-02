package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="doc_tab")
public class Document {
	@Id
	@Column(name="doc_id")
	private int docId;
	@Column(name="doc_name")
	private String docName;
	@Column(name="doc_data")
	@Lob
	private byte[] docData;
	
	public Document(int docId) {
		super();
		this.docId = docId;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public byte[] getDocData() {
		return docData;
	}
	public void setDocData(byte[] docData) {
		this.docData = docData;
	}
	public Document() {
		super();
	}

}
