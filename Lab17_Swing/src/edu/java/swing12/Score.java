package edu.java.swing12;

public class Score {

	// 멤버 변수
	private double korean;
	private double english;
	private double math;
	
	// 생성자
	public Score(double korean, double english, double math){
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	// getters & setters
	
	public double getKorean() {
		return korean;
	}

	public void setKorean(double korean) {
		this.korean = korean;
	}

	public double getEnglish() {
		return english;
	}

	public void setEnglish(double english) {
		this.english = english;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}
	

	
	// 총점 계산 메서드
	public double total() {
		return korean + english + math;
	}
	
	// 평균 계산 메서드
	public double average() {
		return (total() / 3.0);
	}
}
