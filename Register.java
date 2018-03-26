import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblAlphaMedicalRegistration = new JLabel("Alpha Medical Registration");
		lblAlphaMedicalRegistration.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 19));
		lblAlphaMedicalRegistration.setBounds(58, 13, 315, 60);
		panel.add(lblAlphaMedicalRegistration);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(58, 62, 200, 60);
		panel.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(159, 81, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(58, 110, 166, 39);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 116, 116, 22);
		panel.add(passwordField);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password:");
		lblReenterPassword.setBounds(24, 132, 200, 60);
		panel.add(lblReenterPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(159, 151, 116, 22);
		panel.add(passwordField_1);
		
		JButton btnCreateAccount = new JButton("Continue");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String usrname = textField.getText();
				String pswd1 = passwordField.getText();
				String pswd2 = passwordField_1.getText();
				
				if (usrname.length()==0||pswd1.length()==0||pswd2.length()==0)
				{
					JOptionPane.showMessageDialog(null, "All fields must be filled in!");
				}
				else if(pswd1.equals(pswd2) == false)
				{
					JOptionPane.showMessageDialog(null, "Passwords do not match!");
				}
				else if (!pswd1.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{6,}$"))
				{
					JOptionPane.showMessageDialog(null, "Password does not meet requirements");
				}
				else
				{
					Register2 secondframe = new Register2();
					secondframe.setVisible(true);
				}
				//create and if statement that goes to database and checks if username has been taken
				//also creates an entry in the database to store all this information
			}
		});
		btnCreateAccount.setBounds(140, 194, 166, 25);
		panel.add(btnCreateAccount);
	}
}
