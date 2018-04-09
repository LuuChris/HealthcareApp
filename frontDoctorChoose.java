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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontDoctorChoose extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frontDoctorChoose(doctor d) {
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
		
		
		JList list = new JList(Main.ticketlist()) ;
		scrollPane.setViewportView(list);
		
		JButton chooseButton = new JButton("Choose");
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String snum = list.getSelectedValue().toString().substring(11,16);
				int num = Integer.parseInt(snum);
				Main.addDoctorToTicket(num, d.getUserKey());
				setVisible(false);
			}
		});
		chooseButton.setBounds(238, 216, 117, 29);
		panel.add(chooseButton);
		
		JLabel ticketLabel = new JLabel("Tickets");
		ticketLabel.setBounds(24, 19, 107, 16);
		panel.add(ticketLabel);
	}
}
