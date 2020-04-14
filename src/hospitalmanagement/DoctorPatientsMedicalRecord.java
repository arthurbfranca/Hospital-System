package hospitalmanagement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.cliftonlabs.json_simple.JsonObject;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorPatientsMedicalRecord extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Creates the pane that gives the doctor the ability to view the medical records of the patient
	 * @param email The email of the doctor
	 * @param patient The JsonObject representation of the patient in the accounts2.json
	 * @author ggdizon
	 */
	public DoctorPatientsMedicalRecord(String email, JsonObject patient) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[220.00px,center][220.00px,center]", "[32px][32px][32px][32px][32px][32px][32px][40]"));
		
		// Get patient's information
		// Get patient's name
		String last_name = (String) patient.get("last_name") + ", ";
		String first_name = (String) patient.get("first_name");
		
		// Get patient's index with their ID
		String id = (String) patient.get("id");
		int indexAsInt = Integer.parseInt(id) - 1;
		String index = Integer.toString(indexAsInt);
		
		// Creates and adds the labels for the different
		// kinds of medical records into the pane
		// as well as buttons to view them
		JLabel lblRecords = new JLabel("Records");
		contentPane.add(lblRecords, "cell 1 0,grow");
		
		JLabel lblName = new JLabel(last_name + first_name);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblName, "flowy,cell 0 1,alignx center,growy");
		
		JLabel lblBaasicInformation = new JLabel("Basic Information");
		lblBaasicInformation.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBaasicInformation, "cell 0 2,grow");
		
		JButton btnViewBI = new JButton("View Basic Info");
		btnViewBI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				DoctorPatientsBasicInfoView basicInfoPanel = new DoctorPatientsBasicInfoView(email, index, patient);
				basicInfoPanel.setVisible(true);
			}
		});
		contentPane.add(btnViewBI, "cell 1 2");
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNotes, "cell 0 3,grow");
		
		JButton btnViewNotes = new JButton("View Notes");
		btnViewNotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				DoctorPatientsNotesView notesPane = new DoctorPatientsNotesView(email, index);
				notesPane.setVisible(true);
			}
		});
		contentPane.add(btnViewNotes, "cell 1 3");
		
		JLabel lblPhysicalInformation = new JLabel("Physical Information");
		lblPhysicalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPhysicalInformation, "cell 0 4,grow");
		
		JButton btnViewPhysicalInfo = new JButton("View Physical Info");
		btnViewPhysicalInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				DoctorPatientsPhysicalInfoView physInfoPane = new DoctorPatientsPhysicalInfoView(email, index);
				physInfoPane.setVisible(true);
			}
		});
		contentPane.add(btnViewPhysicalInfo, "cell 1 4");
		
		JLabel lblMedications = new JLabel("Medications");
		lblMedications.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMedications, "cell 0 5,grow");
		
		JButton btnViewCurrentMedications = new JButton("View Current Medications");
		btnViewCurrentMedications.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				DoctorPatientsMedicationsView medicationsPane = new DoctorPatientsMedicationsView(email, index);
				medicationsPane.setVisible(true);
			}
		});
		contentPane.add(btnViewCurrentMedications, "cell 1 5");
		
		JLabel lblTestOrders = new JLabel("Test Orders");
		lblTestOrders.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTestOrders, "cell 0 6,grow");
		
		
		JLabel lblMedicalRecord = new JLabel("Medical");
		lblMedicalRecord.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblMedicalRecord, "cell 0 0,grow");
		
		JButton btnViewTestOrders = new JButton("View Test Orders");
		btnViewTestOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				DoctorPatientsTestOrdersView testOrderPane = new DoctorPatientsTestOrdersView(email, index);
				testOrderPane.setVisible(true);
			}
		});
		contentPane.add(btnViewTestOrders, "cell 1 6");
		
		// Button allowing the user to close the pane and return to the previous one
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				DoctorPatientsViewInformation docViewPatientPane = new DoctorPatientsViewInformation(email, indexAsInt);
				docViewPatientPane.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton, "cell 1 7,alignx center,aligny center");
	}
}
