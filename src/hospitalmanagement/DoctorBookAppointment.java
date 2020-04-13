package hospitalmanagement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

/**
 * We already have one but I have made an alternative option based off of the
 * one I made for patient appointment booking !!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * Class that displays the panel for doctors to book an appointment.
 * !!!!!!!!!Note: scheduling only has one year right now so everything here is
 * based off of the current 2020 doctor scheduling. We can just take out
 * bookings past 2020 but I have implemented booking for 2020-2025 for now.
 * !!!!!!!!1
 * 
 * @author sydneykwok
 */
public class DoctorBookAppointment extends JFrame {

	private JPanel contentPane;
	JComboBox<String> deptComboBox;
	JComboBox<String> patientDropdown;
	JComboBox<String> monthDropdown;
	JComboBox<String> dayComboBox;
	JComboBox<String> timeComboBox;
	String year = "2020";
	String month = "April";
	String day = "1";
	String time = "12";

	/**
	 * Create the frame for when the doctor clicks on the "book appointment" button
	 * Shows drop down menus for doctor to book an appointment by selecting the
	 * department, patient, and timeslot for their appointment.
	 * 
	 * @param email The email of the doctor. Used to uniquely identify the user so
	 *              we can easily access their info.
	 */
	public DoctorBookAppointment(String email) {

		// set frame properties
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 510);

		// create panel for the frame
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// add title label for the panel
		JLabel MainLabel = new JLabel("Book Appointment");
		MainLabel.setBounds(173, 39, 113, 14);
		contentPane.add(MainLabel);

		// add label for department
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(87, 99, 89, 16);
		contentPane.add(lblDepartment);

		// add combobox for the doctor's departments
		deptComboBox = new JComboBox<String>();
		deptComboBox.setBounds(203, 96, 171, 22);
		// add the doctor's departments to the combobox
		addDocDepartments(email);
		contentPane.add(deptComboBox);

		// add label for the patients
		JLabel PatientLabel = new JLabel("Patient:");
		PatientLabel.setBounds(87, 145, 75, 14);
		contentPane.add(PatientLabel);

		// create drop menu for doctor to select one of their patients
		patientDropdown = new JComboBox<String>();
		patientDropdown.setBounds(203, 141, 171, 22);
		// add the doctor's patients to the combobox
		addDocPatients(email);
		contentPane.add(patientDropdown);

		// add label for year
		JLabel yearLabel = new JLabel("Year:");
		yearLabel.setBounds(87, 190, 75, 14);
		contentPane.add(yearLabel);

