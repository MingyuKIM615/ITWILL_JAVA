package edu.java.swing09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain09 {

	// JComboBox의 아이템으로 사용하기 위한 문자열 배열을 정의
	private static final String[] ITEMS = {"Facebook", "Instagram", "Youtube"};
	
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private JButton btnConfirm;
	private JCheckBox cbAbstract;
	private JCheckBox cbStatic;
	private JCheckBox cbFinal;
	private JComboBox<String> comboBox;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain09 window = new AppMain09();
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
	public AppMain09() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rbPrivate = new JRadioButton("private");
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showRadioButtonStatus(e);
			}
		});
		buttonGroup.add(rbPrivate);
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 24));
		rbPrivate.setBounds(13, 11, 149, 70);
		frame.getContentPane().add(rbPrivate);
		
		rbPackage = new JRadioButton("package");
		rbPackage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showRadioButtonStatus(e);
				
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 24));
		rbPackage.setBounds(171, 11, 149, 70);
		frame.getContentPane().add(rbPackage);
		
		rbProtected = new JRadioButton("protected");
		rbProtected.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showRadioButtonStatus(e);
				
			}
		});
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 24));
		rbProtected.setBounds(329, 11, 149, 70);
		frame.getContentPane().add(rbProtected);
		
		rbPublic = new JRadioButton("public");
		rbPublic.setSelected(true);
		rbPublic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showRadioButtonStatus(e);
				
			}
		});
		buttonGroup.add(rbPublic);
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 24));
		rbPublic.setBounds(487, 11, 149, 70);
		frame.getContentPane().add(rbPublic);
		
		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCheckBoxStatus(e);
			}
		});
		cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 24));
		cbAbstract.setBounds(13, 100, 161, 70);
		frame.getContentPane().add(cbAbstract);
		
		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showCheckBoxStatus(e);
				
			}
		});
		cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 24));
		cbStatic.setBounds(183, 100, 161, 70);
		frame.getContentPane().add(cbStatic);
		
		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showCheckBoxStatus(e);
				
			}
		});
		cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 24));
		cbFinal.setBounds(353, 100, 161, 70);
		frame.getContentPane().add(cbFinal);
		
		comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 익명 지역 내부 클래스 안에서는 바깥(외부) 클래스이 멤버들을 사용할 수 있음.
				Object selected = (String) comboBox.getSelectedItem();
				textArea.setText(selected + " 선택됨");
			}
		});
		// ComboBoxModel : 콤보 박스에서 보여질 아이템들을 가지고 있는 객체
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(ITEMS);
		// 콤보박스에 ComboBoxModel 객첼를 설정 -> 선택할 수 있는 리스트(아이템)가 설정됨.
		comboBox.setModel(comboModel);
		
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 24));
		comboBox.setBounds(13, 205, 161, 70);
		frame.getContentPane().add(comboBox);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showInfo();
			}
		});
		btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnConfirm.setBounds(13, 306, 161, 70);
		frame.getContentPane().add(btnConfirm);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 30));
		textArea.setBounds(13, 391, 651, 158);
		frame.getContentPane().add(textArea);
	}

	protected void showInfo() {
		StringBuffer buffer = new StringBuffer();
		
		// 라디오 버튼들 중에서 선택된 상태
		if(rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		}else if(rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText());
		}else if(rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		}else if(rbPublic.isSelected()){
			buffer.append(rbPublic.getText());
		}
		buffer.append(" 라디오 버튼 선택 \n");
		
		// 체크박스 선택 상태
		if(cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append("체크박스 선택.\n");
		}
		
		if(cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append("체크박스 선택.\n");
		}
		
		if(cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append("체크박스 선택.\n");
		}
		
		// 콤보박스 선택 상태
		String item = (String) comboBox.getSelectedItem();
		buffer.append(item).append(" 콤보박스 아이템 선택.");
		
		textArea.setText(buffer.toString());
		
		
		
	}

	protected void showCheckBoxStatus(ActionEvent e) {
		String cmd = e.getActionCommand();
		// instanceof 연산자를 사용
		JCheckBox chkBox = (JCheckBox) e.getSource();
		boolean selected = chkBox.isSelected();
		textArea.setText(cmd + " 체크박스 선택여부 : " + selected);
	}

	protected void showRadioButtonStatus(ActionEvent e) {
		String cmd = e.getActionCommand();
//		Object source = e.getSource(); // 이벤트가 발생한 컴포넌트 객체
		textArea.setText(cmd + " 라디오버튼 선택됨" );
		
	}
}
