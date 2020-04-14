package hospitalmanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
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
	 * @param first the user's first name
	 * @param last the user's last name
	 * @param age the user's age
	 * @param email the user's email
	 * @param gender the user's gender
	 * @param user the user's username
	 * @param pass the user's password
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
			
			// create reader
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/medical_records.json")));
			
			// create parser
			parser = (JsonObject) Jsoner.deserialize(reader);
			
			// read medicalrecords array from json
			JsonArray medicalRecords = (JsonArray) parser.get("medicalrecords");
			
			reader.close();
			
			writeNewPatientMedicalRecordList(id, medicalRecords);
			
			writer = new BufferedWriter(new FileWriter("src/hospitalmanagement/medical_records.json"));
			
			Jsoner.serialize(parser, writer);
			
			writer.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}

	/**
	 * This method writes the new account (of a user who is a staff member) to the JSON.
	 * @param userType: the user's account type (doctor, nurse, etc.)
	 * @param first the user's first name
	 * @param last the user's last name
	 * @param email the user's email
	 * @param gender the user's gender
	 * @param user the user's username
	 * @param pass the user's password
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
	    	// get id from most recent person and increment to get new account's id
	    	String id = Integer.toString(Integer.parseInt((String) mostRecentAccount.get("id")) + 1);
	    	
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
			newAccount.put("schedule","");
			
			if(userType.equals("Doctor")) {
				JsonArray appointments = new JsonArray();
				newAccount.put("appointments", appointments);
				
				JsonArray patients = new JsonArray();
				newAccount.put("patients", patients);
			}
			
			// get JsonObject of last user's schedule if doc or nurse
	    	if(userType.equals("Doctor") || userType.equals("Nurse")) {
	    		JsonObject schedule = new JsonObject();
				newAccount.put("schedule", schedule);
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
	 * @param username   the doctor's username
	 * @param department the department that is to be written to
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
	
	/**
	 * This method adds patient's ID to doctor's list of patients in the JSON when doctor
	 * wants to assign themselves as a patient's physician
	 * 
	 * @param patientID the ID of the patient to be added to the doctor's patient list
	 * @param doctorEmail the email of the doctor who wants to add a patient
	 * @author ggdizon
	 */
	public static void addPatientToDoc(String patientID, String doctorEmail) {
		try {
			// create reader
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/hospitalmanagement/accounts2.json")));

			// create parser
		    JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

		    // read accounts array from json
		    JsonArray accounts = (JsonArray) parser.get("accounts");
		    
		    // extract the object representation of the doctors section of the accounts array
		    // then get the array representation of that object
		    JsonObject doctors = (JsonObject) accounts.get(1);
	    	JsonArray doctorArr = (JsonArray) doctors.get("doctor");
	    	
			// close reader
			reader.close();
			
			JsonObject user = Account.getAccountJSONObj("Doctor", doctorEmail);
			int arrayIndex = doctorArr.indexOf(user);
			JsonArray patientList = (JsonArray) user.get("patients");
			
			patientList.add(patientID);
			
			// update list of patients in the user
			user.put("patients", patientList);
			// update user in the doctors array
			doctorArr.set(arrayIndex, user);
			// put this updated doctor array as the doctor object
			doctors.put("patient", doctorArr);
			// put this updated doctor object at index 0 of the accounts array
			accounts.set(1, doctors);
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
	 * This method writes the test info to the assigned patient in the JSON.
	 * 
	 * @param staffType either doctor or nurse in a String
	 * @param staffEmail the email of the staff member submitting the info
	 * @param selectedPatientEmail the email of the patient
	 * @param typeOfTest the type of test (MRI, X-Ray, etc.)
	 * @param textToSubmit the actual String of text to write
	 * @author erinpaslawski
	 * @return false if failed, true otherwise
	 */
	public static boolean writeTestInfo(String staffType, String staffEmail, String selectedPatientEmail , String typeOfTest, String textToSubmit) {
		try {
			// create reader
			BufferedReader reader = new BufferedReader(
			new InputStreamReader(new FileInputStream("src/hospitalmanagement/tests.json")));

			// create parser
		    JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

		    // read tests array from json
		    JsonArray testArray = (JsonArray) parser.get("tests");
	    	
		    // Get most recent patient test
	    	JsonObject mostRecentTest = (JsonObject) testArray.get(testArray.size()-1);	// get the most recently added test

	    	// id is incremented from most recent test's id
	    	String id = Integer.toString(Integer.parseInt((String)mostRecentTest.get("id")) +1);
		    
			// close reader
			reader.close();
			
			JsonObject newTest = new JsonObject(); 
			//add items to new JsonObject
			newTest.put("id", id);
			newTest.put("type", typeOfTest);
			newTest.put("staffType", staffType);
			newTest.put("staffName", staffEmail);
			newTest.put("patient", selectedPatientEmail);
			newTest.put("notes", textToSubmit);
			
			// update tests array
			testArray.add(newTest);

			// put the updated test array as the tests entry in the JSON
			parser.put("tests", testArray);
		    
			// Create a writer
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/hospitalmanagement/tests.json"));

			// Write updates to JSON file
			Jsoner.serialize(parser, writer);

			// Close the writer
			writer.close();
			//return true if it works
			return true;

		} catch (Exception ex) {
			//return false if there are any exceptions thrown
		    return false;
		}
	}
	
		
	/**
	 * This method removes the approved appointment from the req_appointments.json and writes it to the appointments.json file 
	 * @param appointment the appointment to be removed and write to  
	 * @author shavonnetran
	 */
	public static void writeApprovedAppointment(String appointment) {
		try {
			// Create reader
			BufferedReader reader = new BufferedReader(
			new InputStreamReader(new FileInputStream("src/hospitalmanagement/req_appointments.json")));

			// Create parser
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
	
			// Read requested appointments array from JSON
		    	JsonArray reqAppoints = (JsonArray) parser.get("requested_appointments");
		    	
			parser.get(appointment);
	    		
			// Remove JSON object from request_appointments.json
			reqAppoints.remove(appointment);
		    
			// Close reader
			reader.close();
			
			// Create a writer
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/hospitalmanagement/appointments.json"));

			// Write the selected appointment to JSON file containing approved appointments: appointments.json
			Jsoner.serialize(parser, writer);

			// Close the writer
			writer.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	/**
	 * This method edits the JsonArray of the medicalrecords in the medical_records.json
	 * file. It adds the items needed to the medical records of the new patient registering.
	 * The items were examples taken from the source:
	 * {@link https://www.ahrq.gov/ncepcr/tools/pf-handbook/mod8-app-b-monica-latte.html} 
	 * 
	 * @param patientID the new patient's ID
	 * @param records the JsonArray of medical records that contains all the records of all patients
	 * @author ggdizon
	 */
	public static void writeNewPatientMedicalRecordList(String patientID, JsonArray records) {
		// create new JSON object in which the records will be put in
		JsonObject newRecord = new JsonObject();
		
		// add items to JsonObject
		newRecord.put("patientIndex", patientID);
		
		JsonArray notesArr = new JsonArray();
		newRecord.put("notes", notesArr);
		
		newRecord.put("maritalstatus", "NO VALUE");
		newRecord.put("race", "NO VALUE");
		newRecord.put("problems", "NO VALUE");
		
		JsonArray medsArr = new JsonArray();
		newRecord.put("medications", medsArr);
		
		JsonArray allergiesArr = new JsonArray();
		newRecord.put("allergies", allergiesArr);
		
		// array for things involving a physical of a patient
		JsonArray physicalArr = new JsonArray();
		// add items into JsonObject
		JsonObject physicalItems = new JsonObject();
		physicalItems.put("temp", "NO VALUE");
		physicalItems.put("pulse", "NO VALUE");
		physicalItems.put("rhythm", "NO VALUE");
		physicalItems.put("bp", "NO VALUE");
		physicalItems.put("height", "NO VALUE");
		physicalItems.put("weight", "NO VALUE");
		physicalItems.put("appearance", "NO VALUE");
		physicalItems.put("eyes", "NO VALUE");
		physicalItems.put("ENMT", "NO VALUE");
		physicalItems.put("respiratory", "NO VALUE");
		physicalItems.put("cardiovascular", "NO VALUE");
		physicalItems.put("skin", "NO VALUE");
		physicalItems.put("problems", "NO VALUE");
		physicalItems.put("impression", "NO VALUE");
		physicalItems.put("lastupdated", "NO VALUE");
		physicalItems.put("updatedby", "NO VALUE");
		physicalArr.add(physicalItems);	

		newRecord.put("physical", physicalArr);
		
		
		newRecord.put("plan", "NO VALUE");

		newRecord.put("testorders", "NO VALUE");
		
		newRecord.put("location", "Totally-Legit-And-Not-Imaginary Hospital");
		
		records.add(newRecord);
	}
	
	/**
	 * This method adds a new medication to a patient's medical records
	 * @param patientIndex The index of patient according to their position on the accounts2.json
	 * @param medicationName Name of the medication
	 * @param docName Name of the doctor prescribing the medication
	 * @param amount Amount of medication prescribed
	 * @param date Date of refill
	 * @author ggdizon
	 */
	public static void addNewMedication(String patientIndex, String medicationName, String docName, String amount, String date) {
		try {	
			// create reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/medical_records.json")));
			
			// create parser
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
			
			// read medicalrecords array from json
			JsonArray medicalRecords = (JsonArray) parser.get("medicalrecords");
			
			reader.close();
			
			// JsonObject representation of the specified patient's medical records
			JsonObject record = (JsonObject) medicalRecords.get(Integer.parseInt(patientIndex));
			
			// get the JsonArray representation of the patient's medications
			JsonArray medications = (JsonArray) record.get("medications");
			
			// String of the medication info in the proper format
			String medicationInfo = medicationName + " / " + docName + " / " + amount + " / " + date;
			
			// Add the medication information into the JsonArray of the medications
			medications.add(medicationInfo);
			
			// set the new medications JsonArray as the new one in the JsonObject
			// of the patient's medical record
			record.put("medications", medications);
			
			// set the JsonObject of the patient's medical record as the new one
			// in the array of all JsonObjects of all patients' medical records
			medicalRecords.set(Integer.parseInt(patientIndex), record);
			
			// update the entire json of medical records to the new one by putting
			// the updated JsonArray
			parser.put("medicalrecords", medicalRecords);
			
			// create a writer
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/hospitalmanagement/medical_records.json"));
			
			// updates the json file
			Jsoner.serialize(parser, writer);
			
			// close the writer
			writer.close();
			
			// create reader
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/accounts2.json")));

			// create parser
		    parser = (JsonObject) Jsoner.deserialize(reader);

		    // read accounts array from json
		    JsonArray accounts = (JsonArray) parser.get("accounts");
		    
		    // extract the object representation of the patients section of the accounts array
		    // then get the array representation of that object
		    JsonObject patients = (JsonObject) accounts.get(0);
	    	JsonArray patientsArr = (JsonArray) patients.get("patient");
	    	
			// close reader
			reader.close();
			
			// get the JsonObject representation of the patient's account in the json
			JsonObject patient = (JsonObject) patientsArr.get(Integer.parseInt(patientIndex));
			
			// get the JsonArray representation of the patient's prescriptions
			JsonArray prescriptions = (JsonArray) patient.get("prescriptions");
			
			// add the newly prescribed medication to the array of prescriptions of the patient
			prescriptions.add(medicationName);
			
			// update the patient's account
			patient.put("prescriptions", prescriptions);
			
			// update the patients list
			patientsArr.set(Integer.parseInt(patientIndex), patient);
			
			// update the Object representation of the patients list
			patients.put("patient", patientsArr);
			
			// update the JsonArray of accounts
			accounts.set(0, patients);
			
			// update the parser
			parser.put("accounts", accounts);
			
			// open writer
			writer = new BufferedWriter(new FileWriter("src/hospitalmanagement/accounts2.json"));
			
			// update the json file
			Jsoner.serialize(parser, writer);
			
			// close the writer
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * This method updated a patient's physical information in their medical records json
	 * @param patientIndex Index of the patient according to their position in the accounts2.json
	 * @param newPhysicalInfo JsonObject containing the new physical informations
	 */
	public static void setNewPhysicalInfo(String patientIndex, JsonObject newPhysicalInfo) {
		try {
			// create reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/medical_records.json")));
			
			// create parser
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
			
			// read medicalrecords array from json
			JsonArray medicalRecords = (JsonArray) parser.get("medicalrecords");
			
			reader.close();
			
			// JsonObject representation of the specified patient's medical records
			JsonObject record = (JsonObject) medicalRecords.get(Integer.parseInt(patientIndex));
			
			// get the JsonArray representation of the patient's physical information
			JsonArray physical = (JsonArray) record.get("physical");
			
			// update the physical information JsonArray's with the newPhysicalInfo JsonObject
			physical.set(0, newPhysicalInfo);
			
			// update the JsonObject of the patient's physical medical record
			record.put("physical", physical);
			
			// update the JsonArray of all patient's medical record
			medicalRecords.set(Integer.parseInt(patientIndex), record);
			
			// update the parser
			parser.put("medicalrecords", medicalRecords);
			
			// open writer
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/hospitalmanagement/medical_records.json"));
			
			// update the json file
			Jsoner.serialize(parser, writer);
			
			// close the writer
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
