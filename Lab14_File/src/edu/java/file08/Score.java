package edu.java.file08;

import java.io.Serializable;

public class Score implements Serializable{
	// field
	private int korean;
	private int english;
	private int math;
	
	// constructor - 기본 생성자, 파라미터 3개(int, int, int)를 갖는 생성자
	public Score() {}
	
	public Score(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	// getters & setters
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	
	// toString 메서드 override
	@Override
	public String toString() {
		return "Score{Korean : " + this.korean + ", English : " + this.english + ", Math : " + this.math + "}";
	}
	
	
}
