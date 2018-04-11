
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
import javax.swing.JOptionPane;
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
import javax.swing.SwingConstants;

public class Register2 extends JFrame {

	private JPanel contentPane;
	private JTextField addressField;
	private JTextField ageField;
	private JTextField allergyField;
	private JTextField conditionField;

	public Register2(String username, String password, String firstname, String lastname, String contact, String email, int securityint, String securityanswer, String type) {
		setTitle("Register Patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 761);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setLabelFor(ageLabel);
		ageLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		ageLabel.setBounds(58, 213, 132, 56);
		contentPane.add(ageLabel);
		
		JLabel ethnicityLabel = new JLabel("Ethnicity:");
		ethnicityLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		ethnicityLabel.setBounds(58, 305, 132, 79);
		contentPane.add(ethnicityLabel);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		addressLabel.setBounds(58, 128, 109, 50);
		contentPane.add(addressLabel);
		
		addressField = new JTextField();
		addressField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		addressField.setColumns(10);
		addressField.setBounds(206, 133, 268, 41);
		contentPane.add(addressField);
		
		ageField = new JTextField();
		ageField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		ageField.setBounds(206, 221, 268, 41);
		contentPane.add(ageField);
		ageField.setColumns(10);
		
		JComboBox ethnicityBox = new JComboBox();
		ethnicityBox.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		ethnicityBox.setModel(new DefaultComboBoxModel(new String[] {"", "White ", "Black or African American", "American Indian and Alaska Native", "Asian", "Native Hawaiian and Other Pacific Highlander", "Other"}));
		ethnicityBox.setBounds(206, 325, 268, 41);
		contentPane.add(ethnicityBox);
		
		JLabel allergiesLabel = new JLabel("List Allergies:");
		allergiesLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		allergiesLabel.setBounds(58, 428, 142, 31);
		contentPane.add(allergiesLabel);
		
		JLabel conditionLabel = new JLabel("List Medical Conditions:");
		conditionLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		conditionLabel.setBounds(58, 514, 179, 41);
		contentPane.add(conditionLabel);
		
		allergyField = new JTextField();
		allergyField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		allergyField.setBounds(249, 428, 222, 41);
		contentPane.add(allergyField);
		allergyField.setColumns(10);
		
		conditionField = new JTextField();
		conditionField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		conditionField.setBounds(249, 514, 225, 41);
		contentPane.add(conditionField);
		conditionField.setColumns(10);
		
		JLabel registerLabel = new JLabel("Patient Registration");
		registerLabel.setFont(new Font("Helvetica", Font.ITALIC, 30));
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setBounds(103, 26, 348, 71);
		contentPane.add(registerLabel);
		
		JButton continueButton = new JButton("Continue");
		continueButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				String address = addressField.getText();
				String ageS = ageField.getText();
				String ethnicity = (String) ethnicityBox.getSelectedItem();
				int age=0;
				String allergy = allergyField.getText();
				String medicalcondition = conditionField.getText();
				if(!address.matches("\\d{1,5}[A-z]*\\s?[A-z]+\\s?[A-z]*\\s?[A-z]*")) {
					JOptionPane.showMessageDialog(null, "Address is not valid.");
				}else if(ageS.equals("") || !ageS.matches("[1-9]+[0-9]*") || Integer.parseInt(ageS)<1) {
					JOptionPane.showMessageDialog(null, "Age is not valid.");
				}else if(ethnicity.equals("")) {
					JOptionPane.showMessageDialog(null, "Must choose an ethnicity.");
				}else {
					age = Integer.parseInt(ageS);
				}
				
				if(allergy.equals("")) {
					allergy="none";
				}
				if(medicalcondition.equals("")) {
					medicalcondition="none";
				}
				if(address.matches("\\d{1,5}[A-z]*\\s?[A-z]+\\s?[A-z]*\\s?[A-z]*") && age>0 && ethnicity.length()>1) {
					
					patient p = new patient(contact, email, firstname, lastname, password, securityanswer, type, username, securityint, Main.generateUserkey(), allergy, address, ethnicity, medicalcondition, age);
					Main.inputPatient(p);
					frontPatientHome f = new frontPatientHome(p);
					f.setVisible(true);
					f.setResizable(false);
					setVisible(false);
				}
				
				
			}
		});
		continueButton.setBounds(311, 628, 140, 56);
		contentPane.add(continueButton);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register f = new Register();
				f.setVisible(true);
				f.setResizable(false);
				setVisible(false);
			}
		});
		btnGoBack.setBounds(23, 39, 83, 41);
		contentPane.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("(If none, leave blank)");
		lblNewLabel.setBounds(106, 454, 131, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(If none, leave blank)");
		lblNewLabel_1.setBounds(110, 542, 142, 16);
		contentPane.add(lblNewLabel_1);
	}
}
