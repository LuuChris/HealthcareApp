package medpack;

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


public class Register21 extends JFrame {

	private JPanel contentPane;
	private JTextField insuranceField;
	private JTextField workstartField;
	private JTextField specialtyField;
	private JTextField workendField;
	
	public Register21(String username, String password, String firstname, String lastname, String contact, String email, int securityint, String securityanswer, String type) {
		setTitle("Register Doctor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel workstartLabel = new JLabel("Start Worktime:");
		workstartLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		workstartLabel.setBounds(58, 294, 171, 31);
		contentPane.add(workstartLabel);
		
		JLabel workendLabel = new JLabel("End Worktime:");
		workendLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		workendLabel.setBounds(58, 379, 171, 50);
		contentPane.add(workendLabel);
		
		JLabel insuranceLabel = new JLabel("Insurance:");
		insuranceLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		insuranceLabel.setBounds(58, 111, 158, 50);
		contentPane.add(insuranceLabel);
		
		insuranceField = new JTextField();
		insuranceField.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		insuranceField.setColumns(10);
		insuranceField.setBounds(262, 118, 210, 37);
		contentPane.add(insuranceField);
		
		JButton continueButton = new JButton("Continue");
		continueButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String insurance = insuranceField.getText();
				String specialty = specialtyField.getText();
				String workstart = workstartField.getText();
				String workend = workendField.getText();
				if(insurance.equals("")) {
					insurance = "none";
				}
				if(specialty.length()==0) {
					JOptionPane.showMessageDialog(null, "Must enter a specialty.");
				}else if(  !(workstart.matches("[0-2]{1}[0-9]{3}") || workstart.equals("")) ) {
					JOptionPane.showMessageDialog(null, "Enter workstart times in military time (4 numbers)");
				}else if( !(workend.matches("[0-2]{1}[0-9]{3}") || workend.equals("") ) ) {
					JOptionPane.showMessageDialog(null, "Enter workend times in military time (4 numbers)");
				}
					
				if(workstart.equals("")) {
					workstart = "none";
				}
				if(workend.equals("")) {
					workend = "none";
				}
				
				if( specialty.length()>1 && (workstart.matches("[0-2]{1}[0-9]{3}") || workstart.equals("none")) && (workend.matches("[0-2]{1}[0-9]{3}") || workend.equals("none"))) {
					doctor d = new doctor(contact, email, firstname, lastname, password, securityanswer, type, username, securityint, Main.generateUserkey(), insurance, specialty, workstart, workend);
					Main.inputDoctor(d);
					frontDoctorHome f = new frontDoctorHome(d);
					f.setVisible(true);
					f.setResizable(false);
					setVisible(false);
				}
				
			}
		});
		continueButton.setBounds(354, 496, 118, 44);
		contentPane.add(continueButton);
		
		workstartField = new JTextField();
		workstartField.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		workstartField.setBounds(262, 294, 210, 37);
		contentPane.add(workstartField);
		workstartField.setColumns(10);
		
		JLabel specialtyLabel = new JLabel("Specialty:");
		specialtyLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		specialtyLabel.setBounds(58, 205, 109, 31);
		contentPane.add(specialtyLabel);
		
		specialtyField = new JTextField();
		specialtyField.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		specialtyField.setBounds(262, 202, 210, 37);
		contentPane.add(specialtyField);
		specialtyField.setColumns(10);
		
		workendField = new JTextField();
		workendField.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		workendField.setBounds(262, 386, 210, 37);
		contentPane.add(workendField);
		workendField.setColumns(10);
		
		JLabel registerLabel = new JLabel("Doctor Registration");
		registerLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 30));
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setBounds(121, 25, 327, 50);
		contentPane.add(registerLabel);
		
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
		btnGoBack.setBounds(23, 31, 83, 37);
		contentPane.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("(If none, leave blank)");
		lblNewLabel.setBounds(82, 337, 173, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(If none, leave blank)");
		lblNewLabel_1.setBounds(82, 150, 147, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("(Military time)");
		lblNewLabel_2.setBounds(82, 322, 117, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("(Military time)");
		lblNewLabel_3.setBounds(82, 416, 97, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("(If none, leave blank)");
		lblNewLabel_4.setBounds(82, 433, 147, 16);
		contentPane.add(lblNewLabel_4);
	}
}
