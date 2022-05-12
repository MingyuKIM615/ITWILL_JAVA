package edu.java.inheritance03;

public class InheritanceMain03 {

	public static void main(String[] args) {
		// 메서드 override
		
		
		// Car 클래스의 인스턴스 생성
		Car car1 = new Car(50);
		car1.drive();
		
		System.out.println();
		
		// ElectricCar 클래스의 인스턴스를 생성
		ElectricCar car2 = new ElectricCar(50, 100);
		car2.drive();
		
		// 다형성(polymorphism): 한나의 인스턴스를 여러가지 타입으로 부를 수 있는 것.
		// 인스턴스를 자식 타입으로 생성하고 , 그 인스턴스를 가리키는 참조 변수를 
		// 자식 타입으로도, 부모 타입으로도 선언할 수 있는 것.
		// line 16의 의미는 "참조 변수 car2는 ElectricCar 이다"
		
		System.out.println();
		
		Car car3 = new ElectricCar(0, 0); // line22의 의미는 "참조 변수 car3는 Car타입이다."
		car3.drive(); // ElectricCar의 (override된) drive 메서드가 실행됨.
		// 실제 인스턴스는 ElectricCar 이지만, 참조 변수를 부모 타입인 Car 라고 선언했기 때문에,
		// 부모 타입의 멤버(변수, 메서드)만 보임!
		// ElectricCar 클래스가 가지고 있는 getCharge, setCharge 메서드가 보이지 않음.
		// 실제로 생성된 인스턴스는 자식 타입의 멤버(변수, 메서드)를 가지고 있기 때문에, 
		// 형변환(casting)을 하면 모든 멤버들을 사용할 수 있음.
		((ElectricCar) car3).setCharge(100);
		
		// upcasting: Sub class 타입의 객체를 생성하고 Super class 타입의 변수에 저장하는 것.
		// downcasting: Super 타입으로 선언된 변수를 Sub 타입으로 "명시적"으로 타입 변환하는 것.
		// line26 - upcasting, line 33 - downcasting
		
		// 다형성을 사용한 배열 생성
		// 배열을 부모(super) 타입으로 선언하면, 부모 타입뿐만 아니라 자식 타입의 객체도 저장할 수 있음.
		
		System.out.println();
		
		Car[] cars = new Car[3];
		cars[0] = new Car(0);
		cars[1] = new ElectricCar(0, 0);
		cars[2] = new ElectricCar(50, 100);
		
		for(Car c : cars) {
			c.drive();
			System.out.println("------");
		}
		
	}

	
	
}
