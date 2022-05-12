package edu.java.contact.ver05;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyContactFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JLabel labelPhone;
	private JTextField textPhone;
	private JLabel labelEmail;
	private JTextField textEmail;
	private JButton btnCancel;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void addContact() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyContactFrame frame = new MyContactFrame();
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
	public MyContactFrame() {
		initialize();
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("이름");
		labelName.setOpaque(true);
		labelName.setBackground(SystemColor.inactiveCaption);
		labelName.setForeground(SystemColor.desktop);
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		labelName.setFont(new Font("D2Coding", Font.PLAIN, 24));
		labelName.setBounds(17, 15, 130, 50);
		contentPane.add(labelName);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textName.setBounds(164, 15, 259, 50);
		contentPane.add(textName);
		textName.setColumns(10);
		
		labelPhone = new JLabel("전화번호");
		labelPhone.setOpaque(true);
		labelPhone.setHorizontalAlignment(SwingConstants.CENTER);
		labelPhone.setForeground(Color.BLACK);
		labelPhone.setFont(new Font("D2Coding", Font.PLAIN, 24));
		labelPhone.setBackground(SystemColor.inactiveCaption);
		labelPhone.setBounds(17, 113, 130, 50);
		contentPane.add(labelPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textPhone.setColumns(10);
		textPhone.setBounds(164, 113, 259, 50);
		contentPane.add(textPhone);
		
		labelEmail = new JLabel("이메일");
		labelEmail.setOpaque(true);
		labelEmail.setHorizontalAlignment(SwingConstants.CENTER);
		labelEmail.setForeground(Color.BLACK);
		labelEmail.setFont(new Font("D2Coding", Font.PLAIN, 24));
		labelEmail.setBackground(SystemColor.inactiveCaption);
		labelEmail.setBounds(17, 207, 130, 50);
		contentPane.add(labelEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textEmail.setColumns(10);
		textEmail.setBounds(164, 207, 259, 50);
		contentPane.add(textEmail);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnCancel.setBounds(18, 420, 190, 59);
		contentPane.add(btnCancel);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputContact();
			}
		});
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnSave.setBounds(233, 420, 190, 59);
		contentPane.add(btnSave);
	
	}

	protected void inputContact() {
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		Contact c = new Contact(name, phone, email);
		
	}
	

	
}
