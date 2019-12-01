package com.asiainfo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

/**
 * CyclicBarrier——字面意思是循环屏障，构造方法里面有个int类型的参数，用来表示需要拦截的线程数量。CyclicBarrier用来阻塞指定数量的线程，当每个线程调用CyclicBarrier的await方法时告诉CyclicBarrier“我已到达屏障”，然后该线程阻塞，直到最后一个线程到达屏障时之前所有被CyclicBarrier阻塞的线程才会继续运行。
 *
 * @author zhangzhiwang
 * @date 2019年11月30日 下午2:30:46
 */
public class CyclicBarrierTest {
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new A());// 必须有第三个线程调用CyclicBarrier的await方法才能使之前调用过CyclicBarrier#await()方法的线程恢复
		Callable<Integer> myThread1= new MyThread(cyclicBarrier);
		Callable<Integer> myThread2 = new MyThread(cyclicBarrier);
		FutureTask<Integer> futureTask1 = new FutureTask<Integer>(myThread1);
		FutureTask<Integer> futureTask2 = new FutureTask<Integer>(myThread2);
		
		Thread t1 = new Thread(futureTask1, "ta");
		t1.start();
		Thread t2 = new Thread(futureTask2, "tb");
		t2.start();
		
		cyclicBarrier.await();// 如果注掉本行代码，则t1会让t2永远也不会恢复，因为没有第三个线程调用CyclicBarrier#await()方法
		System.out.println(Thread.currentThread().getName());
	}

	static class MyThread implements Callable<Integer> {
		private CyclicBarrier cyclicBarrier;

		public MyThread(CyclicBarrier cyclicBarrier) {
			super();
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public Integer call() throws Exception {
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName());
			return null;
		}
	}
	
	static class A extends Thread {
		public void run() {
			System.out.println("AAAAA");
		}
	}
}
