package edu.java.modifier05;

public class ModifierMain05 {

	public static void main(String[] args) {
		// Member Id, password 입력 및 출력
		Member mem1 = new Member("abc", "123");
		System.out.println("ID : " + mem1.getId());
		System.out.println("Password : " + mem1.getPassword());
		
		// mem1 비밀번호 변경 123 -> 456 및 출력
		mem1.setPassword("456");
		System.out.println("변경된 Password : " + mem1.getPassword());
		
		// Member 클래스의 인스턴스 생성.
		Member m1 = new Member("admin", "admin1234");
		// private 멤버(필드, 생성자, 메서드)는 직접 접근(사용) 불가.
//		System.out.println(m1.memberId); 
//		m1.memberPassword = "!@#$";
		
		//public getter를 사용해서 private 멤버의 값을 간접적으로 읽어옮.
		System.out.println(m1.getId());
		System.out.println(m1.getPassword());
		
		// public setter를 사용해서 private 멤버의 값을 간접적으로 변경 가능.
		m1.setPassword("adminadmin"); // memberPassword의 값을 "adminadmin"으로 변경.
		System.out.println(m1.getPassword());
	}

}
