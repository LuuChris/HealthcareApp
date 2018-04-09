

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import org.junit.Before;
import org.junit.Test;


public class createTicketTest {
	@Before
	public void setUp() throws Exception {
	}

	public static String inputTicket(ticket t){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO ticketTable(ticketid, datecreated, description, doctorkey, patientkey) values (?,?,?,?,?)");
			stmt.setInt(1, t.ticketID);
			stmt.setString(2, t.getDateCreated());
			stmt.setString(3, t.getDescription());
			stmt.setInt(4, t.doctorkey);
			stmt.setInt(5, t.patientkey);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return "success";
		}
		catch(Exception exc) {
			return "fail";
		}
	}
	
	@Test
	public void testInputTicket() {
		ticket t = new ticket(123, "test", "test", 456, 789);
		String description = "test";
		assertEquals(t.getDescription(),description);
		String s = inputTicket(t);
		assertEquals("success", s);
	}

}
