package edu.java.method04;

public class MethodMain04 {

	public static void main(String[] args) {
		// method overloading(메서드 오버로딩):
		// 메서드의 파라미터 개수나 파라미터 타입이 다르면, 같은 이름으로 메서드를 선언할 수 있음.
		// (주의) 메서드의 리턴 타입만 다른 경우에는, 같은 이름으로 메서드를 선언할 수 없음!
		System.out.println(1);  // println(int)
		System.out.println('a');  // println(char)
		System.out.println("Hello");  // println(String)

		sayHello();
		sayHello("오쌤");
		sayHello(16);
		sayHello("오쌤", 16);
	}  // end main()

	public static void sayHello() {
		System.out.println("안녕하세요~");
	}
	
	public static void sayHello(String name) {
		System.out.println("안녕하세요, 저는 " + name + "입니다.");
	}
	
	public static void sayHello(int age) {
		System.out.println("안녕하세요, 제 나이는 " + age + "입니다.");
	}
	
	public static void sayHello(String name, int age) {
		System.out.println("안녕하세요...");
		System.out.println("저는 " + name + "이구요,");
		System.out.println("나이는 " + age + "입니다...");
	}
	
}  // end class
