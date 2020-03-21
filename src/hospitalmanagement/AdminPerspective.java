package hospitalmanagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminPerspective extends JFrame {

	private JPanel contentPane;
	
	/*
	 * Create the frame.
	 */
	public AdminPerspective() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menuLabel = new JLabel("Welcome, Admin!");
		menuLabel.setBounds(237, 70, 119, 14);
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
		btnReturn.setBounds(225, 294, 119, 14);
		contentPane.add(btnReturn);
		
		JButton btnNewButton = new JButton("Assign Doctor to Department");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminAssignDocDepView assignDocDep = new AdminAssignDocDepView();
				assignDocDep.setVisible(true);
			}
		});
		btnNewButton.setBounds(178, 199, 219, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Statistics");
		btnNewButton_1.setBounds(178, 125, 219, 41);
		contentPane.add(btnNewButton_1);
	}
}
