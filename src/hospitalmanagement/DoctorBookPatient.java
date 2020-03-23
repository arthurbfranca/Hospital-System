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
 * This frame allows the doctor to book an appointment with a patient.
 */
public class DoctorBookPatient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String selectedName;
	private int ID;

	/**
	 * Create the frame.
	 * This is for when the Doctor clicks on the "Book Appointment" button.
	 * It will list patients for the Doctor to choose from and make an appointment with.
	 */
	public DoctorBookPatient() {
		
		// set the frame properties
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// create the panel for the frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// add the title label for the panel
		JLabel lblPleaseSelectPatient = new JLabel("Please Select Patient");
		lblPleaseSelectPatient.setBounds(146, 13, 125, 16);
		contentPane.add(lblPleaseSelectPatient);
		
		/******** TODO: List patient names here that the doctor can add using the accounts JSON.
		 * I suggest having a different string array containing their ID (or some way to
		 * get their information once the doctor selects the patient). This string is only
		 * a list for the patient names that will be shown, so yeah, can't put ID here.
		 * Note: do we need to have departments for the patients as well? Like what departments
		 * they need to be in (like are they getting a kidney surgery, and will be placed in the 
		 * nephrology department, and so doctors in the nephrology department will be the ones
		 * that will be able to add them? And they will be in multiple departments if they have
		 * more than 1 type, like kidney appointment and heart surgery?) ASK THEM
		 */
		String[] names = new String[] {"LastName, FirstName Patient1", "LastName, FirstName Patient2", "LastName, FirstName Patient3",
				"LastName, FirstName Patient4", "LastName, FirstName Patient5", "LastName, FirstName Patient6", "LastName, FirstName Patient7",
				"LastName, FirstName Patient8", "LastName, FirstName Patient9", "LastName, FirstName Patient10", "LastName, FirstName Patient11",
				"LastName, FirstName Patient12"};
		
		/******** TODO: Make string array that lists patient ID using accounts JSON. Below is a
		 * placeholder for now. If you have a different idea, let me (Gerard) know so I can properly
		 * adjust. For now, there will be 2 different Strings: first (the one above) containing the
		 * names; second (the one below) containing the IDs (must be same indices)
		 */
		String[] patientIDs = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		
		// List of names of patients
		List<String> values = new ArrayList<>(names.length);
		for (int i = 0; names.length>i; i++) {
			values.add(names[i]);
		}
		
		// JList showing names of patients in the GUI
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
		
		// Button that will choose the selected patient in the JList and move onto next step of making an appointment.
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedName = names[patientList.getSelectedIndex()];
				ID = Integer.parseInt(patientIDs[patientList.getSelectedIndex()]);
				DoctorBookPatientInformation patientInfoPane = new DoctorBookPatientInformation(selectedName, ID);
				patientInfoPane.setVisible(true);
				dispose();
			}
		});
		btnConfirm.setBounds(104, 215, 97, 25);
		contentPane.add(btnConfirm);
		
		// Button that will close current window, effectively returning to the previous window.
		JButton btnCancel = new JButton("Cancel");
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
