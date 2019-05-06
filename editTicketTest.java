

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.junit.Before;
import org.junit.Test;

public class editTicketTest {

	@Before
	public void setUp() throws Exception {
	}
	public static String changeTicketDescription(int ticketid, String description, String date) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
			PreparedStatement stmt = con.prepareStatement("update ticketTable set description = ? where ticketid = ?");
			stmt.setString(1, description);
			stmt.setInt(2, ticketid);
			stmt.executeUpdate();
			PreparedStatement stm = con.prepareStatement("update ticketTable set datecreated = ? where ticketid = ?");
			stm.setString(1, "test2");
			stm.setInt(2, ticketid);
			stm.executeUpdate();
			stmt.close();
			stm.close();
			con.close();
			return "success";
			
		}
		catch(Exception exc) {
			return "fail";

		}
	}
	
	@Test
	public void testChangeTicketDescription() {
		int ticketid = 123;
		String description = "test";
		String date = "test";
		String s = changeTicketDescription(ticketid, description, date);
		assertEquals("success", s);
	}

}
