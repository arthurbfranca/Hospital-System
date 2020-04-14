package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//libraries necessary to work with out JSON:
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//Author: Arthur
//This class is shared by all users. It is used to set their own availability.
//The availability is set by date, where the user has the ability to set it in chunks. That is, he might say my availability is 10-14 on 04/01, as well as
//the upcoming 5 days. When the operation is carried out, 04/01 - 04/06 will have their availability set as 10-14.
//This availability is stored in appointments2.json
public class SetAvailability extends JFrame {
	
	//variable used to determine what is the index of the user's account in their json object within accounts2.json.
	//this is declared here, so that it can be "returned" in a method that already returns the account's object (findAccount())
	private int index = -1;

	private JPanel contentPane;
	private JTextField dateField;
	private JTextField startField;
	private JTextField finishField;
	private JCheckBox consecutiveCheckbox;
	private JTextField dayCount;
	
	 /* Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetAvailability frame = new SetAvailability();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	
	//Helper method for findAccount(), it returns the type of an account given an integer that corresponds to the index of the accountType in the array
	//within accounts2.json. This method was written for the sake of readability
	private String findType(int i) {
		if(i == 0) {
			return "patient";
		}
		else if(i == 1) {
			return "doctor";
		}
		else if(i == 2) {
			return "nurse";
		}
		else if(i == 3) {
			return "assistant";
		}
		else if(i == 4) {
			return "administrator";
		}
		else {
			//notify the tester a bad request was made
			System.out.println("invalid index, could there's no such index in accounts2.json. Index was: " + i);
			return null;
		}
	}
	
	//takes in the index that corresponds to the account type's position in accounts2.json and returns the array with the list of all accounts of
		//said type.
	/*
		private JsonArray findArrayOfAccounts(int accountType) {
			try {
				//reader to read accounts2.json
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/accounts2.json")));
				//parser to parse the reader
				JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
			   //we look for the JsonArray within accounts2.json, for that is where the JsonObject of our account is
				JsonArray accounts = (JsonArray) parser.get("accounts");
				JsonObject accountsObj = (JsonObject) accounts.get(accountType);	//this is the object that has the list of all accounts of the given type
				String type = findType(accountType);
				JsonArray accountsArr = (JsonArray) accountsObj.get(type);
				reader.close();
				return accountsArr;
			}catch(Exception e) {
				System.out.println("Something went wrong in findArrayOfAccounts()");
				return null;
			}
		} */
	
	//This method sorts through a given array of jsonobjects corresponding to accounts and finds the one with the given email, if it cannot
	//it returns a null and notifies the tester in the console
	public JsonObject findAccount(JsonArray accountsArr, String email) {
			Iterator i;
			//Now we find the JsonObject for the doctor in particular we are dealing with, whom is identified by the passed email
			i = accountsArr.iterator(); 
			int flag = 0; //flag used to stop the iteration when we've found the correct object
			JsonObject goal = null;
			//go through all doctors to find the one we're dealing with. A constant time search could be implemented, but that would conflict with the 
			//json format we are going with, which simplifies the syntax. This is a tradeoff in terms of writing code more easily, but we have lesser efficiency
			//had we more time to troubleshoot, we'd opt for the optimal setup.
			while(i.hasNext() && flag == 0) {
				index += 1;
				goal = (JsonObject) i.next();
				String currentEmail = (String) goal.get("email");
				if(currentEmail.equals(email)) {
					flag = 1;
				}
			}
			if(goal!=null) {
				return goal;
			}
			System.out.println("Account returned is null, findAccount() could not find it"); //notify the tester
			return null;
	}
	

	//takes in a number, and returns the month that it is equivalent to it. Helper method for getDays() and dayExists()
	private String getMonthString(int i) {
		if(i == 1) {
			return "january";
		}
		else if(i == 2) {
			return "february";
		}
		else if(i == 3) {
			return "march";
		}
		else if(i == 4) {
			return "april";
		}
		else if(i == 5) {
			return "may";
		}
		else if(i == 6) {
			return "june";
		}
		else if(i == 7) {
			return "july";
		}
		else if(i == 8) {
			return "august";
		}
		else if(i == 9) {
			return "september";
		}
		else if(i == 10) {
			return "october";
		}
		else if(i == 11) {
			return "november";
		}
		else if(i == 12) {
			return "december";
		}
		else{
			System.out.println(i + " is not a month");
			return null;
		}
	}
	
