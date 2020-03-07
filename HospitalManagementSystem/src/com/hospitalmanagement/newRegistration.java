package com.hospitalmanagement; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonKey;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;

public class newRegistration {
	
	static createJSONFile jcreator = new createJSONFile();
	
   public static void main(String args[]) {
	   /*
	   String id = "ID";
	   String FirstName = "Erin";
	   String LastName = "Paslawski";
	   String Password = "MyPswrd";
	   Calendar BirthDate = Calendar.getInstance();
	   addInfo(id,FirstName,LastName,Password);	// addInfo(id,FirstName,LastName,Password,BirthDate);
	   */
   }
   public static void addInfo(String id, String FirstName, String LastName, String Password, String fp) {
		  jcreator.createFile(id, fp);
	      //Creating a JSONObject object
	      JsonObject jObject = new JsonObject();
	      //Inserting key-value pairs into the json object
	      jObject.put("ID", id);
	      jObject.put("First_Name", FirstName);
	      jObject.put("Last_Name", LastName);
	      //jsonObject.put("Date_Of_Birth", BirthDate);
	      jObject.put("Password", Password);
	      try {
	         FileWriter file = new FileWriter(fp + id +".json");	//"src/com/hospitalmanagement/"+
	         file.write(jObject.toString());
	         file.close();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      System.out.println("JSON file created: "+jObject);
   }
}


