package edu.java.contact.ver05;

import java.io.File;
import java.util.ArrayList;

import java.util.List;

import edu.java.contact.model.Contact;
import static edu.java.contact.fileutil.ContactFileUtil.*; // 모든 static멤버(변수, 메서드)를 import

public class ContactDaoImpl implements ContactDao {
	
	// field(멤버변수)
	private List<Contact> list = new ArrayList<>(); // 연락처 정보를 저장할 리스트.
	private File dataFile;// 연락처 정보 리스트를 저장할 파일.
	private File dataDir; //  연락처 데이터 파일을 가지고 있는 폴더.

	// singleton
	private static ContactDaoImpl instance = null;
	private ContactDaoImpl() {
		// 연락처 정보 리스트를 저장하는 파일 관리 객체 생성.
		dataFile = new File(DATA_DIR, DATA_FILE);
		
		// 현재 작업 디렉토리(CWD)에 (data 폴더가 없으면) data 폴더를 생성.
		dataDir = initializeDataDir();
		
		// data 폴더에 있는 contacts.dat 파일을 읽어서 필드 list를 초기화
		list = initializeData();
		
	}
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
		writeDatatoFile(list, dataFile);
		return 1;
	}

	@Override
	public int update(int index, Contact contact) {
		int result = 0;
		if(index < list.size() && index >= 0) { // 파라미터 index그 배열의 인덱스 범위 안에 있으면
			list.set(index, contact);
			writeDatatoFile(list, dataFile);
			result = 1;
		}
		return result;
	}

	@Override
	public int delete(int index) {
		int result = 0;
		if(index < list.size() && index >= 0) { 
			list.remove(index);
			writeDatatoFile(list, dataFile);
			result = 1;
		}
		return result;
	}

}