	//This method is used by getDays() 
	//To check whether a month has passed in the range from starting to starting + q, it will refer to dates.json to see the number
	//of days the month has.
	private Boolean dayExists(int day, int month) {
		try {
			//reader to read dates.json
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/dates.json")));
			//parser to parse the reader
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
			//get the object with latest day of each month for the current year
			JsonObject year = (JsonObject) parser.get("2020");
			String ms = getMonthString(month);
			String monthSizeString = (String) year.get(ms);
			int max = Integer.parseInt(monthSizeString);
			if(day >  max) {
				return false;
			}
			return true;
		}
		catch(Exception e) {
			System.out.println("Something went wrong, presumably dates.json couldn't be opened");
			return null;
		}
	}
	
	
	//this method takes in the information regarding a specific day of the year, and returns a string array containing the date of this day, as well as the
	//next q days after that.
	//d: the day of the starting day
	//m: the month of the starting day, in numbers.
	private String[] getDays(int m, int d, int q) {
		String[] arr = new String[q+1];
		int day = d;
		int month = m;
		for(int i = 0; i <= q; i++) {
			//i should be 0 if no extra days are to be set, keep this in mind when looking at range.
			//for the entire range of days, not including the first, which has already been added to the array, add their numerical date to the string array
			//to be returned in the model mm/dd
			if(!dayExists(day, month)) {
				//we have crossed the latest day of the given month
				//move to the first day of the next month
				month += 1;
				day = 1;
			}
			String s = "";
			if(month < 10) {
				//if month has a single digit, add a 0 prefix
				s += "0";
			}
			s += month + "/";
			if(day < 10) {
				//if day has a single digit, add a 0 prefix
				s += "0";
			}
			s += day;
			System.out.println("finally s is: " + s);
			arr[i] = s;
			day += 1;
		}
		return arr;
	}
	
	
	//This method was written for the sake of readability, it is called in the event handler of confirmButton, and it performs the functionality of this
	//class, that is, set an availability.
	//days: string with the numeric representation of dates whose schedule will be set
	//time: string that represents the time of schedule. model: 10:20/14:30 or 10/12 (either is valid, only use colon if necessary)
	private void set(String email, int accountType, String[] days, String time) {
		try {
			//reader to read accounts2.json
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/hospitalmanagement/accounts2.json")));
			//parser to parse the reader
			JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
		   //we look for the JsonArray within accounts2.json, for that is where the JsonObject of our account is
			JsonArray accounts = (JsonArray) parser.get("accounts");
			JsonObject accountsObj = (JsonObject) accounts.get(accountType);	//this is the object that has the list of all accounts of the given type
			String type = findType(accountType);
			JsonArray accountsArr = (JsonArray) accountsObj.get(type);
			reader.close();
			
			JsonObject account = findAccount(accountsArr,email);
			JsonObject schedule = (JsonObject) account.get("schedule");

			for(int i = 0; i < days.length; i++) {
				schedule.put(days[i],time);
			}

			account.put("schedule",schedule);		//update account's schedule
			accountsArr.set(index,account);			//add the updated account into array of accounts of its type
			//put this updated patient array as the patient object
			accountsObj.put(type, accountsArr);
			//put this updated patient object at index 0 of the accounts array
			accounts.set(accountType, accountsObj);
			//put the updated accounts array as the account entry in the JSON
			parser.put("accounts", accounts);
			
			// Create a writer
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/hospitalmanagement/accounts2.json"));
			// Write updates to JSON file
			Jsoner.serialize(parser, writer);
			// Close the writer
			writer.close();
			System.out.println("Account's schedule is now: " + schedule);
		}catch(Exception e) {
			System.out.println("Something went wrong in set()");
		}		
	}
	
	
	
