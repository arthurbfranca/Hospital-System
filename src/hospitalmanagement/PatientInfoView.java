package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
* Class that displays panel for the personal information of the patient
*/
public class PatientInfoView extends JFrame {

	private JPanel contentPane;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientInfoView frame = new PatientInfoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatientInfoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.setBounds(401, 427, 171, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Patient Name:");
		lblNewLabel.setBounds(59, 28, 115, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone Number:");
		lblNewLabel_1.setBounds(59, 305, 115, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setBounds(59, 366, 115, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address:");
		lblNewLabel_3.setBounds(59, 244, 115, 33);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setBounds(698, 93, 171, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.setBounds(698, 24, 171, 41);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Birthday:");
		lblNewLabel_4.setBounds(59, 172, 115, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender:");
		lblNewLabel_5.setBounds(59, 97, 115, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Bob Smith");
		lblNewLabel_6.setBounds(401, 28, 115, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Male");
		lblNewLabel_7.setBounds(401, 97, 115, 33);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("January 10, 1985");
		lblNewLabel_8.setBounds(401, 172, 115, 33);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_3 = new JButton("Edit");
		btnNewButton_3.setBounds(698, 162, 171, 41);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Edit");
		btnNewButton_4.setBounds(698, 231, 171, 41);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_9 = new JLabel("Maple Street 207 SE");
		lblNewLabel_9.setBounds(401, 244, 115, 33);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("403-010-5000");
		lblNewLabel_10.setBounds(401, 305, 115, 33);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("bobSmith6@gmail.com");
		lblNewLabel_11.setBounds(401, 366, 115, 33);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton_5 = new JButton("Edit");
		btnNewButton_5.setBounds(698, 301, 171, 41);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Edit");
		btnNewButton_6.setBounds(698, 362, 171, 41);
		contentPane.add(btnNewButton_6);
	}
}
