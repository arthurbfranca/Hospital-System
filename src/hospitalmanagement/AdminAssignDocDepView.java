package hospitalmanagement;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminAssignDocDepView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAssignDocDepView frame = new AdminAssignDocDepView();
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
	public AdminAssignDocDepView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MainLabel = new JLabel("Assign a Doctor to a Department");
		MainLabel.setBounds(189, 73, 203, 14);
		contentPane.add(MainLabel);
		
		JLabel DepartmentLabel = new JLabel("Department:");
		DepartmentLabel.setBounds(173, 203, 75, 14);
		contentPane.add(DepartmentLabel);
		
		JComboBox<String> departmentDropdown = new JComboBox<String>();
		departmentDropdown.addItem("Cardiology");
		departmentDropdown.addItem("Nephrology");
		departmentDropdown.addItem("Neurology");
		departmentDropdown.setBounds(292, 199, 141, 22);
		contentPane.add(departmentDropdown);
		
		JLabel DoctorNameLabel = new JLabel("Doctor:");
		DoctorNameLabel.setBounds(173, 138, 75, 14);
		contentPane.add(DoctorNameLabel);
		
		/************ TO DO: go into account JSON and display all doctors as options here ***************/
		// I have just put placeholder doctor names for now
		JComboBox<String> docDropdown = new JComboBox<String>();
		docDropdown.addItem("Dr. Bajwa");
		docDropdown.addItem("Dr. Doctor");
		docDropdown.addItem("Dr. Hartman");
		docDropdown.setBounds(292, 134, 141, 22);
		contentPane.add(docDropdown);
		
		/************ TO DO: when the admin goes through with the assignment,
		 * navigate to the chosen doctor's info in the accounts JSON
		 * write the selected department as the doctor's department
		 ****************/
		JButton BookButton = new JButton("Assign");
		BookButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String selectedDoc = docDropdown.getSelectedItem().toString();
				String selectedDep = departmentDropdown.getSelectedItem().toString();
				Login lframe = new Login();
				JOptionPane.showMessageDialog(lframe, "Your assignment has been successfully processed!");
			}
		});
		BookButton.setBounds(230, 273, 89, 23);
		contentPane.add(BookButton);
		
	}
	
}
