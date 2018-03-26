package mednet.Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;

public class frontDoctorList extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public frontDoctorList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDoctorList = new JLabel("Doctor List");
		lblDoctorList.setFont(new Font("Arial", Font.BOLD, 18));
		lblDoctorList.setBounds(307, 11, 131, 26);
		panel.add(lblDoctorList);
		
		JButton button = new JButton("Log out");
		button.setBounds(544, 15, 89, 23);
		panel.add(button);
		
		JLabel lblTheseAreThe = new JLabel("These are the doctors who chosed your ticket:");
		lblTheseAreThe.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTheseAreThe.setBounds(10, 35, 349, 56);
		panel.add(lblTheseAreThe);
		
		JList list = new JList();
		list.setBounds(10, 81, 495, 387);
		panel.add(list);
		
		JButton btnDoctorsInfromation = new JButton("Information");
		btnDoctorsInfromation.setFont(new Font("Arial", Font.PLAIN, 18));
		btnDoctorsInfromation.setBounds(546, 81, 160, 65);
		panel.add(btnDoctorsInfromation);
		
		JButton button_4 = new JButton("Go Back");
		button_4.setFont(new Font("Arial", Font.PLAIN, 18));
		button_4.setBounds(546, 375, 160, 65);
		panel.add(button_4);
	}

}
