package edu.java.inheritance02;

// class SubClass extends(확장한다) SuperClass
public class BusinessPerson extends Person {
	// 필드(멤버 변수, 속성, 특성)
	private String company;
	
	//생성자
	public BusinessPerson() {
		System.out.println("BusinessPerson() 생성자 호출");
	}
	
	public BusinessPerson(String name, String company) {
		/*
		super(); // 상위 클래스의 기본 생성자를 명시적으로 호출.
		System.out.println("BusinessPerson(name, company) 호출");
		setName(name); // 부모 클래서의 private 필드를 접근하기 위해서는 public 메서드를 이용해야 함.
		this.company = company;
		*/
		super(name); // 상위 클래스의 파라미터를 갖는 생성자를 직접 명시적으로 호출.
		System.out.println("BusinessPerson(name, company) 호출");
		this.company = company;
	}
	
	// 메서드 - getter&setter
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
}
//상속관계에서 생성자 호출 순서
// 1. 하위 클래서의 생성자를 호출하면, 상위 클래서의 생성자가 먼저 호출됨.
// 2. 하위 클래스의 생성자에서 상위 클래스의 생성자를 명시적으로 호출하지 않으면, 
// 상위 클래스의 기본 생성자(super())를 자동으로 호출함.
// 3. 하위 클래스의 생성자에서 상위 클래스의 생성자를 명시적으로 호출할 수도 있음.
// super(); 또는 super(param,...); 형식으로 호출함.
// 비교 - 같은 클래스의 다른(overloading된) 생성자를 호출할 때는 this(), this(param, ..); 형식으로 호출함.
// 4. 상위 클래스가 기본 생성자를 갖고 있지 않고, 파라미터가 있는 생성자만 갖고 있을때,
// 하위 클래스에서 상위 클래스의 생성자를 명시적으로 호출하지 않으면 컴파일 에러(super() 생성자가 없다)가 발생함.
// -> 해결 방법1: 상위 클래스에서 기본 생성자를 만듦.
// -> 해결 방법2: 하위 클래스에서 상위 클래스의 파라미터가 있는 생성자를 "명시적"으로 호출.	


