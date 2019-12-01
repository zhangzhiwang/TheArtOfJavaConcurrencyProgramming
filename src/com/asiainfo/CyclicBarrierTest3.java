package com.asiainfo;

import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

/**
 * CyclicBarrier
 *
 * @author zhangzhiwang
 * @date 2019年11月30日 下午2:30:46
 */
public class CyclicBarrierTest3 {
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

		A a1 = new A(cyclicBarrier);
		a1.start();
		a1.interrupt();
//		A a2 = new A(cyclicBarrier);
//		a2.start();

		Thread.sleep(10);
		System.out.println(cyclicBarrier.getNumberWaiting());
		System.out.println(cyclicBarrier.isBroken());
		System.out.println("--------");
		cyclicBarrier.await();
		System.out.println(cyclicBarrier.isBroken());
	}

	static class A extends Thread {
		private CyclicBarrier cyclicBarrier;

		public A(CyclicBarrier cyclicBarrier) {
			super();
			this.cyclicBarrier = cyclicBarrier;
		}

		public void run() {
			try {
				cyclicBarrier.await();
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
	}
}
