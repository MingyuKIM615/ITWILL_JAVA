package edu.java.contact.ver02;

import edu.java.contact.model.Contact;

public class ContactDaoImpl implements ContactDao {

	private static int MAX_LENGTH = 3; // 배열의 크기
	
	private Contact[] contactlist = new Contact[MAX_LENGTH]; // 연락처를 저장할 배열
	
	private int count = 0;
	
	// private static으로 자기자신 타입의 변수를 선언.
	private static ContactDaoImpl instance = null;
	
	// 생성자를 private으로 선언
	private ContactDaoImpl() {}
	
	// 생성자 대신에 인스턴스를 생성할 수 있는 public static 메서드를 제공
	public static ContactDaoImpl getInstance() {
		// instance가 null인 겨우에만 생성자를 호출
		if(instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	
	@Override
	public Contact[] select() {
		Contact[] list = new Contact[count];
		for(int i = 0 ;i < count;i++) {
			list[i] = contactlist[i];
		}
		return list;
	}

	@Override
	public Contact select(int index) {
		Contact contact = null;
		if(index >= 0 && index < MAX_LENGTH) {
			contact = contactlist[index];
		}
		return contact;
	}

	@Override
	public int insert(Contact c) {
		int result = 0;
		if(count < MAX_LENGTH) {// 배열에 저장된 원소의 개수가 배열 크기보다 작으면
			contactlist[count] = c; // 배열에 저장된 가장 마지막 원소 바로 뒤에 전달받은 연락처를 추가
			count++; // 배열의 원소 개수를 증가
			result = 1; // 새 연락처 추가 결과를 성공(1)으로 설정
		}
		return result;
	}

	@Override
	public int update(int index, Contact contact) {
		int result = 0;
		if(index>=0 && index < count) {
			contactlist[index] = contact;
			result = 1;
		}
		return result;
	}

}
