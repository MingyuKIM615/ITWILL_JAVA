package edu.java.exception01;

// 오류(error) vs 예외(exception)
// 오류(error)의 종류
// 1. compile error: 문법적인 오류. 소스 코드를 class 파일로 변환 불가능. -> 반드시 수정
// 2. out-of-memory(OOM) error: 컴퓨터의 메모리가 부족해서 발생하는 에러. -> 수정 불가능
// 3. 논리적인 오류: 프로그램은 정상적으로 실행/종료가 되는데, 원하는 결과가 나오지 않는 경우. -> 반드시 수정. 힘듦.
// 4. 예외(exception): 프로그램이 실행 중에 발생할 수 있는 비정상적인 상황 -> 반드시 수정.
//    (1) if-else 구문
//    (2) try-catch 구문

public class ExceptionMain01 {

	public static void main(String[] args) {
		System.out.println();
		String s = "ㅁㅁㅁㄴ";
		// if-else 구문을 사용해서 null인 경우와 null이 아닌 경우에 따라서 다르게 코딩하므로써 예외를 처리할 수 있다.
		if (s != null) {
			System.out.println("문자열 길이 = " + s.length());
		} else {
			System.out.println("문자열이 생성되어 있지 않습니다.");
		}

		int x = 123;
		int y = 0;
		// if-else 구문을 사용해서 나누는 수 y가 0일 때와 0이 아닐 때를 다르게 코딩해서 예외를 처리할 수 있다.
		if (y != 0) {
			System.out.println("몫 = " + (x / y));
		} else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}

}
