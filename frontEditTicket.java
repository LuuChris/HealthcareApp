package mednet.Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontEditTicket2 extends JFrame {

	private JPanel contentPane;
	private JTextField descriptiontextField;
	private JTextField patientkeytextField;
	private JTextField ticketidtextField;
	private JTextField datecreatedtextField;
	Connection connection = null;
	//static int ticketid = frontTicketList.ticketid;
	static int ticketid = 12345;
	
	/**
	 * Launch the application.
	 */
	public void fillpage() {
		PreparedStatement stmt = null;
		 
		try {
			
			String sql;
			System.out.print(ticketid);
            sql = "SELECT * FROM ticketTable where ticketid = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, ticketid);
            ResultSet rs = stmt.executeQuery(); 
            while(rs.next()) {
           
            patientkeytextField.setText(rs.getString("patientkey"));
            ticketidtextField.setText(rs.getString("ticketid"));
            descriptiontextField.setText(rs.getString("description"));
            datecreatedtextField.setText(rs.getString("datecreated"));
           
            }
            }catch(Exception e){
	           
            e.printStackTrace();
        }
	}

	/**
	 * Create the frame.
	 */
	public frontEditTicket2() {
		connection = sqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel patientksylabel = new JLabel("Patient Key:");
		patientksylabel.setBounds(88, 63, 81, 14);
		panel.add(patientksylabel);
		
		JLabel ticketidlabel = new JLabel("Ticket ID:");
		ticketidlabel.setBounds(88, 109, 81, 14);
		panel.add(ticketidlabel);
		
		JLabel datecreatedlabel = new JLabel("Date Created:");
		datecreatedlabel.setBounds(88, 154, 96, 14);
		panel.add(datecreatedlabel);
		
		JLabel descriptionlabel = new JLabel("Description:");
		descriptionlabel.setBounds(88, 240, 96, 14);
		panel.add(descriptionlabel);
		
		JLabel label_4 = new JLabel("Edit Ticket");
		label_4.setFont(new Font("Arial", Font.BOLD, 18));
		label_4.setBounds(275, 11, 131, 26);
		panel.add(label_4);
		
		JButton resubmitbutton = new JButton("Resubmit");
		resubmitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(descriptiontextField.getText().length()>=10 && descriptiontextField.getText().length()<50) 
				{try {
					String sql;
					 sql = "Update ticketTable set description = '"+descriptiontextField.getText()+"' where ticketid = ? ";
					 PreparedStatement upd;
					 upd = connection.prepareStatement(sql);
					 upd.setInt(1, ticketid);
					 upd.execute();
					 JOptionPane.showMessageDialog(null, "Resubmit successfully!");
				}catch(Exception e1){
			           
		            e1.printStackTrace();
		        }
				}
				if(descriptiontextField.getText().length()<10) {
					JOptionPane.showMessageDialog(null, "Description must be at least 10 characters.");
				}
				if(descriptiontextField.getText().length()>50) {
					JOptionPane.showMessageDialog(null, "Description must be below 50 characters.");
				}
			}
		});
		resubmitbutton.setFont(new Font("Arial", Font.PLAIN, 18));
		resubmitbutton.setBounds(105, 364, 160, 65);
		panel.add(resubmitbutton);
		
		descriptiontextField = new JTextField();
		descriptiontextField.setColumns(10);
		descriptiontextField.setBounds(210, 234, 309, 91);
		panel.add(descriptiontextField);
		
		JButton deletebutton = new JButton("Delete");
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql;
					 sql = "delete from ticketTable where ticketid = ? ";
					 PreparedStatement upd;
					 upd = connection.prepareStatement(sql);
					 upd.setInt(1, ticketid);
					 upd.execute();
					 JOptionPane.showMessageDialog(null, "Delete successfully!");
					 dispose();
					 frontTicketList doctorinfo = new frontTicketList();
	            	 doctorinfo.setVisible(true);
				}catch(Exception e1){
			           
		            e1.printStackTrace();
		        }
			}
		});
		deletebutton.setFont(new Font("Arial", Font.PLAIN, 18));
		deletebutton.setBounds(471, 364, 160, 65);
		panel.add(deletebutton);
		
		patientkeytextField = new JTextField();
		patientkeytextField.setColumns(10);
		patientkeytextField.setBounds(210, 60, 104, 20);
		panel.add(patientkeytextField);
		
		ticketidtextField = new JTextField();
		ticketidtextField.setColumns(10);
		ticketidtextField.setBounds(210, 106, 104, 20);
		panel.add(ticketidtextField);
		
		datecreatedtextField = new JTextField();
		datecreatedtextField.setBounds(213, 151, 101, 20);
		panel.add(datecreatedtextField);
		datecreatedtextField.setColumns(10);
		
		fillpage();
		
		
	}
}
