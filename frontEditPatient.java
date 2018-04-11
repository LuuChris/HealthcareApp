
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontEditPatient extends JFrame {

	private JPanel contentPane;
	private JTextField oldpasswordField;
	private JTextField newpasswordField;
	private JTextField reenterField;
	private JTextField allergyField;
	private JTextField addressField;
	private JTextField medicalconditionField;

	public frontEditPatient(patient p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.deletePatient(p.getUserKey());
				frontLogin f = new frontLogin();
				f.setVisible(true);
				f.setResizable(false);
			}
		});
		btnDeleteAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnDeleteAccount.setBounds(424, 24, 99, 12);
		panel.add(btnDeleteAccount);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(34, 77, 61, 16);
		panel.add(nameLabel);
		
		JLabel actualnameLabel = new JLabel(p.getFirstName()+" "+p.getLastName());
		actualnameLabel.setBounds(128, 77, 184, 16);
		panel.add(actualnameLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(34, 105, 83, 16);
		panel.add(usernameLabel);
		
		JLabel actualusernameLabel = new JLabel(p.getUsername());
		actualusernameLabel.setBounds(128, 105, 134, 16);
		panel.add(actualusernameLabel);
		
		JLabel lblNewLabel = new JLabel("Edit Patient Account");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(34, 20, 200, 30);
		panel.add(lblNewLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(34, 133, 61, 16);
		panel.add(emailLabel);
		
		JLabel actualemailLabel = new JLabel(p.getEmail());
		actualemailLabel.setBounds(128, 133, 134, 16);
		panel.add(actualemailLabel);
		
		JLabel oldpasswordLabel = new JLabel("Enter old password:");
		oldpasswordLabel.setBounds(34, 227, 144, 16);
		panel.add(oldpasswordLabel);
		
		JLabel directionLabel = new JLabel("Change following fields that need to be edited and click \"Done\"");
		directionLabel.setBounds(34, 199, 434, 16);
		panel.add(directionLabel);
		
		oldpasswordField = new JTextField();
		oldpasswordField.setBounds(190, 222, 215, 26);
		panel.add(oldpasswordField);
		oldpasswordField.setColumns(10);
		
		JLabel newpasswordLabel = new JLabel("Enter new password:");
		newpasswordLabel.setBounds(34, 265, 144, 16);
		panel.add(newpasswordLabel);
		
		newpasswordField = new JTextField();
		newpasswordField.setBounds(190, 260, 215, 26);
		panel.add(newpasswordField);
		newpasswordField.setColumns(10);
		
		JLabel reenterLabel = new JLabel("Reenter new password:");
		reenterLabel.setBounds(34, 303, 153, 16);
		panel.add(reenterLabel);
		
		reenterField = new JTextField();
		reenterField.setBounds(190, 298, 215, 26);
		panel.add(reenterField);
		reenterField.setColumns(10);
		
		JLabel allergyLabel = new JLabel("Allergies:");
		allergyLabel.setBounds(34, 366, 124, 16);
		panel.add(allergyLabel);
		
		JLabel lblNewLabel_2 = new JLabel("The following attributes cannot be changed.");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(34, 49, 237, 16);
		panel.add(lblNewLabel_2);
		
		allergyField = new JTextField();
		allergyField.setBounds(190, 361, 215, 26);
		panel.add(allergyField);
		allergyField.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setBounds(34, 394, 61, 16);
		panel.add(addressLabel);
		
		addressField = new JTextField();
		addressField.setBounds(190, 389, 215, 26);
		panel.add(addressField);
		addressField.setColumns(10);
		
		JLabel medicalconditionsLabel = new JLabel("Medical Conditions:");
		medicalconditionsLabel.setBounds(34, 464, 144, 16);
		panel.add(medicalconditionsLabel);
		
		medicalconditionField = new JTextField();
		medicalconditionField.setBounds(190, 459, 215, 26);
		panel.add(medicalconditionField);
		medicalconditionField.setColumns(10);
		
		allergyField.setText(p.getAllergy());
		addressField.setText(p.getAddress());
		medicalconditionField.setText(p.getMedicalCondition());
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String op = oldpasswordField.getText();
				String np = newpasswordField.getText();
				String rp = reenterField.getText();
				String al = allergyField.getText();
				String mc = medicalconditionField.getText();
				String ad = addressField.getText();
				if(op.equals("") && np.equals("") && rp.equals("") && (ad.equals("") || ad.equals(p.getAddress()) ) ) {
					Main.editPatient(p.getUserKey(), p.getPassword(), al, p.getAddress(), mc);
				}else {
					if(!op.equals(p.getPassword()) ) {
						JOptionPane.showMessageDialog(null, "Current password is invalid");
					}else if(np.length()<5) {
						JOptionPane.showMessageDialog(null, "New password must be more than 5 characters long.");
					}else if(!np.equals(rp)) {
						JOptionPane.showMessageDialog(null, "New password must match reentered password.");
					}else if(!addressField.getText().matches("\\d{1,5}[A-z]*\\s?[A-z]+\\s?[A-z]*\\s?[A-z]*")) {
						JOptionPane.showMessageDialog(null, "Address is invalid\nNew password does not match reentered password");
					}else {
						Main.editPatient(p.getUserKey(), np, al, ad, mc);
					}
				}
				
			}
		});
		btnNewButton.setBounds(328, 527, 144, 61);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontPatientHome f = new frontPatientHome(p);
				f.setVisible(true);
				f.setResizable(false);
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(63, 527, 144, 61);
		panel.add(btnNewButton_1);
	}
}
