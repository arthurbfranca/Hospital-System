package hospitalmanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
* Class that displays panel for the personal information of the patient
*/
public class PatientInfoView extends JFrame {

	private JPanel infoView;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1014, 581);
		infoView = new JPanel();
		infoView.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(infoView);
		infoView.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(166, 118, 115, 33);
		infoView.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(166, 172, 115, 33);
		infoView.add(lblLastName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(166, 231, 115, 33);
		infoView.add(lblAge);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(166, 285, 115, 33);
		infoView.add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(166, 339, 115, 33);
		infoView.add(lblGender);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(166, 397, 115, 33);
		infoView.add(lblPassword);
		
		JLabel lblStoredFirstName = new JLabel("Bob");
		lblStoredFirstName.setBounds(401, 118, 115, 33);
		infoView.add(lblStoredFirstName);
		
		JLabel lblStoredLastName = new JLabel("Smith");
		lblStoredLastName.setBounds(401, 172, 115, 33);
		infoView.add(lblStoredLastName);
		
		JLabel lblStoredAge = new JLabel("35");
		lblStoredAge.setBounds(401, 231, 115, 33);
		infoView.add(lblStoredAge);
		
		JLabel lblStoredEmail = new JLabel("bobsmith6@gmail.com");
		lblStoredEmail.setBounds(401, 285, 195, 33);
		infoView.add(lblStoredEmail);
		
		JLabel lblStoredGender = new JLabel("Male");
		lblStoredGender.setBounds(401, 339, 115, 33);
		infoView.add(lblStoredGender);
		
		JLabel lblStoredPass = new JLabel("passw0rd");
		lblStoredPass.setBounds(401, 397, 195, 33);
		infoView.add(lblStoredPass);
		
		JButton btnLastNameEdit = new JButton("Edit");
		btnLastNameEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lframe = new Login();
				String newVal = JOptionPane.showInputDialog(lframe, "Enter new value: ");
				lblStoredLastName.setText(newVal);
				infoView.repaint();
			}
		});
		btnLastNameEdit.setBounds(672, 168, 171, 41);
		infoView.add(btnLastNameEdit);
		
		JButton btnFirstNameEdit = new JButton("Edit");
		btnFirstNameEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login lframe = new Login();
				String newVal = JOptionPane.showInputDialog(lframe, "Enter new value: ");
				lblStoredFirstName.setText(newVal);
				infoView.repaint();
			}
		});
		btnFirstNameEdit.setBounds(672, 114, 171, 41);
		infoView.add(btnFirstNameEdit);
		
		JButton btnAgeEdit = new JButton("Edit");
		btnAgeEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lframe = new Login();
				String newVal = JOptionPane.showInputDialog(lframe, "Enter new value: ");
				lblStoredAge.setText(newVal);
				infoView.repaint();
			}
		});
		btnAgeEdit.setBounds(672, 227, 171, 41);
		infoView.add(btnAgeEdit);
		
		JButton btnEmailEdit = new JButton("Edit");
		btnEmailEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lframe = new Login();
				String newVal = JOptionPane.showInputDialog(lframe, "Enter new value: ");
				lblStoredEmail.setText(newVal);
				infoView.repaint();
			}
		});
		btnEmailEdit.setBounds(672, 281, 171, 41);
		infoView.add(btnEmailEdit);
		
		JButton btnGenderEdit = new JButton("Edit");
		btnGenderEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lframe = new Login();
				String newVal = JOptionPane.showInputDialog(lframe, "Enter new value: ");
				lblStoredGender.setText(newVal);
				infoView.repaint();
			}
		});
		btnGenderEdit.setBounds(672, 335, 171, 41);
		infoView.add(btnGenderEdit);
		
		JButton btnPasswordEdit = new JButton("Edit");
		btnPasswordEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lframe = new Login();
				String newVal = JOptionPane.showInputDialog(lframe, "Enter new value: ");
				lblStoredPass.setText(newVal);
				infoView.repaint();
			}
		});
		btnPasswordEdit.setBounds(672, 389, 171, 41);
		infoView.add(btnPasswordEdit);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lframe = new Login();
				JOptionPane.showMessageDialog(lframe, "Changes saved! Updates will be made to your file.");
				
				/******* TO DO: Update the user's JSON data with this data *********/
				String firstName = lblStoredFirstName.getText();
				String lastName = lblStoredLastName.getText();
				String age = lblStoredAge.getText();
				String email = lblStoredEmail.getText();
				String gender = lblStoredGender.getText();
				String password = lblStoredPass.getText();
			}
		});
		btnSaveChanges.setBounds(414, 464, 131, 25);
		infoView.add(btnSaveChanges);
		
		JLabel lblYourInformation = new JLabel("Your Information");
		lblYourInformation.setBounds(401, 57, 115, 16);
		infoView.add(lblYourInformation);
	}
}
