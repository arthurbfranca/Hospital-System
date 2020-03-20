package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospitalmanagement.Account;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 600, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		/*
		 * contentPane.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent arg0) { dispose(); } });
		 */
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		username = new JTextField();
		username.setBounds(363, 219, 236, 39);
		contentPane.add(username);
		username.setColumns(10);

		password = new JTextField();
		password.setBounds(363, 310, 236, 39);
		contentPane.add(password);
		password.setColumns(10);

		// Create an empty combo box with items of type String
		JComboBox<String> comboBox = new JComboBox<String>();

		// add items to the combo box
		comboBox.addItem("Administrator");
		comboBox.addItem("Assistant");
		comboBox.addItem("Doctor");
		comboBox.addItem("Nurse");
		comboBox.addItem("Patient");

		// comboBox.setBounds(478, 152, 42, 39);
		comboBox.setBounds(400, 150, 155, 39);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = username.getText();
				String pass = password.getText();
				if (uname == null & pass == null) {
					Login lframe = new Login();
					JOptionPane.showMessageDialog(lframe, "Invalid login");
				} else {
					/************ TO DO: check JSON to verify user BEFORE instantiating the new perspective!! ***************/
				    String userType = comboBox.getSelectedItem().toString();
				    if (userType.equals("Administrator")) {
				    	AdminPerspective adminPane = new AdminPerspective();
				    	adminPane.setVisible(true);
				    } else if (userType.equals("Assistant")) {
				    	AssistantPerspective assistantPane = new AssistantPerspective();
				    	assistantPane.setVisible(true);
				    } else if (userType.equals("Doctor")) {
				    	DoctorPerspective docPane = new DoctorPerspective();
				    	docPane.setVisible(true);
				    } else if (userType.equals("Nurse")) {
				    	NursePerspective nursePane = new NursePerspective();
				    	nursePane.setVisible(true);
				    } else if (userType.equals("Patient")) {
				    	PatientPerspective patientPane = new PatientPerspective();
				    	patientPane.setVisible(true);
				    }
					dispose();
				}
			}
		});
		btnNewButton.setBounds(307, 388, 171, 41);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Register registerPage = new Register();
				registerPage.setVisible(true);
				contentPane.revalidate();
			}
		});
		btnNewButton_1.setBounds(516, 388, 171, 41);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(147, 219, 241, 36);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(147, 310, 211, 36);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Hospital Management System");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_2.setBounds(120, 28, 834, 66);
		contentPane.add(lblNewLabel_2);
	}
}
