package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class AppMain07 {

	private JFrame frame;
	private JTextField textId;
	private JPasswordField passwordField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 731, 731);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelId = new JLabel("아이디");
		labelId.setBackground(SystemColor.inactiveCaption);
		labelId.setOpaque(true);
		labelId.setHorizontalAlignment(SwingConstants.CENTER);
		labelId.setFont(new Font("D2Coding", Font.BOLD, 30));
		labelId.setBounds(17, 15, 280, 100);
		frame.getContentPane().add(labelId);
		
		textId = new JTextField();
		textId.setFont(new Font("D2Coding", Font.BOLD, 30));
		textId.setBounds(314, 15, 378, 100);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		JLabel labelId_1 = new JLabel("비밀번호");
		labelId_1.setBackground(SystemColor.inactiveCaption);
		labelId_1.setOpaque(true);
		labelId_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelId_1.setFont(new Font("D2Coding", Font.BOLD, 30));
		labelId_1.setBounds(17, 130, 280, 100);
		frame.getContentPane().add(labelId_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("D2Coding", Font.BOLD, 30));
		passwordField.setBounds(314, 130, 378, 100);
		frame.getContentPane().add(passwordField);
		
		JButton btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showIdPass();
			}
		});
		btnConfirm.setFont(new Font("굴림", Font.PLAIN, 40));
		btnConfirm.setBounds(17, 261, 675, 93);
		frame.getContentPane().add(btnConfirm);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.BOLD, 30));
		textArea.setBounds(17, 375, 675, 285);
		frame.getContentPane().add(textArea);
	}

	private void showIdPass() {
		String id = textId.getText();
		char[] pass = passwordField.getPassword();
		
		StringBuffer result = new StringBuffer();
		result.append("ID : ").append(id).append("\n")
		.append("Pass : ").append(pass);
		
		textArea.setText(result.toString());
		
		clear();
		
	}

	private void clear() {
		textId.setText("");
		passwordField.setText("");
		
	}
}
