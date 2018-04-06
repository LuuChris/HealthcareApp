

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
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontEditTicket2 extends JFrame {

	private JPanel contentPane;
	private JTextField descriptiontextField;
	
	public frontEditTicket2(int ticketid, int patientkey, String description) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel datecreatedlabel = new JLabel("New Date Created:");
		datecreatedlabel.setBounds(88, 154, 124, 14);
		panel.add(datecreatedlabel);
		
		JLabel descriptionlabel = new JLabel("Description:");
		descriptionlabel.setBounds(88, 240, 96, 14);
		panel.add(descriptionlabel);
		
		JLabel label_4 = new JLabel("Edit Ticket");
		label_4.setFont(new Font("Arial", Font.BOLD, 18));
		label_4.setBounds(275, 11, 131, 26);
		panel.add(label_4);
		
		descriptiontextField = new JTextField();
		descriptiontextField.setColumns(10);
		descriptiontextField.setBounds(210, 234, 309, 91);
		panel.add(descriptiontextField);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontEditTicket f = new frontEditTicket(patientkey);
				f.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(114, 361, 160, 65);
		panel.add(btnNewButton);
		
		descriptiontextField.setText(description);
		
		JLabel patientkeyLabel = new JLabel(Integer.toString(patientkey));
		patientkeyLabel.setBounds(210, 62, 112, 16);
		panel.add(patientkeyLabel);
		
		JLabel ticketidLabel = new JLabel(Integer.toString(ticketid));
		ticketidLabel.setBounds(210, 108, 112, 16);
		panel.add(ticketidLabel);
		
		JLabel dateLabel = new JLabel(new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime()));
		dateLabel.setBounds(210, 153, 112, 16);
		panel.add(dateLabel);
		
		JButton resubmitbutton = new JButton("Resubmit");
		resubmitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(descriptiontextField.getText().length()>=10 && descriptiontextField.getText().length()<200) {
					Main.changeTicketDescription( ticketid, descriptiontextField.getText() , dateLabel.getText() );
					frontEditTicket f = new frontEditTicket(patientkey);
					f.setVisible(true);
					setVisible(false);
				}
				
				if(descriptiontextField.getText().length()<10) {
					JOptionPane.showMessageDialog(null, "Description must be at least 10 characters.");
				}
				
				if(descriptiontextField.getText().length()>200) {
					JOptionPane.showMessageDialog(null, "Description must be below 200 characters.");
				}
			}
		});
		resubmitbutton.setFont(new Font("Arial", Font.PLAIN, 18));
		resubmitbutton.setBounds(471, 361, 160, 65);
		panel.add(resubmitbutton);
	}
}



