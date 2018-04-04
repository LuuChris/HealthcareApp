import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontForgetQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField answerField;

	public frontForgetQuestion(int question, String answer, String password) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		String temp="";
		if(question==1) {
			temp="What is your favorite food?";
		}else if(question==2) {
			temp="What is your mother's maiden name?";
		}else {
			temp="What was your highschool mascot?";
		}
		JLabel questionLabel = new JLabel(temp);
		questionLabel.setVerticalAlignment(SwingConstants.TOP);
		questionLabel.setBounds(57, 32, 316, 49);
		panel.add(questionLabel);
		
		answerField = new JTextField();
		answerField.setBounds(57, 107, 259, 26);
		panel.add(answerField);
		answerField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((answerField.getText()).equals(answer)) {
					questionLabel.setText("Your password is: "+ password);
				}else {
					JOptionPane.showMessageDialog(null, "Try again!");
				}
			}
		});
		btnNewButton.setBounds(57, 198, 117, 29);
		panel.add(btnNewButton);
	}

}
