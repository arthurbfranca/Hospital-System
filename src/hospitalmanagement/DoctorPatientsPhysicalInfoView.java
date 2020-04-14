package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

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
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorPatientsPhysicalInfoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Creates the pane for viewing the patient's physical information
	 * @param email The email of the doctor
	 * @param patientIndex The index of the patient according to the accounts2.json
	 * @author ggdizon
	 */
	public DoctorPatientsPhysicalInfoView(String email, String patientIndex) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 645, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 235));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[225][225,grow]", "[25][25][25][25][25][25][25][45,grow][45,grow][45,grow][45,grow][45,grow][45,grow][45,grow][45,grow][25][25][grow]"));
		
		// Get patient's physical information
		JsonObject physicalInfo = getPatientsPhysicalInfo(patientIndex);
		String temp = (String) physicalInfo.get("temp");
		String pulse = (String) physicalInfo.get("pulse");
		String rhythm = (String) physicalInfo.get("rhythm");
		String bp = (String) physicalInfo.get("bp");
		String height = (String) physicalInfo.get("height");
		String weight = (String) physicalInfo.get("weight");
		String appear = (String) physicalInfo.get("appearance");
		String eyes = (String) physicalInfo.get("eyes");
		String enmt = (String) physicalInfo.get("ENMT");
		String resp = (String) physicalInfo.get("respiratory");
		String cardio = (String) physicalInfo.get("cardiovascular");
		String skin = (String) physicalInfo.get("skin");
		String problems = (String) physicalInfo.get("problems");
		String impression = (String) physicalInfo.get("impression");
		String lastupdated = (String) physicalInfo.get("lastupdated");
		String updatedby = (String) physicalInfo.get("updatedby");
		
		// Add the labels for the physical information (and scroll bar if needed)
		JLabel lblPhysical = new JLabel("Physical Information");
		lblPhysical.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPhysical, "cell 0 0,alignx center");
		
		JLabel lblTemp = new JLabel("Temperature:");
		lblTemp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTemp, "cell 0 1,alignx center");
		
		JTextArea txtTemp = new JTextArea(temp);
		txtTemp.setEditable(false);
		contentPane.add(txtTemp, "cell 1 1,grow");
		
		JLabel lblPulse = new JLabel("Pulse:");
		contentPane.add(lblPulse, "cell 0 2,alignx center");
		
		JTextArea txtPulse = new JTextArea(pulse);
		txtPulse.setEditable(false);
		contentPane.add(txtPulse, "cell 1 2,grow");
		
		JLabel lblRhythm = new JLabel("Rhythm:");
		contentPane.add(lblRhythm, "cell 0 3,alignx center");
		
		JTextArea txtRhythm = new JTextArea(rhythm);
		txtRhythm.setEditable(false);
		contentPane.add(txtRhythm, "cell 1 3,grow");
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure:");
		contentPane.add(lblBloodPressure, "cell 0 4,alignx center");
		
		JTextArea txtBP = new JTextArea(bp);
		txtBP.setEditable(false);
		contentPane.add(txtBP, "cell 1 4,grow");
		
		JLabel lblHeight = new JLabel("Height:");
		contentPane.add(lblHeight, "cell 0 5,alignx center");
		
		JTextArea txtHeight = new JTextArea(height);
		txtHeight.setEditable(false);
		contentPane.add(txtHeight, "cell 1 5,grow");
		
		JLabel lblWeight = new JLabel("Weight:");
		contentPane.add(lblWeight, "cell 0 6,alignx center");
		
		JTextArea txtWeight = new JTextArea(weight);
		txtWeight.setEditable(false);
		contentPane.add(txtWeight, "cell 1 6,grow");
		
		JLabel lblAppearance = new JLabel("Appearance:");
		contentPane.add(lblAppearance, "cell 0 7,alignx center");
		
		JTextArea txtAppear = new JTextArea(appear);
		txtAppear.setEditable(false);
		JScrollPane appearanceScroller = new JScrollPane(txtAppear);
		contentPane.add(appearanceScroller, "cell 1 7,grow");
		
		JLabel lblEyes = new JLabel("Eyes:");
		contentPane.add(lblEyes, "cell 0 8,alignx center");
		
		JTextArea txtEyes = new JTextArea(eyes);
		txtEyes.setEditable(false);
		JScrollPane eyesScroller = new JScrollPane(txtEyes);
		contentPane.add(eyesScroller, "cell 1 8,grow");
		
		JLabel lblEarnosemouththroat = new JLabel("Ear/Nose/Mouth/Throat:");
		contentPane.add(lblEarnosemouththroat, "cell 0 9,alignx center");
		
		JTextArea txtENMT = new JTextArea(enmt);
		txtENMT.setEditable(false);
		JScrollPane enmtScroller = new JScrollPane(txtENMT);
		contentPane.add(enmtScroller, "cell 1 9,grow");
		
		JLabel lblRespiratory = new JLabel("Respiratory:");
		contentPane.add(lblRespiratory, "cell 0 10,alignx center");
		
		JTextArea txtResp = new JTextArea(resp);
		txtResp.setEditable(false);
		JScrollPane respScroller = new JScrollPane(txtResp);
		contentPane.add(respScroller, "cell 1 10,grow");
		
		JLabel lblCardiovascular = new JLabel("Cardiovascular:");
		contentPane.add(lblCardiovascular, "cell 0 11,alignx center");
		
		JTextArea txtCardio = new JTextArea(cardio);
		txtCardio.setEditable(false);
		JScrollPane cardioScroller = new JScrollPane(txtCardio);
		contentPane.add(cardioScroller, "cell 1 11,grow");
		
		JLabel lblSkin = new JLabel("Skin:");
		contentPane.add(lblSkin, "cell 0 12,alignx center");
		
		JTextArea txtSkin = new JTextArea(skin);
		txtSkin.setEditable(false);
		JScrollPane skinScroller = new JScrollPane(txtSkin);
		contentPane.add(skinScroller, "cell 1 12,grow");
		
		JLabel lblProblems = new JLabel("Problems:");
		contentPane.add(lblProblems, "cell 0 13,alignx center");
		
		JTextArea txtProblems = new JTextArea(problems);
		txtProblems.setEditable(false);
		JScrollPane problemsScroller = new JScrollPane(txtProblems);
		contentPane.add(problemsScroller, "cell 1 13,grow");
		
		JLabel lblImpression = new JLabel("Impression:");
		contentPane.add(lblImpression, "cell 0 14,alignx center");
		
		JTextArea txtImpression = new JTextArea(impression);
		txtImpression.setEditable(false);
		JScrollPane impressionScroller = new JScrollPane(txtImpression);
		contentPane.add(impressionScroller, "cell 1 14,grow");
		
		JLabel lblLastUpdated = new JLabel("Last Updated:");
		contentPane.add(lblLastUpdated, "cell 0 15,alignx center");
		
		JTextArea txtLastUpdated = new JTextArea(lastupdated);
		txtLastUpdated.setEditable(false);
		contentPane.add(txtLastUpdated, "cell 1 15,grow");
		
		JLabel lblUpdatedLastBy = new JLabel("Updated Last By:");
		contentPane.add(lblUpdatedLastBy, "cell 0 16,alignx center");
		
		JTextArea txtUpdatedBy = new JTextArea(updatedby);
		txtUpdatedBy.setEditable(false);
		contentPane.add(txtUpdatedBy, "cell 1 16,grow");
		
		// Button that closes the pane and returns to the previous one
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		contentPane.add(btnReturn, "cell 0 17,alignx center");
		
		// Button that brings user to a pane that allows them to update patient's physical information
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				DoctorPatientsPhysicalInfoEdit physInfoEdit = new DoctorPatientsPhysicalInfoEdit(email, patientIndex);
				physInfoEdit.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnUpdate, "cell 1 17,alignx center");
		
	}
	
	/**
	 * This method gets the patient's physical information in the medical records
	 * @param patientIndex The patient's index according to their location in the accounts2.json
	 * @return JsonObject representation of their physical information in the medical_records.json
	 * @author ggdizon
	 */
	private JsonObject getPatientsPhysicalInfo(String patientIndex) {
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
			
			// get the JsonArray representation of the physical information data
			// and then get the object representation of the array
			JsonArray physicalInfoArr = (JsonArray) record.get("physical");
			JsonObject physicalInfoObj = (JsonObject) physicalInfoArr.get(0);
			
			return physicalInfoObj;			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

}
