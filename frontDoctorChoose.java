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

public class frontDoctorChoose extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frontDoctorChoose(doctor d) {
		setTitle("Choose Ticket");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 70, 542, 223);
		panel.add(scrollPane);
		
		JList list = new JList(Main.ticketlist()) ;
		list.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		scrollPane.setViewportView(list);
		
		JButton chooseButton = new JButton("Choose Ticket");
		chooseButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing is selected!");
				} else {
					String snum = list.getSelectedValue().toString().substring(11,16);
					int num = Integer.parseInt(snum);
					Main.addDoctorToTicket(num, d.getUserKey());
					frontDoctorChoose f = new frontDoctorChoose(d);
					f.setLocationRelativeTo(panel);
					f.setVisible(true);
					f.setResizable(false);
					setVisible(false);
				}
			}
		});
		
		chooseButton.setBounds(448, 315, 141, 45);
		panel.add(chooseButton);
		
		JLabel ticketLabel = new JLabel("Tickets");
		ticketLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		ticketLabel.setBounds(24, 19, 133, 29);
		panel.add(ticketLabel);
	}
}
