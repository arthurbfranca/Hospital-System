package hospitalmanagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*
* Class that displays the panel for the nurse when logged in as a nurse user type
*/
public class NursePerspective extends JFrame {

	private JPanel contentPane;
	
	/*
	 * Create the frame.
	 */
	public NursePerspective() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menuLabel = new JLabel("Welcome, Nurse!");
		menuLabel.setBounds(239, 11, 119, 14);
		contentPane.add(menuLabel);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Login loginPane = new Login();
				loginPane.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(225, 259, 119, 14);
		contentPane.add(btnReturn);
		
		JButton btnNewButton = new JButton("Upload Test Results");
		btnNewButton.setBounds(206, 151, 171, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Schedule");
		btnNewButton_1.setBounds(206, 89, 171, 41);
		contentPane.add(btnNewButton_1);
	}
}
