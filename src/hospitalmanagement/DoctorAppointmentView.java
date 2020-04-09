package hospitalmanagement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

/**
* Class that displays the panel for the doctor's appointments
* @author arthurbfranca, ggdizon, sydneykwok
*/
public class DoctorAppointmentView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	* Create the frame.
	* This is for when Doctor clicks "View Appointments" button.
	* It shows a list of appointments for the Doctor, including the basic appointment information
	* such as patient and date.
	* @param email The email of the doctor. Used to uniquely identify the user so we can easily access their info.
	*/
	public DoctorAppointmentView(String email) {
		
		// set the frame properties
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 514);
		
		// create the panel for the frame
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// add the title label for the panel
		JLabel MainLabel = new JLabel("View Appointments");
		MainLabel.setBounds(252, 11, 154, 14);
		contentPane.add(MainLabel);
		
		// create another panel to display the first appointment
		JPanel Appointment1 = new JPanel();
		Appointment1.setBounds(123, 36, 347, 172);
		contentPane.add(Appointment1);
		GridBagLayout gbl_Appointment1 = new GridBagLayout();
		gbl_Appointment1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Appointment1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Appointment1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Appointment1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Appointment1.setLayout(gbl_Appointment1);
		
		// Label showing where patient's name is on GUI
		JLabel PatientNameLabel = new JLabel("Patient:");
		GridBagConstraints gbc_PatientNameLabel = new GridBagConstraints();
		gbc_PatientNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PatientNameLabel.gridx = 1;
		gbc_PatientNameLabel.gridy = 1;
		Appointment1.add(PatientNameLabel, gbc_PatientNameLabel);
		
		// Label showing patient's name
		JLabel PatientName = new JLabel("Bob, Builder");
		GridBagConstraints gbc_PatientName = new GridBagConstraints();
		gbc_PatientName.insets = new Insets(0, 0, 5, 5);
		gbc_PatientName.gridx = 3;
		gbc_PatientName.gridy = 1;
		Appointment1.add(PatientName, gbc_PatientName);
		
		// Label showing where date of appointment is on GUI
		JLabel AppointmentDateLabel = new JLabel("Date:");
		GridBagConstraints gbc_AppointmentDateLabel = new GridBagConstraints();
		gbc_AppointmentDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentDateLabel.gridx = 1;
		gbc_AppointmentDateLabel.gridy = 2;
		Appointment1.add(AppointmentDateLabel, gbc_AppointmentDateLabel);
		
		// Label showing date of appointment
		JLabel AppointmentDate = new JLabel("03/03/03");
		GridBagConstraints gbc_AppointmentDate = new GridBagConstraints();
		gbc_AppointmentDate.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentDate.gridx = 3;
		gbc_AppointmentDate.gridy = 2;
		Appointment1.add(AppointmentDate, gbc_AppointmentDate);
		
		// Label showing where time of appointment is on GUI
		JLabel AppointmentTimeLabel = new JLabel("Time:");
		GridBagConstraints gbc_AppointmentTimeLabel = new GridBagConstraints();
		gbc_AppointmentTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentTimeLabel.gridx = 1;
		gbc_AppointmentTimeLabel.gridy = 3;
		Appointment1.add(AppointmentTimeLabel, gbc_AppointmentTimeLabel);
		
		// Label showing the time of appointment
		JLabel AppointmentTime = new JLabel("10:20-10:40");
		GridBagConstraints gbc_AppointmentTime = new GridBagConstraints();
		gbc_AppointmentTime.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentTime.gridx = 3;
		gbc_AppointmentTime.gridy = 3;
		Appointment1.add(AppointmentTime, gbc_AppointmentTime);
		
		// Label showing where department is on GUI
		JLabel DepartmentLabel = new JLabel("Department:");
		GridBagConstraints gbc_DepartmentLabel = new GridBagConstraints();
		gbc_DepartmentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_DepartmentLabel.gridx = 1;
		gbc_DepartmentLabel.gridy = 4;
		Appointment1.add(DepartmentLabel, gbc_DepartmentLabel);
		
		// Label showing the department
		JLabel Department = new JLabel("Cardiology");
		GridBagConstraints gbc_Department = new GridBagConstraints();
		gbc_Department.insets = new Insets(0, 0, 5, 5);
		gbc_Department.gridx = 3;
		gbc_Department.gridy = 4;
		Appointment1.add(Department, gbc_Department);
		
		// Label showing where appointment type is on GUI
		JLabel AppointmentTypeLabel = new JLabel("Appointment Type:");
		GridBagConstraints gbc_AppointmentTypeLabel = new GridBagConstraints();
		gbc_AppointmentTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentTypeLabel.gridx = 1;
		gbc_AppointmentTypeLabel.gridy = 5;
		Appointment1.add(AppointmentTypeLabel, gbc_AppointmentTypeLabel);
		
		// Label showing type of appointment
		JLabel AppointmentType = new JLabel("Follow Up");
		GridBagConstraints gbc_AppointmentType = new GridBagConstraints();
		gbc_AppointmentType.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentType.gridx = 3;
		gbc_AppointmentType.gridy = 5;
		Appointment1.add(AppointmentType, gbc_AppointmentType);
		
		// Button for canceling the appointment (no event handlers yet)
		JButton CancelButton = new JButton("Cancel");
		GridBagConstraints gbc_CancelButton = new GridBagConstraints();
		gbc_CancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_CancelButton.gridx = 3;
		gbc_CancelButton.gridy = 6;
		Appointment1.add(CancelButton, gbc_CancelButton);
		
		// create another panel for another appointment
		JPanel Appointment1_1 = new JPanel();
		Appointment1_1.setBounds(123, 219, 347, 172);
		contentPane.add(Appointment1_1);
		GridBagLayout gbl_Appointment1_1 = new GridBagLayout();
		gbl_Appointment1_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Appointment1_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Appointment1_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Appointment1_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Appointment1_1.setLayout(gbl_Appointment1_1);
		
		// Label showing where patient's name is on GUI
		JLabel PatientNameLabel2 = new JLabel("Patient:");
		GridBagConstraints gbc_PatientNameLabel2 = new GridBagConstraints();
		gbc_PatientNameLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_PatientNameLabel2.gridx = 1;
		gbc_PatientNameLabel2.gridy = 1;
		Appointment1_1.add(PatientNameLabel2, gbc_PatientNameLabel2);
		
		// Label showing patient's name
		JLabel PatientName2 = new JLabel("Thomas, Train");
		GridBagConstraints gbc_PatientName2 = new GridBagConstraints();
		gbc_PatientName2.insets = new Insets(0, 0, 5, 5);
		gbc_PatientName2.gridx = 3;
		gbc_PatientName2.gridy = 1;
		Appointment1_1.add(PatientName2, gbc_PatientName2);
		
		// Label showing where date is on GUI
		JLabel AppointmentDateLabel2 = new JLabel("Date:");
		GridBagConstraints gbc_AppointmentDateLabel2 = new GridBagConstraints();
		gbc_AppointmentDateLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentDateLabel2.gridx = 1;
		gbc_AppointmentDateLabel2.gridy = 2;
		Appointment1_1.add(AppointmentDateLabel2, gbc_AppointmentDateLabel2);
		
		// Label showing date of appointment
		JLabel AppointmentDate2 = new JLabel("03/03/03");
		GridBagConstraints gbc_AppointmentDate2 = new GridBagConstraints();
		gbc_AppointmentDate2.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentDate2.gridx = 3;
		gbc_AppointmentDate2.gridy = 2;
		Appointment1_1.add(AppointmentDate2, gbc_AppointmentDate2);
		
		// Label showing where time is on GUI
		JLabel AppointmentTimeLabel2 = new JLabel("Time:");
		GridBagConstraints gbc_AppointmentTimeLabel2 = new GridBagConstraints();
		gbc_AppointmentTimeLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentTimeLabel2.gridx = 1;
		gbc_AppointmentTimeLabel2.gridy = 3;
		Appointment1_1.add(AppointmentTimeLabel2, gbc_AppointmentTimeLabel2);
		
		// Label showing the time of appointment
		JLabel AppointmentTime2 = new JLabel("10:20-10:40");
		GridBagConstraints gbc_AppointmentTime2 = new GridBagConstraints();
		gbc_AppointmentTime2.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentTime2.gridx = 3;
		gbc_AppointmentTime2.gridy = 3;
		Appointment1_1.add(AppointmentTime2, gbc_AppointmentTime2);
		
		// Label showing where department is on GUI
		JLabel DepartmentLabel2 = new JLabel("Department:");
		GridBagConstraints gbc_DepartmentLabel2 = new GridBagConstraints();
		gbc_DepartmentLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_DepartmentLabel2.gridx = 1;
		gbc_DepartmentLabel2.gridy = 4;
		Appointment1_1.add(DepartmentLabel2, gbc_DepartmentLabel2);
		
		// Label showing department
		JLabel Department2 = new JLabel("Cardiology");
		GridBagConstraints gbc_Department2 = new GridBagConstraints();
		gbc_Department2.insets = new Insets(0, 0, 5, 5);
		gbc_Department2.gridx = 3;
		gbc_Department2.gridy = 4;
		Appointment1_1.add(Department2, gbc_Department2);
		
		// Label showing where appointment type is on GUI
		JLabel AppointmentTypeLabel2 = new JLabel("Appointment Type:");
		GridBagConstraints gbc_AppointmentTypeLabel2 = new GridBagConstraints();
		gbc_AppointmentTypeLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentTypeLabel2.gridx = 1;
		gbc_AppointmentTypeLabel2.gridy = 5;
		Appointment1_1.add(AppointmentTypeLabel2, gbc_AppointmentTypeLabel2);
		
		// Label showing the appointment type
		JLabel AppointmentType2 = new JLabel("Follow Up");
		GridBagConstraints gbc_AppointmentType2 = new GridBagConstraints();
		gbc_AppointmentType2.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentType2.gridx = 3;
		gbc_AppointmentType2.gridy = 5;
		Appointment1_1.add(AppointmentType2, gbc_AppointmentType2);
		
		// Button to cancel the appointment
		JButton CancelButton2 = new JButton("Cancel");
		GridBagConstraints gbc_CancelButton2 = new GridBagConstraints();
		gbc_CancelButton2.insets = new Insets(0, 0, 0, 5);
		gbc_CancelButton2.gridx = 3;
		gbc_CancelButton2.gridy = 6;
		Appointment1_1.add(CancelButton2, gbc_CancelButton2);
		
		// Button that goes to previous page (if there's more than 1 page of appointments)
		JButton PreviousButton = new JButton("Previous");
		PreviousButton.setBounds(10, 441, 89, 23);
		contentPane.add(PreviousButton);
		
		// Button that goes to next page (if there's more than 1 page of appointments)
		JButton NextButton = new JButton("Next");
		NextButton.setBounds(472, 441, 89, 23);
		contentPane.add(NextButton);
		
		// Button that returns to previous window
		JButton ReturnToMainButton = new JButton("Return");
		// If button is clicked, then close this window, effectively returning to previous.
		ReturnToMainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		ReturnToMainButton.setBounds(252, 441, 89, 23);
		contentPane.add(ReturnToMainButton);
	}
}
