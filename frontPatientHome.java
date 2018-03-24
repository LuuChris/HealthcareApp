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

public class frontPatientHome extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frontPatientHome frame = new frontPatientHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frontPatientHome() {
		setTitle("Homepage");
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(107, 40, 61, 16);
		panel.add(lblNewLabel);
		
		JButton createButton = new JButton("Create Ticket");
		createButton.setBounds(49, 341, 148, 48);
		panel.add(createButton);
		
		JButton editButton = new JButton("Edit Ticket");
		editButton.setBounds(247, 341, 132, 48);
		panel.add(editButton);
		
		JButton viewButton = new JButton("View Doctor Info");
		viewButton.setBounds(441, 341, 148, 48);
		panel.add(viewButton);
		
		txtDescription = new JTextField();
		txtDescription.setText("Description");
		txtDescription.setBounds(51, 92, 398, 212);
		panel.add(txtDescription);
		txtDescription.setColumns(10);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBounds(529, 39, 103, 21);
		panel.add(btnNewButton);
	}

}
