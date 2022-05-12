package edu.java.contact.ver04;

import java.util.List;
import java.util.Scanner;
import static edu.java.contact.menu.MainMenu.*;

import edu.java.contact.model.Contact;


// MVC 아키텍쳐에서 view에 해당하는 클래스. UI를 담당.
public class ContactMain04 {
	private static Scanner scanner = new Scanner(System.in);
	private static ContactDao dao = ContactDaoImpl.getInstase();
	// super타입 변수 = new sub타입(); -> 다형성(polymorphism) -> 코드의 재사용성을 높임.

	public static void main(String[] args) {

		System.out.println("*** 연락처 프로그램 ver 0.3 ***");

		boolean run = true;
		while (run) {
			int menu = chooseMenu();

			switch (menu) {

			case QUIT:
				run = false;
				break;
			case SELECT_ALL:
				selectAllContacts();
				break;
			case SELECT_BY_INDEX:
				selectContactByIndex();
				break;
			case INSERT:
				insertNewContact();
				break;
			case UPDATE:
				updateContactInfo();
				break;
			case DELETE:
				deletContactByIndex();
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요...");

			}

		}
		System.out.println("*** 프로그램 종료. ***");
	}

	private static void deletContactByIndex() {
		System.out.println();
		System.out.println("---- 연락처 정보 삭제 ----");
		System.out.println("삭제할 인덱스 >>>");
		int index = inputInteger();
		int result = dao.delete(index);
		if(result == 1) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}

	private static void updateContactInfo() {
		System.out.println();
		System.out.println("---- 연락처 업데이트 ----");
		System.out.println("변경할 인덱스>>>");
		
		int idx = inputInteger();

		System.out.println("변경할 이름을 입력>>>");
		String name = scanner.nextLine();
		System.out.println("변경할 전화번호를 입력>>>");
		String phone = scanner.nextLine();
		System.out.println("변경할 이메일을 입력>>>");
		String email = scanner.nextLine();

		Contact contact = new Contact(name, phone, email);

		int result = dao.update(idx, contact);

		if (result == 1) {
			System.out.println("업데이트 성공!!!");
		} else {
			System.out.println("업데이트 실패...");
		}

	}

	private static void insertNewContact() {
		System.out.println();
		System.out.println("---- 연락처 추가 ----");
		System.out.println("이름을 입력>>>");
		String name = scanner.nextLine();
		System.out.println("전화번호를 입력>>>");
		String phone = scanner.nextLine();
		System.out.println("이메일을 입력>>>");
		String email = scanner.nextLine();

		Contact c = new Contact(name, phone, email);
		int result = dao.insert(c);

		if (result == 1) {
			System.out.println("연락처 추가 성공!!");
		} else {
			System.out.println("연락처 추가 실패...");
		}

	}

	private static void selectContactByIndex() {
		System.out.println();
		System.out.println("---- 인덱스 검색 기능 ----");
		System.out.println("검색할 인덱스>>>");
		
		int index = inputInteger(); 

		// Controller의 메서드를 사용
		Contact list = dao.select(index);
		// 결과를 출력
		if (list != null) {
			System.out.println(list);
		} else {
			System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
		}

	}

	private static void selectAllContacts() {
		System.out.println();
		System.out.println("---- 연락처 전체 리스트 ----");

		List<Contact> list = dao.select();

		for (Contact c : list) {
			System.out.println(c);
		}

	}

	private static int chooseMenu() {
		showMainMenu();
		int menu = inputInteger();
		return menu;
	}
	
	private static int inputInteger() {
		while(true) {
		String s = scanner.nextLine();
		try {
			int n = Integer.parseInt(s);
			return n;
		}catch(NumberFormatException e){
			System.out.println("입력한 값은 정수가 아닙니다. 다시 입력하세요>>");
		}
		}
	}

	private static void showMainMenu() {
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("[1] 전체 검색 [2] 인덱스 [3] 추가 [4] 수정 [5] 삭제 [0] 종료");
		System.out.println("------------------------------------------------------------");
		System.out.println("선택>>>");

	}

}
