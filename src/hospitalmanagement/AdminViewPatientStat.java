package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

/**
 * Class that displays the next panel for the admin to view the number of patients who have visited 
 * Assume the hospital has been in business since the year 2018 so it stores stats from 2018-present(2020)
 * @author shavonnetran
 */
public class AdminViewPatientStat extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame for viewing the number of patients who visited the hospital
	 * @param email The email of the admin. Used to uniquely identify the user so we can easily access their info.
	 */
	public AdminViewPatientStat(String email) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Number of Patients That Visited:");
		label1.setBounds(101, 28, 421, 33);
		contentPane.add(label1);
		
		//TODO: Connect to JSONS to find out how many patients visited in the selected year and display the number
	}
}