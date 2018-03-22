import java.sql.*;

public class Main {
	
	public static void main(String[]args) {
		frontLogin L = new frontLogin();
		L.setVisible(true);
		try {
	//		Connection con = DriverManager.getConnection()
			
		}
		catch(Exception exc) {
			System.out.println("WAAAAATTT??");
			exc.printStackTrace();
		}
		patient p1 = new patient("email", 0, "password", "name", "background", "age", "gender");
		
	}
}