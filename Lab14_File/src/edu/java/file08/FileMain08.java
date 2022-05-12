package edu.java.file08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain08 {
	private static final String FILE_NAME = "student_list.dat";
	public static void main(String[] args) {
		Random rand = new Random();
		
		// TODO 1: ArrayList<Student>를 생성
		// 1. ArrayList에 Student 객체 5개를 추가
		// ArrayList를 파일에 write (Serialize)
		// ObjectOutputStream ==> BufferedOutputStream==> FileOutputStream == > 파일
		ArrayList<Student> list = new ArrayList<>();
		Score score1 = new Score(50, 50, 100);
		Student stu1 = new Student(1, "aaa", score1);
		Student stu2 = new Student(2, "bbb", new Score(100, 20, 30));
		list.add(stu1);
		list.add(stu2);
		
		for(int i = 0; i<3; i++) {
			Score score = new Score(rand.nextInt(101), rand.nextInt(101), rand.nextInt(101));
			Student stu = new Student(rand.nextInt(100), "학생" + i, score);
			list.add(stu);
		}
		
		try (FileOutputStream out = new FileOutputStream(FILE_NAME);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				ObjectOutputStream oos = new ObjectOutputStream(bout);){
			
			oos.writeObject(list);
			System.out.println("성공");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		// TODO 2: 1번에서 저장된 파일에서 객체 read
		// 객체를 ArrayList로 타입 변환
		// ArrayList에 저장된 원소들을 모두 출력
		// ObjectInputStream <== BufferedInputStream <== FileInputStream <== 파일
		try(FileInputStream in = new FileInputStream(FILE_NAME);
				BufferedInputStream bin = new BufferedInputStream(in);
				ObjectInputStream ois = new ObjectInputStream(bin);){
			
			Object obj = ois.readObject();
			if(obj instanceof ArrayList<?>) {
				ArrayList<Student> student = (ArrayList<Student>) obj;
				// -> 만약 타입 변환이 실패하면 예외(exception)이 발생하고, catch 구문에서 처리할 수 있음.
				for(Student s : student) {
					System.out.println(s);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
