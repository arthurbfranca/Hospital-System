package hospitalmanagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
* Class that displays the options the nurse can choose from upon logging in to their account
* Includes options like: uploading test results and viewing schedules
* @author sydneykwok, shavonnetran
*/
public class NursePerspective extends JFrame {

	private JPanel contentPane;
	
	/**
	* Create the frame for the panel with the nurse options upon logging in
	* Nurses will be directed to this frame and can do various tasks by clicking the appropriate buttons
	*/
	public NursePerspective() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Display welcome message for nurse 
		JLabel menuLabel = new JLabel("Welcome, Nurse!");
		menuLabel.setBounds(239, 11, 119, 14);
		contentPane.add(menuLabel);
		
		//Adding button to return to login home page
		JButton btnReturn = new JButton("Return");
		//Add event handler for return button
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Return back to the login page after clicking return button
				Login loginPane = new Login();
				loginPane.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(225, 259, 119, 14);
		contentPane.add(btnReturn);
		
		//Adding button for uploading test results
		JButton btnNewButton = new JButton("Upload Test Results");
		btnNewButton.setBounds(206, 151, 171, 41);
		contentPane.add(btnNewButton);
		
		//Adding button for viewing schedule
		JButton btnNewButton_1 = new JButton("View Schedule");
		btnNewButton_1.setBounds(206, 89, 171, 41);
		contentPane.add(btnNewButton_1);
	}
}
