


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class frontCreateTicket extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frontCreateTicket(int userkey) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 764, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel userkeyLabel = new JLabel("Patient Key:");
		userkeyLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		userkeyLabel.setBounds(105, 63, 138, 22);
		panel.add(userkeyLabel);
		
		JLabel ticketidLabel = new JLabel("Ticket ID:");
		ticketidLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		ticketidLabel.setBounds(105, 109, 95, 15);
		panel.add(ticketidLabel);
		
		JLabel dateLabel = new JLabel("Date Created:");
		dateLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		dateLabel.setBounds(105, 158, 121, 17);
		panel.add(dateLabel);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		descriptionLabel.setBounds(105, 239, 110, 22);
		panel.add(descriptionLabel);
		
		JLabel createticketLabel = new JLabel("Create Ticket");
		createticketLabel.setFont(new Font("Arial", Font.BOLD, 25));
		createticketLabel.setBounds(275, 11, 194, 41);
		panel.add(createticketLabel);
		
		int ticketid = Main.generateTicketKey();
		String date = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		
		
		
		JLabel patientkeyLabel = new JLabel( Integer.toString(userkey) );
		patientkeyLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		patientkeyLabel.setBounds(255, 66, 106, 16);
		panel.add(patientkeyLabel);
		
		JLabel ticketidText = new JLabel(Integer.toString(ticketid));
		ticketidText.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		ticketidText.setBounds(255, 108, 95, 16);
		panel.add(ticketidText);
		
		JLabel dategeneratedLabel = new JLabel(date);
		dategeneratedLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		dategeneratedLabel.setBounds(255, 155, 147, 22);
		panel.add(dategeneratedLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 240, 348, 109);
		panel.add(scrollPane);
		
		JTextArea descriptionArea = new JTextArea();
		descriptionArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		scrollPane.setViewportView(descriptionArea);
		descriptionArea.setLineWrap(true);
		
		JButton createButton = new JButton("Submit");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(descriptionArea.getText().length()>=10 && descriptionArea.getText().length()<200) {
					ticket t = new ticket(ticketid, date, descriptionArea.getText(), userkey, -1);
					Main.inputTicket(t);
					setVisible(false);
				}
				if(descriptionArea.getText().length()<10) {
					JOptionPane.showMessageDialog(null, "Description must be at least 10 characters.");
				}
				if(descriptionArea.getText().length()>200) {
					JOptionPane.showMessageDialog(null, "Description must be below 200 characters.");
				}
			}
		});
		createButton.setFont(new Font("Arial", Font.PLAIN, 18));
		createButton.setBounds(443, 378, 160, 65);
		panel.add(createButton);
		
	}
}
