package edu.java.inner02;


public class TestwithInner {
	private int count;
	
	public class Counter{
		private Counter() {}
		
		public void addCount() {
			count++;
		}
		
		public void printCount() {
			System.out.println("count = " + count);
		}
	}
	
	public Counter getCounter() {
		return new Counter();
	}	
}
