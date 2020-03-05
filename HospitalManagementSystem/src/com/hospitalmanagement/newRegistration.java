package com.hospitalmanagement; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonKey;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;


public class newRegistration {
   public static void main(String args[]) {
	   String id = "ID";
	   String FirstName = "Erin";
	   String LastName = "Paslawski";
	   String Password = "MyPswrd";
	   Date BirthDate = new Date();
	   addInfo(id,FirstName,LastName,Password,BirthDate);
   }
   public static void addInfo(String id, String FirstName, String LastName, String Password, Date BirthDate) {
		  createJSONFile.createFile(id);
	      //Creating a JSONObject object
	      JsonObject jsonObject = new JsonObject();
	      //Inserting key-value pairs into the json object
	      jsonObject.put("ID", id);
	      jsonObject.put("First_Name", FirstName);
	      jsonObject.put("Last_Name", LastName);
	      jsonObject.put("Date_Of_Birth", BirthDate);
	      jsonObject.put("Password", Password);
	      try {
	         FileWriter file = new FileWriter("src/hospitalSystem/"+id+".json");
	         file.write(jsonObject.toString());
	         file.close();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      System.out.println("JSON file created: "+jsonObject);
   }
}


