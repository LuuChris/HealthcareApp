package mednet.Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;


public class frontLogin extends JFrame{
	private JTextField usernameField;
	private JTextField passwordField;
	public static int UserKey;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frontLogin frame = new frontLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	/**
	 * Create the frame.
	 */
	public frontLogin() {
		
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 316);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(98, 40, 255, 173);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setBounds(98, 0, 58, 28);
		panel_1.add(loginLabel);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		JLabel usernameLabel = new JLabel("Username(email)");
		usernameLabel.setBounds(0, 46, 107, 16);
		panel_1.add(usernameLabel);
		usernameLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(0, 84, 61, 16);
		panel_1.add(passwordLabel);
		passwordLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		usernameField = new JTextField();
		usernameField.setBounds(119, 40, 130, 26);
		panel_1.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(119, 78, 130, 26);
		panel_1.add(passwordField);
		passwordField.setColumns(10);
		
		connection = sqlConnection.dbConnector();
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				PreparedStatement stmt = null;
				try {
					String sql;
		            sql = "SELECT * FROM user";
		            stmt = connection.prepareStatement(sql);
		            ResultSet rs = stmt.executeQuery(sql);
		            String username = usernameField.getText();
		            String password = passwordField.getText();
		            int count = 0;
		            while(rs.next()){
		         
		             if((username.equals(rs.getString("username"))) && 
		               (password.equals(rs.getString("password")))) {
		            	 UserKey = rs.getInt("UserKey");
		            	 count = 1;
		            	 break;	
		                }
		             count++;
		            }
		            if(count == 1) {
		            	 JOptionPane.showMessageDialog(null, "username and password is right");
		            	 
		            	 dispose();
		            	 frontdoctorhome doctorinfo = new frontdoctorhome();
		            	 doctorinfo.setVisible(true);
		            }else {
		            	 JOptionPane.showMessageDialog(null, "username and password is not right");
		            }
		         
		            rs.close();
		            stmt.close();
		            conn.close();
		        }catch(Exception e){
		           
		            e.printStackTrace();
		        }
		      
		    }
		}
);
		
		loginButton.setBounds(0, 112, 117, 29);
		panel_1.add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(132, 112, 117, 29);
		panel_1.add(registerButton);
		
		JButton forgetButton = new JButton("Forget Password?");
		forgetButton.setBounds(66, 146, 117, 16);
		panel_1.add(forgetButton);
		forgetButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
	}
}
