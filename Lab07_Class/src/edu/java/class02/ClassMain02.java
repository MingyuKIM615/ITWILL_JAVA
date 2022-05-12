package edu.java.class02;

public class ClassMain02 {

	public static void main(String[] args) {
		// Student 클래스의 인스턴스 생성
		Student stu1 = new Student();  // 기본 생성자(default constructor) 호출
		System.out.println(stu1);  // stu1 참조 변수: 인스턴스 주소 값
		System.out.println(stu1.id);  // id 필드(변수): 0으로 초기화
		System.out.println(stu1.name);  // name 필드: null 초기화
		// 데이터 타입의 기본 값(default value):
		// 1) boolean 타입: false
		// 2) 정수 타입(byte, short, int, long, char): 0
		// 3) 실수 타입(float, double): 0.0
		// 4) 참조 타입(String, Random, Scanner, BasicTv, Student, ...): null
		// null의 의미: 인스턴스가 생성되지 않음. 참조 주소값이 없음.

		// stu1에게 학번(id)와 이름(name)을 부여.
		stu1.id = 101;
		stu1.name = "오쌤";
		
		// id가 201이고 이름이 "홍길동"인 Student 인스턴스를 생성 -> 파라미터를 갖는 생성자 호출
		Student stu2 = new Student(201, "홍길동");
		System.out.println(stu2.id);
		System.out.println(stu2.name);
		
		Student stu3 = new Student(301);
		System.out.println(stu3.id);
		System.out.println(stu3.name);
		
	}  // end main()

}  // end ClassMain02
