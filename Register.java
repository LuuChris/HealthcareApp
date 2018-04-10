
import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField securityanswerField;
	private JTextField reenterField;
	private JTextField emailField;
	private JTextField firstnameField;
	private JTextField lastnameField;
	private JTextField contactField;

	public Register() {
		setTitle("Register User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel questionLabel = new JLabel("Register for a doctor or patient?");
		questionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		questionLabel.setBounds(63, 543, 288, 27);
		panel.add(questionLabel);
		
		JRadioButton doctorRadioButton = new JRadioButton("Doctor");
		doctorRadioButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		doctorRadioButton.setBounds(73, 582, 141, 23);
		panel.add(doctorRadioButton);
		
		JRadioButton patientRadioButton = new JRadioButton("Patient");
		patientRadioButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		patientRadioButton.setBounds(210, 582, 141, 23);
		panel.add(patientRadioButton);
		
		ButtonGroup group = new ButtonGroup();
		group.add(doctorRadioButton);
		group.add(patientRadioButton);
		
		JButton gobackButton = new JButton("Go Back");
		gobackButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		gobackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontLogin f = new frontLogin();
				f.setVisible(true);
				f.setResizable(false);
				setVisible(false);
			}
		});
		gobackButton.setBounds(15, 16, 76, 38);
		panel.add(gobackButton);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		usernameLabel.setBounds(63, 80, 109, 21);
		panel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		passwordLabel.setBounds(63, 131, 109, 21);
		panel.add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		usernameField.setBounds(307, 74, 232, 32);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(307, 127, 232, 32);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel label = new JLabel("Alpha Medical Registration");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(133, 6, 315, 60);
		panel.add(label);
		
		JLabel securityquestionLabel = new JLabel("Security Question:");
		securityquestionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		securityquestionLabel.setBounds(63, 442, 170, 23);
		panel.add(securityquestionLabel);
		
		JLabel securityanswerLabel = new JLabel("Security Answer:");
		securityanswerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		securityanswerLabel.setBounds(63, 494, 156, 23);
		panel.add(securityanswerLabel);
		
		JComboBox securityquestionComboBox = new JComboBox();
		securityquestionComboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		securityquestionComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "What is your favorite food?", "What is your mother's maiden name?", "What was your highschool mascot?"}));
		securityquestionComboBox.setBounds(307, 438, 232, 32);
		panel.add(securityquestionComboBox);
		
		securityanswerField = new JTextField();
		securityanswerField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		securityanswerField.setBounds(307, 489, 232, 32);
		panel.add(securityanswerField);
		securityanswerField.setColumns(10);
		
		JLabel reenterLabel = new JLabel("Re-Enter Password:");
		reenterLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		reenterLabel.setBounds(63, 185, 181, 21);
		panel.add(reenterLabel);
		
		reenterField = new JTextField();
		reenterField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		reenterField.setBounds(307, 179, 232, 32);
		panel.add(reenterField);
		reenterField.setColumns(10);
		
		JButton continueButton = new JButton("Continue");
		continueButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usr = usernameField.getText();
				String pwd = passwordField.getText();
				String rpwd = reenterField.getText();
				String fname = firstnameField.getText();
				String lname = lastnameField.getText();
				String email = emailField.getText();
				String contact = contactField.getText();
				int securityint = securityquestionComboBox.getSelectedIndex();
				String securityanswer = securityanswerField.getText();
				
		

				if (usr.length()==0||pwd.length()==0||rpwd.length()==0||securityanswer.length()==0||email.length()==0||fname.length()==0||lname.length()==0) {
					JOptionPane.showMessageDialog(null, "All fields must be filled in!");
				} else if(usr.contains(" ")) {
					JOptionPane.showMessageDialog(null, "Username must have no blank spaces.");
				} else if(pwd.equals(rpwd) == false) {
					JOptionPane.showMessageDialog(null, "Passwords do not match!");
				} else if (pwd.length()<5) {
					JOptionPane.showMessageDialog(null, "Password is short.");
				} else if(! (contact.matches("[0-9]{10}")) ) {
					JOptionPane.showMessageDialog(null, "Contact# needs to be 10 digits(without any symbols).");
				} else if( (!email.toLowerCase().matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$") ) || email.contains(" ") ) {
					JOptionPane.showMessageDialog(null, "Invalid email.");
				} else if(securityint==0) {
					JOptionPane.showMessageDialog(null, "Choose a security question.");
				} else if(patientRadioButton.isSelected()==false && doctorRadioButton.isSelected() ==false) {	
					JOptionPane.showMessageDialog(null, "Register as a patient or doctor.");
				}else {
					if(patientRadioButton.isSelected() ) {
						Register2 f = new Register2(usr, pwd, fname, lname, contact, email, securityint, securityanswer, "0");
						f.setVisible(true);
						f.setResizable(false);
						setVisible(false);
					}
					if(doctorRadioButton.isSelected() ) {
						Register21 f = new Register21(usr, pwd, fname, lname, contact, email, securityint, securityanswer, "1");
						f.setVisible(true);
						f.setResizable(false);
						setVisible(false);
					}
				}
				
			}
		});
		continueButton.setBounds(386, 622, 141, 46);
		panel.add(continueButton);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		emailLabel.setBounds(63, 390, 83, 27);
		panel.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		emailField.setBounds(307, 387, 232, 32);
		panel.add(emailField);
		emailField.setColumns(10);
		
		JLabel firstnameLabel = new JLabel("First Name:");
		firstnameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		firstnameLabel.setBounds(63, 236, 181, 21);
		panel.add(firstnameLabel);
		
		JLabel lastnameLabel = new JLabel("Last Name:");
		lastnameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lastnameLabel.setBounds(63, 285, 125, 23);
		panel.add(lastnameLabel);
		
		firstnameField = new JTextField();
		firstnameField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		firstnameField.setBounds(307, 227, 232, 32);
		panel.add(firstnameField);
		firstnameField.setColumns(10);
		
		lastnameField = new JTextField();
		lastnameField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lastnameField.setBounds(307, 280, 232, 32);
		panel.add(lastnameField);
		lastnameField.setColumns(10);
		
		JLabel contactLabel = new JLabel("Contact#:");
		contactLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contactLabel.setBounds(63, 336, 98, 23);
		panel.add(contactLabel);
		
		contactField = new JTextField();
		contactField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contactField.setBounds(307, 331, 232, 32);
		panel.add(contactField);
		contactField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("(10 digits, no symbols)");
		lblNewLabel.setBounds(85, 357, 148, 16);
		panel.add(lblNewLabel);
	}
}
