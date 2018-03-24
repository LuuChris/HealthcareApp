import java.sql.*;

public class Main {
	
	public static void main(String[]args) {
		frontLogin L = new frontLogin();
		L.setVisible(true);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root");
			Statement stmt = con.createStatement();
			ResultSet myRs = stmt.executeQuery("select * from username");
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
			
		}
		catch(Exception exc) {
			System.out.println("WAAAAATTT??");
			exc.printStackTrace();
		}
		
	}
	
	public static Boolean authenticate(String username, String password) {
		//Checks if the username and password are in the database, and if they are from the same user
		if() {
		return true;
		}else {
		return false;
		}
	}
	
	public statc void setClientTo(String username) {
		
	}
}