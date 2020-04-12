package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NurseViewSchedulePerspective extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame for the nurse to view their appointments. 
	 */
	public NurseViewSchedulePerspective(String email) {
		// set frame properties
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		setLocationRelativeTo(null);
		
		// create pane for the frame
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// add the main title label to the panel
		JLabel MainLabel = new JLabel("Schedule:");
		MainLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		MainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MainLabel.setBounds(212, 28, 203, 22);
		contentPane.add(MainLabel);
		
		// add 2 panels for the appointments to sit
		JPanel panel = new JPanel();
		panel.setBounds(82, 62, 467, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setBounds(6, 6, 209, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time: ");
		lblNewLabel_1.setBounds(227, 6, 61, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Department:");
		lblNewLabel_2.setBounds(6, 34, 209, 16);
		panel.add(lblNewLabel_2);
	
		// Add next button
		JButton btnNext = new JButton("Next");
		//Add event handler for next button
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNext.setBounds(413, 354, 136, 22);
		contentPane.add(btnNext);
		// Add previous button
		JButton btnPrevious = new JButton("Previous");
		//Add event handler for previous button
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

			}
		});
		btnPrevious.setBounds(92, 354, 136, 22);
		contentPane.add(btnPrevious);
		
		
		//Adding button to return to nurse perspective home page
		JButton btnReturn = new JButton("Return");
		//Add event handler for return button
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Return back to the main page after clicking return button
				NursePerspective previousPane = new NursePerspective(email);
				previousPane.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(253, 354, 136, 22);
		contentPane.add(btnReturn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(82, 158, 467, 73);
		contentPane.add(panel_2);
		
		JLabel label = new JLabel("Date:");
		label.setBounds(6, 6, 209, 16);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Time: ");
		label_1.setBounds(227, 6, 61, 16);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Department:");
		label_2.setBounds(6, 34, 209, 16);
		panel_2.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(82, 253, 467, 73);
		contentPane.add(panel_1);
		
		JLabel label_3 = new JLabel("Date:");
		label_3.setBounds(6, 6, 209, 16);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Time: ");
		label_4.setBounds(227, 6, 61, 16);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Department:");
		label_5.setBounds(6, 34, 209, 16);
		panel_1.add(label_5);
	
	}
}
