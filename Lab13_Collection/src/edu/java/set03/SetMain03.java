package edu.java.set03;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetMain03 {

	public static void main(String[] args) {
		// 정수(Integer)를 저장할 수 있는 HashTree을 생성
		Set<Integer> num = new HashSet<>();
		
		// 0 이상 9이하의 서로 다른 정수를 난수 5개를 저장.
		Random rand = new Random();
		while(true) {
			int r = rand.nextInt(10);
			System.out.println(r);
			num.add(r);
			System.out.println(num);
			
			if(num.size() == 5) {
				break;
			}
			
			
		}
	}

}
