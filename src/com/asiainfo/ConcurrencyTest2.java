package com.asiainfo;

public class ConcurrencyTest2 extends Thread {
	public static void main(String[] args) {
		ConcurrencyTest2 t1 = new ConcurrencyTest2();
		t1.setName("T_1");
		t1.start();
		ConcurrencyTest2 t2 = new ConcurrencyTest2();
		t2.setName("T_2");
		t2.start();
	}
	
	public void run() {
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block											         
				e.printStackTrace();
			}
		}
	}
}
