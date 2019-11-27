package com.asiainfo;

public class InterruptTest {
	public static void main(String[] args) throws InterruptedException {
		ThreadA threadA = new ThreadA();
		threadA.start();
		Thread.sleep(3000);
		threadA.interrupt();
		System.out.println(threadA.isInterrupted());
	}
	
	static class ThreadA extends Thread {
		public void run() {
			try {
				Thread.sleep(2000);
				System.out.println("end!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
