package mednet.Frontend;

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
import java.awt.event.ActionEvent;

public class frontTicketList extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public frontTicketList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTicketList = new JLabel("Ticket List");
		lblTicketList.setFont(new Font("Arial", Font.BOLD, 18));
		lblTicketList.setBounds(307, 11, 131, 26);
		panel.add(lblTicketList);
		
		JButton button = new JButton("Log out");
		button.setBounds(544, 15, 89, 23);
		panel.add(button);
		
		JList list = new JList();
		list.setBounds(10, 81, 495, 387);
		panel.add(list);
		
		JLabel lblTheseAreTickets = new JLabel("These are the tickets you have created:");
		lblTheseAreTickets.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTheseAreTickets.setBounds(10, 35, 276, 56);
		panel.add(lblTheseAreTickets);
		
		JButton btnAdd = new JButton("Open");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAdd.setBounds(542, 92, 160, 65);
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 18));
		btnDelete.setBounds(542, 290, 160, 65);
		panel.add(btnDelete);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAdd_1.setBounds(544, 192, 160, 65);
		panel.add(btnAdd_1);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Arial", Font.PLAIN, 18));
		btnGoBack.setBounds(542, 386, 160, 65);
		panel.add(btnGoBack);
	}
}
