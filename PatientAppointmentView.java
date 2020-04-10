package hospitalmanagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

/*
* Class that displays the patient's appointments so that they
* can select one to view more about it.
*/
public class PatientAppointmentView extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame. This constructor will display ALL the patient's (past,
	 * present, and future appointments). 
	 * 
	 * @param email The email of the patient. Used to uniquely identify the user so
	 *              we can easily access their info.
	 * @wbp.parser.constructor
	 */
	public PatientAppointmentView(String email) {

		// set frame properties
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// create panel for the frame
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// add a label to the panel to prompt the user to select an appt
		JLabel lblselectAppt = new JLabel("Please Select An Appointment");
		lblselectAppt.setBounds(132, 13, 182, 16);
		contentPane.add(lblselectAppt);

		// get the arraylist of info strings for this user's appointments
		ArrayList<String> myApptInfo = new ArrayList<String>();
		// get the arraylist of appointment id's for this user's appointments
		ArrayList<String> myApptIDs = new ArrayList<String>();
		
		try {
			// reader to read appointments json
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/hospitalmanagement/appointments.json")));
			// parser to parse the reader
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
			// get the json array of appointments
			JsonArray myAppts = (JsonArray) parser.get("appointments");

			Iterator i = myAppts.iterator();
			JsonObject appt;
			int arrIndex = 0;

			// iterate through the json array of appointments
			while (i.hasNext()) {
				// get the json object of the appt
				appt = (JsonObject) i.next();
				// get the email of the patient of this appt
				String patient = (String) appt.get("patient_email");
				// compare that email to this user's email
				if (patient.equals(email)) {
					// get the json object of the appt
					appt = (JsonObject) myAppts.get(arrIndex);
					// create a string of some of the appt info and add it to the arraylist
					myApptInfo.add("Date: " + appt.get("date") + "/" + appt.get("year") + ", Time: " + appt.get("time")
					+ ", Doctor: " + appt.get("doctor_email") + ", Department: " + appt.get("department"));
					// get the id of this appt and add it to the other arraylist
					myApptIDs.add((String) appt.get("number"));
				}
				// increment the array index counter
				arrIndex++;
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// create a list of these appts
		List<String> values = new ArrayList<>(myApptInfo.size());
		for (int j = 0; myApptInfo.size() > j; j++) {
			values.add(myApptInfo.get(j));
		}

		// add the list of appts to the panel
		JList<Object> apptList = new JList<Object>(values.toArray(new String[values.size()]));
		apptList.setValueIsAdjusting(true);
		apptList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		apptList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		apptList.setBounds(64, 34, 315, 161);
		JScrollPane patientListScroller = new JScrollPane();
		patientListScroller.setLocation(50, 38);
		patientListScroller.setSize(330, 169);
		patientListScroller.setViewportView(apptList);
		apptList.setLayoutOrientation(JList.VERTICAL);
		contentPane.add(patientListScroller);

		// add a button to the panel to allow the user to confirm their selection
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedIndex = apptList.getSelectedIndex();
				// if the user has not made a selection, give them a pop-up
				if (selectedIndex < 0) {
					JOptionPane.showMessageDialog(contentPane, "Please select an appointment.");
				} else {	// else, show the appt info on this new pane
					PatientAppointmentInfoView p = new PatientAppointmentInfoView(email, myApptIDs.get(selectedIndex));
					p.setVisible(true);
					dispose();
				}
			}
		});
		btnConfirm.setBounds(104, 215, 97, 25);
		contentPane.add(btnConfirm);

		// add a button to the panel to allow the user to return to the previous view
		JButton btnCancel = new JButton("Return");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(236, 215, 97, 25);
		contentPane.add(btnCancel);
	}
	
	/**
	 * Create the frame. This constructor will display only the patient's appointments
	 * that are set on or after the given date.
	 * @param email The email of the patient. Used to uniquely identify the user so
	 *              we can easily access their info.
	 * @param date The current date. Only appointments on or after this date will be
	 * 				displayed to the user.
	 */
	public PatientAppointmentView(String email, String date) {
		// TODO: implement this!!
		// we will need to get the current date and time and only display 
		// appointments after this time
	}

}
