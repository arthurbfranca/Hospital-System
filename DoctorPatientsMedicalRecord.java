package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.cliftonlabs.json_simple.JsonObject;

import javax.swing.JList;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorPatientsMedicalRecord extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DoctorPatientsMedicalRecord(String email, JsonObject patient) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TODO: Don't have json information for medical records of patients yet.
		// Once that has been done, then get info from json (whether it is accounts2.json
		// or a different json) and post it here. 
		
		// IDEA: have a new json containing patient's medical records. In this json,
		// the medical record contains an ID/email/index of the patient. Index will
		// be preferable for fastest/lowest cost (when a patient is registered, a medical
		// record for them is made at the same time, putting them both at the same index).
		// -----
		// New json because if we include this in any other existing json files, it will
		// quickly become messy especially when the patient has a huge record in the hospital.
		// -----
		// It will contain an array of strings, and the beginning of the string will contain
		// an identifier. The identifier will either be: "NOTE", for a doctor's note about
		// the patient; "APPT", which means the string is an appointment ID; "TEST", which
		// means the string is a test ID (not sure about this one); or "MISC", which
		// contains notes from the doctor that the patient does not need to know.
		// At the end of the strings for "NOTE" or "MISC", there will be a "DATE" identifier
		// that will simply say the date the record was added. No need for "APPT" or "TEST"
		// since they already have a date.
		
		// Get patient's information
		// Get patient's name
		String last_name = (String) patient.get("last_name");
		String first_name = (String) patient.get("first_name");
		String name = last_name + " ," + first_name;
		
		
		JLabel lblMedicalRecord = new JLabel("Medical Record");
		lblMedicalRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicalRecord.setBounds(162, 13, 107, 16);
		contentPane.add(lblMedicalRecord);
		
		JLabel lblNewLabel = new JLabel(name);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 42, 182, 16);
		contentPane.add(lblNewLabel);
		
		// JList showing the medical records of the selected patient
		// There is currently a placeholder until json is made
		JList list = new JList();
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setBounds(75, 89, 280, 151);
		contentPane.add(list);
		
		
		// Button that allows doctor to edit patient's medical record
		JButton btnEditRecord = new JButton("Edit Record");
		btnEditRecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorPatientsMedicalRecordEdit editRecordPane = new DoctorPatientsMedicalRecordEdit(email, patient);
				editRecordPane.setVisible(true);
				dispose();
			}
		});
		btnEditRecord.setBounds(75, 253, 100, 25);
		contentPane.add(btnEditRecord);
		
		// Button that closes the pane and returns to the previous one
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
		btnReturn.setBounds(256, 253, 100, 25);
		contentPane.add(btnReturn);

		
		
		
	}
}
