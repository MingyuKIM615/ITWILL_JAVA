package edu.java.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Appmain05 {

	// 이미지 파일들이 저장된 폴더와 파일 이름을 문자열 사웃(배열)로 정의
	private static final String[] IMAGES = {
			"images/flower1.jpg",
			"images/flower2.jpg",
			"images/flower3.jpg",
			"images/flower4.jpg",
			"images/flower5.jpg",
	};
	
	// 현재 application window에서 보여지는 이미지의 인덱스를 저장하는 변수
	private int index;
	
	private JFrame frame;
	private JLabel labelImage;
	private JButton btnPrev;
	private JButton btnNext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appmain05 window = new Appmain05();
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
	public Appmain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 918, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// JLabel(Icon image) 생성자
		// 다형성을 이용해서 Icon 타입 객체를 전달하는 곳에 ImageIcon 객체를 전달
		labelImage = new JLabel(new ImageIcon(IMAGES[index]) );
		labelImage.setBounds(17, 15, 862, 394);
		frame.getContentPane().add(labelImage);
		
		btnPrev = new JButton("<< 이전");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPrevImage();
			}
		});
		btnPrev.setFont(new Font("D2Coding", Font.PLAIN, 32));
		btnPrev.setBounds(17, 424, 394, 105);
		frame.getContentPane().add(btnPrev);
		
		btnNext = new JButton("다음 >>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNextImage();
			}
		});
		btnNext.setFont(new Font("D2Coding", Font.PLAIN, 32));
		btnNext.setBounds(485, 424, 394, 105);
		frame.getContentPane().add(btnNext);
	}

	protected void showPrevImage() {
		// 현재 인덱스(index)가 0보다 크면
		if(index > 0) {
			index--; // 인덱스 감소
			labelImage.setIcon(new ImageIcon(IMAGES[index]));
		}else {
			JOptionPane.showMessageDialog(frame, "첫번째 이미지입니다.");
		}
		
	}

	protected void showNextImage() {
		// 현재 인덱스(index)가 배열의 마지막의 인덱스보다 작으면
		if(index < IMAGES.length -1) { 
			index++; // 인덱스 증가
			// 배열에서 증가된 인덱스로 파일 이름을 찾아서 이미지 아이콘을 설정
			labelImage.setIcon(new ImageIcon(IMAGES[index]));
		}else {
			JOptionPane.showMessageDialog(frame, "마지막 이미지입니다.");
		}
		
	}

	

}
