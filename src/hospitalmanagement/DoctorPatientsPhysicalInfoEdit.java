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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorPatientsPhysicalInfoEdit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Creates the pane for editing the patient's physical information
	 * @param email The email of the doctor
	 * @param patientIndex The index of the patient according to the accounts2.json
	 * @author ggdizon
	 */
	public DoctorPatientsPhysicalInfoEdit(String email, String patientIndex) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 645, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 235));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[225][225,grow]", "[25][25][25][25][25][25][25][45,grow][45,grow][45,grow][45,grow][45,grow][45,grow][45,grow][45,grow][25][25][grow]"));
		
		
		// Add the labels for the physical information (and scroll bar if needed)
		JLabel lblPhysical = new JLabel("Physical Information");
		lblPhysical.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPhysical, "cell 0 0,alignx center");
		
		JLabel lblTemp = new JLabel("Temperature:");
		lblTemp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTemp, "cell 0 1,alignx center");
		
		JTextArea txtTemp = new JTextArea("");
		contentPane.add(txtTemp, "cell 1 1,grow");
		
		JLabel lblPulse = new JLabel("Pulse:");
		contentPane.add(lblPulse, "cell 0 2,alignx center");
		
		JTextArea txtPulse = new JTextArea("");
		contentPane.add(txtPulse, "cell 1 2,grow");
		
		JLabel lblRhythm = new JLabel("Rhythm:");
		contentPane.add(lblRhythm, "cell 0 3,alignx center");
		
		JTextArea txtRhythm = new JTextArea("");
		contentPane.add(txtRhythm, "cell 1 3,grow");
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure:");
		contentPane.add(lblBloodPressure, "cell 0 4,alignx center");
		
		JTextArea txtBP = new JTextArea("");
		contentPane.add(txtBP, "cell 1 4,grow");
		
		JLabel lblHeight = new JLabel("Height:");
		contentPane.add(lblHeight, "cell 0 5,alignx center");
		
		JTextArea txtHeight = new JTextArea("");
		contentPane.add(txtHeight, "cell 1 5,grow");
		
		JLabel lblWeight = new JLabel("Weight:");
		contentPane.add(lblWeight, "cell 0 6,alignx center");
		
		JTextArea txtWeight = new JTextArea("");
		contentPane.add(txtWeight, "cell 1 6,grow");
		
		JLabel lblAppearance = new JLabel("Appearance:");
		contentPane.add(lblAppearance, "cell 0 7,alignx center");
		
		JTextArea txtAppear = new JTextArea("");
		JScrollPane appearanceScroller = new JScrollPane(txtAppear);
		contentPane.add(appearanceScroller, "cell 1 7,grow");
		
		JLabel lblEyes = new JLabel("Eyes:");
		contentPane.add(lblEyes, "cell 0 8,alignx center");
		
		JTextArea txtEyes = new JTextArea("");
		JScrollPane eyesScroller = new JScrollPane(txtEyes);
		contentPane.add(eyesScroller, "cell 1 8,grow");
		
		JLabel lblEarnosemouththroat = new JLabel("Ear/Nose/Mouth/Throat:");
		contentPane.add(lblEarnosemouththroat, "cell 0 9,alignx center");
		
		JTextArea txtENMT = new JTextArea("");
		JScrollPane enmtScroller = new JScrollPane(txtENMT);
		contentPane.add(enmtScroller, "cell 1 9,grow");
		
		JLabel lblRespiratory = new JLabel("Respiratory:");
		contentPane.add(lblRespiratory, "cell 0 10,alignx center");
		
		JTextArea txtResp = new JTextArea("");
		JScrollPane respScroller = new JScrollPane(txtResp);
		contentPane.add(respScroller, "cell 1 10,grow");
		
		JLabel lblCardiovascular = new JLabel("Cardiovascular:");
		contentPane.add(lblCardiovascular, "cell 0 11,alignx center");
		
		JTextArea txtCardio = new JTextArea("");
		JScrollPane cardioScroller = new JScrollPane(txtCardio);
		contentPane.add(cardioScroller, "cell 1 11,grow");
		
		JLabel lblSkin = new JLabel("Skin:");
		contentPane.add(lblSkin, "cell 0 12,alignx center");
		
		JTextArea txtSkin = new JTextArea("");
		JScrollPane skinScroller = new JScrollPane(txtSkin);
		contentPane.add(skinScroller, "cell 1 12,grow");
		
		JLabel lblProblems = new JLabel("Problems:");
		contentPane.add(lblProblems, "cell 0 13,alignx center");
		
		JTextArea txtProblems = new JTextArea("");
		JScrollPane problemsScroller = new JScrollPane(txtProblems);
		contentPane.add(problemsScroller, "cell 1 13,grow");
		
		JLabel lblImpression = new JLabel("Impression:");
		contentPane.add(lblImpression, "cell 0 14,alignx center");
		
		JTextArea txtImpression = new JTextArea("");
		JScrollPane impressionScroller = new JScrollPane(txtImpression);
		contentPane.add(impressionScroller, "cell 1 14,grow");
		
		JLabel lblLastUpdated = new JLabel("Last Updated:");
		contentPane.add(lblLastUpdated, "cell 0 15,alignx center");
		
		JTextArea txtLastUpdated = new JTextArea("");
		txtLastUpdated.setEditable(false);
		contentPane.add(txtLastUpdated, "cell 1 15,grow");
		
		JLabel lblUpdatedLastBy = new JLabel("Updated Last By:");
		contentPane.add(lblUpdatedLastBy, "cell 0 16,alignx center");
		
		JTextArea txtUpdatedBy = new JTextArea("");
		txtUpdatedBy.setEditable(false);
		contentPane.add(txtUpdatedBy, "cell 1 16,grow");
		
		// Button that closes the pane and returns to the previous one
		JButton btnReturn = new JButton("Cancel");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				DoctorPatientsPhysicalInfoView physInfoPane = new DoctorPatientsPhysicalInfoView(email, patientIndex);
				physInfoPane.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnReturn, "cell 0 17,alignx center");
		
		// Button that brings user to a pane that allows them to update patient's physical information
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// JsonObject containing the patient's new information
				JsonObject physicalInfo = new JsonObject();
				// Variables for the patient's new physical information
				String temp = txtTemp.getText();
				String pulse = txtPulse.getText();
				String rhythm = txtRhythm.getText();
				String bp = txtBP.getText();
				String height = txtHeight.getText();
				String weight = txtWeight.getText();
				String appear = txtAppear.getText();
				String eyes = txtEyes.getText();
				String enmt = txtENMT.getText();
				String resp = txtResp.getText();
				String cardio = txtCardio.getText();
				String skin = txtSkin.getText();
				String problems = txtProblems.getText();
				String impression = txtImpression.getText();
				setPhysicalInfoJSONObj(physicalInfo, temp, pulse, rhythm, bp, height, weight, appear, eyes, enmt, resp, cardio, skin, problems, impression, email);
				WriteToJSON.setNewPhysicalInfo(patientIndex, physicalInfo);
				DoctorPatientsPhysicalInfoView physInfoPane = new DoctorPatientsPhysicalInfoView(email, patientIndex);
				physInfoPane.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnUpdate, "cell 1 17,alignx center");
		
	}
	
	/**
	 * This method takes in the new physical information and stores it in a JsonObject
	 * @param physicalInfo JsonObject in which the data will be stored
	 * @param temp Temperature data
	 * @param pulse Pulse data
	 * @param rhythm Rhythm data
	 * @param bp Blood Pressure data
	 * @param height Height data
	 * @param weight Weight data
	 * @param appearance Appearance data
	 * @param eyes Eyes data
	 * @param enmt Ear, Nose, Mouth, Throat data
	 * @param respiratory Respiratory data
	 * @param cardiovascular Cardiovascular data
	 * @param skin Skin data
	 * @param problems Problems data
	 * @param impression Impressions data
	 * @param docEmail The doctor's email
	 * @author ggdizon
	 */
	private void setPhysicalInfoJSONObj(JsonObject physicalInfo, String temp, String pulse, String rhythm, String bp, String height,
										String weight, String appearance, String eyes, String enmt, String respiratory,
										String cardiovascular, String skin, String problems, String impression, String docEmail) {
		physicalInfo.put("temp", temp);
		physicalInfo.put("pulse", pulse);
		physicalInfo.put("rhythm", rhythm);
		physicalInfo.put("bp", bp);
		physicalInfo.put("height", height);
		physicalInfo.put("weight", weight);
		physicalInfo.put("appearance", appearance);
		physicalInfo.put("eyes", eyes);
		physicalInfo.put("ENMT", enmt);
		physicalInfo.put("respiratory", respiratory);
		physicalInfo.put("cardiovascular", cardiovascular);
		physicalInfo.put("skin", skin);
		physicalInfo.put("problems", problems);
		physicalInfo.put("impression", impression);
		physicalInfo.put("lastupdated", getDate());
		physicalInfo.put("updatedby", getDoctorName(docEmail));
	}
	
	/**
	 * Method for getting the current date
	 * @return String of date in the format DD/MM/YYYY
	 * @author ggdizon
	 */
	private String getDate() {
		// get the local date right now
		LocalDate date = LocalDate.now();
		
		int day = date.getDayOfMonth();		// day expressed as integer
		int month = date.getMonthValue();	// months expressed as integer
		int year = date.getYear();			// year expressed as integer
		
		String stringDay;					// day expressed as String
		if (day < 10) {
			stringDay = "0" + Integer.toString(day);	// prepend 0 to day if single digit
		} else {
			stringDay = Integer.toString(day);
		}
		
		String stringMonth;					// months expressed as String
		if (month < 10) {
			stringMonth = "0" + Integer.toString(month);	// prepend 0 to month if single digit
		} else {
			stringMonth = Integer.toString(month);
		}
		
		String stringYear = Integer.toString(year);	//year expressed as String
		
		String formattedDate = stringDay + "/" + stringMonth + "/" + stringYear;
		return formattedDate;
	}
	
	/**
	 * Method for getting doctor's name
	 * @param email The email of the doctor
	 * @return String of doctor's last name
	 * @author ggdizon
	 */
	private String getDoctorName(String email) {
		JsonObject doctor = Account.getAccountJSONObj("Doctor", email);
		String last_name = "Dr." + (String) doctor.get("last_name");
		return last_name;
	}
	

}
