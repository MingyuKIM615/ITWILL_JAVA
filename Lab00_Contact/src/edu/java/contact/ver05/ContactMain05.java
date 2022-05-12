package edu.java.contact.ver05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.model.Contact;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactMain05 {

	private static final String[] COLUMN_NAMES = {"이름", "전화번호", "이메일"};
	
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain05 window = new ContactMain05();
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
	public ContactMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 698);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textField.setText("");
		textField.setBounds(17, 15, 247, 62);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnSearch.setBounds(281, 14, 129, 62);
		frame.getContentPane().add(btnSearch);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyContactFrame.addContact();
			}
		});
		btnAdd.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnAdd.setBounds(427, 14, 62, 62);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("-");
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnDelete.setBounds(499, 15, 62, 62);
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 88, 544, 539);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
	}
}
