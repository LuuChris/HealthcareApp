package testing;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class ConnectionTest {

	public String connection() {
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
		return "connected";
		}
		catch(Exception exc) {
			exc.printStackTrace();
			return "fail";
		}
	}
	
	@Test
	public void test() {
		String s = connection();
		assertEquals("connected", s);
	}
	
	

}
