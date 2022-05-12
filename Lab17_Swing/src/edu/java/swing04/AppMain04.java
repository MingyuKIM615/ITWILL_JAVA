package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {

	private JFrame frame;
	private JButton btn3;
	private JButton btn4;
	private JLabel labelMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		labelMessage = new JLabel("New label");
		labelMessage.setFont(new Font("D2Coding", Font.BOLD, 32));
		labelMessage.setBounds(17, 15, 574, 54);
		frame.getContentPane().add(labelMessage);
		
		JButton btn1 = new JButton("익명클래스");
		// ActionListener 객체를 익명 클래스 객체로 생성하고, 
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				labelMessage.setText(e.getActionCommand());
			}
		});
		btn1.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btn1.setBounds(17, 102, 268, 95);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("람다표현식");
		// ActionListener 익명 클래스 객체 생성 -> 람다 표현식(Lambda expression) : (param) -> {구현 코드 작성; }
		btn2.addActionListener((e) -> {
			labelMessage.setText(e.getActionCommand());
		}
		);
		

		btn2.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btn2.setBounds(323, 102, 268, 95);
		frame.getContentPane().add(btn2);
		
		btn3 = new JButton("메서드 1");
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				method(e);
			}
		});
		btn3.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btn3.setBounds(17, 222, 268, 95);
		frame.getContentPane().add(btn3);
		
		btn4 = new JButton("메서드 2");
		btn4.addActionListener((e) -> { method(e);}
		);
		btn4.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btn4.setBounds(323, 222, 268, 95);
		frame.getContentPane().add(btn4);
	}

	protected void method(ActionEvent e) {
		labelMessage.setText(e.getActionCommand());
	}
}
