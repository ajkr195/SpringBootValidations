package com.springboot.validations;

import java.io.File;

public class UtilityDirPath {
	static String path = "c://temp";
	static File file = new File(path);

	static boolean exists =      file.exists();      // Check if the file exists
	static boolean isDirectory = file.isDirectory(); // Check if it's a directory
	static boolean isFile =      file.isFile();
	
	public static void main(String[] args) {
	
		System.out.println(exists);
		System.out.println(isDirectory);
		System.out.println(isFile);
		
	}
	
	
}
