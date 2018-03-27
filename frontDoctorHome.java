package mednet.Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class frontdoctorhome extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public frontdoctorhome() {
		connection = sqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Choose Ticket");
		btnNewButton.setBounds(134, 328, 160, 65);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("View Ticket");
		btnNewButton_1.setBounds(444, 328, 160, 65);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(622, 27, 89, 23);
		
		JLabel lblNewLabel_1 = new JLabel("Homepage");
		lblNewLabel_1.setBounds(305, 0, 131, 26);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		panel.setLayout(null);
		panel.add(lblNewLabel_1);
		panel.add(btnNewButton);
		panel.add(btnNewButton_1);
		panel.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 42, 469, 265);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		PreparedStatement stmt = null;
		try {
			int key = frontLogin.UserKey;
			String sql;
            sql = "SELECT * FROM doctor where UserKey = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, key);
            ResultSet rs = stmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e){
	           
            e.printStackTrace();
        }
    
		
	}
}
