package hospitalmanagement;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PatientTestResultView extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PatientTestResultView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/************ TO DO: this class will
		 * access the user's account (JSON) info and display their test results
		 * we will need to add a test results section in the accounts JSONs?
		 *  ***************/
		
		JLabel MainLabel = new JLabel("My Test Results");
		MainLabel.setBounds(254, 45, 154, 14);
		contentPane.add(MainLabel);
		
		JPanel Appointment1 = new JPanel();
		Appointment1.setBounds(123, 72, 347, 172);
		contentPane.add(Appointment1);
		GridBagLayout gbl_Appointment1 = new GridBagLayout();
		gbl_Appointment1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Appointment1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Appointment1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Appointment1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Appointment1.setLayout(gbl_Appointment1);
		
		JLabel PatientNameLabel = new JLabel("Test Type:");
		GridBagConstraints gbc_PatientNameLabel = new GridBagConstraints();
		gbc_PatientNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PatientNameLabel.gridx = 1;
		gbc_PatientNameLabel.gridy = 1;
		Appointment1.add(PatientNameLabel, gbc_PatientNameLabel);
		
		JLabel PatientName = new JLabel("CT Scan");
		GridBagConstraints gbc_PatientName = new GridBagConstraints();
		gbc_PatientName.insets = new Insets(0, 0, 5, 5);
		gbc_PatientName.gridx = 3;
		gbc_PatientName.gridy = 1;
		Appointment1.add(PatientName, gbc_PatientName);
		
		JLabel AppointmentDateLabel = new JLabel("Date:");
		GridBagConstraints gbc_AppointmentDateLabel = new GridBagConstraints();
		gbc_AppointmentDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentDateLabel.gridx = 1;
		gbc_AppointmentDateLabel.gridy = 2;
		Appointment1.add(AppointmentDateLabel, gbc_AppointmentDateLabel);
		
		JLabel AppointmentDate = new JLabel("03/03/03");
		GridBagConstraints gbc_AppointmentDate = new GridBagConstraints();
		gbc_AppointmentDate.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentDate.gridx = 3;
		gbc_AppointmentDate.gridy = 2;
		Appointment1.add(AppointmentDate, gbc_AppointmentDate);
		
		JLabel AppointmentTimeLabel = new JLabel("Results:");
		GridBagConstraints gbc_AppointmentTimeLabel = new GridBagConstraints();
		gbc_AppointmentTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentTimeLabel.gridx = 1;
		gbc_AppointmentTimeLabel.gridy = 3;
		Appointment1.add(AppointmentTimeLabel, gbc_AppointmentTimeLabel);
		
		JLabel AppointmentTime = new JLabel("All clear! Nothing to worry about.");
		GridBagConstraints gbc_AppointmentTime = new GridBagConstraints();
		gbc_AppointmentTime.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentTime.gridx = 3;
		gbc_AppointmentTime.gridy = 3;
		Appointment1.add(AppointmentTime, gbc_AppointmentTime);
		
		JLabel DepartmentLabel = new JLabel("Department:");
		GridBagConstraints gbc_DepartmentLabel = new GridBagConstraints();
		gbc_DepartmentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_DepartmentLabel.gridx = 1;
		gbc_DepartmentLabel.gridy = 4;
		Appointment1.add(DepartmentLabel, gbc_DepartmentLabel);
		
		JLabel Department = new JLabel("Cardiology");
		GridBagConstraints gbc_Department = new GridBagConstraints();
		gbc_Department.insets = new Insets(0, 0, 5, 5);
		gbc_Department.gridx = 3;
		gbc_Department.gridy = 4;
		Appointment1.add(Department, gbc_Department);
		
		JButton CancelButton = new JButton("Cancel");
		GridBagConstraints gbc_CancelButton = new GridBagConstraints();
		gbc_CancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_CancelButton.gridx = 3;
		gbc_CancelButton.gridy = 6;
		Appointment1.add(CancelButton, gbc_CancelButton);
		
		JPanel Appointment1_1 = new JPanel();
		Appointment1_1.setBounds(123, 244, 347, 172);
		contentPane.add(Appointment1_1);
		GridBagLayout gbl_Appointment1_1 = new GridBagLayout();
		gbl_Appointment1_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Appointment1_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Appointment1_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Appointment1_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Appointment1_1.setLayout(gbl_Appointment1_1);
		
		JLabel PatientNameLabel2 = new JLabel("Test Type:");
		GridBagConstraints gbc_PatientNameLabel2 = new GridBagConstraints();
		gbc_PatientNameLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_PatientNameLabel2.gridx = 1;
		gbc_PatientNameLabel2.gridy = 1;
		Appointment1_1.add(PatientNameLabel2, gbc_PatientNameLabel2);
		
		JLabel PatientName2 = new JLabel("MRI Scan");
		GridBagConstraints gbc_PatientName2 = new GridBagConstraints();
		gbc_PatientName2.insets = new Insets(0, 0, 5, 5);
		gbc_PatientName2.gridx = 3;
		gbc_PatientName2.gridy = 1;
		Appointment1_1.add(PatientName2, gbc_PatientName2);
		
		JLabel AppointmentDateLabel2 = new JLabel("Date:");
		GridBagConstraints gbc_AppointmentDateLabel2 = new GridBagConstraints();
		gbc_AppointmentDateLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentDateLabel2.gridx = 1;
		gbc_AppointmentDateLabel2.gridy = 2;
		Appointment1_1.add(AppointmentDateLabel2, gbc_AppointmentDateLabel2);
		
		JLabel AppointmentDate2 = new JLabel("03/03/03");
		GridBagConstraints gbc_AppointmentDate2 = new GridBagConstraints();
		gbc_AppointmentDate2.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentDate2.gridx = 3;
		gbc_AppointmentDate2.gridy = 2;
		Appointment1_1.add(AppointmentDate2, gbc_AppointmentDate2);
		
		JLabel AppointmentTimeLabel2 = new JLabel("Results:");
		GridBagConstraints gbc_AppointmentTimeLabel2 = new GridBagConstraints();
		gbc_AppointmentTimeLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentTimeLabel2.gridx = 1;
		gbc_AppointmentTimeLabel2.gridy = 3;
		Appointment1_1.add(AppointmentTimeLabel2, gbc_AppointmentTimeLabel2);
		
		JLabel AppointmentTime2 = new JLabel("Further testing needed.");
		GridBagConstraints gbc_AppointmentTime2 = new GridBagConstraints();
		gbc_AppointmentTime2.insets = new Insets(0, 0, 5, 5);
		gbc_AppointmentTime2.gridx = 3;
		gbc_AppointmentTime2.gridy = 3;
		Appointment1_1.add(AppointmentTime2, gbc_AppointmentTime2);
		
		JLabel DepartmentLabel2 = new JLabel("Department:");
		GridBagConstraints gbc_DepartmentLabel2 = new GridBagConstraints();
		gbc_DepartmentLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_DepartmentLabel2.gridx = 1;
		gbc_DepartmentLabel2.gridy = 4;
		Appointment1_1.add(DepartmentLabel2, gbc_DepartmentLabel2);
		
		JLabel Department2 = new JLabel("Cardiology");
		GridBagConstraints gbc_Department2 = new GridBagConstraints();
		gbc_Department2.insets = new Insets(0, 0, 5, 5);
		gbc_Department2.gridx = 3;
		gbc_Department2.gridy = 4;
		Appointment1_1.add(Department2, gbc_Department2);
		
		// not sure whether we want to give the option to cancel test results or not?
		JButton CancelButton2 = new JButton("Cancel");
		GridBagConstraints gbc_CancelButton2 = new GridBagConstraints();
		gbc_CancelButton2.insets = new Insets(0, 0, 0, 5);
		gbc_CancelButton2.gridx = 3;
		gbc_CancelButton2.gridy = 6;
		Appointment1_1.add(CancelButton2, gbc_CancelButton2);
		
		JButton PreviousButton = new JButton("Previous");
		PreviousButton.setBounds(12, 431, 89, 23);
		contentPane.add(PreviousButton);
		
		JButton NextButton = new JButton("Next");
		NextButton.setBounds(472, 431, 89, 23);
		contentPane.add(NextButton);
		
		JButton ReturnToMainButton = new JButton("X");
		ReturnToMainButton.setBounds(522, 7, 39, 23);
		contentPane.add(ReturnToMainButton);
	}
}
