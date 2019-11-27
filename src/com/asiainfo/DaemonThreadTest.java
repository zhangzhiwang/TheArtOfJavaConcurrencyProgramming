package com.asiainfo;

public class DaemonThreadTest {
	public static void main(String[] args) throws InterruptedException {
		// 守护线程是一种支持型线程，它的存在主要是支持别的线程运行，为其他线程提供服务的线程
		DeamonThread deamonThread = new DeamonThread();// 一个线程创建了另一个线程，该线程为被创建线程的父线程，可以查看Thread类的init源码
//		deamonThread.setDaemon(true);// 这只守护线程必须在start之前
//		deamonThread.setPriority(Thread.NORM_PRIORITY);
		deamonThread.start();
		
//		Thread.sleep(1000);
//		System.out.println(deamonThread.isDaemon());
//		System.out.println(deamonThread.getPriority());
	}

	static class DeamonThread extends Thread {
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println("end!");// 守护线程的finally不一定执行
			}
		}
	}
}
