package com.springboot.validations.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Project {
	@NotEmpty(message = "JSR Validation - Project name can not be empty.")
	@Size(min = 4, max = 35, message = "JSR Validation - Project name must be between {2} and {1} characters.")
	private String projectname;
	@NotEmpty(message = "JSR Validation - Project path can not be empty.")
	@Size(min = 4, max = 150, message = "JSR Validation - Project path must be between {2} and {1} characters.")
	private String projectpath;
	@NotEmpty(message = "JSR Validation - You must select a Project type.")
	private String projecttechnology;
	@NotEmpty(message = "JSR Validation - You must select a Project Database type.")
	private String projectdatabase;
//	@NotEmpty(message = "You must provide a Database name. It is required.")
//	@Size(min = 4, max = 40, message = "Database name must be between {2} and {1} characters.")
	private String projectdatabasename;
	@NotNull(message = "JSR Validation - You must select JPA Option. It can not be empty.")
	private boolean isjpaused;
	@NotNull(message = "JSR Validation - You must select Bootstrap Option. It is required.")
	private boolean isbootstrapused;
	@NotNull(message = "JSR Validation - You must select  DataTable Option. It can not be empty.")
	private boolean isdatatablesused;
	@NotNull(message = "JSR Validation - You must select AJAX Option. It is required.")
	private boolean isajaxused;
	@NotNull(message = "JSR Validation - You must select JQuery Option. It can not be empty.")
	private boolean isjqueryused;
	@NotNull(message = "JSR Validation - You must select REST Controller Option. It is required.")
	private boolean isrestcontrollerused;

	public Project() {
	}

	public Project(String projectname, String projectpath, String projecttechnology, String projectdatabase,
			String projectdatabasename, boolean isjpaused, boolean isbootstrapused, boolean isdatatablesused,
			boolean isajaxused, boolean isjqueryused, boolean isrestcontrollerused) {
		this.projectname = projectname;
		this.projectpath = projectpath;
		this.projecttechnology = projecttechnology;
		this.projectdatabase = projectdatabase;
		this.projectdatabasename = projectdatabasename;
		this.isjpaused = isjpaused;
		this.isbootstrapused = isbootstrapused;
		this.isdatatablesused = isdatatablesused;
		this.isajaxused = isajaxused;
		this.isjqueryused = isjqueryused;
		this.isrestcontrollerused = isrestcontrollerused;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjectpath() {
		return projectpath;
	}

	public void setProjectpath(String projectpath) {
		this.projectpath = projectpath;
	}

	public String getProjecttechnology() {
		return projecttechnology;
	}

	public void setProjecttechnology(String projecttechnology) {
		this.projecttechnology = projecttechnology;
	}

	public String getProjectdatabase() {
		return projectdatabase;
	}

	public void setProjectdatabase(String projectdatabase) {
		this.projectdatabase = projectdatabase;
	}

	public String getProjectdatabasename() {
		return projectdatabasename;
	}

	public void setProjectdatabasename(String projectdatabasename) {
		this.projectdatabasename = projectdatabasename;
	}

	public boolean isIsjpaused() {
		return isjpaused;
	}

	public void setIsjpaused(boolean isjpaused) {
		this.isjpaused = isjpaused;
	}

	public boolean isIsbootstrapused() {
		return isbootstrapused;
	}

	public void setIsbootstrapused(boolean isbootstrapused) {
		this.isbootstrapused = isbootstrapused;
	}

	public boolean isIsdatatablesused() {
		return isdatatablesused;
	}

	public void setIsdatatablesused(boolean isdatatablesused) {
		this.isdatatablesused = isdatatablesused;
	}

	public boolean isIsajaxused() {
		return isajaxused;
	}

	public void setIsajaxused(boolean isajaxused) {
		this.isajaxused = isajaxused;
	}

	public boolean isIsjqueryused() {
		return isjqueryused;
	}

	public void setIsjqueryused(boolean isjqueryused) {
		this.isjqueryused = isjqueryused;
	}

	public boolean isIsrestcontrollerused() {
		return isrestcontrollerused;
	}

	public void setIsrestcontrollerused(boolean isrestcontrollerused) {
		this.isrestcontrollerused = isrestcontrollerused;
	}

	@Override
	public String toString() {
		return "Project [projectname=" + projectname + ", projectpath=" + projectpath + ", projecttechnology="
				+ projecttechnology + ", isjpaused=" + isjpaused + ", isbootstrapused=" + isbootstrapused
				+ ", isdatatablesused=" + isdatatablesused + ", isajaxused=" + isajaxused + ", isjqueryused="
				+ isjqueryused + "]";
	}

}
