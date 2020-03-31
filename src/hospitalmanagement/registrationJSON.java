package hospitalmanagement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

/**
 * This class is used in registration. When the user registers themself into the system,
 * a new account will be made for them and then this class will write all their account
 * info to our "accounts2" JSON file.
 * @author erinpaslawski, sydneykwok
 *
 */
public class registrationJSON {

	/**
	 * This method adds the new account to our database.
	 * @param newAccount: the new account to be added
	 */
	public static void addNewAccount(Account newAccount) {
		
		// grab all the info from the new account
		String userType = newAccount.getAccountType();
		String firstName = newAccount.getFirstName();
		String lastName = newAccount.getLastName();
		String email = newAccount.getEmail();
		String gender = newAccount.getGender();
		String password = newAccount.getPassword();
		
		if (userType.equals("Administrator") || userType.equals("Assistant") || userType.equals("Doctor") || userType.equals("Nurse")) {
			// if the user is a staff member, add them to the json as such
			writeStaffAccountToJSON(userType, firstName, lastName, email, gender, password);
	    } else {
	    	// otherwise the user is a patient and we will add them as a patient
	    	writePatientAccountToJSON(firstName, lastName, newAccount.getAge(), email, gender, password);
	    }
	}
	
	/**
	 * This method writes the new account (of a user who is a patient) to the JSON.
	 * @param first: the user's first name
	 * @param last: the user's last name
	 * @param age: the user's age
	 * @param email: the user's email
	 * @param gender: the user's gender
	 * @param user: the user's username
	 * @param pass: the user's password
	 */
	public static void writePatientAccountToJSON(String first, String last, int age, String email, String gender, String pass) {
		try {
		    // create reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/accounts2.json")));

		    // create parser
		    JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

		    // read accounts array from json
		    JsonArray accounts = (JsonArray) parser.get("accounts");
		    
		    // extract the object representation of the patients section of the accounts array
		    // then get the array representation of that object
		    JsonObject patients = (JsonObject) accounts.get(0);
	    	JsonArray patientArr = (JsonArray) patients.get("patient");
	    	
	    	// Get most recent patient id
	    	JsonObject mostRecentPatient = (JsonObject) patientArr.get(patientArr.size()-1);	// get the most recently added patient
	    	// get id from last patient
	    	int lastID = ((BigDecimal) mostRecentPatient.get("id")).intValue();
	    	
	    	//close reader
		    reader.close();
	    	
	    	// Create a new patient with the given new account parameters
			JsonObject newPatient = new JsonObject();
			newPatient.put("id", lastID+1);	// id is incremented from most recent patient's id
			newPatient.put("first_name", first);
			newPatient.put("last_name", last);
			newPatient.put("age", age);
			newPatient.put("email", email);
			newPatient.put("gender", gender);
			newPatient.put("password", pass);
			JsonArray appointments = new JsonArray();
			newPatient.put("appointments", appointments);
			JsonArray prescriptions = new JsonArray();
			newPatient.put("prescriptions", prescriptions);
			
			// append new patient to patient list
			patientArr.add(newPatient);
			// put this updated patient array as the patient object
			patients.put("patient", patientArr);
			// put this updated patient object at index 0 of the accounts array
			accounts.set(0, patients);
			// put the updated accounts array as the account entry in the JSON
			parser.put("accounts", accounts);
		    
			// Create a writer
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/hospitalmanagement/accounts2.json"));

			// Write updates to JSON file
			Jsoner.serialize(parser, writer);

			// Close the writer
			writer.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	/**
	 * This method writes the new account (of a user who is a staff member) to the JSON.
	 * @param userType: the user's account type (doctor, nurse, etc.)
	 * @param first: the user's first name
	 * @param last: the user's last name
	 * @param email: the user's email
	 * @param gender: the user's gender
	 * @param user: the user's username
	 * @param pass: the user's password
	 */
	public static void writeStaffAccountToJSON(String userType, String first, String last, String email, String gender, String pass) {
		try {
		    // create reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/accounts2.json")));

		    // create parser
		    JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

		    // read accounts array from json
		    JsonArray accounts = (JsonArray) parser.get("accounts");
		    
		    // extract the object representation of the specified account type section of the accounts array
		    // then get the array representation of that object
		    JsonObject accountTypeObj;
		    JsonArray accountTypeArr;
		    String lowerCaseType;	// get the user type in lower case so it matches the JSON key names
		    int arrayIndex;
		    if (userType.equals("Administrator")) {
		    	accountTypeObj = (JsonObject) accounts.get(4);
		    	accountTypeArr = (JsonArray) accountTypeObj.get("administrator");
		    	lowerCaseType = "administrator";
		    	arrayIndex = 4;
		    } else if (userType.equals("Assistant")) {
		    	accountTypeObj = (JsonObject) accounts.get(3);
		    	accountTypeArr = (JsonArray) accountTypeObj.get("assistant");
		    	lowerCaseType = "assistant";
		    	arrayIndex = 3;
		    } else if (userType.equals("Doctor")) {
		    	accountTypeObj = (JsonObject) accounts.get(1);
		    	accountTypeArr = (JsonArray) accountTypeObj.get("doctor");
		    	lowerCaseType = "doctor";
		    	arrayIndex = 1;
		    } else {
		    	accountTypeObj = (JsonObject) accounts.get(2);
		    	accountTypeArr = (JsonArray) accountTypeObj.get("nurse");
		    	lowerCaseType = "nurse";
		    	arrayIndex = 2;
		    }
	    	
		    // get the most recently added person of that account type
	    	JsonObject mostRecentAccount = (JsonObject) accountTypeArr.get(accountTypeArr.size()-1);
	    	// get id from that person
	    	int lastID = ((BigDecimal) mostRecentAccount.get("id")).intValue();
	    	
	    	//close reader
		    reader.close();
	    	
	    	// Create a new Json Object with the given new account parameters
			JsonObject newAccount = new JsonObject();
			newAccount.put("id", lastID+1);	// id is incremented from most recent account's id
			newAccount.put("first_name", first);
			newAccount.put("last_name", last);
			newAccount.put("email", email);
			newAccount.put("gender", gender);
			newAccount.put("password", pass);
			if(userType.equals("Doctor")) {
				JsonArray appointments = new JsonArray();
				newAccount.put("appointments", appointments);
			}
			
			// append new patient to patient list
			accountTypeArr.add(newAccount);
			// put this updated patient array as the patient object
			accountTypeObj.put(lowerCaseType, accountTypeArr);
			// put this updated patient object at index 0 of the accounts array
			accounts.set(arrayIndex, accountTypeObj);
			// put the updated accounts array as the account entry in the JSON
			parser.put("accounts", accounts);
		    
			// Create a writer
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/hospitalmanagement/accounts2.json"));

			// Write updates to JSON file
			Jsoner.serialize(parser, writer);

			// Close the writer
			writer.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
}
