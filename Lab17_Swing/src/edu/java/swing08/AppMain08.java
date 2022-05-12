package edu.java.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AppMain08 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain08 window = new AppMain08();
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
	public AppMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 535, 858);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnMsgDlg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(
						frame, // 다이얼로그가 실행될 부모 컴포넌트 
						"안녕하세요...^^", // 다이얼로그에 표시될 메시지
						"Hello",  // 다이얼로그의 타이틀(제목)
						JOptionPane.PLAIN_MESSAGE, //메시지 타입
						null); // 아이콘
			}
		});
		btnMsgDlg.setBounds(17, 15, 479, 91);
		frame.getContentPane().add(btnMsgDlg);
		
		JButton btnConfirmDlg = new JButton("Confirm Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(
						frame, // 다이얼로그가 실행될 부모 컴포넌트 
						"정말 삭제할까요?", // 확인 다이얼로그의 메시지  
						"확인", // 제목표시줄의 타이틀 
						JOptionPane.YES_NO_CANCEL_OPTION,  // 확인 옵션(Yes or No, Cancel,...)
						JOptionPane.QUESTION_MESSAGE, // 메시지 종류
						null);
				System.out.println("confirm = " + confirm);
				// -> YES = 0; NO = 1, Cancel = 2
			}
		});
		btnConfirmDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnConfirmDlg.setBounds(17, 121, 479, 91);
		frame.getContentPane().add(btnConfirmDlg);
		
		JButton btnOptionDlg = new JButton("Option Dialog");
		btnOptionDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String[] options = {"몰라요", "아니요", "재미있어요"};
			int option = JOptionPane.showOptionDialog(
						frame, // 다이얼로그가 실행될 부모 컴포넌트 
						"Swing 재밌나요...?", // 다이얼로그의 메시지 
						"확인", // 다이얼로그 제목표시줄의 타이틀
						JOptionPane.YES_NO_CANCEL_OPTION, // 확인할 옵션의 종류 
						JOptionPane.QUESTION_MESSAGE,  
						null, // 아이콘
						options, // 옵션 버튼에서 사용할 문자열
						options[2]); // 다이얼로그가 실행됐을 때 포커스를 받고 있는 버튼
			System.out.println("option = " + option);
			}
		});
		btnOptionDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnOptionDlg.setBounds(17, 227, 479, 91);
		frame.getContentPane().add(btnOptionDlg);
		
		JButton btnInputDlg = new JButton("input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				String input = JOptionPane.showInputDialog("이름은?");
				//showInputDialog(parentCompoent, message, initialSelectionValue)
//				String input = JOptionPane.showInputDialog(frame, "나이는", 0);
				String[] values = {"10대", "20대", "30대"};
				Object input = JOptionPane.showInputDialog(frame, 
						"나이는?", 
						"입력",// title
						JOptionPane.QUESTION_MESSAGE, // messageType 
						null, // icon 
						values,//selectionValues 
						values[2]);// initialSelectionValue
				System.out.println("input = " + input);
				
			}
		});
		btnInputDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnInputDlg.setBounds(17, 333, 479, 91);
		frame.getContentPane().add(btnInputDlg);
		
		JButton btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDialog.showMyDialog();
			}
		});
		btnCustomDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnCustomDlg.setBounds(17, 439, 479, 91);
		frame.getContentPane().add(btnCustomDlg);
		
		JButton btnCustomFrame = new JButton("Custom Frame");
		btnCustomFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyFrame.showMyFrame();
			}
		});
		btnCustomFrame.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnCustomFrame.setBounds(17, 545, 479, 91);
		frame.getContentPane().add(btnCustomFrame);
	}
}
