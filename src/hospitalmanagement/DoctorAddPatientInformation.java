package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorAddPatientInformation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorAddPatientInformation frame = new DoctorAddPatientInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * This frame is the frame for when the Doctor clicks on the patient in the Add Patient pane.
	 */
	public DoctorAddPatientInformation(String name, int ID) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int add = JOptionPane.showConfirmDialog(contentPane, "Add " + name + "?");
				if (add == 0) {
					/******** TODO: Add selected patient to doctor's lists of patients in the accounts JSON. 
					 */
					JOptionPane.showMessageDialog(contentPane, name + "has been added to your patients.");
					dispose();
					DoctorAddPatient addPatientPane = new DoctorAddPatient();
					addPatientPane.setVisible(true);
				} else if (add == 1) {
					JOptionPane.showMessageDialog(contentPane, "Patient has NOT been added.");
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(contentPane, "Patient has NOT been added.");
				dispose();
				DoctorAddPatient addPatientPane = new DoctorAddPatient();
				addPatientPane.setVisible(true);
			}
		});
		
		JPanel Patient = new JPanel();
		GridBagLayout gbl_Patient = new GridBagLayout();
		gbl_Patient.columnWidths = new int[] {50, 50};
		gbl_Patient.rowHeights = new int[] {30, 30, 30, 30};
		gbl_Patient.columnWeights = new double[]{0.0, 0.0};
		gbl_Patient.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		Patient.setLayout(gbl_Patient);
		
		JLabel PatientNameLabel = new JLabel("Patient:");
		GridBagConstraints gbc_PatientNameLabel = new GridBagConstraints();
		gbc_PatientNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PatientNameLabel.gridx = 0;
		gbc_PatientNameLabel.gridy = 0;
		Patient.add(PatientNameLabel, gbc_PatientNameLabel);
		
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
		
		JLabel lblPatientInformation = new JLabel("Patient Information");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(112)
					.addComponent(btnAddPatient)
					.addGap(18)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(102, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(158, Short.MAX_VALUE)
					.addComponent(lblPatientInformation)
					.addGap(155))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(85)
					.addComponent(Patient, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
					.addGap(82))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPatientInformation)
					.addGap(18)
					.addComponent(Patient, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddPatient)
						.addComponent(btnCancel))
					.addContainerGap())
		);
		
		JLabel lblMale = new JLabel("Male");
		GridBagConstraints gbc_lblMale = new GridBagConstraints();
		gbc_lblMale.insets = new Insets(0, 0, 5, 0);
		gbc_lblMale.gridx = 1;
		gbc_lblMale.gridy = 2;
		Patient.add(lblMale, gbc_lblMale);
		
		JLabel lblDepartment = new JLabel("Department:");
		GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
		gbc_lblDepartment.insets = new Insets(0, 0, 0, 5);
		gbc_lblDepartment.gridx = 0;
		gbc_lblDepartment.gridy = 3;
		Patient.add(lblDepartment, gbc_lblDepartment);
		
		JLabel lblCardiology = new JLabel("Cardiology");
		GridBagConstraints gbc_lblCardiology = new GridBagConstraints();
		gbc_lblCardiology.gridx = 1;
		gbc_lblCardiology.gridy = 3;
		Patient.add(lblCardiology, gbc_lblCardiology);
		contentPane.setLayout(gl_contentPane);
	}
}
