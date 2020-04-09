package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NurseAddTestInfoPerspective extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the frame for the nurses to add test info for individual patients
	 * @author erinpaslawski
	 * @param email THe email of the nurse
	 * @param selectedPatient the patient for the test
	 */
	public NurseAddTestInfoPerspective(String email, String selectedPatient){
		// set properties of the frame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 444);
		// create a new panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// add the main title label to the panel
		JLabel MainLabel = new JLabel("Add Test Results for: "); // TODO: GET NAME
		MainLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		MainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MainLabel.setBounds(189, 73, 203, 22);
		contentPane.add(MainLabel);
		
		// Add a text field for typing the test info
		textField_1 = new JTextField();
		textField_1.setBounds(43, 169, 510, 165);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		// Add a combo box for the test type.
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"X-Ray", "Blood Test", "MRI", "Ultrasound", "CAT Scan", "Other"}));
		comboBox.setBounds(276, 117, 165, 27);
		contentPane.add(comboBox);
		
		// Label for combo box
		JLabel lblNewLabel = new JLabel("Test Type:");
		lblNewLabel.setBounds(159, 121, 99, 16);
		contentPane.add(lblNewLabel);
		
		
		// Submit button, which is an action handler that will write to the JSON with the written info
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String textToSubmit = textField_1.getSelectedText();
				String typeOfTest = comboBox.getName();
				boolean successful = WriteToJSON.writeTestInfo("Nurse", email, selectedPatient, typeOfTest, textToSubmit);
				if (successful == true) {
					Login lframe = new Login();
					JOptionPane.showMessageDialog(lframe, "Successful.");
				}
				else {
					Login lframe = new Login();
					JOptionPane.showMessageDialog(lframe, "Not successful.");
				}
				//Return back to the main page
				NursePerspective previousPane = new NursePerspective(email);
				previousPane.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(227, 346, 136, 29);
		contentPane.add(btnNewButton);
		
		
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
		btnReturn.setBounds(227, 383, 136, 14);
		contentPane.add(btnReturn);

	}
}
