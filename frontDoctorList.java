package medpack;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class frontDoctorList extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frontDoctorList(patient p) {
		setTitle("Your Doctors");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 764, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDoctorList = new JLabel("Doctor List");
		lblDoctorList.setFont(new Font("Arial", Font.BOLD, 22));
		lblDoctorList.setBounds(307, 11, 131, 26);
		panel.add(lblDoctorList);
		
		JLabel lblTheseAreThe = new JLabel("These are the doctors who chose your ticket:");
		lblTheseAreThe.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTheseAreThe.setBounds(10, 42, 358, 49);
		panel.add(lblTheseAreThe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 103, 677, 339);
		panel.add(scrollPane);
		
		JTextArea doctorArea = new JTextArea();
		doctorArea.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		doctorArea.setText("");
		doctorArea.setEditable(false);
		scrollPane.setViewportView(doctorArea);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
			Statement stmt = con.createStatement();
			Statement stm = con.createStatement();
			Statement st = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from ticketTable");
			ResultSet re = stm.executeQuery("select * from userTable");
			ResultSet r = st.executeQuery("select * from doctorTable");
			int ticketkey,dkey;
			String description = "";
			String firstname = "";
			String lastname = "";
			String specialty = "";
			String contact = "";
			String email = "";
			String insurance = "";
			String workstart = "";
			String workend = "";
			while(res.next()) {
				if(p.getUserKey()==res.getInt("patientkey") && res.getInt("doctorkey")!=-1) {
					dkey = res.getInt("doctorkey");
					ticketkey = res.getInt("ticketid");
					description = res.getString("description");
					while(re.next()) {
						if(dkey==re.getInt("userkey")) {
							firstname = re.getString("firstname");
							lastname = re.getString("lastname");
							contact = re.getString("contact");
							email = re.getString("email");
							while(r.next()) {
								if(dkey==r.getInt("userkey")) {
									specialty = r.getString("specialty");
									insurance = r.getString("insurance");
									workstart = r.getString("workstart");
									workend = r.getString("workend");
									doctorArea.append("\nTicket ID: "+ticketkey+"\nDoctor Name: "+firstname+" "+lastname+"\nSpecialty: "+specialty+"\nContact info: "+email+", #"+contact+"\nTicket Description: "+description+"\n\n");
								}
							}
							r.beforeFirst();
						}
					}
					re.beforeFirst();
				}
			}
		}
		catch(Exception exc) {
			System.out.println("Error List");
			exc.printStackTrace();
		}
	}
}
