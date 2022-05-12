package edu.java.modifier01;

public class AccessTest {
	//field
	private int privateField;
	int packageField;
	protected int protectedField;
	public int publicField;
	
	//method
	public void printAllFields() {
		// 같은 클래스 내부에서는 모든 멤버들을 사용할 수 있다.
		System.out.println("private : " + privateField);
		System.out.println("package : " + packageField);
		System.out.println("protected : " + protectedField);
		System.out.println("public : " + publicField);
	}
}
