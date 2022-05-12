package edu.java.list03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMain03 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// 기본생성자(default constructor)를 사용해서 Member 클래스의 인스턴스를 생성
		Member m1 = new Member(); // toString() 메서드를 voerride하기 전/후의 결과 비교
		System.out.println(m1);
		
		// getter : 멤버 변수(필드)의 값을 가져옴(읽어옴).
		System.out.println("m1.memberId : " + m1.getMemberId());
		System.out.println("m1.memberPassword : " + m1.getMemberPassword());
		
		//setter : 멤버 변수(필드)의 값을 설정.
		m1.setMemberPassword("abcd");
		System.out.println("m1.memberPassword : " + m1.getMemberPassword());
		
		// 파라미터를 갖는 생성자를 사용해서 Member 클래스의 인스턴스를 생성
		Member m2 = new Member("guest", "huest1234");
		System.out.println("m2 : " + m2);
		
		System.out.println();
		
		// Member 타입을 저장할 수 있는 ArrayList를 생성
		List<Member> member = new ArrayList<>(); // 생성자를 호출할 때는 ArrayList가 저장하는 타입을 생략할 수 있음.
		System.out.println(member);
		
		// 반복문을 사용해서
		// 아이디와 비밀번호를 입력받아서 Member 객체를 생성해서
		// ArrayList에 Member 타입 객체 3개를 추가
		for (int i = 0; i < 3; i++) {
			System.out.println("ID 입력>>>");
			String id = scanner.nextLine();
			System.out.println("Password 입력>>>");
			String pass = scanner.nextLine();
			// Member. 객체 생성
			Member m = new Member(id, pass);
			//Member 객체 추가
			member.add(m);
		}

		// 리스트의 내용을 출력 - 각각의 회원의 아이디와 비밀번호가 출력될 수 있도록(toString override테스트)
		for(Member m : member) {
			System.out.println(m);
		}

		// 인덱스 0 위치의 회원 정보 중에서 비밀번호를 변경하고 리스트 내용을 출력
		Member m0 = member.get(0);// (1) 인덱스 0 위치의 회원 정보를 찾음. 
		m0.setMemberPassword("123");//(2) 그 회원의 비번을 설정(setter).
		System.out.println(member);
		
		// member.get(0).setMemberPassword("123"); // 메서드 연쇄 호출(chain call)

		// 인덱스 1 위치의 회원 정보를 삭제하고 리스트 내용을 출력
		member.remove(1);
		System.out.println(member);

		// 아이디가 일치하면 같은 회원으로 간주되도록 Member 클래스를 수정 - equals, hashCode
		// 아이디가 일치하는 회원을 리스트에서 삭제하고 리스트 내용을 출력 - list.remove(Object value)
		Member m = new Member("aaa", "111"); // 삭제하려고 하는 회원 정보
		/*
		 for(int i = 0; i<member.size(); i++) { // 인덱스 0 부터 마지막 원소까지 반복하면서
			Member m3 = member.get(i); // 인덱스 위치에 있는 원소를 가져옴.
			if( m3.getMemberId().equals(m.getMemberId()) ) { // 리스트에 저장된 회원 아이디와 
				                                             // 삭제하려고 하는 회원 아이디가 같다면
				member.remove(i);// 리스트에서 그 인덱스의 원소를 삭제.
				break; // 반복문을 종료.
			}
		}
		*/
		member.remove(m);
		System.out.println(member);
	}

}
