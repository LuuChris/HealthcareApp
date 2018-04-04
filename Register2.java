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
import javax.swing.SwingConstants;


public class Register2 extends JFrame {

	private JPanel contentPane;
	private JTextField addressField;
	private JTextField ageField;
	private JTextField allergyField;
	private JTextField conditionField;

	public Register2(String username, String password, String firstname, String lastname, String contact, String email, int securityint, String securityanswer, String type) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 782);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setLabelFor(ageLabel);
		ageLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		ageLabel.setBounds(58, 258, 132, 56);
		contentPane.add(ageLabel);
		
		JLabel ethnicityLabel = new JLabel("Ethnicity:");
		ethnicityLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		ethnicityLabel.setBounds(58, 334, 87, 109);
		contentPane.add(ethnicityLabel);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		addressLabel.setBounds(58, 163, 109, 50);
		contentPane.add(addressLabel);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(242, 180, 210, 22);
		contentPane.add(addressField);
		
		ageField = new JTextField();
		ageField.setBounds(242, 278, 210, 22);
		contentPane.add(ageField);
		ageField.setColumns(10);
		
		JComboBox ethnicityBox = new JComboBox();
		ethnicityBox.setModel(new DefaultComboBoxModel(new String[] {"", "White ", "Black or African American", "American Indian and Alaska Native", "Asian", "Native Hawaiian and Other Pacific Highlander", "Other"}));
		ethnicityBox.setBounds(242, 381, 210, 22);
		contentPane.add(ethnicityBox);
		
		JLabel allergiesLabel = new JLabel("List Allergies:");
		allergiesLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		allergiesLabel.setBounds(58, 470, 132, 31);
		contentPane.add(allergiesLabel);
		
		JLabel conditionLabel = new JLabel("List Medical Conditions:");
		conditionLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		conditionLabel.setBounds(58, 550, 179, 79);
		contentPane.add(conditionLabel);
		
		allergyField = new JTextField();
		allergyField.setBounds(242, 475, 210, 26);
		contentPane.add(allergyField);
		allergyField.setColumns(10);
		
		conditionField = new JTextField();
		conditionField.setBounds(242, 577, 210, 26);
		contentPane.add(conditionField);
		conditionField.setColumns(10);
		
		JLabel registerLabel = new JLabel("Patient Registration");
		registerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setBounds(58, 57, 348, 71);
		contentPane.add(registerLabel);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String address = addressField.getText();
				int age = Integer.parseInt(ageField.getText());
				String ethnicity = (String) ethnicityBox.getSelectedItem();
				String allergy = allergyField.getText();
				String medicalcondition = conditionField.getText();
				if(allergy.equals("")) {
					allergy="none";
				}
				if(medicalcondition.equals("")) {
					medicalcondition="none";
				}
				if(address.length()>5 && age>0 && ethnicity.length()>1) {
					
					patient p = new patient(contact, email, firstname, lastname, password, securityanswer, type, username, securityint, Main.generateUserkey(), allergy, address, ethnicity, medicalcondition, age);
					Main.inputPatient(p);
					frontPatientHome f = new frontPatientHome(p);
					f.setVisible(true);
					setVisible(false);
				}
				
				
			}
		});
		continueButton.setBounds(279, 699, 97, 25);
		contentPane.add(continueButton);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register f = new Register();
				f.setVisible(true);
				setVisible(false);
			}
		});
		btnGoBack.setBounds(103, 697, 117, 29);
		contentPane.add(btnGoBack);
	}
}
