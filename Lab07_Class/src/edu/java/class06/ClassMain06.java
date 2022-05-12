package edu.java.class06;

public class ClassMain06 {

	public static void main(String[] args) {
		// 계좌번호 114, 잔액 : 100 계좌 생성
		Account ac1 = new Account(123456, 1000);
		ac1.info();

		System.out.println();

		Account ac2 = new Account(123789, 1000);
		ac2.info();

		// ac1에 10,000원 입금
		ac1.deposit(10000);
		ac1.info();

		// ac1에 3,000원 cnfrma
		ac1.withdraw(3000);
		ac1.info();
		
		System.out.println();
		
		//ac1에서 ac2에게 5000원 이체
		ac1.transfer(5000, ac2);
		ac1.info();
		ac2.info();
	}

}
