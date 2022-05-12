package edu.java.contact.ver02;

import java.util.Scanner;

import edu.java.contact.model.Contact;
import static edu.java.contact.ver02.MainMenu.*;

// MVC 아키텍쳐에서 view에 해당하는 클래스. UI를 담당.
public class ContactMain02 {
	private static Scanner scanner = new Scanner(System.in);
	private static ContactDao dao = ContactDaoImpl.getInstance();
	// super타입 변수 = new sub타입(); -> 다형성(polymorphism) -> 코드의 재사용성을 높임.

	public static void main(String[] args) {

		System.out.println("*** 연락처 프로그램 ver 0.2 ***");

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
			default:
				System.out.println("메뉴를 다시 선택하세요...");

			}

		}
		System.out.println("*** 프로그램 종료. ***");
	}

	private static void updateContactInfo() {
		System.out.println();
		System.out.println("---- 연락처 업데이트 ----");
		System.out.println("변경할 인덱스>>>");
		String s = scanner.nextLine();
		int idx = Integer.parseInt(s);

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
		String s = scanner.nextLine();
		int index = Integer.parseInt(s);

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

		Contact[] list = dao.select();

		for (Contact c : list) {
			System.out.println(c);
		}

	}

	private static int chooseMenu() {
		showMainMenu();
		String s = scanner.nextLine();
		int menu = Integer.parseInt(s);
		return menu;
	}

	private static void showMainMenu() {
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println("[1] 전체 검색 [2] 인덱스 [3] 추가 [4] 수정 [0] 종료");
		System.out.println("---------------------------------------------------");
		System.out.println("선택>>>");

	}

}
