package com.hospitalmanagement;

import java.io.File;
import java.io.IOException;

public class createJSONFile {
	  public static void main(String[] args) {

	  }
	  public static void createFile(String userID){
		    try {
			      File myObj = new File("src/hospitalSystem/" + userID + ".json");
			      if (myObj.createNewFile()) {
			        System.out.println("File created: " + myObj.getName());
			      } else {
			        System.out.println("File already exists.");
			      }
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
	  }
	}