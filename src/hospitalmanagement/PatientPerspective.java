package hospitalmanagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
* Class that displays the options the patient can choose from upon logging in to their account
* Includes options like: viewing and booking appointments, viewing test results, personal information, and records
* @author sydneykwok, shavonnetran
*/
public class PatientPerspective extends JFrame {

	private JPanel contentPane;
	
	/**
	* Create the frame for the panel with the patient options upon logging in
	* Patients will be directed to this frame and can do various tasks by clicking the appropriate buttons
	* @param email The email of the patient. Used to uniquely identify the user so we can easily access their info.
	*/
	public PatientPerspective(String email) {
		
		// set frame properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		setLocationRelativeTo(null);
		
		// create panel for the frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Display welcome message for patient
		JLabel menuLabel = new JLabel("Welcome, Patient!");
		menuLabel.setBounds(239, 51, 119, 14);
		contentPane.add(menuLabel);
		
		//Adding button for returning to login home page
		JButton btnReturn = new JButton("Return");
		//Add event handler for return button
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Return back to the login page after clicking return button
				Login loginPane = new Login();
				loginPane.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(219, 296, 139, 41);
		contentPane.add(btnReturn);
		
		//Adding button for viewing appointments
		JButton viewAppointButton = new JButton(" View appointments");
		//Add event handler for view appointments button
		viewAppointButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Switch to panel that displays appointments for patients to view
				PatientAppointmentView appointmentPane = new PatientAppointmentView(email);
				appointmentPane.setVisible(true);
			}
		});
		viewAppointButton.setBounds(68, 168, 199, 41);
		contentPane.add(viewAppointButton);
		
		//Adding button for booking appointments
		JButton bookAppointButton = new JButton("Book an appointment");
		//Add event handler for book appointments button
		bookAppointButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Switch to panel where patients can book an appointment
				PatientBookAppointment bookApp = new PatientBookAppointment(email);
				bookApp.setVisible(true);
			}
		});
		bookAppointButton.setBounds(320, 107, 199, 46);
		contentPane.add(bookAppointButton);
		
		//Adding button for viewing test results
		JButton viewResultButton = new JButton("View test results");
		//Add event handler for view test results button
		viewResultButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Switch to panel that displays the test results for patients to view
				PatientTestResultView appointmentPane = new PatientTestResultView(email);
				appointmentPane.setVisible(true);
			}
		});
		viewResultButton.setBounds(320, 166, 199, 44);
		contentPane.add(viewResultButton);
		
		//Adding button for viewing medical records
		JButton viewRecordButton = new JButton("View records");
		viewRecordButton.setBounds(68, 114, 199, 41);
		contentPane.add(viewRecordButton);
		
		//Adding button for viewing personal information
		JButton viewInfoButton = new JButton("View personal info");
		//Add event handler for view personal info button
		viewInfoButton .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Switch to panel that displays the patient's personal info 
				PatientInfoView personalInfo = new PatientInfoView(email);
				personalInfo.setVisible(true);
			}
		});
		viewInfoButton .setBounds(68, 222, 199, 41);
		contentPane.add(viewInfoButton );
	}
}
