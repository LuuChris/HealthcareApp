package testing;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.junit.Test;
import medpack.Main;
import medpack.patient;
import medpack.doctor;

public class DeleteAccountTest extends Main{
	
	@Test
	public static void main (String[] args)
	{
		//make sure that there are no users in the database already with these usernames and emails
		assertTrue (checkUser("1User","1User@email.com"));
		assertTrue (checkUser("1Doctor","1Doctor@email.com"));
		
		//here we create a new patient and doctor and add them to database
		patient p = new patient("0123456789", "1User@email.com", "John", "smith", "password", "pizza", "0", "1User", 1, 00400, "peanuts", "1234 boxville", "other", "none", 20);
		inputPatient(p);
		
		doctor d = new doctor("9876543210", "1Doctor@email.com", "Sanjay", "Gupta", "password", "salad", "1", "1Doctor", 1, 0623, "StateFarm", "Neurosurgeon", "0900", "1700");
		inputDoctor(d);
		
		int userkey1 = p.getUserKey(), userkey2 = d.getUserKey();
		
		//check to make sure that doctor and patient were added to the database 
		//pop up will show saying "username and email exist"
		assertFalse(checkUser("1User","1User@email.com"));
		assertFalse(checkUser("1Doctor","1Doctor@email.com"));
		
		//this try catch will delete the user manually from the database
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
			PreparedStatement stmt = con.prepareStatement("delete from userTable where userkey = ?");
			stmt.setInt(1, userkey1);
			assertEquals(1,stmt.executeUpdate());										//assert that execute update returns 1
			PreparedStatement stm = con.prepareStatement("delete from patientTable where userkey = ?");
			stm.setInt(1, userkey1);
			assertEquals(1,stm.executeUpdate());										//assert that execute update returns 1
			PreparedStatement st = con.prepareStatement("delete from ticketTable where patientkey = ?");
			st.setInt(1, userkey1);
			assertEquals(0,st.executeUpdate());											//assert that execute update returns 0
			stmt.close();
			stm.close();
			st.close();
			
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
		
		//this try catch will manually delete a doctor and all his number from database and tickets
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
			PreparedStatement stmt = con.prepareStatement("delete from userTable where userkey = ?");
			stmt.setInt(1, userkey2);
			assertEquals(1,stmt.executeUpdate());													//assert that execute update returns 1
			PreparedStatement stm = con.prepareStatement("delete from doctorTable where userkey = ?");
			stm.setInt(1, userkey2);
			assertEquals(1,stm.executeUpdate());													//assert that execute update returns 1
			PreparedStatement st = con.prepareStatement("update ticketTable set doctorkey = ? where doctorkey = ?");
			st.setInt(1, -1);
			st.setInt(2, userkey2);
			assertEquals(0,st.executeUpdate());														//assert that execute update returns 0
			stmt.close();
			stm.close();
			st.close();
			con.close();
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
		
		//check to make sure that doctor and patient are deleted and no longer in database
		assertTrue(checkUser("1User","1User@email.com"));
		assertTrue(checkUser("1Doctor","1Doctor@email.com"));
	}
		
		
	

}
