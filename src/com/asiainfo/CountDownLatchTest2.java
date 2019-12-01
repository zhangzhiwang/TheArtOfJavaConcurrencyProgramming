package com.asiainfo;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * CountDownLatch——是一个线程或多个线程等待其他线程完成操作
 * </p>
 * 需求：主线程计算所有其子线程的返回结果的总和。本示例使用CountDownLatch来实现需求。
 *
 * @author zhangzhiwang
 * @date 2019年11月30日 下午1:09:03
 */
public class CountDownLatchTest2 {
	public static void main(String[] args) throws Exception {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		Callable<Integer> myThread = new MyThread(countDownLatch);
		FutureTask<Integer> futureTask1 = new FutureTask<Integer>(myThread);
		FutureTask<Integer> futureTask2 = new FutureTask<Integer>(myThread);
		FutureTask<Integer> futureTask3 = new FutureTask<Integer>(myThread);
		
		Thread t1 = new Thread(futureTask1, "AA");
		Thread t2 = new Thread(futureTask2, "BB");
		Thread t3 = new Thread(futureTask3, "CC");
		t1.start();
		t2.start();
		t3.start();
		
		countDownLatch.await();
		System.out.println(futureTask1.get() + futureTask2.get() + futureTask3.get());
	}

	static class MyThread implements Callable<Integer> {
		private CountDownLatch conDownLatch;

		public MyThread(CountDownLatch conDownLatch) {
			super();
			this.conDownLatch = conDownLatch;
		}

		@Override
		public Integer call() throws Exception {
			Thread.sleep(2000);
			conDownLatch.countDown();
			String threadName = Thread.currentThread().getName();
			if (threadName.contains("AA")) {
				return 1;
			}
			if (threadName.contains("BB")) {
				return 2;
			}
			if (threadName.contains("CC")) {
				return 3;
			}

			return null;
		}
	}
}
