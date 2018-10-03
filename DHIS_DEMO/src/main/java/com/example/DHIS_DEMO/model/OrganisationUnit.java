package com.example.DHIS_DEMO.model;

import java.io.Serializable;

public class OrganisationUnit implements Serializable{
	String id;
	String displayName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
