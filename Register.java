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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel questionLabel = new JLabel("Register for a doctor or patient?");
		questionLabel.setBounds(103, 494, 232, 16);
		panel.add(questionLabel);
		
		JRadioButton doctorRadioButton = new JRadioButton("Doctor");
		doctorRadioButton.setBounds(103, 536, 141, 23);
		panel.add(doctorRadioButton);
		
		JRadioButton patientRadioButton = new JRadioButton("Patient");
		patientRadioButton.setBounds(267, 536, 141, 23);
		panel.add(patientRadioButton);
		
		ButtonGroup group = new ButtonGroup();
		group.add(doctorRadioButton);
		group.add(patientRadioButton);
		
		JButton gobackButton = new JButton("Go Back");
		gobackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontLogin f = new frontLogin();
				f.setVisible(true);
				setVisible(false);
			}
		});
		gobackButton.setBounds(103, 571, 117, 29);
		panel.add(gobackButton);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(63, 80, 84, 16);
		panel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(63, 131, 84, 16);
		panel.add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(205, 75, 222, 26);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(205, 126, 222, 26);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel label = new JLabel("Alpha Medical Registration");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 19));
		label.setBounds(63, 6, 315, 60);
		panel.add(label);
		
		JLabel securityquestionLabel = new JLabel("Security Question:");
		securityquestionLabel.setBounds(63, 406, 125, 16);
		panel.add(securityquestionLabel);
		
		JLabel securityanswerLabel = new JLabel("Security Answer:");
		securityanswerLabel.setBounds(63, 446, 125, 16);
		panel.add(securityanswerLabel);
		
		JComboBox securityquestionComboBox = new JComboBox();
		securityquestionComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "What is your favorite food?", "What is your mother's maiden name?", "What was your highschool mascot?"}));
		securityquestionComboBox.setBounds(205, 402, 222, 27);
		panel.add(securityquestionComboBox);
		
		securityanswerField = new JTextField();
		securityanswerField.setBounds(205, 441, 222, 26);
		panel.add(securityanswerField);
		securityanswerField.setColumns(10);
		
		JLabel reenterLabel = new JLabel("Re-Enter Password:");
		reenterLabel.setBounds(63, 189, 125, 16);
		panel.add(reenterLabel);
		
		reenterField = new JTextField();
		reenterField.setBounds(205, 184, 222, 26);
		panel.add(reenterField);
		reenterField.setColumns(10);
		
		JButton continueButton = new JButton("Continue");
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
				
				if(patientRadioButton.isSelected() && contact.matches("[0-9]{10}") && usr.length()>0 && pwd.length()>4 && rpwd.length()>4 && !securityanswer.equals("") && securityint!=0 && Main.checkUser(usr,email) && (email.toLowerCase().matches("^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,6}$")) ) {

					Register2 f = new Register2(usr, pwd, fname, lname, contact, email, securityint, securityanswer, "0");
					f.setVisible(true);
					setVisible(false);
				}
				
				if(doctorRadioButton.isSelected() && contact.matches("[0-9]{10}") && usr.length()>0 && pwd.length()>4 && rpwd.length()>4 && !securityanswer.equals("") && securityint!=0 && Main.checkUser(usr,email) && (email.toLowerCase().matches("^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,6}$")) ) {

					Register21 f = new Register21(usr, pwd, fname, lname, contact, email, securityint, securityanswer, "1");
					f.setVisible(true);
					setVisible(false);
					
				}

				if (usr.length()==0||pwd.length()==0||rpwd.length()==0||securityanswer.length()==0||email.length()==0||fname.length()==0||lname.length()==0) {
					JOptionPane.showMessageDialog(null, "All fields must be filled in!");
				} else if(pwd.equals(rpwd) == false) {
					JOptionPane.showMessageDialog(null, "Passwords do not match!");
				} else if (pwd.length()<5) {
					JOptionPane.showMessageDialog(null, "Password is short.");
				} else if(! (contact.matches("[0-9]{10}")) ) {
					JOptionPane.showMessageDialog(null, "Contact# needs to be 10 digits(without any symbols).");
				} else if(! (email.toLowerCase().matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$") )) {
					JOptionPane.showMessageDialog(null, "Invalid email.");
				} else if(securityint==0) {
					JOptionPane.showMessageDialog(null, "Choose a security question.");
				} else if(patientRadioButton.isSelected()==false && doctorRadioButton.isSelected() ==false) {	
					JOptionPane.showMessageDialog(null, "Register as a patient or doctor.");
				}
				
			}
		});
		continueButton.setBounds(267, 571, 117, 29);
		panel.add(continueButton);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(63, 369, 61, 16);
		panel.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setBounds(205, 364, 222, 26);
		panel.add(emailField);
		emailField.setColumns(10);
		
		JLabel firstnameLabel = new JLabel("First Name:");
		firstnameLabel.setBounds(63, 238, 84, 16);
		panel.add(firstnameLabel);
		
		JLabel lastnameLabel = new JLabel("Last Name:");
		lastnameLabel.setBounds(63, 282, 84, 16);
		panel.add(lastnameLabel);
		
		firstnameField = new JTextField();
		firstnameField.setBounds(205, 233, 222, 26);
		panel.add(firstnameField);
		firstnameField.setColumns(10);
		
		lastnameField = new JTextField();
		lastnameField.setBounds(205, 277, 222, 26);
		panel.add(lastnameField);
		lastnameField.setColumns(10);
		
		JLabel contactLabel = new JLabel("Contact#:");
		contactLabel.setBounds(63, 331, 61, 16);
		panel.add(contactLabel);
		
		contactField = new JTextField();
		contactField.setBounds(205, 326, 222, 26);
		panel.add(contactField);
		contactField.setColumns(10);
	}

}
