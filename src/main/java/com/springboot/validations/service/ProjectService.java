package com.springboot.validations.service;

import java.util.List;

import com.springboot.validations.model.Project;

public interface ProjectService {
	List<String> technologyList();
	List<String> databaseList();
	void populateDefaults(Project project);
	boolean validatePath(String folderpath);
	void testPathForWriteDelete(String folderpath);
	void writeConfigfile(Project project);
}
