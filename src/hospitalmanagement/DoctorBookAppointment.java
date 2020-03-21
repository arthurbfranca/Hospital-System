package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
* Class that displays the panel where the doctor can book appointments
*/
public class DoctorBookAppointment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorBookAppointment frame = new DoctorBookAppointment();
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
	public DoctorBookAppointment() {
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
		
		JComboBox<String> departmentDropdown = new JComboBox<String>();
		departmentDropdown.addItem("Cardiology");
		departmentDropdown.addItem("Nephrology");
		departmentDropdown.addItem("Neurology");
		departmentDropdown.setBounds(292, 111, 141, 22);
		contentPane.add(departmentDropdown);
		
		JLabel DoctorNameLabel = new JLabel("Patient:");
		DoctorNameLabel.setBounds(173, 158, 75, 14);
		contentPane.add(DoctorNameLabel);
		
		/************ TO DO: go into account JSON and display all of the doctor's patients as options here ***************/
		// I have just put placeholder name for now
		JComboBox<String> patientDropdown = new JComboBox<String>();
		patientDropdown.addItem("Patient 1");
		patientDropdown.addItem("Patient 2");
		patientDropdown.addItem("Patient 3");
		patientDropdown.setBounds(292, 154, 141, 22);
		contentPane.add(patientDropdown);
		
		JLabel TimeslotLabel = new JLabel("Timeslot:");
		TimeslotLabel.setBounds(173, 203, 75, 14);
		contentPane.add(TimeslotLabel);
		
		/************ TO DO:
		 * go into account or appointment? JSON and
		 * some how display available timeslots for the doctor
		 ****************/
		// I have just put placeholder times for now
		JComboBox<String> timeDropdown = new JComboBox<String>();
		timeDropdown.addItem("09:00");
		timeDropdown.addItem("11:00");
		timeDropdown.addItem("14:00");
		timeDropdown.setBounds(292, 199, 141, 22);
		contentPane.add(timeDropdown);
		
		JLabel AppointmentTypeLabel = new JLabel("Apt. Type:");
		AppointmentTypeLabel.setBounds(173, 248, 75, 14);
		contentPane.add(AppointmentTypeLabel);
		
		JComboBox<String> aptTypeDropdown = new JComboBox<String>();
		aptTypeDropdown.addItem("Consultation");
		aptTypeDropdown.addItem("Surgery");
		aptTypeDropdown.addItem("Test/Scans");
		aptTypeDropdown.setBounds(292, 240, 141, 22);
		contentPane.add(aptTypeDropdown);
		
		/************ TO DO: when the doctor books the appointment,
		 * add this information to the appointments JSON file and
		 * add this appointment as an appointment for the doctor and patient in the accounts JSON
		 ****************/
		JButton BookButton = new JButton("Book");
		BookButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String selectedDep = departmentDropdown.getSelectedItem().toString();
				String selectedPatient = patientDropdown.getSelectedItem().toString();
				String selectedTime = timeDropdown.getSelectedItem().toString();
				String aptType = aptTypeDropdown.getSelectedItem().toString();
				Login lframe = new Login();
				JOptionPane.showMessageDialog(lframe, "The appointment has been booked!");
			}
		});
		BookButton.setBounds(250, 297, 89, 23);
		contentPane.add(BookButton);
		
	}
}
