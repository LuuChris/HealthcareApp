

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

public class frontCreateTicket extends JFrame {

	private JPanel contentPane;
	private JTextField descriptionField;

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
		userkeyLabel.setBounds(88, 63, 81, 14);
		panel.add(userkeyLabel);
		
		JLabel ticketidLabel = new JLabel("Ticket ID:");
		ticketidLabel.setBounds(88, 109, 81, 14);
		panel.add(ticketidLabel);
		
		JLabel dateLabel = new JLabel("Date Created:");
		dateLabel.setBounds(88, 154, 96, 14);
		panel.add(dateLabel);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setBounds(88, 240, 96, 14);
		panel.add(descriptionLabel);
		
		JLabel createticketLabel = new JLabel("Create Ticket");
		createticketLabel.setFont(new Font("Arial", Font.BOLD, 18));
		createticketLabel.setBounds(275, 11, 131, 26);
		panel.add(createticketLabel);
		
		int ticketid = Main.generateTicketKey();
		String date = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
		
		JButton createButton = new JButton("Submit");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(descriptionField.getText().length()>=10 && descriptionField.getText().length()<200) {
					ticket t = new ticket(ticketid, date, descriptionField.getText(), userkey, -1);
					Main.inputTicket(t);
					setVisible(false);
				}
				if(descriptionField.getText().length()<10) {
					JOptionPane.showMessageDialog(null, "Description must be at least 10 characters.");
				}
				if(descriptionField.getText().length()>200) {
					JOptionPane.showMessageDialog(null, "Description must be below 200 characters.");
				}
			}
		});
		createButton.setFont(new Font("Arial", Font.PLAIN, 18));
		createButton.setBounds(443, 359, 160, 65);
		panel.add(createButton);
		
		JLabel patientkeyLabel = new JLabel( Integer.toString(userkey) );
		patientkeyLabel.setBounds(210, 62, 106, 16);
		panel.add(patientkeyLabel);
		
		descriptionField = new JTextField();
		descriptionField.setBounds(210, 234, 309, 91);
		panel.add(descriptionField);
		descriptionField.setColumns(10);
		
		JLabel ticketidText = new JLabel(Integer.toString(ticketid));
		ticketidText.setBounds(210, 108, 61, 16);
		panel.add(ticketidText);
		
		JLabel dategeneratedLabel = new JLabel(date);
		dategeneratedLabel.setBounds(210, 153, 131, 16);
		panel.add(dategeneratedLabel);
	}
}
