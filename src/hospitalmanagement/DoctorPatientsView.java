package hospitalmanagement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This frame displays the list of patients the doctor has an appointment with.
 */
public class DoctorPatientsView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame. This is for when the Doctor clicks on the "View Patients"
	 * button. Here, the Doctor will be able to see a list of patients they have an
	 * appointment with.
	 * @param email The email of the doctor. Used to uniquely identify the user so we can easily access their info.
	 */
	public DoctorPatientsView(String email) {

		// set frame properties
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// create panel for the frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/********
		 * TODO: List patient names here. This string will be used as the String to show
		 * names into the pane.
		 */
		// String[] names = new String[] {"LastName, FirstName Patient1", "LastName,
		// FirstName Patient2", "LastName, FirstName Patient3", "LastName, FirstName
		// Patient4", "LastName, FirstName Patient5", "LastName, FirstName Patient6",
		// "LastName, FirstName Patient7", "LastName, FirstName Patient8", "LastName,
		// FirstName Patient9", "LastName, FirstName Patient10", "LastName, FirstName
		// Patient11", "LastName, FirstName Patient12"};
		ArrayList<String> names = new ArrayList<String>();
		try {
			// create reader
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/hospitalmanagement/accounts2.json")));

			// create parser
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

			// read accounts array from json
			JsonArray accounts = (JsonArray) parser.get("accounts");

			// extract the object representation of the account type from the accounts array
			// then get the array representation of that account type
			// then create an iterator to iterate through that array
			JsonObject patients = (JsonObject) accounts.get(0);
			JsonArray patientArr = (JsonArray) patients.get("patient");
			Iterator i = patientArr.iterator();

			// iterate through all pairs of first and last names in the user type array
			while (i.hasNext()) {

				JsonObject account = (JsonObject) i.next();
				String firstName = (String) account.get("first_name");
				String lastName = (String) account.get("last_name");

				names.add(lastName + ", " + firstName);
			}

			// close reader
			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		/********
		 * TODO: Make string array that lists patient ID using accounts JSON. Below is a
		 * placeholder for now. If you have a different idea, let me (Gerard) know so I
		 * can properly adjust. For now, there will be 2 different Strings: first (the
		 * one above) containing the names; second (the one below) containing the IDs
		 * (must be same indices). These will be the ones used for finding the patient's
		 * information.
		 */
		String[] patientIDs = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

		List<String> values = new ArrayList<>(names.size());
		for (int i = 0; names.size() > i; i++) {
			values.add(names.get(i));
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
				String selectedName = names.get(patientList.getSelectedIndex());
				int ID = Integer.parseInt(patientIDs[patientList.getSelectedIndex()]);
				DoctorPatientsViewInformation patientInfoPane = new DoctorPatientsViewInformation(email, selectedName, ID);
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
		// String[] patients = {"LastName, Alice", "LastName, Bob", "LastName, COVID19",
		// "LastName, Dad", "LastName, Eckhardt"};
	}
}
