package edu.java.interface03;

public class InterfaceMain03 {

	public static void main(String[] args) {
		// Customer 인스턴스 생성
		Customer customer1 = new Customer();
		customer1.buy();
		customer1.sell();
		
		System.out.println();
		
		Buyer customer2 = new Customer(); // 다형성(polymorphism)
		customer2.buy();
		// 생성된 인스턴스는 Customer 타입이지만 참조 변수 선언을 Buyer로 했기 때문에, Buyer 인터페이스의 메서드만 사용 가능.
		// 강제 타입 변환(casting)을 사용하면 Seller 인터페이스의 메서드도 사용 가능.
		if(customer2 instanceof Customer) {
			((Customer) customer2).sell();
		}
		
		if (customer2 instanceof Seller) {
			((Seller) customer2).sell();
		}

		System.out.println();
		
		Customer customer3 = new Customer();
		customer3.order();
	}

} // end class InterfaceMain03

// 상위 클래스 상속(extends)과 인터페이스 구현(implements)를 동시에 하는 경우:
class SuperClass{}
interface MyInterface {}
class SubClass extends SuperClass implements MyInterface{}

// 2개 이상의 인터페이스를 구현하는 경우:
interface Buyer{
	void buy();
	
	// 다른 인터페이스에서 같은 signature(리턴 타입, 이름, 파라미터)를 갖는 default 메서드가 있는 경우
	default void order() {
		System.out.println("구매자 주문...");
	}
}// end interface Buyer

interface Seller{
	void sell();
	
	default void order(){
		System.out.println("판매자 주문...");
	}
} // end interface Seller

// 2 개이상의 인터페이스를 구현하는 클래스에서 default 메서드 이름이 중복되는 문제를 override로 해결해야 함.
class Customer implements Buyer, Seller{

	@Override // Seller 인터페이스의 추상 메서드를 구현
	public void sell() {
		System.out.println("판매...");
		
	}

	@Override // Buyer 인터페이스의 추상 메서드를 구현
	public void buy() {
		System.out.println("구매...");
		
	}

	@Override
	public void order() {
		// TODO Auto-generated method stub
		Buyer.super.order(); // Buyer 인터페이스의 order 메서드를 사용.
		Seller.super.order(); // Seller 인터페이스의 order 메서드를 사용.
		System.out.println("Customer order 완료...");
	}
	
}