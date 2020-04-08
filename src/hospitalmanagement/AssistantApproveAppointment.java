package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

/**
 * Class that displays the panel for the assistant to approve appointments
 * Assistants can approve an appointment which gets stored in a JSON file containing approved appointments
 * @author shavonnetran
 */
public class AssistantApproveAppointment extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame for the assistant to approve appointments.
	 * @param email: The email of the assistant. Used to uniquely identify the user so we can easily access their info.
	 */
	public AssistantApproveAppointment(String email) {
		//Set frame properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 514);
		
		//Create the panel for the frame
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Create label to indicate to assistants to select an appointment 
		JLabel selectAppointLabel = new JLabel("Select an Appointment to Approve");
		selectAppointLabel.setBounds(76, 230, 423, 33);
		contentPane.add(selectAppointLabel);
		
		//Read from appointments JSON
		ArrayList<String> appointments = new ArrayList<String>();
		try {
			//Create reader
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/hospitalmanagement/appointments.json")));

			//Create parser
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

			//Read appointments array from JSON
			JsonArray appointArr = (JsonArray) parser.get("appointments");
			Iterator i = appointArr.iterator();

			//Iterate through all information stored in the appointments array of the JSON
			while (i.hasNext()) {	
				JsonObject appointObj = (JsonObject) i.next();
				String date = (String) appointObj.get("date");
				String number = (String) appointObj.get("number");
				String patientID = (String) appointObj.get("patientID");
				String docID = (String) appointObj.get("doctorID");
				String department = (String) appointObj.get("department");
				String time = (String) appointObj.get("time");
				String prescrip = (String) appointObj.get("prescriptions");

				appointments.add(patientID + ", " + docID + ", " + date + ", " + time + ", " + number + ", " + department + ", " + prescrip);
			}

			//Close reader
			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		//List of appointments
		List<String> values = new ArrayList<>(appointments.size());
		for (int i = 0; appointments.size() > i; i++) {
			values.add(appointments.get(i));
		}

		//JList showing appointments of patients in the GUI for the assistant to approve
		JList<Object> appointList = new JList<Object>(values.toArray(new String[values.size()]));
		appointList.setValueIsAdjusting(true);
		appointList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		appointList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		appointList.setBounds(64, 34, 315, 161);
		
		JScrollPane appointListScroll = new JScrollPane();
		appointListScroll.setLocation(50, 33);
		appointListScroll.setSize(330, 169);
		appointListScroll.setViewportView(appointList);
		appointList.setLayoutOrientation(JList.VERTICAL);
		contentPane.add(appointListScroll);

		//Add button to approve
		JButton approveBtn = new JButton("Approve");
		//Add event handler for approve button
		approveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: connect to JSON file that stores approved appointments
			}
		});
		approveBtn.setBounds(566, 28, 171, 41);
		contentPane.add(approveBtn);
		
		//Add button to return to assistant home page
		JButton btnNewButton = new JButton("Return");
		//Add event handler for return button
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Close current window and return to assistant home page
				dispose();
			}
		});
		btnNewButton.setBounds(566, 357, 171, 41);
		contentPane.add(btnNewButton);
	}
}