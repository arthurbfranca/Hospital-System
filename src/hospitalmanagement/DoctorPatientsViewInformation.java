package hospitalmanagement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;

/**
 * Class that displays the selected patient's information.
 * @author arthurbfranca, ggdizon, sydneykwok
 */
public class DoctorPatientsViewInformation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * This frame is the frame for when the Doctor selects the patient in the View Patient pane.
	 * The Doctor will be shown information about the specific patient that was chosen in the previous pane.
	 * @param email The email of the doctor (used as an identifier for reading/writing to JSON).
	 * @param name Name of the patient chosen by the Doctor that was passed from the previous pane.
	 * @param ID ID of the patient chosen by the Doctor that was passed from the previous pane.
	 */
	public DoctorPatientsViewInformation(String email, String name, int ID) {
		
		// set frame properties
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// create the panel for the frame
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/******** TODO: This is just a suggestion: using the ID, find the patient information
		 * and then make a new object of Patient class. once that's done, I will take any needed
		 * information and list it. I'm open to suggestions about what information must be shown
		 * when a doctor wants to view a patient, since I'm not too sure. I haven't added
		 * appointments since there's already "View Appointments" section. We might want to have
		 * a JSON that includes the medical information of the Patient (in addition to prescriptions)
		 * although that's a lot of work and probably would be just considered an exciting requirement.
		 */		
		
		// Button that will close the current pane and return to the previous pane.
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DoctorPatientsView viewPatientPane = new DoctorPatientsView(email);
				viewPatientPane.setVisible(true);
				dispose();
			}
		});
		
		// Below will contain various labels showing the patient's information.
		JLabel lblPatientInformation = new JLabel("Patient Information");
		
		JPanel Patient = new JPanel();
		GridBagLayout gbl_Patient = new GridBagLayout();
		gbl_Patient.columnWidths = new int[]{50, 50, 0};
		gbl_Patient.rowHeights = new int[]{30, 30, 30, 0, 0};
		gbl_Patient.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_Patient.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		Patient.setLayout(gbl_Patient);
		
		JLabel PatientNameLabel = new JLabel("Patient:");
		GridBagConstraints gbc_PatientNameLabel = new GridBagConstraints();
		gbc_PatientNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PatientNameLabel.gridx = 0;
		gbc_PatientNameLabel.gridy = 0;
		Patient.add(PatientNameLabel, gbc_PatientNameLabel);
		
		// Label for name of patient
		JLabel lblCourageCowardlydog = new JLabel(name);
		GridBagConstraints gbc_lblCourageCowardlydog = new GridBagConstraints();
		gbc_lblCourageCowardlydog.insets = new Insets(0, 0, 5, 0);
		gbc_lblCourageCowardlydog.gridx = 1;
		gbc_lblCourageCowardlydog.gridy = 0;
		Patient.add(lblCourageCowardlydog, gbc_lblCourageCowardlydog);
		
		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 1;
		Patient.add(lblAge, gbc_lblAge);
		
		// Label for age of patient
		JLabel AppointmentDate = new JLabel("3");
		GridBagConstraints gbc_AppointmentDate = new GridBagConstraints();
		gbc_AppointmentDate.insets = new Insets(0, 0, 5, 0);
		gbc_AppointmentDate.gridx = 1;
		gbc_AppointmentDate.gridy = 1;
		Patient.add(AppointmentDate, gbc_AppointmentDate);
		
		JLabel lblGender = new JLabel("Gender:");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 2;
		Patient.add(lblGender, gbc_lblGender);
		
		// Label for gender of patient
		JLabel lblMale = new JLabel("Male");
		GridBagConstraints gbc_lblMale = new GridBagConstraints();
		gbc_lblMale.insets = new Insets(0, 0, 5, 0);
		gbc_lblMale.gridx = 1;
		gbc_lblMale.gridy = 2;
		Patient.add(lblMale, gbc_lblMale);
		
		JLabel lblPrescriptions = new JLabel("Prescriptions:");
		GridBagConstraints gbc_lblPrescriptions = new GridBagConstraints();
		gbc_lblPrescriptions.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrescriptions.gridx = 0;
		gbc_lblPrescriptions.gridy = 3;
		Patient.add(lblPrescriptions, gbc_lblPrescriptions);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(75, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblPatientInformation)
							.addGap(155))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(161))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(Patient, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
							.addGap(67))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPatientInformation)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Patient, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnReturn)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		/******** TODO: Get list of prescriptions prescribed to the patient.
		 * Below is a placeholder for prescriptions.
		 */
		String[] prescriptions = new String[] {"Vicodin", "Atorvastatin", "Simvastatin", "IDK Something Else"};
		
		// List of prescriptions prescribed to the patient.
		List<String> drugs = new ArrayList<>();
		for (int i = 0; prescriptions.length > i; i++) {
			drugs.add((i+1)+". " + prescriptions[i]);
		}
		
		// JList of patient's prescriptions.
		JList<Object> prescriptionList = new JList<Object>(drugs.toArray(new String[drugs.size()]));
		prescriptionList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		prescriptionList.setValueIsAdjusting(true);
		GridBagConstraints gbc_prescriptionList = new GridBagConstraints();
		gbc_prescriptionList.fill = GridBagConstraints.BOTH;
		gbc_prescriptionList.gridx = 1;
		gbc_prescriptionList.gridy = 3;
		JScrollPane prescriptionListScroller = new JScrollPane();
		prescriptionListScroller.setViewportView(prescriptionList);
		Patient.add(prescriptionListScroller, gbc_prescriptionList);
		contentPane.setLayout(gl_contentPane);
	}
}
