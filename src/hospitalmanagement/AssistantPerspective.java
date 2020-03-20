package hospitalmanagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*
* Class that displays the panel for the assistant after logging in
*/
public class AssistantPerspective extends JFrame {
	
	private JPanel contentPane;
	
	/*
	 * Create the frame.
	 */
	public AssistantPerspective() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menuLabel = new JLabel("Welcome, Assistant!");
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
		btnReturn.setBounds(239, 306, 119, 14);
		contentPane.add(btnReturn);
		
		JButton btnNewButton = new JButton("Approve Appointments");
		btnNewButton.setBounds(207, 82, 171, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Approve Referrals");
		btnNewButton_1.setBounds(207, 151, 171, 41);
		contentPane.add(btnNewButton_1);
	}
}
