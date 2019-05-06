package testing;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import org.junit.Test;
import medpack.ticket;
import medpack.Main;


public class ViewChosenTicketTest extends Main{
	
	@Test
	public static void main (String[] args)
	{
		//ticket has already been created and added into database
		ticket t1 = new ticket(99999, "01-01-1901", "Please send help!!!", 23069, 81197); 
		
		
		int count=0;
		String[] s = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from ticketTable");
			while (res.next()) {
				if(res.getInt("doctorkey")==81197) {
					count++;
				}
			}
			
			s = new String[count];
			int temp = count;
			res.beforeFirst();
			while(res.next()) {
				
				if(res.getInt("doctorkey")==81197)
				{
					s[count-temp]="Ticket ID: "+ Integer.toString( res.getInt("ticketid") )+", Patient Key: "+ Integer.toString( res.getInt("patientkey") ) +", Description: "+res.getString("description");
					assertEquals(t1.getTicketID(), res.getInt("ticketid"));
					assertEquals(t1.getPatientKey(), res.getInt("patientKey"));				//these assert statements check that the info retrieved from database matches the infro above
					assertEquals(t1.getDescription(), res.getString("description"));
					temp=temp-1;
				}
			}

			con.close();
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
		
		
		
	}

}
