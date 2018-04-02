package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cust_tab")
/** customer model class having details of customers */
public class Customer {
	@Id
	@Column(name="cid") 
	/**customer id Property */
private int custId;
	@Column(name="cname")
	/**  customer name property */
private String custName;
	/**customer name Property */
	@Column(name="email")
private String custaMail;
	/**customer email Property */
	@Column(name="ctype")
private String custType;
	/**customer Type Property */
	@Column(name="addr")
private String custAddress;
	/**customer password Property */
	@Column(name="pwd")
private String password;
	/**access token Property */
	@Column(name="token")
private String accTock;
	
	/**customer address getting method */
	public String getCustAddress() {
		return custAddress;
	}
	/**customer address setter method */
	public void setCustAddress( String  custAddress) {
		this.custAddress = custAddress;
	}
	/**customer password getting method */
	public String getPassword() {
		return password;
	}
	/**customer password setting method */
	public void setPassword(String password) {
		this.password = password;
	}
	/**customer Access token getting method */
	public String getAccTock() {
		return accTock;
	}
	/**customer Access token setting method */
	public void setAccTock(String accTock) {
		this.accTock = accTock;
	}
	/**0 parm constructor , it is mandatory while reading data by get()/load() method , by using this object will be created */
	public Customer() {
	}
	/** single param constructor for creating object by using custId*/
	public Customer(int custId) {
		this.custId = custId;
	}

	@Override
	/**this method is use full while  printing whole object */
	public String toString() {
		return "Customer [custId=" + custId + "]";
	}
	/**customer custId get method */
	public int getCustId() {
		return custId;
	}
	/**customer custId set method */
	public void setCustId(int custId) {
		this.custId = custId;
	}
	/**customer customer Name getter method */
	public String getCustName() {
		return custName;
	}
	/**  customer Name set method */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**  customer Mail get method */
	public String getCustaMail() {
		return custaMail;
	}
	/**  customer Mail set method */
	public void setCustaMail(String custaMail) {
		this.custaMail = custaMail;
	}
	/**  customer customer Type get method */
	public String getCustType() {
		return custType;
	}
	/**  customer customer Type set method */
	public void setCustType(String custType) {
		this.custType = custType;
	}
	
	
}
