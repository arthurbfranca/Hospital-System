/**
 * 
 */
package hospitalmanagement;
import java.io.FileWriter;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

/**
 * @author erinpaslawski
 *
 */
public class registrationJSON {

	public static void addNewAccount(Account newAccount) throws Exception {
		
	}
	
	public static void addNewPatient(Patient newPatient) throws Exception {
	    JsonObject newObject = new JsonObject();
	    newObject.put("id", newPatient.getId());
	    newObject.put("first_name", newPatient.getFirst_name());
	    newObject.put("last_name", newPatient.getLast_name());
	    newObject.put("age", newPatient.getAge());
	    newObject.put("email", newPatient.getEmail());
	    newObject.put("password", newPatient.getPassword());
	    newObject.put("appointments", newPatient.getAppointments());
	    newObject.put("prescriptions", newPatient.getPrescriptions());

	    JsonArray messages = new JsonArray();
	    messages.add("Hey!");
	    messages.add("What's up?!");

	    //sampleObject.put("messages", messages);
	    //Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
	}
}
