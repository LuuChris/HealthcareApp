import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class frontDoctorHome extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public frontDoctorHome(doctor d) {
		setTitle("Doctor Homepage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Choose Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontDoctorChoose f = new frontDoctorChoose(d);
				f.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("View Ticket");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontViewTicket f = new frontViewTicket(d);
				f.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontLogin f = new frontLogin();
				f.setVisible(true);
				setVisible(false);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel nameLabel = new JLabel(d.getFirstName()+" "+d.getLastName());
		
		JButton editacountButton = new JButton("Edit Account");
		editacountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontEditDoctor f = new frontEditDoctor(d);
				f.setVisible(true);
				setVisible(false);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblName)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(editacountButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addContainerGap(94, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(174))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameLabel))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnLogOut)
							.addGap(39)
							.addComponent(editacountButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		
		JTextArea txtrK = new JTextArea();
		txtrK.setText("k");
		txtrK.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtrK.setText("Account Information\n"+"Contact#: "+d.contact+"\nEmail: "+d.email+"\nUsername: "+d.username+"\nPassword: "+d.password+"\nType: "+d.type+"\nUserkey: "+d.getUserKey()+"\nInsurances: "+d.getInsurance()+"\nSpecialty: "+d.getSpecialty());
		txtrK.append("\nWorkstart: "+d.getWorkStart()+"\nWorkend: "+d.getWorkEnd());
		scrollPane.setViewportView(txtrK);
		txtrK.setEditable(false);
		panel.setLayout(gl_panel);
	}
}