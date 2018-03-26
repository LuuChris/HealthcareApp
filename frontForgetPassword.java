import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class frontForgetPassword extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;

	/**
	 * Create the frame.
	 */
	public frontForgetPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel enterEmailLabel = new JLabel("Enter email address:");
		enterEmailLabel.setBounds(56, 115, 133, 16);
		panel.add(enterEmailLabel);
		
		emailField = new JTextField();
		emailField.setBounds(200, 110, 130, 26);
		panel.add(emailField);
		emailField.setColumns(10);
		
		JButton btnGetSecurityQuestion = new JButton("Get Security Question");
		btnGetSecurityQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emailField.getText()!=null) {
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/UserDB", "root", "password");
						Statement stmt = con.createStatement();
						ResultSet res = stmt.executeQuery("select * from users");
						while(res.next()) {
							if( (emailField.getText() ).equals(res.getString("email") ) ) {
								frontForgetQuestion frame = new frontForgetQuestion(res.getString("securityquestion"), res.getString("securityanswer"), res.getString("password"));
								frame.setVisible(true);
							}
						}
					}
					catch(Exception exc) {
						System.out.println("Error");
						exc.printStackTrace();
					}
				}
			}
		});
		btnGetSecurityQuestion.setBounds(142, 169, 168, 29);
		panel.add(btnGetSecurityQuestion);
	}
}
