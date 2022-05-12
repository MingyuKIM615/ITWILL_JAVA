package edu.java.swing12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain12 {

	// 테이블의 컬럼 이름ㅇ르 상수
	private static final String[] COLUMN_NAMES = { "국어", "영어", "수학", "총점", "평균" };

	private JFrame frame;
	private JTextField textKorean;
	private JTextField textEnglish;
	private JTextField textMath;
	private JTable table;
	private JButton btnInput;
	private JButton btnDelete;
	private JLabel lableKorean;
	private JLabel lableEnglish;
	private JLabel lableMath;
	private DefaultTableModel tableModel; // 테이블의 데이터(행, 열, 셀)

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain12 window = new AppMain12();
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
	public AppMain12() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 679, 776);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lableKorean = new JLabel("국어");
		lableKorean.setFont(new Font("D2Coding", Font.PLAIN, 24));
		lableKorean.setBounds(17, 15, 219, 67);
		frame.getContentPane().add(lableKorean);

		textKorean = new JTextField();
		textKorean.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textKorean.setBounds(253, 15, 387, 67);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);

		lableEnglish = new JLabel("영어");
		lableEnglish.setFont(new Font("D2Coding", Font.PLAIN, 24));
		lableEnglish.setBounds(17, 97, 219, 67);
		frame.getContentPane().add(lableEnglish);

		textEnglish = new JTextField();
		textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textEnglish.setColumns(10);
		textEnglish.setBounds(253, 97, 387, 67);
		frame.getContentPane().add(textEnglish);

		lableMath = new JLabel("수학");
		lableMath.setFont(new Font("D2Coding", Font.PLAIN, 24));
		lableMath.setBounds(17, 179, 219, 67);
		frame.getContentPane().add(lableMath);

		textMath = new JTextField();
		textMath.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textMath.setColumns(10);
		textMath.setBounds(253, 179, 387, 67);
		frame.getContentPane().add(textMath);

		btnInput = new JButton("점수입력");
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputScore();
			}
		});
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnInput.setBounds(17, 261, 209, 67);
		frame.getContentPane().add(btnInput);

		btnDelete = new JButton("행 삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRowFromTable();
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnDelete.setBounds(253, 261, 209, 67);
		frame.getContentPane().add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 343, 623, 362);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		
		// 테이블에 테이블 모델을 설정
		tableModel = new DefaultTableModel(null, COLUMN_NAMES);
		
		// 테이블 모델에서변화가 생겼을 때(예 : 셀의 내용이 변경) 이벤트를 처리하기 위한 이벤트 핸들러를 테이블 모델에
		tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
//				System.out.println("type " + e.getType()); // 테이블 모델 변화의 이벤트 타입(추가, 삭제, 수정)
//				System.out.println("first row " + e.getFirstRow()); // 이벤트가 발생한 행(row) 인덱스
//				System.out.println("column " + e.getColumn()); // 이벤트가 발생한 열(column) 인덱스
				handleTableChange(e);
				
			}
		});
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
	}

	private void handleTableChange(TableModelEvent e) {
		// 테이블 모델 변화 이벤트의 타입을 찾음.
		int eventType = e.getType();
		
		if(eventType != TableModelEvent.UPDATE) {
			// UPDATE 이벤트만 처리하고, 그 이외의 다른 이벤트(INSERT, DELETE)들은 처리하지 않음.
			return;
		}
		
		int row = e.getFirstRow(); // (업데이트) 이벤트가 발생한 행 인덱스
		int col = e.getColumn(); // (업데이트) 이벤트가 발생한 열 인덱스
		if(col >= 0 && col <=2 ) {// 국어, 여어, 수학 점수 변경이 일어났을 때
			// 총점과 평균을 다시 계산하기 위해서 국어, 영어, 수학 점수를 테이블에서 읽음.
			double kor = Double.parseDouble(String.valueOf(tableModel.getValueAt(row, 0)));
			double eng = Double.parseDouble(String.valueOf(tableModel.getValueAt(row, 1)));
			double math = Double.parseDouble(String.valueOf(tableModel.getValueAt(row, 2)));
			
			Score s = new Score(kor, eng, math);
			
			// 변경된 점수로 계산된 총점과 평균을 테이블 모델에 반영.
			tableModel.setValueAt(s.total(), row, 3);
			tableModel.setValueAt(s.average(), row, 4);
			
			String msg = (row + 1) + "번 인덱스 행의 정보가 수정됐습니다.";
			JOptionPane.showMessageDialog(frame, msg);
			
		}
	}

	private void deleteRowFromTable() {
		// 테이블에서 선택된 행(row)의 인덱스를 찾음.
		int index = table.getSelectedRow();
		
		if(index == -1) { // 테이블에서 선택된 행이 없으면
			JOptionPane.showMessageDialog(frame, "테이블에서 삭제할 행을 먼저 선택하세요.");
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(frame, 
				"정말로 삭제할까요?",
				"삭제 확인",
				JOptionPane.YES_NO_OPTION);
		
		if(confirm == JOptionPane.YES_OPTION) {
			tableModel.removeRow(index);
		}
	}

	private void inputScore() {
		// 국어, 영어, 수학 점수를 읽음(문자열 -> 정수 변환).
		double korean = 0;
		double english = 0;
		double math = 0;
		try {
			korean = Double.parseDouble(textKorean.getText());
			english = Double.parseDouble(textEnglish.getText());
			math = Double.parseDouble(textMath.getText());
		} catch (NumberFormatException e) {
			String message = e.getMessage() + "\n입력한 내용은 숫자가 아닙니다.";
			JOptionPane.showMessageDialog(frame, message, "입력 오류", JOptionPane.ERROR_MESSAGE);
			
			return; // 메서드 종료
		}finally{
			// 모든 텍스트 필드의 값들을 지움
			clearAllTextFields();
		}
		// Score 객체 생성 -> 총점, 평균 기능 사용 가능
		Score score = new Score(korean, english, math);

		// 테이블 모델에 행(row)를 추가
		Object[] rowData = { score.getKorean(), score.getEnglish(), score.getMath(), score.total(), score.average() };

		tableModel.addRow(rowData);

		

	}

	private void clearAllTextFields() {
		textKorean.setText("");
		textEnglish.setText("");
		textMath.setText("");

	}
}
