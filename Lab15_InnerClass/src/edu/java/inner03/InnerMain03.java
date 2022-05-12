package edu.java.inner03;

import edu.java.inner03.EnclosingCls.NestedCls;

public class InnerMain03 {

	public static void main(String[] args) {
		// static 내부 (멤버) 클래스
		// EnclosingCls의 생성자 호출 전(인스턴스 생성전)
		// static 변수와 메서드 사용 가능. 클래스 이름으로 참조해서 사용.
		System.out.println(EnclosingCls.classVar);
		EnclosingCls.staticMethod();
		
		// EnclosingCls의 생성자 호출(인스턴스 생성)
		// 인스턴스 변수와 메서드는 참조 변수(인스턴스의 주소를 저장하는 지역 변수)를 통해서 사용.
		EnclosingCls outer = new EnclosingCls(111);
		outer.printMembers();
		outer.staticMethod(); // 나쁜 사용 예
		// static 변수나 메서드는 참조 변수로 참조해서 사용이 가능하긴 하지만 권장하지 않음.
		
		System.out.println();
		// 중첩 클래스(static 내부 클래스)의 생성자 호출 방법
		EnclosingCls.NestedCls nested = new EnclosingCls.NestedCls("hello");
		nested.nestedClassMethod();
		
		NestedCls nested2 = new NestedCls("안녕하세요");
		nested2.nestedClassMethod();
		
	}
}
