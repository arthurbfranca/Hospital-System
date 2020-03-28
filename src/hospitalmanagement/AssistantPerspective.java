package hospitalmanagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
* Class that displays the options the assistant can choose from upon logging in to their account.
* Includes options like: approving appointments, approving referrals that patients upload.
* @author sydneykwok, shavonnetran
*/
public class AssistantPerspective extends JFrame {
	
	private JPanel contentPane;
	
	/**
	* Create the frame for the panel with the assistant options upon logging in.
	* Assistants will be directed to this frame and can do various tasks by clicking the appropriate buttons.
	* @param email The email of the assistant. Used to uniquely identify the user so we can easily access their info.
	*/
	public AssistantPerspective(String email) {
		
		// set frame properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		setLocationRelativeTo(null);
		
		// create the panel for the frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// display welcome message for assistant
		JLabel menuLabel = new JLabel("Welcome, Assistant!");
		menuLabel.setBounds(239, 62, 119, 14);
		contentPane.add(menuLabel);
		
		//Adding button for returning to login home page
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
		btnReturn.setBounds(239, 295, 119, 14);
		contentPane.add(btnReturn);
		
		//Adding button for approving appointments
		JButton btnNewButton = new JButton("Approve Appointments");
		btnNewButton.setBounds(207, 119, 171, 41);
		contentPane.add(btnNewButton);
		
		//Adding button for approving referrals 
		JButton btnNewButton_1 = new JButton("Approve Referrals");
		btnNewButton_1.setBounds(207, 202, 171, 41);
		contentPane.add(btnNewButton_1);
	}
}
