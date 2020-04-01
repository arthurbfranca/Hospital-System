package hospitalmanagement;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

/**
 * Class that displays the panel for patients to book an appointment
 * 
 * @author sydneykwok
 */
public class PatientBookAppointment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientBookAppointment frame = new PatientBookAppointment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame for when the patient clicks on the "book appointment" button
	 * Shows drop down menus for patients to book an appointment by selecting the
	 * department, doctor name, timeslot and appointment type.
	 * @param email The email of the patient. Used to uniquely identify the user so we can easily access their info.
	 */
	public PatientBookAppointment(String email) {

		// set frame properties
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 444);

		// create panel for the frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// add title label for the panel
		JLabel MainLabel = new JLabel("Book Appointment");
		MainLabel.setBounds(230, 66, 128, 14);
		contentPane.add(MainLabel);

		// add label for the departments
		JLabel DepartmentLabel = new JLabel("Department:");
		DepartmentLabel.setBounds(173, 115, 75, 14);
		contentPane.add(DepartmentLabel);

		// Create drop menu for patients to select a department when booking an
		// appointment
		JComboBox<String> departmentDropdown = new JComboBox<String>();
		departmentDropdown.addItem("Cardiology");
		departmentDropdown.addItem("Nephrology");
		departmentDropdown.addItem("Neurology");
		departmentDropdown.setBounds(292, 111, 141, 22);
		contentPane.add(departmentDropdown);

		// add label for the doctors
		JLabel DoctorNameLabel = new JLabel("Doctor:");
		DoctorNameLabel.setBounds(173, 158, 75, 14);
		contentPane.add(DoctorNameLabel);

		// Create drop menu for patients to select a doctor when booking an appointment
		JComboBox<String> docDropdown = new JComboBox<String>();
		// go into the account JSON and display all doctors as options here
		try {

			// create reader
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/hospitalmanagement/accounts2.json")));
			// create parser
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
			// read accounts array from json
			JsonArray accounts = (JsonArray) parser.get("accounts");
			// extract the object representation of doctor from the accounts array
			JsonObject doctors = (JsonObject) accounts.get(1);
			// then get the array representation of doctor
			JsonArray doctorArr = (JsonArray) doctors.get("doctor");

			// then create an iterator to iterate through that array
			Iterator i = doctorArr.iterator();
			// iterate through all doctors in the doctor array
			while (i.hasNext()) {
				JsonObject doctor = (JsonObject) i.next();
				docDropdown.addItem("Dr. " + (String) doctor.get("last_name"));
			}

			// close reader
			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		docDropdown.setBounds(292, 154, 141, 22);
		contentPane.add(docDropdown);

		// add label for timeslots
		JLabel TimeslotLabel = new JLabel("Timeslot:");
		TimeslotLabel.setBounds(173, 203, 75, 14);
		contentPane.add(TimeslotLabel);

		/************
		 * TO DO: go into account or appointment? JSON and some how display available
		 * timeslots for the chosen doctor
		 ****************/
		// I have just put placeholder times for now
		// Create drop menu for patients to select a timeslot when booking an appointment
		JComboBox<String> timeDropdown = new JComboBox<String>();
		timeDropdown.addItem("09:00");
		timeDropdown.addItem("11:00");
		timeDropdown.addItem("14:00");
		timeDropdown.setBounds(292, 199, 141, 22);
		contentPane.add(timeDropdown);

		// label for appointment type
		JLabel AppointmentTypeLabel = new JLabel("Apt. Type:");
		AppointmentTypeLabel.setBounds(173, 248, 75, 14);
		contentPane.add(AppointmentTypeLabel);

		// Create drop menu for patients to select an appointment type when booking an appointment
		JComboBox<String> aptTypeDropdown = new JComboBox<String>();
		aptTypeDropdown.addItem("Consultation");
		aptTypeDropdown.addItem("Surgery");
		aptTypeDropdown.addItem("Test/Scans");
		aptTypeDropdown.setBounds(292, 240, 141, 22);
		contentPane.add(aptTypeDropdown);

		/************
		 * TO DO: when the patient books the appointment, add this account information
		 * to the appointments JSON file add this appointment as an appointment for the
		 * doctor in the accounts JSON
		 ****************/
		// Adding button for booking an appointment
		JButton BookButton = new JButton("Book");
		// Add event handler for book button
		BookButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Get all the information the patients selected from the drop down menus
				String selectedDep = departmentDropdown.getSelectedItem().toString();
				String selectedDoc = docDropdown.getSelectedItem().toString();
				String selectedTime = timeDropdown.getSelectedItem().toString();
				String aptType = aptTypeDropdown.getSelectedItem().toString();
				Login lframe = new Login();
				// Displays a message to confirm that the patient has successfully booked their appointment
				JOptionPane.showMessageDialog(lframe, "Your appointment request has been made!");
			}
		});
		BookButton.setBounds(250, 297, 89, 23);
		contentPane.add(BookButton);
	}
}
