package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import hospital.Login;

import javax.swing.JButton;
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
	private JTextField enterUser;
	private JTextField enterPass;
	private JTextField confirmPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

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
		
		//Event handler for sign up button
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//get texts from textfields
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
					NewAccountWelcome welcome = new NewAccountWelcome();
					welcome.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(401, 383, 171, 41);
		contentPane.add(btnNewButton);
		
		enterUser = new JTextField();
		enterUser.setBounds(371, 90, 236, 39);
		contentPane.add(enterUser);
		enterUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(47, 90, 285, 36);
		contentPane.add(lblNewLabel);
		
		enterPass = new JTextField();
		enterPass.setBounds(371, 183, 236, 39);
		contentPane.add(enterPass);
		enterPass.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(47, 185, 285, 33);
		contentPane.add(lblNewLabel_1);
		
		confirmPass = new JTextField();
		confirmPass.setBounds(371, 278, 236, 39);
		contentPane.add(confirmPass);
		confirmPass.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(47, 280, 285, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Register for a new account below");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setBounds(217, 11, 733, 41);
		contentPane.add(lblNewLabel_3);
		
	}

}
