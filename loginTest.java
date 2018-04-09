

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

public class loginTest {

	@Before
	public void setUp() throws Exception {
	}
	public static String authenticate(String username, String password) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from userTable");
			String u;
			String p;
			while (res.next()) {
				u = res.getString("username");
				p = res.getString("password");
				if(u.equals(username) && p.equals(password) ) {
					return "success";
				}
			}
		}
		catch(Exception exc) {
			System.out.println("Error!");
			exc.printStackTrace();
		}
		return "ERROR";
	}
	
	public static String check(String username, String password) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from userTable");
			while (res.next()) {
				if(res.getString("username").equals(username) && res.getString("password").equals(password)) {
					String k = res.getString("type");
					String s = "ERROR";
					if(k=="1"||k=="0") {
						s = "success";
					}
					return s;
				}
			}
		}
		catch(Exception exc) {
			System.out.println("Error!!");
			exc.printStackTrace();
		}
		return "ERROR";
	}
	@Test
	public void testAuthenticateuserandpassword() {
		String username = "user";
		String password = "password";
		String s = authenticate(username, password);
		assertEquals("success", s);
	}
	public void testcheck() {
		String username = "user";
		String password = "password";
		String s = check(username, password);
		assertEquals("success", s);
	}

}
