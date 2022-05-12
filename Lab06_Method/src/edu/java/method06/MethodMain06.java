package edu.java.method06;

public class MethodMain06 {

	public static void main(String[] args) {
		// main 메서드: JRE(Java 실행 환경)이 프로그램을 실행할 때 가장 먼저 호출하는 메서드.
		// main 메서드의 파라미터 args: JRE가 프로그램에게 전달하는 값(argument)
		// Eclipse 메뉴 -> Run -> Run Configurations -> Arguments 탭 -> Program arguments 
		// -> 값들을 공백으로 구별해서 입력 -> Run

		System.out.println("argument 개수: " + args.length);
		for (String x : args) {
			System.out.println(x);
		}
	}

}
