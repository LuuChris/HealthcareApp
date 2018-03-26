import java.awt.EventQueue;
import java.sql.*;

public class Main {
	
	public static void main(String[]args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frontLogin frame = new frontLogin();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/UserDB", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from user");
			while (res.next()) {
				System.out.println(res.getString("last_name"));
			}
			
		}
		catch(Exception exc) {
			System.out.println("WAAAAATTT??");
			exc.printStackTrace();
		}
		
	}
	
	public static Boolean authenticate(String username, String password) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/UserDB", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from users");
			System.out.println("CONNECTED");
		}
/*			while (res.next()) {
				if(res.getString("username").equals(username) && res.getString("password").equals(password)) {
					if(res.getString("type").equals("0")) {
						patient();
					}else {
						doctor();
					}
					return true;
				}
			}
		}
*/		
		catch(Exception exc) {
			System.out.println("WAAAAATTT??");
			exc.printStackTrace();
		}
		return false;
	}
	
	public static void setClientTo(String username) {
		
	}
}