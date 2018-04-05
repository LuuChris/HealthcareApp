import java.awt.EventQueue; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
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
	/*	
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from userTable");
			while (res.next()) {
				System.out.println(res.getString("firstname"));
			}
			
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
	*/
		
	}
	public static Boolean authenticate(String username, String password) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from userTable");
			String u;
			String p;
			while (res.next()) {
				u = res.getString("username");
				p = res.getString("password");
				if(u.equals(username) && p.equals(password) ) {
					return true;
				}
			}
		}
		catch(Exception exc) {
			System.out.println("Error!");
			exc.printStackTrace();
		}
		return false;
	}
	
	public static String check(String username, String password) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from userTable");
			while (res.next()) {
				if(res.getString("username").equals(username) && res.getString("password").equals(password)) {
					String k = res.getString("type");
					return k;
				}
			}
		}
		catch(Exception exc) {
			System.out.println("Error!!");
			exc.printStackTrace();
		}
		return "ERROR";
	}
	
	public static patient pcheck(String username, String password) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			Statement stm = conn.createStatement();
			ResultSet res = stmt.executeQuery("select * from userTable");
			ResultSet pat = stm.executeQuery("select * from patientTable");
			String contact,email,firstname,lastname,pwd,securityanswer,type,usrname;
			int securityint,userkey;
			String allergy,address,ethnicity,medicalcondition;
			int age;
			
			while (res.next()) {
				if(res.getString("username").equals(username) && res.getString("password").equals(password)) {
					contact = res.getString("contact");
					email = res.getString("email");
					firstname = res.getString("firstname");
					lastname = res.getString("lastname");
					pwd = res.getString("password");
					securityanswer = res.getString("securityanswer");
					type = res.getString("type");
					usrname = res.getString("username");
					securityint = res.getInt("securityint");
					userkey = res.getInt("userkey");
						while(pat.next()) {
							if(userkey==pat.getInt("userkey")) {
								allergy = pat.getString("allergy");
								address = pat.getString("address");
								ethnicity = pat.getString("ethnicity");
								medicalcondition = pat.getString("medicalcondition");
								age = pat.getInt("age");
								patient p = new patient(contact, email, firstname, lastname, pwd, securityanswer, type, usrname, securityint, userkey, allergy, address, ethnicity, medicalcondition, age);
								return p;
							}
							
						}
						JOptionPane.showMessageDialog(null, "Error.");
				}
			}
		}
				
		catch(Exception exc) {
			System.out.println("Error!!!");
			exc.printStackTrace();
		}
		return null;
	}
	
	public static doctor dcheck(String username, String password) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			Statement stm = conn.createStatement();
			ResultSet res = stmt.executeQuery("select * from userTable");
			ResultSet doc = stm.executeQuery("select * from doctorTable");
			while (res.next()) {
				if(res.getString("username").equals(username) && res.getString("password").equals(password)) {
					String contact = res.getString("contact");
					String email = res.getString("email");
					String firstname = res.getString("firstname");
					String lastname = res.getString("lastname");
					String pwd = res.getString("password");
					String securityanswer = res.getString("securityanswer");
					String type = res.getString("type");
					String usrname = res.getString("username");
					int securityint = res.getInt("securityint");
					int userkey = res.getInt("userkey");
					
						while(doc.next()) {
							
							if(userkey==doc.getInt("userkey")) {
								String insurance = doc.getString("insurance");
								String specialty = doc.getString("specialty");
								String workstart = doc.getString("workstart");
								String workend = doc.getString("workend");
								doctor d = new doctor(contact, email, firstname, lastname, pwd, securityanswer, type, usrname, securityint, userkey, insurance, specialty, workstart, workend);
								return d;
							}
							
						}
						JOptionPane.showMessageDialog(null, "Error..");
				}
			}
		}
		catch(Exception exc) {
			System.out.println("Error!!!!");
			exc.printStackTrace();
		}
		return null;
	}
	
	public static Boolean checkUser(String username, String email) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from userTable");
			Boolean user = true;
			Boolean eml = true;
			while (res.next()) {
				if( username.equals(res.getString("username") ) ) {
					user = false;
				}
				if( email.equals(res.getString("email") ) ){
					eml = false;
				}
			}
			if(user==false && eml==false ){
				JOptionPane.showMessageDialog(null, "Username and email already exists");
				return false;
			}else if( eml==false ){
				JOptionPane.showMessageDialog(null, "Email already exists");
				return false;
			}else if( user==false ){
				JOptionPane.showMessageDialog(null, "Username already exists");
				return false;
			}
		}
		catch(Exception exc) {
			System.out.println("Error!!!!!");
			exc.printStackTrace();
		}
		return true;
	}
	
	public static int generateUserkey() {
		Random rand = new Random();
		int  n = rand.nextInt(99999) + 1;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			Statement stm = conn.createStatement();
			ResultSet res = stmt.executeQuery("select * from userTable");
			ResultSet re = stm.executeQuery("select * from userTable");
			int temp;
			while (res.next()) {
				temp=res.getInt("userkey");
				if (n==res.getInt("userkey")) {
					n = rand.nextInt(99999) + 1;
					res.first();
				}
			}
			
		}
		catch(Exception exc) {
			System.out.println("Error!!!!!!");
			exc.printStackTrace();
		}
		return n;
	}
	
	public static int generateTicketKey() {
		Random rand = new Random();
		int  n = rand.nextInt(99999) + 1;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			Statement stm = conn.createStatement();
			ResultSet res = stmt.executeQuery("select * from ticketTable");
			ResultSet re = stm.executeQuery("select * from ticketTable");
			int temp;
			while (res.next()) {
				temp=res.getInt("ticketid");
				if (n==res.getInt("ticketid")) {
					n = rand.nextInt(99999) + 1;
					res.first();
				}
			}
			
		}
		catch(Exception exc) {
			System.out.println("Error!!!!!!");
			exc.printStackTrace();
		}
		return n;
	}
	
	public static void inputPatient(patient p) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO mednet.userTable(contact,email,firstname,lastname,password,securityanswer,type,username,securityint,userkey) values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, p.getContact());
			stmt.setString(2, p.getEmail());
			stmt.setString(3, p.getFirstName());
			stmt.setString(4, p.getLastName());
			stmt.setString(5, p.getPassword());
			stmt.setString(6, p.getSecurityAnswer());
			stmt.setString(7, p.getType());
			stmt.setString(8, p.getUsername());
			stmt.setInt(9, p.getSecurityInt());
			stmt.setInt(10, p.getUserKey());
			stmt.executeUpdate();
		//	con.commit();
			stmt.close();
			con.close();
		}
		catch(Exception exc) {
			System.out.println("Error!!!!!!!");
			exc.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO mednet.patientTable(allergy,address,ethnicity,medicalcondition,age,userkey) values (?,?,?,?,?,?)");
			stmt.setString(1, p.getAllergy());
			stmt.setString(2, p.getAddress());
			stmt.setString(3, p.getEthnicity());
			stmt.setString(4, p.getMedicalCondition());
			stmt.setInt(5, p.getAge());
			stmt.setInt(6, p.getUserKey());
			stmt.executeUpdate();
			//con.commit();
			stmt.close();
			con.close();
		}
		catch(Exception exc) {
			System.out.println("ERROR!!!!!!!");
			exc.printStackTrace();
		}
	}
		
	
	public static void inputDoctor(doctor d) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO mednet.userTable(contact,email,firstname,lastname,password,securityanswer,type,username,securityint,userkey) values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, d.getContact());
			stmt.setString(2, d.getEmail());
			stmt.setString(3, d.getFirstName());
			stmt.setString(4, d.getLastName());
			stmt.setString(5, d.getPassword());
			stmt.setString(6, d.getSecurityAnswer());
			stmt.setString(7, d.getType());
			stmt.setString(8, d.getUsername());
			stmt.setInt(9, d.getSecurityInt());
			stmt.setInt(10, d.getUserKey());
			stmt.executeUpdate();
			//con.commit();
			stmt.close();
			con.close();
			
		}
		catch(Exception exc) {
			System.out.println("Error!!!!!!!!");
			exc.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO mednet.doctorTable(insurance,specialty,workstart,workend,userkey) values (?,?,?,?,?)");
			stmt.setString(1, d.getInsurance());
			stmt.setString(2, d.getSpecialty());
			stmt.setString(3, d.getWorkStart());
			stmt.setString(4, d.getWorkEnd());
			stmt.setInt(5, d.getUserKey());
			stmt.executeUpdate();
			//con.commit();
			stmt.close();
			con.close();
		}
		catch(Exception exc) {
			System.out.println("ERROR!!!!!!!!");
			exc.printStackTrace();
		}
		
	}
	
	public static void inputTicket(ticket t){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO mednet.ticketTable(ticketid, datecreated, description, doctorkey, patientkey) values (?,?,?,?,?)");
			stmt.setInt(1, t.getTicketID());
			stmt.setString(2, t.getDateCreated());
			stmt.setString(3, t.getDescription());
			stmt.setInt(4, t.getDoctorKey());
			stmt.setInt(5, t.getPatientKey());
			stmt.executeUpdate();
			//con.commit();
			stmt.close();
			con.close();
		}
		catch(Exception exc) {
			System.out.println("ERROR!!!!!!!!");
			exc.printStackTrace();
		}
	}
	
	public static String[] ticketlist() {
		int count=0;
		String[] s = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from ticketTable");
			while (res.next()) {
				if(res.getInt("doctorkey")==-1) {
					count++;
				}
			}
			s = new String[count];
			int temp = count;
			res.beforeFirst();
			while(res.next()) {
				
				if(res.getInt("doctorkey")==-1) {
					s[count-temp]="Ticket ID: "+ Integer.toString( res.getInt("ticketid") )+", Patient Key: "+ Integer.toString( res.getInt("patientkey") ) +", Description: "+res.getString("description");
					temp=temp-1;
				}
			}
			
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
		return s;
	}
	
	public static void addDoctorToTicket(int ticketid, int doctorkey) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			PreparedStatement stmt = con.prepareStatement("update ticketTable set doctorkey = ? where ticketid = ?");
			stmt.setInt(1, doctorkey);
			stmt.setInt(2, ticketid);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
	}
	
	public static String[] takenticketlist(int doctorkey) {
		int count=0;
		String[] s = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from ticketTable");
			while (res.next()) {
				if(res.getInt("doctorkey")==doctorkey) {
					count++;
				}
			}
			s = new String[count];
			int temp = count;
			res.beforeFirst();
			while(res.next()) {
				
				if(res.getInt("doctorkey")==doctorkey) {
					s[count-temp]="Ticket ID: "+ Integer.toString( res.getInt("ticketid") )+", Patient Key: "+ Integer.toString( res.getInt("patientkey") ) +", Description: "+res.getString("description");
					temp=temp-1;
				}
			}
			
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
		return s;
	}
	
	public static void viewPatientInfo(int userkey) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			Statement stm = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from patientTable");
			ResultSet re = stm.executeQuery("select * from userTable");
			String firstname="", lastname="", contact="", email ="";
			String allergy="", medicalcondition="", ethnicity="", age="";
			while (res.next()) {
				if(res.getInt("userkey")==userkey) {
					allergy = res.getString("allergy");
					medicalcondition = res.getString("medicalcondition");
					ethnicity = res.getString("ethnicity");
					age = res.getString("age");
				}
			}
			while(re.next()) {
				if(re.getInt("userkey")==userkey) {
					firstname = re.getString("firstname");
					lastname = re.getString("lastname");
					contact = re.getString("contact");
					email = re.getString("email");
				}
			}
			JOptionPane.showMessageDialog(null, "Patient Name: "+firstname+" "+lastname+"\nContact#: "+contact+"\nEmail: "+email+"\nAge: "+age+"\nEthnicity: "+ethnicity+"\nAllergies: "+allergy+"\nMedical Conditions: "+medicalcondition);
			
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
	}
	
	public static String[] editticketlist(int userkey) {
		int count=0;
		String[] s = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from ticketTable");
			while (res.next()) {
				if(res.getInt("patientkey")==userkey) {
					count++;
				}
			}
			s = new String[count];
			int temp = count;
			res.beforeFirst();
			while(res.next()) {
				
				if(res.getInt("patientkey")==userkey) {
					s[count-temp]="Ticket ID: "+ Integer.toString( res.getInt("ticketid") )+", Patient Key: "+ Integer.toString( res.getInt("patientkey") ) +", Description: "+res.getString("description");
					temp=temp-1;
				}
			}
			
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
		return s;
	}
	
	public static void changeTicketDescription(int ticketid, String description, String date) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			PreparedStatement stmt = con.prepareStatement("update ticketTable set description = ? where ticketid = ?");
			stmt.setString(1, description);
			stmt.setInt(2, ticketid);
			stmt.executeUpdate();
			PreparedStatement stm = con.prepareStatement("update ticketTable set datecreate = ? where ticketid = ?");
			stm.setString(1, date);
			stm.setInt(2, ticketid);
			stm.executeUpdate();
			stmt.close();
			stm.close();
			con.close();
			
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
	}
	
	public static void deleteTicket(int ticketid) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mednet?useSSL=false", "root", "password");
			PreparedStatement stmt = con.prepareStatement("delete from ticketTable where ticketid = ?");
			stmt.setInt(1, ticketid);
			stmt.executeUpdate();
			stmt.close();
			con.close();
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
	}
}