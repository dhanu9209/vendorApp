package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="ven_tab")
public class Vendor {
	@Id
	@Column(name="ven_id")
private int vendorId;
	@Column(name="ven_name")
private String vendorName;
	@Column(name="ven_mail")
private String  vendorMail;
	@Column(name="ven_address")
private String vendorAddress;
	@Column(name="ven_type")
private String vendorType;
	@Column(name="ven_RegIdType")
private String vendorRegIdType;
	@Column(name="ven_regid")
private String vendorRegId;
	@ManyToOne
	@JoinColumn(name="locFk")
private Location location;
	
	
public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
public Vendor() {
	super();
}
public Vendor(int vendorId) {
	super();
	this.vendorId = vendorId;
}
@Override
public String toString() {
	return "Vendor [vendorAddress=" + vendorAddress + ", vendorId=" + vendorId
			+ ", vendorMail=" + vendorMail + ", vendorName=" + vendorName
			+ ", vendorRegId=" + vendorRegId + ", vendorRegIdType="
			+ vendorRegIdType + ", vendorType=" + vendorType + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}
public int getVendorId() {
	return vendorId;
}
public void setVendorId(int vendorId) {
	this.vendorId = vendorId;
}
public String getVendorName() {
	return vendorName;
}
public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}
public String getVendorMail() {
	return vendorMail;
}
public void setVendorMail(String vendorMail) {
	this.vendorMail = vendorMail;
}
public String getVendorAddress() {
	return vendorAddress;
}
public void setVendorAddress(String vendorAddress) {
	this.vendorAddress = vendorAddress;
}
public String getVendorType() {
	return vendorType;
}
public void setVendorType(String vendorType) {
	this.vendorType = vendorType;
}
public String getVendorRegIdType() {
	return vendorRegIdType;
}
public void setVendorRegIdType(String vendorRegIdType) {
	this.vendorRegIdType = vendorRegIdType;
}
public String getVendorRegId() {
	return vendorRegId;
}
public void setVendorRegId(String vendorRegId) {
	this.vendorRegId = vendorRegId;
}

}
