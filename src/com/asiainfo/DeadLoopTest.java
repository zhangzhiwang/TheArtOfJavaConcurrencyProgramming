package com.asiainfo;

/**
 * 死循环，使用top和jstack命令查看
 *
 * @author zhangzhiwang
 * @date Dec 3, 2019 5:42:31 PM
 */
public class DeadLoopTest extends Thread {
	private DeadLoopTest deadLoopTest;

	public DeadLoopTest(DeadLoopTest deadLoopTest) {
		super();
		this.deadLoopTest = deadLoopTest;
	}

	public DeadLoopTest() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {
//		for(int i = 0; i < Integer.MAX_VALUE; i++) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					double d = Double.MAX_VALUE / Math.random(); 
//				}
//			}, "MyThread_" + i).start();
//		}
//		Thread.sleep(Integer.MAX_VALUE);
		DeadLoopTest deadLoopTest = new DeadLoopTest();
		Thread t1 = new DeadLoopTest(deadLoopTest);
		t1.setName("My_A");
		t1.start();

		Thread t2 = new DeadLoopTest(deadLoopTest);
		t2.setName("My_B");
		t2.start();
	}

	public void met1() {
		synchronized (deadLoopTest) {
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(Integer.MAX_VALUE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void run() {
		met1();
	}
}
