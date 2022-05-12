package edu.java.class02;

// class: 속성/정보(field) + 기능(method) [+ 생성자(constructor)] => 데이터 타입
// 생성자: 객체를 메모리에 생성하고, 객체가 가지고 있는 필드들을 초기화하는 특별한 종류의 메서드.
// 생성자를 호출할 때는 new 키워드를 먼저 사용함.
// 생성자의 이름은 반드시 클래스의 이름과 동일해야 함.
// 생성자는 메서드와 다르게 리턴 타입이 없음. (void도 사용하면 안됨!)
// 생성자는 메서드와 비슷하게 파라미터들을 선언할 수 있음.
// 파라미터가 하나도 없는 생성자를 기본 생성자(default constructor)라고 부름.
// 클래스를 설계할 때 생성자를 한 개도 작성하지 않으면,
// 자바 컴파일러가 (모든 필드를 기본값으로 초기화하는) 기본 생성자를 자동으로 작성해 줌.
// 클래스를 설계할 때 생성자를 한 개라도 작성하면,
// 자바 컴파일러는 기본 생성자를 자동으로 만들어 주지 않음!
// 생성자 오버로딩(overloading): 파라미터(의 타입, 개수)가 다른 여러개의 생성자를 중복해서 정의하는 것.

// this: 
// 1) 객체가 생성된 곳의 주소 - 참조 연산자(.)과 함께 사용. (예) this.id
// 2) 생성자 - (예) this(), this(값, ...)

public class Student {
	// field: "학생" 객체가 가져야 할 속성/정보
	int id;  // 학번
	String name;  // 이름
	
	// 생성자(constructor)
	// 1) default constructor(기본 생성자): 파라미터가 없는 생성자
	public Student() {
		// 할 일 없음.
	}
	
	// 2) 파라미터를 갖는 생성자
	public Student(int id, String name) {
		// this.field = parameter; 생성자 호출하는 곳에서 파라미터에 전달한 값을 필드에 저장(초기화).
		this.id = id;
		this.name = name;
	}
	
	// 3) id 파라미터만 갖는 생성자
	public Student(int id) {
//		this.id  = id;
//		this.name = "unknown";
		this(id, "unknown");  // 파라미터 2개를 갖는 생성자를 호출.
	}
	
} // end class Student