		// TODO: decide how many years in advance we will allow bookings.
		// for now i have made the executive decision to allow bookings 5 years in
		// advance.
		JComboBox<String> yearDropdown = new JComboBox<String>();
		yearDropdown.setBounds(203, 186, 171, 22);
		yearDropdown.addItem("2020");
		yearDropdown.addItem("2021");
		yearDropdown.addItem("2022");
		yearDropdown.addItem("2023");
		yearDropdown.addItem("2024");
		yearDropdown.addItem("2025");
		contentPane.add(yearDropdown);
		yearDropdown.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					year = (String) event.getItem();
					// set month options depending on the selected year
					setMonthDropdownVals(year);
				}
			}
		});

		// label for month
		JLabel MonthLabel = new JLabel("Month:");
		MonthLabel.setBounds(87, 237, 75, 14);
		contentPane.add(MonthLabel);

		// dropdown menu of months for patient to book in
		monthDropdown = new JComboBox<String>();
		monthDropdown.setBounds(203, 233, 171, 22);
		setMonthDropdownVals(year);
		contentPane.add(monthDropdown);
		monthDropdown.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					month = (String) event.getItem();
					// set date options depending on the selected month
					setDayDropdownVals(year, month.toLowerCase());
				}
			}
		});

		// label for day
		JLabel dayLabel = new JLabel("Day:");
		dayLabel.setBounds(87, 284, 56, 16);
		contentPane.add(dayLabel);

		// dropdown menu of days for the patient to book in
		dayComboBox = new JComboBox<String>();
		dayComboBox.setBounds(203, 281, 171, 22);
		setDayDropdownVals(year, month);
		contentPane.add(dayComboBox);
		dayComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					day = (String) event.getItem();
					// set time options depending on the selected day
					setTimeDropdownVals(email, year, month, day);
				}
			}
		});

		// label for time
		JLabel lblTime = new JLabel("Start Time (1 hr):");
		lblTime.setBounds(87, 333, 104, 16);
		contentPane.add(lblTime);

		// dropdown menu of hours the patient can book in
		timeComboBox = new JComboBox<String>();
		timeComboBox.setBounds(203, 330, 171, 22);
		setTimeDropdownVals(email, year, month, day);
		contentPane.add(timeComboBox);

		/************
		 * TO DO: when the doctor books the appointment, double check all the selections are valid,
		 * then (1) add this appointment to the appointments JSON file
		 * 		(2) add the appointment ID to the patient's appointment array in account json
		 * 		(3) add the appointment ID to the doctor's appointment array in account json
		 * 		(4) add the appointment ID to the department's appointment array in department json
		 * 		(5) some how update the doctor's availability???????????? cries
		 ****************/
		// Adding button for booking an appointment
		JButton BookButton = new JButton("Book");
		BookButton.setBounds(162, 386, 89, 23);
		// Add event handler for book button
		BookButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// Get all the information the patients selected from the drop down menus
				// String selectedDep = departmentDropdown.getSelectedItem().toString();
				String selectedDoc = patientDropdown.getSelectedItem().toString();
				String selectedTime = yearDropdown.getSelectedItem().toString();
				String aptType = monthDropdown.getSelectedItem().toString();
				Login lframe = new Login();
				// Displays a message to confirm that the patient has successfully booked their
				// appointment
				JOptionPane.showMessageDialog(lframe, "Your appointment has been made!");
			}
		});
		contentPane.add(BookButton);
	}

	/**
	 * Reads from the departments json to add all the doctor's departments as
	 * department options on the appointment booking panel.
	 * 
	 * @param email The email of the doctor.
	 */
	private void addDocDepartments(String email) {
		// get the doctor's username
		JsonObject doc = Account.getAccountJSONObj("Doctor", email);
		String username = (String) doc.get("username");

		// go into the departments json and add all departments the doctor is in
		// deptComboBox
		try {
			// create reader
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/hospitalmanagement/departments.json")));
			// create parser
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
			// read departments array from json
			JsonArray departments = (JsonArray) parser.get("departments");

			// iterate through the array of departments and get their array of doctors
			for (int i = 0; i < departments.size(); i++) {

				// get the i-th department object
				JsonObject department = (JsonObject) departments.get(i);
				// get the array of doctors from that object
				JsonArray doctors = (JsonArray) department.get("doctors");
				// iterate through the array of doctors and see if the doctor is included
				for (int j = 0; j < doctors.size(); j++) {
					String uname = doctors.getString(j);
					if (uname.equals(username)) {
						// if they are in the department, add the department to the combobox
						deptComboBox.addItem((String) department.get("type"));
						break;
					}
				}
			}

			// close the reader
			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void addDocPatients(String email) {
		// get the array of the doctor's patients from the account json
		JsonObject doc = Account.getAccountJSONObj("Doctor", email);
		JsonArray patients = (JsonArray) doc.get("patients");
		// add all the patients to the combobox
		for (int i = 0; i < patients.size(); i++) {
			String patientID = patients.getString(i);
			// get the patient's (unique) email and add it to the combobox
			JsonArray patientAccounts = (JsonArray) Account.getAccountJSONObj("Patient");
			for (int j = 0; j < patientAccounts.size(); j++) {
				JsonObject patient = (JsonObject) patientAccounts.get(j);
				String id = (String) patient.get("id");
				if (id.equals(patientID)) {
					// if they are one of the doctor's patients, add the patient to the combobox
					patientDropdown.addItem((String) patient.get("email"));
					// break;
				}
			}
		}
	}

	/**
	 * Updates the values of the month JComboBox. If the year is 2020, only show
	 * from April onwards. Otherwise, show all the months.
	 * 
	 * @param year The currently selected year
	 */
	private void setMonthDropdownVals(String year) {
		// remove all current combo box values
		monthDropdown.removeAllItems();
		// now add new values depending on the year
		if (!(year.equals("2020"))) {
			monthDropdown.addItem("January");
			monthDropdown.addItem("February");
			monthDropdown.addItem("March");
		}
		monthDropdown.addItem("April");
		monthDropdown.addItem("May");
		monthDropdown.addItem("June");
		monthDropdown.addItem("July");
		monthDropdown.addItem("August");
		monthDropdown.addItem("September");
		monthDropdown.addItem("October");
		monthDropdown.addItem("November");
		monthDropdown.addItem("December");
	}

	/**
	 * TODO: Get current date and only show today and days after today. Updates the
	 * values of the day JComboBox. It refers to the dates.json to see the number of
	 * days the month has and adds the days accordingly.
	 * 
	 * @param year  The currently selected month.
	 * @param month The currently selected month.
	 */
	private void setDayDropdownVals(String year, String month) {
		// remove all current combo box values
		dayComboBox.removeAllItems();
		// go into the dates json to add the days in the given month
		try {
			// reader to read dates.json
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/hospitalmanagement/dates.json")));
			// parser to parse the reader
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
			// get the object with latest day of each month for the current year
			JsonObject chosenYear = (JsonObject) parser.get(year);
			// get the String representation of the number of days in that month
			String monthSizeString = (String) chosenYear.get(month.toLowerCase());
			// close the reader
			reader.close();

			// get the integer value of the number of days in the month
			int daysInMonth = Integer.parseInt(monthSizeString);
			// add the days in the month from 1 to daysInMonth
			for (int i = 1; i <= daysInMonth; i++) {
				dayComboBox.addItem("" + i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * TODO: get current time and only show future hours. Goes into the doctor's
	 * schedule and displays all available booking times for that doctor on that
	 * day.
	 * 
	 * @param email The email of this doctor.
	 * @param year  The currently selected year. (MAY NOT NEED since scheduling
	 *              doesn't currently take into account year...)
	 * @param month The currently selected month.
	 * @param day   The currently selected day.
	 */
	private void setTimeDropdownVals(String email, String year, String month, String day) {
		// remove all past vals
		timeComboBox.removeAllItems();

		// get the MM/DD representation of the currently chosen date
		String date = getMMDDString();

		// get the doctor object from the accounts json
		JsonObject doctor = (JsonObject) Account.getAccountJSONObj("Doctor", email);
		// get the doctor's schedule object
		JsonObject schedule = (JsonObject) doctor.get("schedule");
		// get the doctor's schedule for the chosen day
		String availability = (String) schedule.get(date);
		if (availability == null) {
			timeComboBox.addItem("No availability set for this day.");
			timeComboBox.addItem("Set availability for this day or");
			timeComboBox.addItem("Please try another day.");
		} else {
			// availability = StartTime/EndTime
			// split the date so that halves[0] = StartTime and halves[1] = EndTime
			String[] halves = availability.split("/");
			int startTime = Integer.parseInt(halves[0]);
			int endTime = Integer.parseInt(halves[1]);
			// add all hours from ST to ET-1
			// (ET-1 because if shift ends at 9 and appointments are 1hr, appointment start
			// times go up to 8)
			for (int i = startTime; i < endTime; i++) {
				timeComboBox.addItem("" + i);
			}
		}
	}

	/**
	 * Returns the MM/DD format of the currently selected date.
	 * 
	 * @return the MM/DD format of the currently selected date.
	 */
	private String getMMDDString() {
		String MM = "";
		String DD = "";

		// set MM
		if (month == "January") {
			MM = "01";
		} else if (month == "February") {
			MM = "02";
		} else if (month == "March") {
			MM = "03";
		} else if (month == "April") {
			MM = "04";
		} else if (month == "May") {
			MM = "05";
		} else if (month == "June") {
			MM = "06";
		} else if (month == "July") {
			MM = "07";
		} else if (month == "August") {
			MM = "08";
		} else if (month == "September") {
			MM = "09";
		} else if (month == "October") {
			MM = "10";
		} else if (month == "November") {
			MM = "11";
		} else { // if(month == "december") {
			MM = "12";
		}

		// set DD
		DD = day;
		if (DD.length() == 1) {
			DD = "0" + DD;
		}

		// return MM/DD
		return MM + "/" + DD;
	}
}
