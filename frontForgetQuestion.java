import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontForgetQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField answerField;

	public frontForgetQuestion(String question, String answer, String password) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel questionLabel = new JLabel(question);
		questionLabel.setVerticalAlignment(SwingConstants.TOP);
		questionLabel.setBounds(57, 32, 316, 49);
		panel.add(questionLabel);
		
		answerField = new JTextField();
		answerField.setBounds(57, 107, 259, 26);
		panel.add(answerField);
		answerField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((answerField.getText()).equals(answer)) {
					questionLabel.setText("Your password is: "+ password);
				}else {
					ErrorFrame err = new ErrorFrame();
					err.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(57, 198, 117, 29);
		panel.add(btnNewButton);
	}

}
