package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class that displays the panel for the admin to view statistics 
 * Includes statistics about how many patients the hospital has had in prior years
 * Assume the hospital has been in business since the year 2018 so it stores stats from 2018-present(2020)
 * @author shavonnetran
 */
public class AdminViewStats extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame for viewing statistics
	 * @param email The email of the admin. Used to uniquely identify the user so we can easily access their info.
	 */
	public AdminViewStats(String email) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select a Year to View Stats");
		lblNewLabel.setBounds(145, 15, 356, 33);
		contentPane.add(lblNewLabel);
				
		//Create a dropdown for admins to select the year they want to view statistics from
		JComboBox<String> yearComboBox = new JComboBox<String>();
		
		//Add the years to combo box 
		yearComboBox.addItem("2018");
		yearComboBox.addItem("2019");
		yearComboBox.addItem("2020");
		
		yearComboBox.setBounds(229, 76, 181, 44);
		contentPane.add(yearComboBox);
		
		//Add button to go to next page
		JButton nextBtn = new JButton("Next");
		//Add event handler for next button
		nextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Switch to next page to see how many patients visited in the selected year
				AdminViewPatientStat nextPage = new AdminViewPatientStat(email);
				nextPage.setVisible(true);
				dispose();
			}
		});
		nextBtn.setBounds(229, 235, 171, 41);
		contentPane.add(nextBtn);
	}
}
