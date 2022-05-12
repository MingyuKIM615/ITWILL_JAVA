package edu.java.swing10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain10 {

	private JFrame frame;
	private JTextField textField;
	private JButton btnInput;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JList<String> list; // String을 원소로 갖는 JList타입
	private DefaultListModel<String> model; // JList의 아이템들을 관리(추가, 삭제)한는 클래스

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain10 window = new AppMain10();
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
	public AppMain10() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 761);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textField.setBounds(17, 15, 403, 85);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		btnInput = new JButton("입력");
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addElementToList();
			}
		});
		btnInput.setFont(new Font("굴림", Font.BOLD, 24));
		btnInput.setBounds(437, 15, 193, 85);
		frame.getContentPane().add(btnInput);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteElementFromList();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 24));
		btnDelete.setBounds(437, 115, 193, 85);
		frame.getContentPane().add(btnDelete);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 115, 403, 575);
		frame.getContentPane().add(scrollPane);

		list = new JList<String>(); // String을 원소로 갖는 JList객체를 생성
		model = new DefaultListModel<String>(); // JList의 아이템을 관리하는 DefaultListModel 객체를 생성
		list.setModel(model); // JList에 model을 설정.
		list.setFont(new Font("D2Coding", Font.PLAIN, 24));
		scrollPane.setViewportView(list);

	}

	protected void deleteElementFromList() {
		// JList에서 선택된 아이템의 인덱스를 찾음.
		// 선택된 아이템이 없다면, 사용자에게 삭제할 아이템을 선택하라고 메시지 보여줌.
		// 선택된 아이템이 있다면, 정말로 삭제할 것인 지를 확인한 후
		// 사용자가 삭제하겠다고 확인하면 model에서 아이템을 삭제.
		int index = list.getSelectedIndex();
		
		if(index < 0) {
			JOptionPane.showMessageDialog(frame, "삭제할 내용을 선택하세요.");
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(frame, 
				"정말로 삭제할까요?",
				"삭제 확인",
				JOptionPane.YES_NO_OPTION);
		
		if(confirm == JOptionPane.YES_OPTION) {
			model.remove(index);
		}
		
	}

	protected void addElementToList() {

		// JTextField의 내용을 읽고 JList의 모델에 아이템을 추가.
		String text = textField.getText();
		
		// TODO : 텍스트필드에 내용이 있는 경우에만 JList아이템이 추가되도록.
		if (text.equals("")) { // JTextField에 내용이 입력되어 있지 않으면
			JOptionPane.showMessageDialog(frame, "추가할 내용을 입력하세요.");
			return; // 메서드 종료
		}
			model.addElement(text);
		
		// TODO : JList에 아이템을 추가하고 나면 텍스트필드의 내용을 지움.
		textField.setText("");

	}
}
