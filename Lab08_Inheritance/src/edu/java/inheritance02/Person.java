package edu.java.inheritance02;

// 회사원(BusinessPerson)은 사람(Person)이다.
// Person - super class, BusinessPerson - sub class

public class Person {
	// 필드(멤버변수, 속성, 특성)
	private String name;
	
	// 생성자
	public Person() {
		System.out.println("Person() 생성자 호출");
	}
	
	public Person(String name) {
		System.out.println("Person(name) 생성자 호출");
		this.name = name;
	}


	
	// 메서드(getter & setter)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
