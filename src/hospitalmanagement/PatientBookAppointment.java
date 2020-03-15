package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PatientBookAppointment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public PatientBookAppointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MainLabel = new JLabel("Book Appointment");
		MainLabel.setBounds(239, 11, 128, 14);
		contentPane.add(MainLabel);
		
		JComboBox DepartmentDropdown = new JComboBox();
		DepartmentDropdown.setBounds(292, 58, 75, 22);
		contentPane.add(DepartmentDropdown);
		
		JLabel DepartmentLabel = new JLabel("Department:");
		DepartmentLabel.setBounds(215, 62, 75, 14);
		contentPane.add(DepartmentLabel);
		
		JLabel DoctorNameLabel = new JLabel("Doctor:");
		DoctorNameLabel.setBounds(215, 91, 75, 14);
		contentPane.add(DoctorNameLabel);
		
		JComboBox PatientNameDropdown = new JComboBox();
		PatientNameDropdown.setBounds(292, 87, 75, 22);
		contentPane.add(PatientNameDropdown);
		
		JLabel TimeslotLabel = new JLabel("Timeslot:");
		TimeslotLabel.setBounds(215, 120, 75, 14);
		contentPane.add(TimeslotLabel);
		
		JComboBox PatientNameDropdown_1 = new JComboBox();
		PatientNameDropdown_1.setBounds(292, 116, 75, 22);
		contentPane.add(PatientNameDropdown_1);
		
		JButton BookButton = new JButton("Book");
		BookButton.setBounds(292, 210, 89, 23);
		contentPane.add(BookButton);
		
		JButton CancelButton = new JButton("Cancel");
		CancelButton.setBounds(193, 210, 89, 23);
		contentPane.add(CancelButton);
		
		JLabel AppointmentTypeLabel = new JLabel("Apt. Type:");
		AppointmentTypeLabel.setBounds(215, 149, 75, 14);
		contentPane.add(AppointmentTypeLabel);
		
		JComboBox AppointmentTypeDropdown = new JComboBox();
		AppointmentTypeDropdown.setBounds(292, 145, 75, 22);
		contentPane.add(AppointmentTypeDropdown);
	}
}
