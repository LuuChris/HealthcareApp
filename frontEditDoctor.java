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

public class frontEditDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField oldpasswordField;
	private JTextField newpasswordField;
	private JTextField reenterField;
	private JTextField insuranceField;
	private JTextField specialtyField;
	private JTextField workstartField;
	private JTextField workendField;

	public frontEditDoctor(doctor d) {
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
				Main.deleteDoctor(d.getUserKey());
				new frontLogin().setVisible(true);
			}
		});
		btnDeleteAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnDeleteAccount.setBounds(424, 24, 99, 12);
		panel.add(btnDeleteAccount);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(34, 77, 61, 16);
		panel.add(nameLabel);
		
		JLabel actualnameLabel = new JLabel(d.getFirstName()+" "+d.getLastName());
		actualnameLabel.setBounds(128, 77, 184, 16);
		panel.add(actualnameLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(34, 105, 83, 16);
		panel.add(usernameLabel);
		
		JLabel actualusernameLabel = new JLabel(d.getUsername());
		actualusernameLabel.setBounds(128, 105, 134, 16);
		panel.add(actualusernameLabel);
		
		JLabel lblNewLabel = new JLabel("Edit Patient Account");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(34, 20, 200, 30);
		panel.add(lblNewLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(34, 133, 61, 16);
		panel.add(emailLabel);
		
		JLabel actualemailLabel = new JLabel(d.getEmail());
		actualemailLabel.setBounds(128, 133, 134, 16);
		panel.add(actualemailLabel);
		
		JLabel oldpasswordLabel = new JLabel("Enter old password:");
		oldpasswordLabel.setBounds(34, 227, 144, 16);
		panel.add(oldpasswordLabel);
		
		JLabel directionLabel = new JLabel("Only change the fields you want to edit.");
		directionLabel.setBounds(34, 199, 434, 16);
		panel.add(directionLabel);
		
		oldpasswordField = new JTextField();
		oldpasswordField.setBounds(260, 222, 194, 26);
		panel.add(oldpasswordField);
		oldpasswordField.setColumns(10);
		
		JLabel newpasswordLabel = new JLabel("Enter new password:");
		newpasswordLabel.setBounds(34, 265, 144, 16);
		panel.add(newpasswordLabel);
		
		newpasswordField = new JTextField();
		newpasswordField.setBounds(260, 260, 194, 26);
		panel.add(newpasswordField);
		newpasswordField.setColumns(10);
		
		JLabel reenterLabel = new JLabel("Reenter new password:");
		reenterLabel.setBounds(34, 303, 153, 16);
		panel.add(reenterLabel);
		
		reenterField = new JTextField();
		reenterField.setBounds(260, 298, 194, 26);
		panel.add(reenterField);
		reenterField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("The following 3 attributes cannot be changed.");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(34, 49, 237, 16);
		panel.add(lblNewLabel_2);
		
		insuranceField = new JTextField();
		insuranceField.setBounds(260, 361, 194, 26);
		panel.add(insuranceField);
		insuranceField.setColumns(10);
		
		JLabel insuranceLabel = new JLabel("Insurance:");
		insuranceLabel.setBounds(34, 366, 99, 16);
		panel.add(insuranceLabel);
		
		JLabel specialtyLabel = new JLabel("Specialty:");
		specialtyLabel.setBounds(34, 414, 61, 16);
		panel.add(specialtyLabel);
		
		specialtyField = new JTextField();
		specialtyField.setBounds(260, 409, 194, 26);
		panel.add(specialtyField);
		specialtyField.setColumns(10);
		
		JLabel workstartLabel = new JLabel("Work Start(4 digit military time):");
		workstartLabel.setBounds(34, 467, 215, 16);
		panel.add(workstartLabel);
		
		workstartField = new JTextField();
		workstartField.setBounds(260, 462, 194, 26);
		panel.add(workstartField);
		workstartField.setColumns(10);
		
		JLabel workendLabel = new JLabel("Work End(4 digit military time):");
		workendLabel.setBounds(34, 525, 215, 16);
		panel.add(workendLabel);
		
		workendField = new JTextField();
		workendField.setBounds(260, 520, 194, 26);
		panel.add(workendField);
		workendField.setColumns(10);
		
		insuranceField.setText(d.getInsurance());
		specialtyField.setText(d.getSpecialty());
		workstartField.setText(d.getWorkStart());
		workendField.setText(d.getWorkEnd());
		
		JButton btnNewButton = new JButton("Done!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String op = oldpasswordField.getText();
				String np = newpasswordField.getText();
				String rp = reenterField.getText();
				String in = insuranceField.getText();
				String sp = specialtyField.getText();
				String ws = workstartField.getText();
				String we = workendField.getText();
				if(op.equals("") && np.equals("") && rp.equals("") && (sp.equals("") || sp.equals(d.getSpecialty()) && (ws.equals("")|| ws.equals("none")) && (we.equals("")|| we.equals("none")) ) ) {
					Main.editDoctor(d.getUserKey(), d.getPassword(), in, d.getSpecialty(), d.getWorkStart(), d.getWorkEnd());
				}else {
					if(!op.equals(d.getPassword()) ) {
						JOptionPane.showMessageDialog(null, "Current password is invalid");
					}else if(np.length()<5) {
						JOptionPane.showMessageDialog(null, "New password must be more than 5 characters long.");
					}else if(!np.equals(rp)) {
						JOptionPane.showMessageDialog(null, "New password must match reentered password.");
					}else if(sp.length()<2) {
						JOptionPane.showMessageDialog(null, "Specialty is invalid.");
					}else if( !ws.matches("[0-2]\\d{3}") || !ws.equals("none") || !ws.equals("") ) {
						JOptionPane.showMessageDialog(null, "Work start is invalid.(Must be in military time)");
					}else if( !we.matches("[0-2]\\d{3}") || !we.equals("none") || !we.equals("") ) {
						JOptionPane.showMessageDialog(null, "Work end is invalid.(Must be in military time)");
					}else {
						Main.editDoctor(d.getUserKey(), np, in, sp, ws, we);
					}
				}
			}
		});
		btnNewButton.setBounds(306, 569, 144, 48);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new frontDoctorHome(d).setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(52, 569, 126, 48);
		panel.add(btnNewButton_1);
	}
}
