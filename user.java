import java.awt.Frame;
import java.sql.*;

import javax.swing.JOptionPane;

public class user {
	
	protected static String contact, email, firstname, lastname, password, securityanswer, type, username;
	protected static int securityint, userkey;
	
	public user(String contact, String email, String firstname, String lastname, String password, String securityanswer, String type, String username, int securityint, int userkey) {
		this.contact = contact;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.securityanswer = securityanswer;
		this.type = type;
		this.username = username;
		this.securityint = securityint;
		this.userkey = userkey;
	}
	
	public static void Register() {
		Register f = new Register();
		f.setVisible(true);
	}
	
	public static void Login(String username, String password) {
		
	}
	
	public static void Logout() {
		
	}
	
	public static void DeleteAccount() {
		
	}
	
	public static void EditAccount() {
		
	}
	
	public static void ForgetPassword() {
		frontForgetPassword f = new frontForgetPassword();
		f.setVisible(true);
	}
	
//--------------------------------------------------------------------------------------
	
	public String getContact() {
		return contact;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getSecurityAnswer() {
		return securityanswer;
	}
	
	public String getType() {
		return type;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getSecurityInt() {
		return securityint;
	}
	
	public int getUserKey() {
		return userkey;
	}
	
//-------------------------------------------------------------------------------------------
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSecurityAnswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setUsernae(String username) {
		this.username = username;
	}
	
	public void setSecurityInt(int securityint) {
		this.securityint = securityint;
	}
	
	public void setUserKey(int userkey) {
		this.userkey = userkey;
	}

}
