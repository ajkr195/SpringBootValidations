package com.springboot.validations.model;

import java.util.List;

public class ProjectEntity {
	private String entityname;
	private List<String> entityfields;

	public ProjectEntity() {
	}

	public ProjectEntity(String entityname, List<String> entityfields) {
		this.entityname = entityname;
		this.entityfields = entityfields;
	}

	public String getEntityname() {
		return entityname;
	}

	public void setEntityname(String entityname) {
		this.entityname = entityname;
	}

	public List<String> getEntityfields() {
		return entityfields;
	}

	public void setEntityfields(List<String> entityfields) {
		this.entityfields = entityfields;
	}

	@Override
	public String toString() {
		return "ProjectEntity [entityname=" + entityname + ", entityfields=" + entityfields + "]";
	}
}
