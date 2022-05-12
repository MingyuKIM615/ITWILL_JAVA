package edu.java.lambda03;

public class Calculator {

	@FunctionalInterface
	interface Calculable{
		double calcuate(double x, double y);
	}
	
	public double calculate(double x, double y, Calculable calc) {
		return calc.calcuate(x, y);
	}
}
