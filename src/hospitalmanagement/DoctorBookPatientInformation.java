package hospitalmanagement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;

public class DoctorBookPatientInformation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * This frame is the frame for when the Doctor selects the patient in the DoctorBookPatient pane.
	 * This frame will show important information about the patient as well as give options for the 
	 * appointments, such as time and date.
	 * @param name Name of patient passed from previous window.
	 * @param ID ID of patients passed from previous window.
	 */
	public DoctorBookPatientInformation(String name, int ID) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/******** TODO: This is just a suggestion: using the ID, find the patient information
		 * and then make a new object of Patient class. once that's done, I will take any needed
		 * information and list it. I'm open to suggestions about what information must be shown
		 * when a doctor wants to add a patient, since I'm not too sure. So far, I'm only putting
		 * the Name, Age, Gender, and Department they're specified in. The JSONs doesn't have any
		 * department(s) assigned to the patients, but we will need to so that the doctor in the
		 * right department is choosing.
		 */
		
		// Button for completing the appointment booking process.
		JButton btnBookAppointment = new JButton("Book Appointment");
		
		// Button for cancelling the appointment booking process.
		JButton btnCancel = new JButton("Cancel");
		// If Cancel button is clicked, it will show a dialog, then close the pane and return to previous pane
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(contentPane, "Patient has NOT been added.");
				dispose();
				DoctorBookPatient addPatientPane = new DoctorBookPatient();
				addPatientPane.setVisible(true);
			}
		});
		
		JPanel PatientInfo = new JPanel();
		GridBagLayout gbl_PatientInfo = new GridBagLayout();
		gbl_PatientInfo.columnWidths = new int[] {50, 50};
		gbl_PatientInfo.rowHeights = new int[] {30, 30, 30, 40, 38, 38, 38, 38};
		gbl_PatientInfo.columnWeights = new double[]{0.0, 1.0};
		gbl_PatientInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0};
		PatientInfo.setLayout(gbl_PatientInfo);
		
		// Label showing where patient's name is
		JLabel PatientNameLabel = new JLabel("Patient:");
		GridBagConstraints gbc_PatientNameLabel = new GridBagConstraints();
		gbc_PatientNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PatientNameLabel.gridx = 0;
		gbc_PatientNameLabel.gridy = 0;
		PatientInfo.add(PatientNameLabel, gbc_PatientNameLabel);
		
		// Label showing patient's name
		JLabel lblCourageCowardlydog = new JLabel(name);
		GridBagConstraints gbc_lblCourageCowardlydog = new GridBagConstraints();
		gbc_lblCourageCowardlydog.insets = new Insets(0, 0, 5, 0);
		gbc_lblCourageCowardlydog.gridx = 1;
		gbc_lblCourageCowardlydog.gridy = 0;
		PatientInfo.add(lblCourageCowardlydog, gbc_lblCourageCowardlydog);
		
		// Label showing where patient's age is
		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 1;
		PatientInfo.add(lblAge, gbc_lblAge);
		
		// Label showing patients age
		JLabel AppointmentDate = new JLabel("3");
		GridBagConstraints gbc_AppointmentDate = new GridBagConstraints();
		gbc_AppointmentDate.insets = new Insets(0, 0, 5, 0);
		gbc_AppointmentDate.gridx = 1;
		gbc_AppointmentDate.gridy = 1;
		PatientInfo.add(AppointmentDate, gbc_AppointmentDate);
		
		// Label showing where patient's gender is
		JLabel lblGender = new JLabel("Gender:");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 2;
		PatientInfo.add(lblGender, gbc_lblGender);
		
		// Label showing patient's gender
		JLabel lblMale = new JLabel("Male");
		GridBagConstraints gbc_lblMale = new GridBagConstraints();
		gbc_lblMale.insets = new Insets(0, 0, 5, 0);
		gbc_lblMale.gridx = 1;
		gbc_lblMale.gridy = 2;
		PatientInfo.add(lblMale, gbc_lblMale);
		
		
		JLabel lblPatientInformation = new JLabel("Patient Information");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(158, Short.MAX_VALUE)
					.addComponent(lblPatientInformation)
					.addGap(155))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(85)
					.addComponent(btnBookAppointment)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(82))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(PatientInfo, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPatientInformation)
					.addGap(18)
					.addComponent(PatientInfo, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnBookAppointment))
					.addContainerGap())
		);
		
		// Label showing where patient's prescription is
		JLabel lblPrescriptions = new JLabel("Prescriptions:");
		GridBagConstraints gbc_lblPrescriptions = new GridBagConstraints();
		gbc_lblPrescriptions.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrescriptions.gridx = 0;
		gbc_lblPrescriptions.gridy = 3;
		PatientInfo.add(lblPrescriptions, gbc_lblPrescriptions);
		
		/******** TODO: Get list of prescriptions prescribed to the patient.
		 * Below is  placeholder for prescriptions.
		 */
		String[] prescriptions = new String[] {"Vicodin", "Atorvastatin", "Simvastatin", "IDK Something Else"};
		
		// List of patient's prescription
		List<String> drugs = new ArrayList<>();
		for (int i = 0; prescriptions.length > i; i++) {
			drugs.add((i+1)+". " + prescriptions[i]);
		}
		
		// JList showing patient's prescription onto GUI
		JList<Object> prescriptionList = new JList<Object>(drugs.toArray(new String[drugs.size()]));
		prescriptionList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		prescriptionList.setValueIsAdjusting(true);
		GridBagConstraints gbc_prescriptionList = new GridBagConstraints();
		gbc_prescriptionList.insets = new Insets(0, 0, 5, 0);
		gbc_prescriptionList.fill = GridBagConstraints.BOTH;
		gbc_prescriptionList.gridx = 1;
		gbc_prescriptionList.gridy = 3;
		JScrollPane prescriptionListScroller = new JScrollPane();
		prescriptionListScroller.setViewportView(prescriptionList);
		PatientInfo.add(prescriptionListScroller, gbc_prescriptionList);
		
		// Label showing where Department can be chosen
		JLabel lblDepartment = new JLabel("Department:");
		GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
		gbc_lblDepartment.anchor = GridBagConstraints.EAST;
		gbc_lblDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartment.gridx = 0;
		gbc_lblDepartment.gridy = 4;
		PatientInfo.add(lblDepartment, gbc_lblDepartment);
		
		// Drop down list of Departments that can be chosen
		JComboBox<String> Department = new JComboBox<String>();
		GridBagConstraints gbc_Department = new GridBagConstraints();
		gbc_Department.insets = new Insets(0, 0, 5, 0);
		gbc_Department.fill = GridBagConstraints.HORIZONTAL;
		gbc_Department.gridx = 1;
		gbc_Department.gridy = 4;
		PatientInfo.add(Department, gbc_Department);
		Department.addItem("Cardiology");
		Department.addItem("Nephrology");
		Department.addItem("Neurology");		
		
		// Label showing where Appointment Type can be chosen
		JLabel lblApptType = new JLabel("Appt. Type:");
		GridBagConstraints gbc_lblApptType = new GridBagConstraints();
		gbc_lblApptType.anchor = GridBagConstraints.EAST;
		gbc_lblApptType.insets = new Insets(0, 0, 5, 5);
		gbc_lblApptType.gridx = 0;
		gbc_lblApptType.gridy = 5;
		PatientInfo.add(lblApptType, gbc_lblApptType);
		
		// Drop down list of Appointment Types that can be chosen
		JComboBox<String> ApptType = new JComboBox<String>();
		GridBagConstraints gbc_ApptType = new GridBagConstraints();
		gbc_ApptType.insets = new Insets(0, 0, 5, 0);
		gbc_ApptType.fill = GridBagConstraints.HORIZONTAL;
		gbc_ApptType.gridx = 1;
		gbc_ApptType.gridy = 5;
		PatientInfo.add(ApptType, gbc_ApptType);
		
		// Label showing where the Date can be chosen
		JLabel lblDate = new JLabel("Date:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 6;
		PatientInfo.add(lblDate, gbc_lblDate);
		
		
		/******** TODO: We need to implement a way to know the dates and set appointments
		 * not only on time of day but the date as well.
		 */
		// Drop down list showing the Dates possible for the appointment
		JComboBox<Object> ApptDate = new JComboBox<Object>();
		GridBagConstraints gbc_ApptDate = new GridBagConstraints();
		gbc_ApptDate.insets = new Insets(0, 0, 5, 0);
		gbc_ApptDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_ApptDate.gridx = 1;
		gbc_ApptDate.gridy = 6;
		PatientInfo.add(ApptDate, gbc_ApptDate);
		
		// Label showing where the Time can be chosen
		JLabel lblTime = new JLabel("Time:");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.insets = new Insets(0, 0, 0, 5);
		gbc_lblTime.gridx = 0;
		gbc_lblTime.gridy = 7;
		PatientInfo.add(lblTime, gbc_lblTime);
		
		
		/******** TODO: Going to need to find a way to see doctor availability and be able to add
		 * the time stamps into a list of strings. like "10:00-10:25am", "10:30-10:55", etc.
		 * are in a string or something. If we find a way to determine how availability is
		 * going to be stored and read from, it should be easy to implement them.
		 * For now, below is a placeholder for the doctor's time availability.
		 */
		String[] time = new String[] {"10:00-10:25am", "10:30-10:55am", "11:00-11:25am", "11:30-11:55am", "12:00-12:25pm", "12:30-12:55pm"};
		
		// List of available times for the Doctor
		List<String> availability = new ArrayList<>();
		for (int i = 0; time.length > i; i++) {
			availability.add(time[i]);
		}
		
		// JList showing the times that can be chosen onto the GUI
		JList<Object> timeList = new JList<Object>(availability.toArray(new String[availability.size()]));
		timeList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		timeList.setValueIsAdjusting(true);
		GridBagConstraints gbc_timeList = new GridBagConstraints();
		gbc_timeList.fill = GridBagConstraints.BOTH;
		gbc_timeList.gridx = 1;
		gbc_timeList.gridy = 7;
		JScrollPane timeListScroller = new JScrollPane();
		timeListScroller.setViewportView(timeList);
		PatientInfo.add(timeListScroller, gbc_timeList);
		ApptType.addItem("Uh... IDK what to put");
		contentPane.setLayout(gl_contentPane);
		
		// If "Book Appointment" button was clicked, a confirmation dialogue will be shown.
		btnBookAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int add = JOptionPane.showConfirmDialog(contentPane, "Add " + name + "?");		//Confirmation dialogue shown to doctor
				if (add == 0) {		//If "YES" was clicked, make new appointment and add patient to it, and give a dialogue saying so.
					String timeSelected = time[timeList.getSelectedIndex()];
					/******** TODO: Add selected patient to doctor's lists of patients in the accounts JSON. 
					 * The time for appointment is a string called timeSelected, defined above.
					 * Also need to create an appointment ID.
					 */
					JOptionPane.showMessageDialog(contentPane, name + "has been added to your patients.\n" + 
					 "Time of appointment: " + timeSelected);
					dispose();
					DoctorBookPatient addPatientPane = new DoctorBookPatient();
					addPatientPane.setVisible(true);
				} else {		//If "NO" or "CACNEL" was clicked, don't make appointment and give a dialogue saying so.
					JOptionPane.showMessageDialog(contentPane, "Patient has NOT been added.");
				}
			}
		});
	}
}
