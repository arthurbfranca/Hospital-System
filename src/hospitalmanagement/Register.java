package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import hospital.Login;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

/**
* Class for registering to a new account
*/
public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField enterID;
	private JTextField enterFirstName;
	private JTextField enterLastName;
	private JTextField enterEmail;
	private JTextField enterUser;
	private JTextField enterPass;
	private JTextField confirmPass;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//
		
		enterID = new JTextField();
		enterID.setBounds(381, 76, 236, 39);
		contentPane.add(enterID);
		enterID.setColumns(10);
		
		JLabel lbl_id = new JLabel("Enter ID #");
		lbl_id.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_id.setBounds(57, 79, 285, 36);
		contentPane.add(lbl_id);
		
		enterFirstName = new JTextField();
		enterFirstName.setBounds(381, 113, 236, 39);
		contentPane.add(enterFirstName);
		enterFirstName.setColumns(10);
		
		JLabel lbl_firstName = new JLabel("Enter First Name");
		lbl_firstName.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_firstName.setBounds(57, 116, 285, 36);
		contentPane.add(lbl_firstName);
		
		enterLastName = new JTextField();
		enterLastName.setBounds(381, 151, 236, 39);
		contentPane.add(enterLastName);
		enterLastName.setColumns(10);
		
		JLabel lbl_lastName = new JLabel("Enter Last Name");
		lbl_lastName.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_lastName.setBounds(57, 154, 285, 36);
		contentPane.add(lbl_lastName);
		
		enterEmail = new JTextField();
		enterEmail.setBounds(381, 189, 236, 39);
		contentPane.add(enterEmail);
		enterEmail.setColumns(10);
		
		JLabel lbl_email = new JLabel("Enter Email");
		lbl_email.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_email.setBounds(57, 192, 285, 36);
		contentPane.add(lbl_email);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Male");
		comboBox.addItem("Female");
		comboBox.addItem("Other");
		comboBox.setBounds(381, 241, 75, 22);
		contentPane.add(comboBox);
		
		//
		enterUser = new JTextField();
		enterUser.setBounds(381, 275, 236, 39);
		contentPane.add(enterUser);
		enterUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(57, 278, 265, 36);
		contentPane.add(lblNewLabel);
		
		enterPass = new JTextField();
		enterPass.setBounds(381, 310, 236, 39);
		contentPane.add(enterPass);
		enterPass.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(57, 321, 265, 28);
		contentPane.add(lblNewLabel_1);
		
		confirmPass = new JTextField();
		confirmPass.setBounds(381, 346, 236, 39);
		contentPane.add(confirmPass);
		confirmPass.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(57, 352, 285, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Register For a New Account Below");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setBounds(245, 22, 733, 41);
		contentPane.add(lblNewLabel_3);
		
		//Event handler for sign up button
				JButton btnNewButton = new JButton("Sign Up");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						/************ TO DO: decide what account info we want from users for registration/JSON storage ***************/
						// and then make sure both our registration page and json files reflect that!!
						
						//get texts from textfields
						try {
							int id = Integer.parseInt(enterID.getText());
						} catch(NumberFormatException n) {
							Login lframe0 = new Login();
							JOptionPane.showMessageDialog(lframe0, enterID.getText() + " is not a valid ID number.");
						}
						
						String firstName = enterUser.getText();
						String lastName = enterUser.getText();
						String email = enterUser.getText();
						String gender = comboBox.getSelectedItem().toString();
						String username = enterUser.getText();
						String password = enterPass.getText();
						String confirm = confirmPass.getText();
						
						if(!password.equals(confirm)) { 	//if passwords not equal, display error message
							Login lframe = new Login();
							JOptionPane.showMessageDialog(lframe, "Passwords do not match");
						}
						else if (username.isEmpty() || password.isEmpty() || confirm.isEmpty()) {	//if any fields are empty, display failed login message
							Login lframe1 = new Login();
							JOptionPane.showMessageDialog(lframe1, "Invalid username and password");
						}
						else if ((password.equals(confirm)) && (username!=null) && (password!=null) && (confirm!=null)) {	//if passwords are equal, go to new account welcome page
							NewAccountWelcome welcome = new NewAccountWelcome(contentPane);
							welcome.setVisible(true);
							dispose();
						}
					}
				});
				//btnNewButton.setBounds(401, 383, 171, 41);
				btnNewButton.setBounds(300, 416, 171, 41);
				contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(483, 416, 171, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setBounds(115, 71, 56, 16);
		contentPane.add(label);
		
		JLabel lbl_email_1 = new JLabel("Enter Gender");
		lbl_email_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl_email_1.setBounds(57, 232, 285, 36);
		contentPane.add(lbl_email_1);
	}
}