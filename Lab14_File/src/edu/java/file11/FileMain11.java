package edu.java.file11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileMain11 {

	public static void main(String[] args) {
		// Writer 객체들을 사용한 파일 쓰기
		// BufferedWriter ==> OutputStreamWriter==> FileOutputStream ==> File
		try(FileOutputStream out = new FileOutputStream("data/writer_test.txt");
				OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
				BufferedWriter bw = new BufferedWriter(osw);){
			bw.write("Hello, Java!");
			bw.newLine(); // 줄 바꿈.
			bw.write("안녕, 자바...");
			bw.newLine();
			bw.write("123 456 789 0");
			bw.newLine();
			
			System.out.println("파일 작성 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 위에서 작성된 파일을 읽기
		// BufferedReader <== InputStreamReader <== FileInputStream <== File
		// BufferedReader 클래스의 readLine() 메서드를 사용해서 한 줄씩 읽기
		try(FileInputStream in = new FileInputStream("data/writer_test.txt");
				InputStreamReader reader = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(reader);){
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
