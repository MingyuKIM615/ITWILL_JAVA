package edu.java.contact.ver03;

import java.util.ArrayList;

import java.util.List;

import edu.java.contact.model.Contact;

public class ContactDaoImpl implements ContactDao {
	
	// field(멤버변수)
	private List<Contact> list = new ArrayList<>(); // 연락처 정보를 저장할 리스트.

	// singleton
	private static ContactDaoImpl instance = null;
	private ContactDaoImpl() {}
	public static ContactDaoImpl getInstase() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Contact> select() {
		return list;
	}

	@Override
	public Contact select(int index) {
		Contact result = null;
		if (list.size() > index && index >= 0) { // 파라미터 index가 리스트의 인덱스 범위 안에 있으면
			result = list.get(index);
		} 
		return result;
	}

	@Override
	public int insert(Contact c) {
		list.add(c);
		return 1;
	}

	@Override
	public int update(int index, Contact contact) {
		int result = 0;
		if(index < list.size() && index >= 0) { // 파라미터 index그 배열의 인덱스 범위 안에 있으면
			list.set(index, contact);
			result = 1;
		}
		return result;
	}

	@Override
	public int delete(int index) {
		int result = 0;
		if(index < list.size() && index >= 0) { 
			list.remove(index);
			result = 1;
		}
		return result;
	}

}
