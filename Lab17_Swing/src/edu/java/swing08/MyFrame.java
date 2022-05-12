package edu.java.swing08;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void showMyFrame() {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		initialize();
	}

	public void initialize() {
		// 기본 닫기 동작 설정
		// 1) EXIT_ON_CLOSE: 닫기 버튼(x)을 클릭했을 때 프로그램 종료
		// 2) DISPOSE_ON_CLOSE : 현재 창만 종료
		// 3) JDialog는 EXIT_ON_CLOSE를 사용할 수 없음!
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
