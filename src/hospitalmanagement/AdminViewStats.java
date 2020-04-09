package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

/**
 * Class that displays the panel for the admin to view statistics 
 * Includes statistics about: 
 * @author 
 */
public class AdminViewStats extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame for viewing statistics
	 * @param email The email of the admin. Used to uniquely identify the user so we can easily access their info.
	 */
	public AdminViewStats(String email) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
