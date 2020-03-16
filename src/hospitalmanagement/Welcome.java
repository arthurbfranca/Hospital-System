package hospitalmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 200, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Welcome back!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(324, 95, 545, 231);
		contentPane.add(lblNewLabel);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorPerspective doctorPane = new DoctorPerspective();
				doctorPane.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(434, 464, 97, 25);
		contentPane.add(btnReturn);
	}

}
