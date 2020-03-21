package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
* Class that displays the panel for the options the doctor can choose from upon logging in to their account
* Includes viewing appointments, patients, booking appointments, etc.
* @author arthurbfranca, sydneykwok, ggdizon
*/
public class DoctorPerspective extends JFrame {

	private JPanel contentPane;

	/**
	* Launch the application.
	*/
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorPerspective frame = new DoctorPerspective();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	* Create the frame for the doctor's panel upon logging in
	*/
	public DoctorPerspective() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menuLabel = new JLabel("Alberta Health");
		menuLabel.setBounds(239, 11, 119, 14);
		contentPane.add(menuLabel);
		
		//Adding button for viewing appointments
		JButton ViewAppointmentsButton = new JButton("View Appointments");
		//Add event handler for view appointment button
		ViewAppointmentsButton.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				//Switch to panel that displays the appointments to view
				DoctorAppointmentView appointmentPane = new DoctorAppointmentView();
				appointmentPane.setVisible(true);
			}
		});
		ViewAppointmentsButton.setBounds(115, 73, 148, 53);
		contentPane.add(ViewAppointmentsButton);
		
		//Adding button for viewing patients
		JButton ViewPatientsButton = new JButton("View Patients");
		//Add event handler for view patient button
		ViewPatientsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Switch to panel that displays the patients that the doctor can view 
				DoctorPatientsView viewPatientsPane = new DoctorPatientsView();
				viewPatientsPane.setVisible(true);
			}
		});
		ViewPatientsButton.setBounds(115, 137, 148, 53);
		contentPane.add(ViewPatientsButton);
		
		//Adding button for viewing availability
		JButton ViewAvailabilityButton = new JButton("View Availability");
		ViewAvailabilityButton.setBounds(115, 201, 148, 53);
		contentPane.add(ViewAvailabilityButton);
		
		//Adding button for booking appointments
		JButton BookAppointmentButton = new JButton("Book Appointment");
		//Add event handler for book appointment button
		BookAppointmentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Switch to panel where the doctor can book an appointment
				DoctorBookAppointment patientsPane = new DoctorBookAppointment();
				patientsPane.setVisible(true);
			}
		});
		BookAppointmentButton.setBounds(289, 73, 148, 53);
		contentPane.add(BookAppointmentButton);
		
		//Adding button for adding new patients to database
		JButton AddPatientButton = new JButton("Add Patient");
		//Add event handler for adding patient button
		AddPatientButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Switch to panel where doctor can add in a new patient
				DoctorAddPatient addPatientPane = new DoctorAddPatient();
				addPatientPane.setVisible(true);
			}
		});
		AddPatientButton.setBounds(289, 137, 148, 53);
		contentPane.add(AddPatientButton);
		
		//Adding button for setting up the doctor's availability
		JButton SetAvailabilityButton = new JButton("Set Availability");
		SetAvailabilityButton.setBounds(289, 201, 148, 53);
		contentPane.add(SetAvailabilityButton);
		
		//Adding button to return back to the home page
		JButton btnReturn = new JButton("Return");
		//Add event handler for return button
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Return back to the login home page after clicking return button
				Login loginPane = new Login();
				loginPane.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(239, 280, 119, 14);
		contentPane.add(btnReturn);
	}
}
