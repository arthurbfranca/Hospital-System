package hospitalmanagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
* Class that displays the options the adminstrator can choose from upon logging in to their account
* Includes options like: assigning doctors to departments, viewing departments/statistics 
* @author sydneykwok
*/
public class AdminPerspective extends JFrame {

	private JPanel contentPane;
	
	/**
	* Create the frame for the panel with the adminstrator options upon logging in
	* Adminstrators will be directed to this frame and can do various tasks by clicking the appropriate buttons
	*/
	public AdminPerspective() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Display welcome message for adminstrator
		JLabel menuLabel = new JLabel("Welcome, Admin!");
		menuLabel.setBounds(237, 70, 119, 14);
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
		btnReturn.setBounds(225, 294, 119, 14);
		contentPane.add(btnReturn);
		
		//Adding button for assigning doctor to department
		JButton btnNewButton = new JButton("Assign Doctor to Department");
		//Add event handler for assigning doctor to department button
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Switch to panel that displays the frame for assigning doctors to department
				AdminAssignDocDepView assignDocDep = new AdminAssignDocDepView();
				assignDocDep.setVisible(true);
			}
		});
		btnNewButton.setBounds(178, 199, 219, 41);
		contentPane.add(btnNewButton);
		
		//Adding button for viewing statistics 
		JButton btnNewButton_1 = new JButton("View Statistics");
		btnNewButton_1.setBounds(178, 125, 219, 41);
		contentPane.add(btnNewButton_1);
	}
}
