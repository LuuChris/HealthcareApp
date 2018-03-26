import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Register2 extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField insurance;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register2 frame = new Register2();
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
	public Register2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 625);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblFirstName.setBounds(58, 77, 109, 109);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblLastName.setBounds(58, 139, 132, 109);
		contentPane.add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setLabelFor(lblDateOfBirth);
		lblDateOfBirth.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(58, 270, 132, 109);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblGender.setBounds(58, 333, 87, 109);
		contentPane.add(lblGender);
		
		JLabel lblEthnicity = new JLabel("Ethnicity:");
		lblEthnicity.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblEthnicity.setBounds(58, 396, 87, 109);
		contentPane.add(lblEthnicity);
		
		JLabel lblInsurance = new JLabel("Insurance:");
		lblInsurance.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblInsurance.setBounds(58, 204, 109, 109);
		contentPane.add(lblInsurance);
		
		firstname = new JTextField();
		firstname.setBounds(242, 123, 164, 22);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(242, 185, 164, 22);
		contentPane.add(lastname);
		
		insurance = new JTextField();
		insurance.setColumns(10);
		insurance.setBounds(242, 250, 164, 22);
		contentPane.add(insurance);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnContinue.setBounds(188, 540, 97, 25);
		contentPane.add(btnContinue);
		
		textField = new JTextField();
		textField.setBounds(242, 316, 164, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "M", "F"}));
		comboBox.setBounds(242, 379, 37, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "White ", "Black or African American", "American Indian and Alaska Native", "Asian", "Native Hawaiian and Other Pacific Highlander", "Other"}));
		comboBox_1.setBounds(242, 442, 164, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblmmddyyyy = new JLabel("(MM/DD/YYYY)");
		lblmmddyyyy.setBounds(73, 316, 200, 50);
		contentPane.add(lblmmddyyyy);
	}
}
