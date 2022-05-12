package edu.java.file12;

import java.io.File;

public class FileMain12 {

	public static void main(String[] args) {
		// 파일, 디렉토리(폴더) 관리 - 정보, 생성, 삭제, ... 

		// System.getProperty(string): Java Runtime이 실행 중인 컴퓨터의 여러가지 (시스템) 정보들을 리턴.
		// user.dir : 현재 작업 디렉토리(폴더). CWD(Current Working Directory).
		String cwd = System.getProperty("user.dir");
		System.out.println(cwd);
		
		// user.home : OS에 로그인한 사용자(User)의 기본(홈) 디렉토리(폴더).
		String home = System.getProperty("user.home");
		System.out.println(home);

		// 디렉토리 구분자(separator) : 
		// (1) MS-Windows : \
		// (2) Linux, MacOs, Unix, Android, IOS, ... : /
		// File.separator 필드를 사용하면, Java 프로그램이 실행되는 환경에 맞춰서 \ 또는 /가 자동으로 선택됨.
		
		// 절대 경로(absolute path):
		// 시스템의 루트(root, C:\, /)부터 시작해서 전체 경로 이름을 사용하는 방법.
		// (예) C:\study\lab_java\Lab14_File
		// (예) /Users/gildong/workspace/proj1/src/Main.java
		
		// 상대 경로(relative path):
		// 현재 작업 디렉토리(CWD)를 기준으로 파일(폴더)가 있는 위치를 찾아가는 방법.
		// (예) data\test.txt
		// (예) src/Main.java
		// . : 현재 디렉토리(폴더)
		// .. : 상위 디렉토리(폴더)
		// (예) .\data\test.txt, ..\Lab13_Collection
		
		// File 클래스 : 파일(txt, jpg, mp4, ppt, java,....)과 디렉토리(폴더)를 관리할 수 있는 클래스.
		// Windows : "data\\test.txt", MacOS:"data/test.txt"
		File f1 = new File("data" + File.separator + "test.txt"); // 상대 경로로 생성
		System.out.println("file : " + f1);
		System.out.println("절대 경로 : " + f1.getAbsolutePath());
		System.out.println("경로 : " + f1.getPath());
		// 파일 객체를 생성할 때 상대 경로를 사용해서 생성한 경우에는, getPath 메서드는 상대 경로를 리턴함.
		System.out.println("파일 이름 : " + f1.getName());
		System.out.println("존재 여부 : " + f1.exists());
		System.out.println("디렉토리 여부:" + f1.isDirectory());
		System.out.println("파일 여부" + f1.isFile());
		System.out.println("파일 크기 : " + f1.length());
		
		System.out.println();
		
		File f2 = new File("C:" + File.separator + "study"+ File.separator +"test.txt"); // 절대 경로로 생성
		System.out.println("file : " + f2);
		System.out.println("절대 경로 : " + f2.getAbsolutePath());
		System.out.println("경로 : " + f2.getPath());
		// 파일 객체를 생성할 때 절대 경로를 사용해서 생성한 경우에는, getPath 메서드는 절대 경로를 리턴함.
		System.out.println("존재 여부 : " + f2.exists());
		
		System.out.println();
		// 폴더 아래의 파일과 폴더 정보 출력
		String parent = System.getProperty("user.dir"); // 상위 디렉토리
		String child = "data"; // 하위 디렉토리
		File dir = new File(parent, child); // 파일 객체 생성
		System.out.println(dir);
		File[] files = dir.listFiles(); // 폴더(디렉토리) 안에 있는 File 객체들의 배열을 리턴.
		for(File f : files) {
//			System.out.println(f);
			String fname = f.getName();
			if(f.isFile()) {
				fname += "\t" + f.length() + "bytes";
			}else {
				fname += "\t <DIR>";
			}
			System.out.println(fname);
		}
		
		System.out.println();
		
		// 디렉토리(폴더) 생성과 삭제
		File newFolder = new File("data", "test123");
		if(!newFolder.exists()) { // 디렉토리가 존재하지 않으면
			newFolder.mkdir(); // make directory
			System.out.println("디렉토리 생성 성공");
			
		}else {
			System.out.println("디렉토리가 이미 존재합니다.");
		}
		
		if(newFolder.exists()) { // 디렉토리가 존재하면
			newFolder.delete();
			System.out.println("삭제 성공");
		}else {
			System.out.println("디렉토리가 존재하지 않습니다.");
		}
	}

}
