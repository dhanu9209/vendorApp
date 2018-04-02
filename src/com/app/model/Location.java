package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loc_tab")
public class Location {
	@Id
	@Column(name="loc_id")
private Integer locId;
	@Column(name="loc_name")
private String locName;
	@Column(name="loc_type")
private String locType;
	public Location() {
		
	}
	
public Location(int locId) {
		this.locId=locId;
	}

public Integer getLocId() {
	return locId;
}

public void setLocId(Integer locId) {
	this.locId = locId;
}

public String getLocName() {
	return locName;
}

public void setLocName(String locName) {
	this.locName = locName;
}

public String getLocType() {
	return locType;
}

public void setLocType(String locType) {
	this.locType = locType;
}
	
	
	
	
	
}
