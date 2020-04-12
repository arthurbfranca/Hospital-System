package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class NurseSetSchedulePerspective extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public NurseSetSchedulePerspective(String email, String name) {
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
		
		//Display welcome message for nurse 
		JLabel menuLabel = new JLabel("Set Schedule for " + name + "."); 
		menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuLabel.setBounds(185, 11, 238, 14);
		contentPane.add(menuLabel);
	}

}
