import java.sql.*;

public class Connect {
	
	public static void main(String[] args) {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
		
			
			
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
	}

}
