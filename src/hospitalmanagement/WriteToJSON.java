package hospitalmanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

/**
 * This class is used in registration. When the user registers themself into the
 * system, a new account will be made for them and then this class will write
 * all their account info to our "accounts2" JSON file.
 * 
 * @author erinpaslawski, sydneykwok
 *
 */
public class WriteToJSON {

	/**
	 * This method adds the new account to our database.
	 * @param newAccount: the new account to be added
	 * @throws Exception if email given is already in system, throw an exception
	 */
	public static void addNewAccount(Account newAccount) throws Exception {
		
		// grab all the info from the new account
		String userType = newAccount.getAccountType();
		String firstName = newAccount.getFirstName();
		String lastName = newAccount.getLastName();
		String email = newAccount.getEmail();
		String gender = newAccount.getGender();
		String password = newAccount.getPassword();
		
		if (invalidRegistrationCredentials(email, userType)) {
			Register rframe = new Register();
			JOptionPane.showMessageDialog(rframe, "The email you have given is already in the system.");
			throw new Exception("Email already exists.");
		} else if (userType.equals("Administrator") || userType.equals("Assistant") || userType.equals("Doctor") || userType.equals("Nurse")) {
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

	    	// id is incremented from most recent patient's id
	    	String id = Integer.toString(Integer.parseInt((String)mostRecentPatient.get("id")) +1);
	    	
	    	//close reader
		    reader.close();
	    	
	    	// Create a new patient with the given new account parameters
			JsonObject newPatient = new JsonObject();

			newPatient.put("id", id);	
			newPatient.put("first_name", first);
			newPatient.put("last_name", last);
			newPatient.put("age", Integer.toString(age));
      
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

	    	String id = Integer.toString( Integer.parseInt((String) mostRecentAccount.get("id")) +1);
	    	
	    	//close reader
		    reader.close();
	    	
	    	// Create a new Json Object with the given new account parameters
			JsonObject newAccount = new JsonObject();

			newAccount.put("id", id);	// id is incremented from most recent account's id

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

	private static boolean invalidRegistrationCredentials(String user, String userType) {
		boolean isInvalid = false;
		try {
		    // create reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/accounts2.json")));

		    // create parser
		    JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

		    // read accounts array from json
		    JsonArray accounts = (JsonArray) parser.get("accounts");
		    
		    // extract the object representation of the account type from the accounts array
		    // then get the array representation of that account type
		    // then create an iterator to iterate through that array
		    Iterator i;
		    
		    if (userType.equals("Administrator")) {
		    	JsonObject administrators = (JsonObject) accounts.get(4);
		    	JsonArray adminArr = (JsonArray) administrators.get("administrator");
		    	i = adminArr.iterator();
		    } else if (userType.equals("Assistant")) {
		    	JsonObject assistants = (JsonObject) accounts.get(3);
		    	JsonArray assistantArr = (JsonArray) assistants.get("assistant");
		    	i = assistantArr.iterator();
		    } else if (userType.equals("Doctor")) {
		    	JsonObject doctors = (JsonObject) accounts.get(1);
		    	JsonArray doctorArr = (JsonArray) doctors.get("doctor");
		    	i = doctorArr.iterator();
		    } else if (userType.equals("Nurse")) {
		    	JsonObject nurses = (JsonObject) accounts.get(2);
		    	JsonArray nurseArr = (JsonArray) nurses.get("nurse");
		    	i = nurseArr.iterator();
		    } else {
		    	JsonObject patients = (JsonObject) accounts.get(0);
		    	JsonArray patientArr = (JsonArray) patients.get("patient");
		    	i = patientArr.iterator();
		    }
		    
		    // iterate through all pairs of usernames and passwords in the user type array
		    while (i.hasNext()) {
		    	
		        JsonObject account = (JsonObject) i.next();
		        String username = (String) account.get("email");
		        
		        // if the login credentials match a pair in the database, the input is valid!
		        if(user.equals(username)) {
		        	isInvalid = true;
		        }
		    }
		    
		    //close reader
		    reader.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		
		return isInvalid;
	}
	
	
	/**
	 * This method writes the doctor to the assigned department in the JSON.
	 * 
	 * @param username:   the doctor's username
	 * @param department: the department that is to be written to
	 * @author erinpaslawski
	 * @return false if failed, true otherwise
	 */
	public static int addDocToDepartment(String username, String department) {
		try {
			// create reader
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/hospitalmanagement/departments.json")));

			// create parser
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

			// read departments array from json
			JsonArray departments = (JsonArray) parser.get("departments");

			// close reader
			reader.close();

			// extract the object representation of the specified department type section of
			// the departments array
			// then get the array representation of that object
			JsonObject departmentTypeObj;
			JsonArray docArray;
			int arrayIndex;

			if (department.equals("Neurology")) {
				departmentTypeObj = (JsonObject) departments.get(0);
				arrayIndex = 0;
			} else if (department.equals("Cardiology")) {
				departmentTypeObj = (JsonObject) departments.get(1);
				arrayIndex = 1;
			} else {
				departmentTypeObj = (JsonObject) departments.get(2);
				arrayIndex = 2;
			}

			docArray = (JsonArray) departmentTypeObj.get("doctors");
			if (!docArray.contains(username)) {
				docArray.add(username);

				// put this updated doctor array as the doctors object
				departmentTypeObj.put("doctors", docArray);
				// put this updated doctors object at index of the accounts array
				departments.set(arrayIndex, departmentTypeObj);
				// put the updated accounts array as the account entry in the JSON
				parser.put("departments", departments);

				// Create a writer
				BufferedWriter writer = new BufferedWriter(new FileWriter("src/hospitalmanagement/departments.json"));

				// Write updates to JSON file
				Jsoner.serialize(parser, writer);

				// Close the writer
				writer.close();
				return 0;
			}
			else {
				return 1;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return 2;
		}
	}
	
	public static void updatePatientInfo(String firstName,	String lastName, String age,
			String email, String gender, String password) {
		try {
			// create reader
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/hospitalmanagement/accounts2.json")));

			// create parser
		    JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

		    // read accounts array from json
		    JsonArray accounts = (JsonArray) parser.get("accounts");
		    
		    // extract the object representation of the patients section of the accounts array
		    // then get the array representation of that object
		    JsonObject patients = (JsonObject) accounts.get(0);
	    	JsonArray patientArr = (JsonArray) patients.get("patient");
	    	
			// close reader
			reader.close();
			
			JsonObject user = Account.getAccountJSONObj("Patient", email);
			int arrayIndex = patientArr.indexOf(user);
			
			user.put("first_name", firstName);
			user.put("last_name", lastName);
			user.put("age", age);
			user.put("email", email);
			user.put("gender", gender);
			user.put("password", password);
			
			// update user in the patients array
			patientArr.set(arrayIndex, user);
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
}
