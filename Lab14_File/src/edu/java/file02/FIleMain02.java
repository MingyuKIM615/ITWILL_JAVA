package edu.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIleMain02 {

	public static void main(String[] args) {
		// overloading되어 있는 read, write - 여러개의 바이트를 한번에 읽고 쓰기.
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("data/test.txt");
			out = new FileOutputStream("data/test_copy2.txt");
			
			while(true) {
				// 파일에서 읽은 데이터들을 저장하기 위한 배열
				byte[] buffer = new byte[20]; // 20바이트를 저장할 수 있는 배열 생성
				// read(byte[] b) : 파일에서 읽은 데이터를 b에 저장하고, 실제로 읽은 바이트 수를 리턴.
				int result = in.read(buffer);
				if(result == -1) { // 파일에서 더이상 읽을 데이터가 없을 때(파일 끝)
					break; // 무한 루프 종료
				}
				System.out.println(result + "바이트 읽음.");
//				out.write(buffer); // 파일에 20바이트씩 쓰기(write)
				// write(byte[]b, int off, int len) -> 읽은 바이트만큼 쓰기
				// - byte[]b : 파일 쓸 데이터가 저장된 배열
				// - int off :  배열 b에서 몇번째 인덱스부터 쓰기 시작할 것인 지(offset)
				// - int len :  off부터 시작해서 몇 바이트를 쓸 것인 지
				out.write(buffer, 0, result);
				// 읽은 바이트만큼 쓰기
			}
			System.out.println("파일 복사 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