	//email: the login that identifies the user
	//accountType: identifies which kind of account has accessed this panel. Corresponds to the position of the account type in accounts2.json
	//This constructor creates the panel
	public SetAvailability(String email, int accountType) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{215, 107, 35, 177, 0, 0};
		gbl_contentPane.rowHeights = new int[]{65, 22, 65, 20, 20, 20, 23, 20, 23, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel mainLabel = new JLabel("Set Availability");
		mainLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_mainLabel = new GridBagConstraints();
		gbc_mainLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mainLabel.gridx = 3;
		gbc_mainLabel.gridy = 1;
		contentPane.add(mainLabel, gbc_mainLabel);
		
		JLabel dateLabel = new JLabel("Date (MM/DD):");
		GridBagConstraints gbc_dateLabel = new GridBagConstraints();
		gbc_dateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateLabel.gridx = 1;
		gbc_dateLabel.gridy = 3;
		contentPane.add(dateLabel, gbc_dateLabel);
		
		dateField = new JTextField();
		GridBagConstraints gbc_dateField = new GridBagConstraints();
		gbc_dateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateField.insets = new Insets(0, 0, 5, 5);
		gbc_dateField.gridx = 3;
		gbc_dateField.gridy = 3;
		contentPane.add(dateField, gbc_dateField);
		dateField.setColumns(10);
		
		JLabel startLabel = new JLabel("Starting Hour:");
		GridBagConstraints gbc_startLabel = new GridBagConstraints();
		gbc_startLabel.insets = new Insets(0, 0, 5, 5);
		gbc_startLabel.gridx = 1;
		gbc_startLabel.gridy = 4;
		contentPane.add(startLabel, gbc_startLabel);
		
		startField = new JTextField();
		startField.setColumns(10);
		GridBagConstraints gbc_startField = new GridBagConstraints();
		gbc_startField.fill = GridBagConstraints.HORIZONTAL;
		gbc_startField.insets = new Insets(0, 0, 5, 5);
		gbc_startField.gridx = 3;
		gbc_startField.gridy = 4;
		contentPane.add(startField, gbc_startField);
		
		JLabel finishLabel = new JLabel("Finishing Hour:");
		GridBagConstraints gbc_finishLabel = new GridBagConstraints();
		gbc_finishLabel.insets = new Insets(0, 0, 5, 5);
		gbc_finishLabel.gridx = 1;
		gbc_finishLabel.gridy = 5;
		contentPane.add(finishLabel, gbc_finishLabel);
		
		finishField = new JTextField();
		finishField.setColumns(10);
		GridBagConstraints gbc_finishField = new GridBagConstraints();
		gbc_finishField.fill = GridBagConstraints.HORIZONTAL;
		gbc_finishField.insets = new Insets(0, 0, 5, 5);
		gbc_finishField.gridx = 3;
		gbc_finishField.gridy = 5;
		contentPane.add(finishField, gbc_finishField);
	
		
		JLabel moreDaysLabel = new JLabel("How many more days:");
		GridBagConstraints gbc_moreDaysLabel = new GridBagConstraints();
		gbc_moreDaysLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moreDaysLabel.gridx = 1;
		gbc_moreDaysLabel.gridy = 7;
		contentPane.add(moreDaysLabel, gbc_moreDaysLabel);
		moreDaysLabel.setVisible(false);
		
		dayCount = new JTextField();
		dayCount.setColumns(10);
		GridBagConstraints gbc_dayCount = new GridBagConstraints();
		gbc_dayCount.fill = GridBagConstraints.HORIZONTAL;
		gbc_dayCount.insets = new Insets(0, 0, 5, 5);
		gbc_dayCount.gridx = 3;
		gbc_dayCount.gridy = 7;
		contentPane.add(dayCount, gbc_dayCount);
		dayCount.setVisible(false);
		
		consecutiveCheckbox = new JCheckBox("Set schedule for following days");
		consecutiveCheckbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(consecutiveCheckbox.isSelected()) {
					moreDaysLabel.setVisible(true);
					dayCount.setVisible(true);
				}
				else {
					moreDaysLabel.setVisible(false);
					dayCount.setVisible(false);
				}
			}
		});
		GridBagConstraints gbc_consecutiveCheckbox = new GridBagConstraints();
		gbc_consecutiveCheckbox.insets = new Insets(0, 0, 5, 5);
		gbc_consecutiveCheckbox.gridx = 3;
		gbc_consecutiveCheckbox.gridy = 6;
		contentPane.add(consecutiveCheckbox, gbc_consecutiveCheckbox);
						
								
		//Pardon the strange identation here, that was a windowsBuilder prank
							JButton confirmButton = new JButton("Confirm");
								confirmButton.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										String date = dateField.getText();
										String start = startField.getText();
										String finish = finishField.getText();
										if(date.length() > 0 && start.length() > 0 && finish.length() > 0) {
											//if all information was inputted, although not necessarily correctly
											if(!consecutiveCheckbox.isSelected()) {
												//if only a single day is to be set, set the availability to the given
												String[] day = new String[] {date};
												set(email, accountType, day, start + "/" + finish);
												dispose();
											}else {
											//if more than one days is to be set get the days to be set and add to the json
												String[] halves = date.split("/");
												int month = Integer.parseInt(halves[0]);
												int day = Integer.parseInt(halves[1]);	
												int q = Integer.parseInt(dayCount.getText());
												String[] days = getDays(month, day, q);
												set(email, accountType, days, start + "/" + finish);
												dispose();
											}
										} else {
											System.out.println("missing strings");
										}
									}
								});
								GridBagConstraints gbc_confirmButton = new GridBagConstraints();
								gbc_confirmButton.insets = new Insets(0, 0, 5, 5);
								gbc_confirmButton.gridx = 3;
								gbc_confirmButton.gridy = 8;
								contentPane.add(confirmButton, gbc_confirmButton);
						
						JButton cancelButton = new JButton("Cancel");
						cancelButton.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								dispose();
							}
						});
						GridBagConstraints gbc_cancelButton = new GridBagConstraints();
						gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
						gbc_cancelButton.gridx = 3;
						gbc_cancelButton.gridy = 9;
						contentPane.add(cancelButton, gbc_cancelButton);
	}

}

