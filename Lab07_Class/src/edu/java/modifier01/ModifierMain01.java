package edu.java.modifier01;

// 접근 제한 수식어(access modifier)
// 1. 종류 : private, (package), protected, public
// 2. 기능 : 클래스의 멤버들에 대한 접근 권한을 제어.
//    (1) field(멤버 변수)에 대한 접근 권한을 제한.
//    (2) method에 대한 접근 권한을 제한.
//    (3) 생성자에 대한 접근 권한을 제한.
// 3. 의미 : 
//    (1) private : 선언된 클래스 내부에서만 직접 접근(사용)이 가능.
//    (2) (package) : 같은 패키지에 있는 클래스들에서 직접 접근(사용)이 가능. 수식어를 사용하지 않는 경우.
//    (3) protected : 같은 패키지에 있거나, 상속을 받는 클래스 안에서 직접 접근(사용)이 가능.
//    (4) public : 어디서든지 직접 접근(사용)이 가능.
// 가시성(visibility) 범위 : private < (package) < protected < public

public class ModifierMain01 {

	public static void main(String[] args) {
		// AccessTest 클래스의 인스턴스 생성
		AccessTest test = new AccessTest();
		// 참조변수 test 다음에 참조 연산자(.)를 사용했을 때 Eclipse가 보여주는 것들;
		// packageField, protectedField, publicField, public method
		
		test.printAllFields ();
//		System.out.println(test.privateField);
	}

}
