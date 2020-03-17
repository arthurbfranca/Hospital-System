package hospitalmanagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*
* Class that displays the panel for the patient's perspective after logging in as a patient user
*/
public class PatientPerspective extends JFrame {

	private JPanel contentPane;
	
	/*
	* Create the frame.
	*/
	public PatientPerspective() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 436);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menuLabel = new JLabel("Welcome, Patient!");
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
		btnReturn.setBounds(217, 279, 139, 41);
		contentPane.add(btnReturn);
		
		JButton btnNewButton = new JButton(" View appointments");
		btnNewButton.setBounds(68, 113, 199, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Book an appointment");
		btnNewButton_1.setBounds(320, 55, 199, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View test results");
		btnNewButton_2.setBounds(320, 111, 199, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View records");
		btnNewButton_3.setBounds(68, 58, 199, 41);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View personal info");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PatientInfoView personalInfo = new PatientInfoView();
				personalInfo.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(68, 166, 199, 41);
		contentPane.add(btnNewButton_4);
	}
}
