import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;

public class frontPatientHome extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public frontPatientHome(patient p) {
		setTitle("Patient Homepage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(49, 40, 61, 16);
		panel.add(nameLabel);
		
		JLabel dynamicName = new JLabel();
		dynamicName.setText(p.firstname + " " + p.lastname);
		dynamicName.setBounds(107, 40, 258, 16);
		panel.add(dynamicName);
		
		JButton createButton = new JButton("Create Ticket");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patient.CreateTicket(p.getUserKey());
			}
		});
		createButton.setBounds(49, 341, 148, 48);
		panel.add(createButton);
		
		JButton editButton = new JButton("Edit Ticket");
		editButton.setBounds(247, 341, 132, 48);
		panel.add(editButton);
		
		JButton viewButton = new JButton("View Doctor Info");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontDoctorList f = new frontDoctorList(p);
				f.setVisible(true);
			}
		});
		viewButton.setBounds(441, 341, 148, 48);
		panel.add(viewButton);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontLogin f = new frontLogin();
				f.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(529, 39, 103, 21);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 68, 310, 243);
		panel.add(scrollPane);
		
		JTextArea txtrDescription = new JTextArea();
		scrollPane.setViewportView(txtrDescription);
		txtrDescription.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtrDescription.setText("Account Information\n"+"Contact#: "+p.contact+"\nEmail: "+p.email+"\nUsername: "+p.username+"\nPassword: "+p.password+"\nType: "+p.type+"\nUserkey: "+p.getUserKey()+"\nAllergies: "+p.getAllergy()+"\nAddress: "+p.getAddress());
		txtrDescription.append("\nMedical Conditions: "+p.getMedicalCondition()+"\nAge: "+p.getAge());
		txtrDescription.setEditable(false);
	}
}
