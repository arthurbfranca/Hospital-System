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
* Class that displays the options the doctor can choose from upon logging in to their account; includes viewing appointments, patients, booking appointments, etc.
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
	 * Create the frame.
	 */
	public DoctorPerspective() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menuLabel = new JLabel("Alberta Health");
		menuLabel.setBounds(239, 11, 119, 14);
		contentPane.add(menuLabel);
		
		JButton ViewAppointmentsButton = new JButton("View Appointments");
		ViewAppointmentsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DoctorAppointmentView appointmentPane = new DoctorAppointmentView();
				appointmentPane.setVisible(true);
			}
		});
		ViewAppointmentsButton.setBounds(115, 73, 148, 53);
		contentPane.add(ViewAppointmentsButton);
		
		JButton ViewPatientsButton = new JButton("View Patients");
		ViewPatientsButton.setBounds(115, 137, 148, 53);
		contentPane.add(ViewPatientsButton);
		
		JButton ViewAvailabilityButton = new JButton("View Availability");
		ViewAvailabilityButton.setBounds(115, 201, 148, 53);
		contentPane.add(ViewAvailabilityButton);
		
		JButton BookAppointmentButton = new JButton("Book Appointment");
		BookAppointmentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DoctorBookAppointment patientsPane = new DoctorBookAppointment();
				patientsPane.setVisible(true);
			}
		});
		BookAppointmentButton.setBounds(289, 73, 148, 53);
		contentPane.add(BookAppointmentButton);
		
		JButton AddPatientButton = new JButton("Add Patient");
		AddPatientButton.setBounds(289, 137, 148, 53);
		contentPane.add(AddPatientButton);
		
		JButton SetAvailabilityButton = new JButton("Set Availability");
		SetAvailabilityButton.setBounds(289, 201, 148, 53);
		contentPane.add(SetAvailabilityButton);
	}
}
