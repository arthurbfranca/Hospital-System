package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

public class DoctorAddPatient extends JFrame {

	private JPanel contentPane;
	private String selectedName;
	private int ID;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorAddPatient frame = new DoctorAddPatient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public DoctorAddPatient() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/******** TODO: List patient names here that the doctor can add using the accounts JSON.
		 * I suggest having a different string array containing their ID (or some way to
		 * get their information once the doctor selects the patient). This string is only
		 * a list for the patient names that will be shown, so yeah, can't put ID here.
		 * Note: do we need to have departments for the patients as well? Like what departments
		 * they need to be in (like are they getting a kidney surgery, and will be placed in the 
		 * nephrology department, and so doctors in the nephrology department will be the ones
		 * that will be able to add them? And they will be in multiple departments if they have
		 * more than 1 type, like kidney appointment and heart surgery?) ASK THEM
		 */
		String[] names = new String[] {"LastName, FirstName Patient1", "LastName, FirstName Patient2", "LastName, FirstName Patient3", "LastName, FirstName Patient4", "LastName, FirstName Patient5", "LastName, FirstName Patient6", "LastName, FirstName Patient7", "LastName, FirstName Patient8", "LastName, FirstName Patient9", "LastName, FirstName Patient10", "LastName, FirstName Patient11", "LastName, FirstName Patient12"};
		
		/******** TODO: Make string array that lists patient ID using accounts JSON. Below is a
		 * placeholder for now. If you have a different idea, let me (Gerard) know so I can properly
		 * adjust. For now, there will be 2 different Strings: first (the one above) containing the
		 * names; second (the one below) containing the IDs (must be same indices)
		 */
		String[] patientIDs = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		
		List<String> values = new ArrayList<>(names.length);
		for (int i = 0; names.length>i; i++) {
			values.add(names[i]);
		}
		
		JList<Object> patientList = new JList<Object>(values.toArray(new String[values.size()]));
		patientList.setValueIsAdjusting(true);
		patientList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		patientList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		patientList.setBounds(64, 34, 315, 161);
		JScrollPane patientListScroller = new JScrollPane();
		patientListScroller.setLocation(50, 33);
		patientListScroller.setSize(330, 169);
		patientListScroller.setViewportView(patientList);
		patientList.setLayoutOrientation(JList.VERTICAL);
		contentPane.add(patientListScroller);
		
		JLabel lblPleaseSelectPatient = new JLabel("Please Select Patient");
		lblPleaseSelectPatient.setBounds(146, 13, 125, 16);
		contentPane.add(lblPleaseSelectPatient);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedName = names[patientList.getSelectedIndex()];
				ID = Integer.parseInt(patientIDs[patientList.getSelectedIndex()]);
				DoctorAddPatientInformation patientInfoPane = new DoctorAddPatientInformation(selectedName, ID);
				patientInfoPane.setVisible(true);
				dispose();
			}
		});
		btnConfirm.setBounds(104, 215, 97, 25);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("Return");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(236, 215, 97, 25);
		contentPane.add(btnCancel);
		String[] patients = {"LastName, Alice", "LastName, Bob", "LastName, COVID19", "LastName, Dad", "LastName, Eckhardt"};
	}
}
