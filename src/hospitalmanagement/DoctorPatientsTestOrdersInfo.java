package hospitalmanagement;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorPatientsTestOrdersInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Creates the pane for viewing additional information of the wanted test
	 * @param email The email of the doctor
	 * @param patientIndex The index of the patient according to their location in the accounts2.json
	 * @param testID The ID of the wanted test
	 * @author ggdizon
	 */
	public DoctorPatientsTestOrdersInfo(String email, String patientIndex, String testID) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 235));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150][250,grow]", "[][30][45][45][60][]"));
		
		// String of additional test information
		String[] moreTestInfos = getMoreTestInfo(testID);
		
		// Create and show needed labels for the test information
		JLabel lblTestOrderFor = new JLabel("Test Order For:");
		lblTestOrderFor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblTestOrderFor, "cell 0 1,alignx center");
		
		JLabel lblPatientname = new JLabel(getPatientName(patientIndex));
		lblPatientname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblPatientname, "cell 1 1,alignx center");
		
		JLabel lblTestId = new JLabel("Test ID:");
		lblTestId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblTestId, "cell 0 2,alignx center");
		
		JLabel lblTestid = new JLabel(testID);
		lblTestid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblTestid, "cell 1 2,alignx center");
		
		JLabel lblTestType = new JLabel("Test Type:");
		lblTestType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblTestType, "cell 0 3,alignx center");
		
		JLabel lblTesttype = new JLabel(moreTestInfos[0]);
		lblTesttype.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblTesttype, "cell 1 3,alignx center");
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNotes, "cell 0 4,alignx center");
		
		JTextArea txtNotes = new JTextArea();
		txtNotes.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtNotes.setText(moreTestInfos[1]);
		JScrollPane txtNotesScroller = new JScrollPane(txtNotes);
		contentPane.add(txtNotesScroller, "cell 1 4,grow");
		
		// Button that closes the pane and returns to the previous one
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		contentPane.add(btnReturn, "cell 1 5,growx");
	}

	/**
	 * This method gets the full name of the patient in the form "lastname, firstname"
	 * @param patientIndex The index of the patient according to their location in the accounts2.json
	 * @return String if patient's full name
	 * @author ggdizon
	 */
	private String getPatientName(String patientIndex) {
		// Get JsonArray representation of all patient accounts
		JsonArray patients = Account.getAccountJSONObj("Patient");
		
		// get JsonObject representation of wanted patient
		JsonObject patient = (JsonObject) patients.get(Integer.parseInt(patientIndex));
		
		// get patient's fullname
		String first_name = (String) patient.get("first_name");
		String last_name = (String) patient.get("last_name");
		String full_name = last_name + ", " + first_name;
		
		return full_name;
	}
	
	/**
	 * This method gathers additional data for the test
	 * @param testID ID of the test wanted to be viewed
	 * @return and Array of Strings containing the additional information
	 * @author ggdizon
	 */
	private String[] getMoreTestInfo(String testID) {
		String type;
		String notes;
		try {
			// create reader
			BufferedReader reader = new BufferedReader(
			new InputStreamReader(new FileInputStream("src/hospitalmanagement/tests.json")));

			// create parser
		    JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

		    // read tests array from json
		    JsonArray testArray = (JsonArray) parser.get("tests");
		    
		    // get the specified test from the array
		    JsonObject test = (JsonObject) testArray.get(Integer.parseInt(testID) - 1);
		    
		    // get ID and check to see if the test taken has the right ID
		    String takenID = (String) test.get("id");
		    if (!takenID.equals(testID)) {	// If not correct, iterate through all tests until found
		    	Iterator i = testArray.iterator();
		    	while(i.hasNext()) {
		    		test = (JsonObject) i.next();
		    		takenID = (String) test.get("id");
		    		if (takenID.equals(testID)) {
		    			break;
		    		}
		    	}
		    }
		    // get the test type and notes
		    type = (String) test.get("type");
		    notes = (String) test.get("notes");
		    
		    // store them into Array of String
		    String[] testInfos = {type, notes};
		    
		    return testInfos;
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
