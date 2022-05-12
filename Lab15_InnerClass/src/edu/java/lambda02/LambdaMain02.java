package edu.java.lambda02;

@FunctionalInterface
interface MyMath {
	double calc(double x, double y);
}

@FunctionalInterface
interface Printable{
	void print(String s);
}

public class LambdaMain02 {

	public static void main(String[] args) {
		// MyMath 인터페이스를 구현. - (x - y)의 절대값을 리턴
		MyMath abs = new MyMath() {
			
			@Override
			public double calc(double x, double y) {
				double result = 0;
				if(x > y) {
					result = x - y;
				}else {
					result = y - x;
				}
				return result;
			}
		};
		System.out.println(abs.calc(2.0, 1.0));
		System.out.println(abs.calc(1.0, 2.0));
		
		// 람다 표현식(lambda expression)
		// (파라미터 선언) -> {메서드가 할 일 구현}
		// 람다 표현식에서는 파라미터를 선언할 때 모든 타입들을생략할 수 있음.
		// 메서드 블록 안의 내용이 리턴 문장만 있는 경우에는, 중괄호({})와 return까지 생략하고 리턴 값만 써도 됨.
		MyMath abs2 = (x, y) -> {
			double result = 0;
			if(x > y) {
				result = x - y;
			}else {
				result = y - x;
			}
			return result;
		};
		System.out.println(abs2.calc(2.0, 1.0));
		System.out.println(abs2.calc(1.0, 2.0));
		
		// 삼항 연산자
		// (조건식) ? 조건식을 만족할 때 선택할 값 : 조건식을 만족하지 못할 때 선택할 값
		// 변수 = (조건식) ? 값1 : 값2;
		MyMath abs3 = new MyMath() {
			
			@Override
			public double calc(double x, double y) {
				return (x > y) ? x - y : y - x;
				 
			}
		};
		System.out.println(abs3.calc(1.0, 2.0));
		
		
		MyMath abs4 = (x, y) -> (x > y) ? x - y: y - x;
		System.out.println(abs4.calc(1.0, 2.0));
		
		// 리턴 값이 없는 추상 메서드 구현
		// 익명 클래스
		Printable printer1 = new Printable() {
			
			@Override
			public void print(String s) {
				System.out.println("Hello, " + s);
				
			}
		};
		printer1.print("Java");
		
		// 람다 표현식
		Printable printer2 = (s) -> {System.out.println("Hello, " + s);};
		printer2.print("자바");
		
	}

}
