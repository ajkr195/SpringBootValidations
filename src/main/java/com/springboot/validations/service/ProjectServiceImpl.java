package com.springboot.validations.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.validations.model.Project;

@Service

public class ProjectServiceImpl implements ProjectService {

	@Override
	public List<String> technologyList() {
		List<String> technologyList = new ArrayList<String>();
		technologyList.add("SpringBoot");
		technologyList.add("SpringMVC");
		technologyList.add("SpringCore");
		technologyList.add("Struts2x");
		return technologyList;
	}

	@Override
	public List<String> databaseList() {
		List<String> dbtypeList = new ArrayList<String>();

		dbtypeList.add("H2");
		dbtypeList.add("MySQL");
		dbtypeList.add("PostgreSQL");
		dbtypeList.add("Oracle");
		dbtypeList.add("MS-SQL");
		return dbtypeList;
	}

	@Override
	public void populateDefaults(Project project) {

		project.setIsjpaused(true);
		project.setIsbootstrapused(true);
		project.setIsdatatablesused(true);
		project.setIsajaxused(true);
		project.setIsjqueryused(true);
		project.setIsrestcontrollerused(false);

	}

	@Override
	public boolean validatePath(String folderpath) {
		File file = new File(folderpath);
		boolean isDirectory = file.isDirectory();
		if (isDirectory) {
			System.out.println("\nService Message - Valid directory path..!! >>>>>>>>>>>>> " + folderpath + "\n");
		} else {
			System.err.println("\nService Message - INVALID directory path..!! >>>>>>>>>>>>> " + folderpath + "\n");
		}
		return isDirectory;
	}

	@Override
	public void testPathForWriteDelete(String folderpath) {
		// TODO Auto-generated method stub
		File file = new File(folderpath);
		if (file.canWrite()) {
			// write/delete access
			System.out.println("Service Message - You have write access to this directory");
			PrintWriter writer;
			File testFile = new File(folderpath + "/test.txt");
			if (testFile.exists()) {
				System.out.println("Service Message - Checking any existing file and deleting...");
				testFile.delete();
			}
			try {
				writer = new PrintWriter(testFile, "UTF-8");
				System.out.println("Service Message - Writing to test file...");
				writer.println("Ignore this file and text.");
				writer.close();
				System.out.println("Service Message - Write successful...");
				System.out.println("Service Message - Deleting file...");
				testFile.delete();
				System.out.println("Service Message - Deletion successful...");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// no write access
			System.err.println("Service Message - You DO NOT have write access to this directory !!");
		}
	}

	@Override
	public void writeConfigfile(Project project) {

		BufferedWriter bw = null;
		FileWriter fw = null;
		String configFileName = project.getProjectname() + "_config.properties";
		File projDir = new File(project.getProjectpath().replaceAll("\\\\", "//") + "//" + project.getProjectname());
		if (projDir.exists()) {
			System.out.println("Service Message - Project directory Exists...Deleting  : " + projDir.getName());
			projDir.delete();
			boolean result = false;
			System.out.println("Service Message - Recreating Project directory...");
			try {
				projDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
				System.err.println("Service Message - Project directory creation failed...!!!");
			}
			if (result) {
				System.out.println("Service Message - Project directory created...successfully.");
			}
		} else {

			System.out.println("Service Message - Project directory does not exist.!! Creating now...");
			boolean result = false;

			try {
				projDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle
				System.err.println("Service Message - Project directory creation failed...!!!");
			}
			if (result) {
				System.out.println("Service Message - Project directory created...successfully.");
			}

		}

		String fileNamePath = project.getProjectpath() + "//" + configFileName;

		File configFile = new File(fileNamePath);
		if (configFile.exists()) {
			System.out.println("Service Message - Config File Exists.!! Deleting....");
			configFile.delete();
		} else {
			System.out.println("Service Message - Config File DOES NOT Exists.!!");
		}
		try {
			fw = new FileWriter(configFile, true);
			bw = new BufferedWriter(fw);
			System.out.println("Service Message - Writing new content to Config File.!!");
			bw.write("projectname=" + project.getProjectname());
			bw.newLine();
			bw.write("projecttype=" + project.getProjecttechnology());
			bw.newLine();
			bw.write("projectdatabasetype=" + project.getProjectdatabase());
			bw.newLine();
			bw.write("projectdatabasename=" + project.getProjectdatabasename());
			bw.newLine();
			bw.write("isjpaused=" + project.isIsjpaused());
			bw.newLine();
			bw.write("isbootstrapused=" + project.isIsbootstrapused());
			bw.newLine();
			bw.write("isdatatableused=" + project.isIsdatatablesused());
			bw.newLine();
			bw.write("isajaxused=" + project.isIsajaxused());
			bw.newLine();
			bw.write("isjqueryused=" + project.isIsjqueryused());
			bw.newLine();
			bw.write("isrestcontrollerused=" + project.isIsrestcontrollerused());
			bw.close();
			System.out.println("Service Message - Successfully written new Config File \"" + configFileName
					+ "\" at this location: " + project.getProjectpath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Service Message - File not found error...!!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Service Message - File I/O error...!!");
			e.printStackTrace();
		}

	}

}
