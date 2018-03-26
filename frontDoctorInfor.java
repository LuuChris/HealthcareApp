package mednet.Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class frontDoctorInfor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frontDoctorInfor frame = new frontDoctorInfor();
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
	public frontDoctorInfor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(21, 64, 693, 336);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDoctorsInformtion = new JLabel("Doctor's Informtion");
		lblDoctorsInformtion.setFont(new Font("Arial", Font.BOLD, 18));
		lblDoctorsInformtion.setBounds(278, 11, 182, 26);
		panel.add(lblDoctorsInformtion);
		
		JButton button = new JButton("Log out");
		button.setBounds(626, 15, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Go Back");
		button_1.setFont(new Font("Arial", Font.PLAIN, 18));
		button_1.setBounds(554, 411, 160, 65);
		panel.add(button_1);
	}

}
