package edu.java.modifier04;

public class ModifierMain04 {

	public static void main(String[] args) {
		// Person 인스턴스 생성
		Person ssam = new Person();
		
		//private멤버들은 직접 접근(사용)이 불가능.
//		ssam.name = "오쌤"
//		ssam.age = -16; // 데이터 무결성이 깨짐
		
		// 제공된 public getter(읽기) 또는 setter(쓰기)를 사용할 수 있음.
		ssam.setName("오쌤");
		ssam.setAge(-16);
		
		System.out.println(ssam.getName());
		System.out.println(ssam.getAge());
		
		// 데이터 캡슐화(encapsulation):
		// 멤버 변수(필드, 데이터)를 private으로 감추고
		// 대신에 필요한 경우에 한해서 public으로 공개된 getter 또는 setter 메서드를 통해서
		// 데이터를 접근(읽기, 쓰기)를 허용하는 프로그래밍 기법
		// 보안성과 데이터 무결성을 유지하기 위해서 사용.
		
		
		
	}

}
