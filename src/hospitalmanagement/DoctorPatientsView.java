package hospitalmanagement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * This frame displays the list of patients the doctor has an appointment with.
 */
public class DoctorPatientsView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * This is for when the Doctor clicks on the "View Patients" button.
	 * Here, the Doctor will be able to see a list of patients they have an appointment with.
	 */
	public DoctorPatientsView() {
		
		// set frame properties
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// create panel for the frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/******** TODO: List patient names here. This string will be used as the String to show names
		 * into the pane.
		 */
		String[] names = new String[] {"LastName, FirstName Patient1", "LastName, FirstName Patient2", "LastName, FirstName Patient3", "LastName, FirstName Patient4", "LastName, FirstName Patient5", "LastName, FirstName Patient6", "LastName, FirstName Patient7", "LastName, FirstName Patient8", "LastName, FirstName Patient9", "LastName, FirstName Patient10", "LastName, FirstName Patient11", "LastName, FirstName Patient12"};
		
		/******** TODO: Make string array that lists patient ID using accounts JSON. Below is a
		 * placeholder for now. If you have a different idea, let me (Gerard) know so I can properly
		 * adjust. For now, there will be 2 different Strings: first (the one above) containing the
		 * names; second (the one below) containing the IDs (must be same indices). These will be
		 * the ones used for finding the patient's information.
		 */
		String[] patientIDs = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		
		List<String> values = new ArrayList<>(names.length);
		for (int i = 0; names.length>i; i++) {
			values.add(names[i]);
		}
		
		// create a list of patients
		JList<Object> patientList = new JList<Object>(values.toArray(new String[values.size()]));
		patientList.setValueIsAdjusting(true);
		patientList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		patientList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		patientList.setBounds(64, 34, 315, 161);
		JScrollPane patientListScroller = new JScrollPane();
		patientListScroller.setLocation(50, 33);
		patientListScroller.setSize(330, 169);
		patientListScroller.setViewportView(patientList);
		patientList.setLayoutOrientation(JList.VERTICAL);
		contentPane.add(patientListScroller);
		
		// add a label to the panel to prompt the user to select a patient
		JLabel lblPleaseSelectPatient = new JLabel("Please Select Patient");
		lblPleaseSelectPatient.setBounds(146, 13, 125, 16);
		contentPane.add(lblPleaseSelectPatient);
		
		// add a button to the panel to allow the user to confirm their actions
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedName = names[patientList.getSelectedIndex()];
				int ID = Integer.parseInt(patientIDs[patientList.getSelectedIndex()]);
				DoctorPatientsViewInformation patientInfoPane = new DoctorPatientsViewInformation(selectedName, ID);
				patientInfoPane.setVisible(true);
				dispose();
			}
		});
		btnConfirm.setBounds(104, 215, 97, 25);
		contentPane.add(btnConfirm);
		
		// add a button to the panel to allow the user to return to the previous view
		JButton btnCancel = new JButton("Return");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(236, 215, 97, 25);
		contentPane.add(btnCancel);
		// String[] patients = {"LastName, Alice", "LastName, Bob", "LastName, COVID19", "LastName, Dad", "LastName, Eckhardt"};
	}
}
