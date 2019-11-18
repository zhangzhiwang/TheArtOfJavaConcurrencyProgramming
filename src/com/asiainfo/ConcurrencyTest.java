package com.asiainfo;

public class ConcurrencyTest {
	public static long count = 1000;// 当循环次数很少时多线程可能比单线程慢，循环次数越大多线程的优势越明显

	public static void main(String[] args) throws InterruptedException {
		met1();
		met2();
	}

	public static void met1() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				long l = 0;
				for (int i = 0; i < count; i++) {
					l++;
				}
			}
		});
		thread.start();

		long l2 = 0;
		for (int i = 0; i < count; i++) {
			l2--;
		}
		thread.join();

		long end = System.currentTimeMillis();
		System.out.println("多线程耗时：" + (end - start));
	}

	public static void met2() {
		long start = System.currentTimeMillis();
		long l = 0;
		for (int i = 0; i < count; i++) {
			l++;
		}

		long l2 = 0;
		for (int i = 0; i < count; i++) {
			l2--;
		}

		long end = System.currentTimeMillis();
		System.out.println("	单线程耗时：" + (end - start));
	}
}
