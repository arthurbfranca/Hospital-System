package hospitalmanagement;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorPatientsBasicInfoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Creates the pane that shows the patient's basic information
	 * @param email The email of the doctor
	 * @param patientIndex The index of the patient according to the accounts2.json
	 * @param patient JsonObject representation of the patient in the accounts2.json
	 * @author ggdizon
	 */
	public DoctorPatientsBasicInfoView(String email, String patientIndex, JsonObject patient) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[100px][500,grow]", "[30][30px][30px][30px][30px][60px][60px][30px][]"));
		
		// Gets the basic information of the patient needed
		ArrayList<Object> informations = getMedicalRecordBasicInfo(patientIndex);
		String fullName = (String) patient.get("first_name") + " / " + patient.get("last_name");
		String gender = (String) patient.get("gender");
		String age = (String) patient.get("age");
		String maritalstatus = (String) informations.get(0);
		String race = (String) informations.get(1);
		String problems = (String) informations.get(2);
		String location = (String) informations.get(3);
		@SuppressWarnings("unchecked")
		ArrayList<String> allergies = (ArrayList<String>) informations.get(4);
		
		// Creates and shows the labels for the patient's basic information
		JLabel lblName = new JLabel("Full Name (First / Last):");
		contentPane.add(lblName, "cell 0 0,alignx center");
		
		JLabel lblFullname = new JLabel(fullName);
		contentPane.add(lblFullname, "cell 1 0,alignx center");
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAge, "cell 0 1,alignx center");
		
		JLabel lblShownAge = new JLabel(age);
		contentPane.add(lblShownAge, "cell 1 1,alignx center");
		
		JLabel lblGender = new JLabel("Gender:");
		contentPane.add(lblGender, "cell 0 2,alignx center");
		
		JLabel lblShowngender = new JLabel(gender);
		contentPane.add(lblShowngender, "cell 1 2,alignx center");
		
		JLabel lblMaritalStatus = new JLabel("Marital Status:");
		contentPane.add(lblMaritalStatus, "cell 0 3,alignx center");
		
		JLabel lblShownmarital = new JLabel(maritalstatus);
		contentPane.add(lblShownmarital, "cell 1 3,alignx center");
		
		JLabel lblRace = new JLabel("Race:");
		lblRace.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRace, "cell 0 4,alignx center");
		
		JLabel lblShownrace = new JLabel(race);
		contentPane.add(lblShownrace, "cell 1 4,alignx center");
		
		JLabel lblProblems = new JLabel("Problems:");
		contentPane.add(lblProblems, "cell 0 5,alignx center");
		
		JTextPane txtpnShownproblems = new JTextPane();
		txtpnShownproblems.setEditable(false);
		txtpnShownproblems.setText(problems);
		contentPane.add(txtpnShownproblems, "cell 1 5,grow");
		
		JLabel lblAllergies = new JLabel("Allergies:");
		contentPane.add(lblAllergies, "cell 0 6,alignx center");
		
		JList<Object> shownAllergies = new JList<>(allergies.toArray(new String [allergies.size()]));
		shownAllergies.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JScrollPane allergyScroller = new JScrollPane();
		allergyScroller.setViewportView(shownAllergies);
		contentPane.add(allergyScroller, "cell 1 6,grow");
		
		JLabel lblClinicLocation = new JLabel("Clinic Location:");
		contentPane.add(lblClinicLocation, "cell 0 7,alignx center");
		
		JLabel lblShownlocation = new JLabel(location);
		contentPane.add(lblShownlocation, "cell 1 7,alignx center");
		
		// Button to close the window and return to the previous one
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		contentPane.add(btnReturn, "cell 1 8,alignx right");
		
	}
	
	/**
	 * This method gets the patient's basic information in the medical_records.json
	 * with the help of their index
	 * @param patientIndex The index of the patient in the accounts2.json
	 * @return The JsonObject containing their basic information
	 * @author ggdizon
	 */
	private ArrayList<Object> getMedicalRecordBasicInfo(String patientIndex) {
		try {
			// create reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/medical_records.json")));
			
			// create parser
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
			
			// read medicalrecords from json
			JsonArray medicalrecords = (JsonArray) parser.get("medicalrecords");
			
			// Extract the JsonObject representation of the patient's medical records
			JsonObject record = (JsonObject) medicalrecords.get(Integer.parseInt(patientIndex));
			
			// get the recorded index of the patient
			String recordedIndex = (String) record.get("patientIndex");
			
			// if recorded index does not match the supposed index, this is a bug
			if (!recordedIndex.equals(patientIndex)) {
				throw new Exception("BUG: Patient's index does not match the one in the records.");
			}
			
			// get the basic information of the patient
			String maritalstatus = (String) record.get("maritalstatus");
			String race = (String) record.get("race");
			String problems = (String) record.get("problems");
			String location = (String) record.get("location");
			ArrayList<String> allergies = new ArrayList<>();
			
			// get the JsonArray representation of the list of allergies
			// using an interator
			JsonArray allergyArr = (JsonArray) record.get("allergies");
			Iterator i = allergyArr.iterator();
			int index = 0;
			
			while (i.hasNext()) {
				i.next();
				allergies.add(allergyArr.getString(index));
				index++;
			}
			
			// adds the information as strings into a String ArrayList
			ArrayList<Object> infos = new ArrayList<>();
			infos.add(maritalstatus);
			infos.add(race);
			infos.add(problems);
			infos.add(location);
			infos.add(allergies);
			return infos;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}


}
