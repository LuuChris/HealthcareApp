import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

	public frontForgetPassword() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel enterEmailLabel = new JLabel("Enter username:");
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
						Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
						Statement stmt = con.createStatement();
						ResultSet res = stmt.executeQuery("select * from userTable");
						Boolean temp=true;
						while(res.next()) {
							if( (emailField.getText() ).equals(res.getString("username") ) ) {
								frontForgetQuestion frame = new frontForgetQuestion(res.getInt("securityint"), res.getString("securityanswer"), res.getString("password"));
								frame.setVisible(true);
								setVisible(false);
								temp=false;
							}
						}
						if(temp) {
						JOptionPane.showMessageDialog(null, "Try again!");
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
