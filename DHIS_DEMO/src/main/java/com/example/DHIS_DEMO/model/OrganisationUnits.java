package com.example.DHIS_DEMO.model;

import java.io.Serializable;
import java.util.List;

public class OrganisationUnits implements Serializable{
	PageInfo pager;
	List<OrganisationUnit> organisationUnits;
	public PageInfo getPager() {
		return pager;
	}
	public void setPager(PageInfo pager) {
		this.pager = pager;
	}
	public List<OrganisationUnit> getOrganisationUnits() {
		return organisationUnits;
	}
	public void setOrganisationUnits(List<OrganisationUnit> organisationUnits) {
		this.organisationUnits = organisationUnits;
	}
	
}
