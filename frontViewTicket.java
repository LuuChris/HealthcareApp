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

public class frontViewTicket extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frontViewTicket(doctor d) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 47, 299, 148);
		panel.add(scrollPane);
		
		
		JList list = new JList(Main.takenticketlist(d.getUserKey())) ;
		scrollPane.setViewportView(list);
		
		JLabel ticketLabel = new JLabel("Taken Tickets");
		ticketLabel.setBounds(24, 19, 107, 16);
		panel.add(ticketLabel);
		
		JButton btnViewPatientInfo = new JButton("View Patient Info");
		btnViewPatientInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String snum = list.getSelectedValue().toString().substring(31,36);
				int num = Integer.parseInt(snum);
				Main.viewPatientInfo(num);
			}
		});
		btnViewPatientInfo.setBounds(242, 207, 149, 29);
		panel.add(btnViewPatientInfo);
		
		JButton btnNewButton = new JButton("Resolve Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing is selected!");
				}else {
					String ticketstring = list.getSelectedValue().toString().substring(11,16);
					int ticketid = Integer.parseInt(ticketstring);
					Main.deleteTicket(ticketid);
					frontViewTicket f = new frontViewTicket(d);
					f.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(24, 207, 137, 29);
		panel.add(btnNewButton);
	}
}

