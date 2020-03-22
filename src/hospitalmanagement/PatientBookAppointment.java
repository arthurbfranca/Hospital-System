package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

/**
* Class that displays the panel for patients to book an appointment
* @author sydneykwok
*/
public class PatientBookAppointment extends JFrame {

	private JPanel contentPane;

	/**
	* Launch the application
	*/
	public static void main(String[] args) {
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
	}

	/**
	* Create the frame for when the patient clicks on the "book appointment" button
	* Shows drop down menus for patients to book an appointment by selecting the department, doctor name, timeslot and appointment type
	*/
	public PatientBookAppointment() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MainLabel = new JLabel("Book Appointment");
		MainLabel.setBounds(230, 66, 128, 14);
		contentPane.add(MainLabel);
		
		JLabel DepartmentLabel = new JLabel("Department:");
		DepartmentLabel.setBounds(173, 115, 75, 14);
		contentPane.add(DepartmentLabel);
		
		//Create drop menu for patients to select a department when booking an appointment
		JComboBox<String> departmentDropdown = new JComboBox<String>();
		departmentDropdown.addItem("Cardiology");
		departmentDropdown.addItem("Nephrology");
		departmentDropdown.addItem("Neurology");
		departmentDropdown.setBounds(292, 111, 141, 22);
		contentPane.add(departmentDropdown);
		
		JLabel DoctorNameLabel = new JLabel("Doctor:");
		DoctorNameLabel.setBounds(173, 158, 75, 14);
		contentPane.add(DoctorNameLabel);
		
		/************ TO DO: go into account JSON and display all doctors as options here ***************/
		// I have just put placeholder doctor names for now lol
		//Create drop menu for patients to select a doctor when booking an appointment
		JComboBox<String> docDropdown = new JComboBox<String>();
		docDropdown.addItem("Dr. Bajwa");
		docDropdown.addItem("Dr. Doctor");
		docDropdown.addItem("Dr. Hartman");
		docDropdown.setBounds(292, 154, 141, 22);
		contentPane.add(docDropdown);
		
		JLabel TimeslotLabel = new JLabel("Timeslot:");
		TimeslotLabel.setBounds(173, 203, 75, 14);
		contentPane.add(TimeslotLabel);
		
		/************ TO DO:
		 * go into account or appointment? JSON and
		 * some how display available timeslots for the chosen doctor
		 ****************/
		// I have just put placeholder times for now
		//Create drop menu for patients to select a timeslot when booking an appointment
		JComboBox<String> timeDropdown = new JComboBox<String>();
		timeDropdown.addItem("09:00");
		timeDropdown.addItem("11:00");
		timeDropdown.addItem("14:00");
		timeDropdown.setBounds(292, 199, 141, 22);
		contentPane.add(timeDropdown);
		
		JLabel AppointmentTypeLabel = new JLabel("Apt. Type:");
		AppointmentTypeLabel.setBounds(173, 248, 75, 14);
		contentPane.add(AppointmentTypeLabel);
		
		//Create drop menu for patients to select an appointment type when booking an appointment
		JComboBox<String> aptTypeDropdown = new JComboBox<String>();
		aptTypeDropdown.addItem("Consultation");
		aptTypeDropdown.addItem("Surgery");
		aptTypeDropdown.addItem("Test/Scans");
		aptTypeDropdown.setBounds(292, 240, 141, 22);
		contentPane.add(aptTypeDropdown);
		
		/************ TO DO: when the patient books the appointment,
		 * add this account information to the appointments JSON file
		 * add this appointment as an appointment for the doctor in the accounts JSON
		 ****************/
		//Adding button for booking an appointment
		JButton BookButton = new JButton("Book");
		//Add event handler for book button
		BookButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Get all the information the patients selected from the drop down menus
				String selectedDep = departmentDropdown.getSelectedItem().toString();
				String selectedDoc = docDropdown.getSelectedItem().toString();
				String selectedTime = timeDropdown.getSelectedItem().toString();
				String aptType = aptTypeDropdown.getSelectedItem().toString();
				Login lframe = new Login();
				//Displays a message to confirm that the patient has successfully booked their appointment
				JOptionPane.showMessageDialog(lframe, "Your appointment request has been made!");
			}
		});
		BookButton.setBounds(250, 297, 89, 23);
		contentPane.add(BookButton);
	}
}
