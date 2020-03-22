package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
* Class that displays the welcome page for new users who just registered for an account 
* @author shavonnetran, sydneykwok
*/
public class NewAccountWelcome extends JFrame {

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAccountWelcome frame = new NewAccountWelcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	* Create the frame for the new account welcome page
	* It shows a welcome message and return button
	*/
	public NewAccountWelcome(JPanel contentPane) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Add welcome message
		JLabel lblNewLabel = new JLabel("Welcome to your new account!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(183, 87, 732, 238);
		contentPane.add(lblNewLabel);
		
		//Adding button for returning to login home page
		JButton btnReturn = new JButton("Return");
		//Add event handler for return button
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnReturn.setBounds(407, 434, 97, 25);
		contentPane.add(btnReturn);
		
		JLabel lblPleaseRememberYour = new JLabel("Please remember your username (your email before the @ symbol) and password!");
		lblPleaseRememberYour.setBounds(209, 279, 514, 16);
		contentPane.add(lblPleaseRememberYour);
	}
}
