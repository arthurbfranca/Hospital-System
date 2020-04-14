package hospitalmanagement;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorPatientsTestOrdersView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Creates pane for viewing list of test orders for the patient
	 * @param patientIndex The patient's index according to their position in the accounts2.json
	 * @author ggdizon
	 */
	public DoctorPatientsTestOrdersView(String patientIndex) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 235));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[30][10][grow][30]"));

		// get list of tests for the patient
		JsonArray testsList = getPatientsTestOrders(patientIndex);
		
		// check if there are no test orders for the patient
		Iterator i = testsList.iterator();
		boolean hasTest = true;
		if (!i.hasNext()) {
			hasTest = false;
		}
		
		// create List of test information to be shown
		List<String> testInfos;
		if (hasTest) {
			testInfos = formatTestOrders(testsList);
		} else {
			testInfos = new ArrayList<>();
			testInfos.add("No Test Orders For The Patient.");
		}
		
		JLabel lblTestOrders = new JLabel("Test Orders");
		contentPane.add(lblTestOrders, "cell 0 0,alignx center");
		
		JList<Object> testList = new JList<>(testInfos.toArray(new String [testInfos.size()]));
		testList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JScrollPane testListScroller = new JScrollPane(testList);
		contentPane.add(testListScroller, "cell 0 2,grow");
		
		// Check if there are tests before adding "View" button
		if (hasTest) {
			// Button for viewing more test information for the selected test
			JButton btnView = new JButton("View");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnView.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					int selectedIndex = testList.getSelectedIndex();
					if (selectedIndex < 0) {
						JOptionPane.showMessageDialog(contentPane, "Please select a test order.");
					} else {
						
					}
				}
			});
			contentPane.add(btnView, "flowx,cell 0 3,alignx center");
		}
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		contentPane.add(btnReturn, "cell 0 3,alignx center");
		
	}

	/**
	 * Gets the JsonArray representation of patient's test orders
	 * @param patientIndex The patient's index according to their position on the accounts2.json
	 * @return JsonArray representation of the patient's test orders
	 * @author ggdizon
	 */
	private JsonArray getPatientsTestOrders(String patientIndex) {
		try {
			// get JsonArray representation of all patient accounts
			JsonArray patients = Account.getAccountJSONObj("Patient");
			
			// get JsonObject representation of want patient's account
			JsonObject patient = (JsonObject) patients.get(Integer.parseInt(patientIndex));
			
			// get the patient's email
			String email = (String) patient.get("email");
			
			// create reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/tests.json")));
			
			// create parser
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
			
			// read tests from json
			JsonArray tests = (JsonArray) parser.get("tests");
			
			// iterate through all the tests and check if it's for the wanted patient
			// using the tests JsonArray and an interator
			Iterator i = tests.iterator();
			
			// Store the JsonObject into a JsonArray if it is for the wanted patient
			JsonArray patientTests = new JsonArray();
			
			while (i.hasNext()) {
				JsonObject selectedTest = (JsonObject) i.next();
				String emailOfTest = (String) selectedTest.get("patient");
				if (email.equals(emailOfTest)) {
					patientTests.add(selectedTest);
				}
			}
			
			return patientTests;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Formats the Test information into a JList-able format
	 * @param testList JsonArray representation of patient's test orders
	 * @return ArrayList<String> of the test orders' information in the proper format
	 * @author ggdizon
	 */
	private ArrayList<String> formatTestOrders(JsonArray testList) {
		// Iterate through the JsonArray using an iterator
		// and store information into ArrayList
		Iterator i = testList.iterator();
		ArrayList<String> testInfo = new ArrayList<>();
		
		while (i.hasNext()) {
			JsonObject test = (JsonObject) i.next();
			String idAndType = "Test ID: " + (String) test.get("id") + " | " + "Test Type:" + (String) test.get("type");
			testInfo.add(idAndType);
		}
		
		return testInfo;
	}
	
}
