package com.asiainfo;

import java.util.Map.Entry;
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
public class CyclicBarrierTest2 {
	private static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();

	public static void main(String[] args) throws Exception {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new B());

		for (int i = 0; i < 3; i++) {
			Callable<Integer> myThread = new MyThread(cyclicBarrier);
			FutureTask<Integer> futureTask = new FutureTask<Integer>(myThread);
			Thread t = new Thread(futureTask);
			t.start();
		}
	}

	static class MyThread implements Callable<Integer> {
		private CyclicBarrier cyclicBarrier;

		public MyThread(CyclicBarrier cyclicBarrier) {
			super();
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public Integer call () throws Exception {
			concurrentHashMap.put(Thread.currentThread().getName(), 1);
			cyclicBarrier.await();
			return 1;
		}
	}

	static class B extends Thread {
		public void run() {
			int result = 0;
			for (Entry<String, Integer> entry : concurrentHashMap.entrySet()) {
				result += entry.getValue();
			}
			System.out.println(result);
		}
	}
}
