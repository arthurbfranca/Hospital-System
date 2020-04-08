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
 * This frame allows the doctor to book an appointment with a patient.
 */
public class DoctorBookPatient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String selectedName;
	private int ID;

	/**
	 * Create the frame. This is for when the Doctor clicks on the "Book
	 * Appointment" button. It will list patients for the Doctor to choose from and
	 * make an appointment with.
	 * @param email The email of the doctor. Used to uniquely identify the user so we can easily access their info.
	 */
	public DoctorBookPatient(String email) {

		// set the frame properties
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// create the panel for the frame
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// add the title label for the panel
		JLabel lblPleaseSelectPatient = new JLabel("Please Select Patient");
		lblPleaseSelectPatient.setBounds(146, 13, 125, 16);
		contentPane.add(lblPleaseSelectPatient);

		/********
		 * TODO: List patient names here that the doctor can add using the accounts
		 * JSON. I suggest having a different string array containing their ID (or some
		 * way to get their information once the doctor selects the patient). This
		 * string is only a list for the patient names that will be shown, so yeah,
		 * can't put ID here. Note: do we need to have departments for the patients as
		 * well? Like what departments they need to be in (like are they getting a
		 * kidney surgery, and will be placed in the nephrology department, and so
		 * doctors in the nephrology department will be the ones that will be able to
		 * add them? And they will be in multiple departments if they have more than 1
		 * type, like kidney appointment and heart surgery?) ASK THEM
		 */
		// String[] names = new String[] {"LastName, FirstName Patient1", "LastName,
		// FirstName Patient2", "LastName, FirstName Patient3",
		// "LastName, FirstName Patient4", "LastName, FirstName Patient5", "LastName,
		// FirstName Patient6", "LastName, FirstName Patient7",
		// "LastName, FirstName Patient8", "LastName, FirstName Patient9", "LastName,
		// FirstName Patient10", "LastName, FirstName Patient11",
		// "LastName, FirstName Patient12"};

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
		 * (must be same indices)
		 */
		String[] patientIDs = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

		// List of names of patients
		List<String> values = new ArrayList<>(names.size());
		for (int i = 0; names.size() > i; i++) {
			values.add(names.get(i));
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

		// Button that will choose the selected patient in the JList and move onto next
		// step of making an appointment.
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedName = names.get(patientList.getSelectedIndex());
				ID = Integer.parseInt(patientIDs[patientList.getSelectedIndex()]);
				DoctorBookPatientInformation patientInfoPane = new DoctorBookPatientInformation(email, selectedName, ID);
				patientInfoPane.setVisible(true);
				dispose();
			}
		});
		btnConfirm.setBounds(104, 215, 97, 25);
		contentPane.add(btnConfirm);

		// Button that will close current window, effectively returning to the previous
		// window.
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
