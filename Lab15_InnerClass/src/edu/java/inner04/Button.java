package edu.java.inner04;

public class Button {
	//static 내부 인터페이스(중첩 인터페이스)
	public static interface OnClickListener{
		void onClick(); // 추상 메서드(abstract method)
	}

	// 멤버 변수
	private String btnName;
	private OnClickListener listener;
	
	//생성자
	public Button(String btnName) {
		this.btnName = btnName;
	}
	
	// 메서드
	public void setOnclickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	public void click() {
		System.out.print(btnName + "버튼 : ");
		listener.onClick();
	}
	
}
