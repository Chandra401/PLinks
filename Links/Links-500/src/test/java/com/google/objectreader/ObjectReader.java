package com.google.objectreader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ObjectReader {
	Properties pro;
public ObjectReader() {
	try {
		File file=new File("./ObjectRepository/ObjectRepository.properties");
		FileInputStream fis=new FileInputStream(file);
		pro=new Properties();
		pro.load(fis);
	}catch(Exception e) {
		System.out.println("The Uncaught Exception is == "+e.getMessage());
	}
}
public String chromePath() {
	return pro.getProperty("chromePath");
}
}
