package edu.java.inheritance;

// SmartTv 클래스는 BasicTv클래스를 확장한다(상속한다).
public class SmartTv extends BasicTv {
	private String ip;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
