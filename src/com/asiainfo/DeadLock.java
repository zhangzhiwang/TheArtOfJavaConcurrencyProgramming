package com.asiainfo;

public class DeadLock {
	private static Object o1 = new Object();
	private static Object o2 = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o1) {
					try {
						Thread.sleep(Integer.MAX_VALUE);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					synchronized (o2) {
						System.out.println("线程1获取了第二个锁");
					}
				}
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o2) {
					try {
						Thread.sleep(Integer.MAX_VALUE);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					synchronized (o2) {
						System.out.println("线程2获取了第二个锁");
					}
				}
			}
		});
		t2.start();
	}
}
