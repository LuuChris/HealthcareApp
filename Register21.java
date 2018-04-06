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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 625);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel workstartLabel = new JLabel("Start Worktime:");
		workstartLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		workstartLabel.setBounds(58, 293, 158, 62);
		contentPane.add(workstartLabel);
		
		JLabel workendLabel = new JLabel("End Worktime:");
		workendLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		workendLabel.setBounds(58, 367, 147, 50);
		contentPane.add(workendLabel);
		
		JLabel insuranceLabel = new JLabel("Insurance:");
		insuranceLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		insuranceLabel.setBounds(58, 163, 109, 50);
		contentPane.add(insuranceLabel);
		
		insuranceField = new JTextField();
		insuranceField.setColumns(10);
		insuranceField.setBounds(242, 180, 164, 22);
		contentPane.add(insuranceField);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String insurance = insuranceField.getText();
				String specialty = specialtyField.getText();
				String workstart = workstartField.getText();
				String workend = workendField.getText();
				if(insurance.equals("")) {
					insurance = "none";
				}
				if(workstart.equals("")) {
					workstart = "none";
				}
				if(workend.equals("")) {
					workend = "none";
				}
				if(!workstart.matches("[0-2]\\d{3}") || !workend.matches("[0-2]\\d{3}")) {
					JOptionPane.showMessageDialog(null, "Enter workstart/workend times in military time (4 numbers)");
				}
				
				if( specialty.length()>1 && (workstart.matches("[0-2]\\d{3}") || workstart.equals("none")) && (workend.matches("[0-2]\\d{3}") || workend.equals("none"))) {
					doctor d = new doctor(contact, email, firstname, lastname, password, securityanswer, type, username, securityint, Main.generateUserkey(), insurance, specialty, workstart, workend);
					Main.inputDoctor(d);
					frontDoctorHome f = new frontDoctorHome(d);
					f.setVisible(true);
					setVisible(false);
				}
				
			}
		});
		continueButton.setBounds(262, 540, 97, 25);
		contentPane.add(continueButton);
		
		workstartField = new JTextField();
		workstartField.setBounds(242, 316, 164, 22);
		contentPane.add(workstartField);
		workstartField.setColumns(10);
		
		JLabel specialtyLabel = new JLabel("Specialty:");
		specialtyLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		specialtyLabel.setBounds(58, 238, 109, 31);
		contentPane.add(specialtyLabel);
		
		specialtyField = new JTextField();
		specialtyField.setBounds(242, 243, 164, 26);
		contentPane.add(specialtyField);
		specialtyField.setColumns(10);
		
		workendField = new JTextField();
		workendField.setBounds(242, 382, 164, 26);
		contentPane.add(workendField);
		workendField.setColumns(10);
		
		JLabel registerLabel = new JLabel("Doctor Registration");
		registerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setBounds(58, 59, 327, 50);
		contentPane.add(registerLabel);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register f = new Register();
				f.setVisible(true);
				setVisible(false);
			}
		});
		btnGoBack.setBounds(82, 538, 117, 29);
		contentPane.add(btnGoBack);
	}
}
