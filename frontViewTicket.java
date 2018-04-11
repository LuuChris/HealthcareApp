package medpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class frontViewTicket extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frontViewTicket(doctor d) {
		setTitle("Patient Taken Ticket List");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 637, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 62, 554, 253);
		panel.add(scrollPane);
		
		
		JList list = new JList(Main.takenticketlist(d.getUserKey())) ;
		list.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		scrollPane.setViewportView(list);
		
		JLabel ticketLabel = new JLabel("Taken Tickets");
		ticketLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ticketLabel.setBounds(24, 19, 179, 31);
		panel.add(ticketLabel);
		
		JButton btnViewPatientInfo = new JButton("View Patient Info");
		btnViewPatientInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnViewPatientInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing is selected!");
				} else {
					String snum = list.getSelectedValue().toString().substring(31,36);
					int num = Integer.parseInt(snum);
					Main.viewPatientInfo(num);
				}
				
			}
		});
		btnViewPatientInfo.setBounds(425, 343, 167, 46);
		panel.add(btnViewPatientInfo);
		
		JButton btnNewButton = new JButton("Resolve Ticket");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing is selected!");
				}else {
					String ticketstring = list.getSelectedValue().toString().substring(11,16);
					int ticketid = Integer.parseInt(ticketstring);
					ticket.ResolveTicket(ticketid);
					frontViewTicket f = new frontViewTicket(d);
					f.setVisible(true);
					f.setResizable(false);
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(18, 343, 167, 46);
		panel.add(btnNewButton);
	}
}

