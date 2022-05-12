package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AppMina06 {

	private JFrame frame;
	private JTextField textName;
	private JLabel lable1_1;
	private JTextField textPhone;
	private JLabel lable1_2;
	private JTextField textEmail;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMina06 window = new AppMina06();
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
	public AppMina06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 930, 774);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lable1 = new JLabel("이름");
		lable1.setHorizontalAlignment(SwingConstants.CENTER);
		lable1.setFont(new Font("D2Coding", Font.PLAIN, 32));
		lable1.setBounds(17, 15, 291, 103);
		frame.getContentPane().add(lable1);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 32));
		textName.setBounds(344, 15, 547, 103);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		lable1_1 = new JLabel("전화번호");
		lable1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lable1_1.setFont(new Font("D2Coding", Font.PLAIN, 32));
		lable1_1.setBounds(17, 133, 291, 103);
		frame.getContentPane().add(lable1_1);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 32));
		textPhone.setColumns(10);
		textPhone.setBounds(344, 133, 547, 103);
		frame.getContentPane().add(textPhone);
		
		lable1_2 = new JLabel("이메일");
		lable1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lable1_2.setFont(new Font("D2Coding", Font.PLAIN, 32));
		lable1_2.setBounds(17, 251, 291, 103);
		frame.getContentPane().add(lable1_2);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 32));
		textEmail.setColumns(10);
		textEmail.setBounds(344, 251, 547, 103);
		frame.getContentPane().add(textEmail);
		
		JButton btnConfirm = new JButton("입력 완료");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showInfo();
			}
		});
		btnConfirm.setFont(new Font("굴림", Font.BOLD, 40));
		btnConfirm.setBounds(17, 377, 874, 98);
		frame.getContentPane().add(btnConfirm);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 30));
		textArea.setBounds(17, 504, 874, 199);
		frame.getContentPane().add(textArea);
	} // end initialize

	protected void showInfo() {
		// 3개의 JTextField에서 이름, 전화번호, 이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		StringBuffer message = new StringBuffer(); // StringBuffer 객체 생성
		message.append("이름 : ").append(name).append("\n")
		.append("전화번호 : ").append(phone).append("\n")
		.append("이메일 : ").append(email);
		
		textArea.setText(message.toString());
		
		// 3개의 JTextField의 내용을 모두 지움.
		clearAllTextField();
		
	}

	private void clearAllTextField() {
		textName.setText("");
		textPhone.setText("");
		textEmail.setText("");
		
	}
}
