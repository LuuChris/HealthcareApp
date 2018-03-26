package mednet.Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class frontEditTicket extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public frontEditTicket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("User Key");
		label.setBounds(88, 63, 46, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(169, 60, 148, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Ticket ID");
		label_1.setBounds(88, 109, 46, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Create Date");
		label_2.setBounds(88, 154, 81, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Availability Time");
		label_3.setBounds(88, 195, 81, 14);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(169, 106, 148, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(169, 151, 148, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(169, 192, 148, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(169, 240, 323, 111);
		panel.add(textField_4);
		
		JLabel label_4 = new JLabel("Description");
		label_4.setBounds(88, 240, 71, 14);
		panel.add(label_4);
		
		JLabel lblEditTicket = new JLabel("Edit Ticket");
		lblEditTicket.setFont(new Font("Arial", Font.BOLD, 18));
		lblEditTicket.setBounds(275, 11, 131, 26);
		panel.add(lblEditTicket);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSubmit.setBounds(53, 362, 160, 65);
		panel.add(btnSubmit);
		
		JButton button_1 = new JButton("Go Back");
		button_1.setFont(new Font("Arial", Font.PLAIN, 18));
		button_1.setBounds(262, 362, 160, 65);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Log out");
		button_2.setBounds(562, 15, 89, 23);
		panel.add(button_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 18));
		btnDelete.setBounds(472, 362, 160, 65);
		panel.add(btnDelete);
	}
}
