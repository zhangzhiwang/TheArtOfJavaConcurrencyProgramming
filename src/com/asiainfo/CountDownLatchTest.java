package com.asiainfo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * CountDownLatch——是一个线程或多个线程等待其他线程完成操作
 * </p>
 * 需求：主线程计算所有其子线程的返回结果的总和。本示例使用join方法来实现需求，CountDownLatchTest2将使用CountDownLatch来实现本需求。
 *
 * @author zhangzhiwang
 * @date 2019年11月30日 下午1:09:03
 */
public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyThread myThread = new MyThread();
		FutureTask<Integer> futureTask1 = new FutureTask<Integer>(myThread);
		FutureTask<Integer> futureTask2 = new FutureTask<Integer>(myThread);
		FutureTask<Integer> futureTask3 = new FutureTask<Integer>(myThread);
		Thread thread1 = new Thread(futureTask1, "AA");
		thread1.start();
		Thread thread2 = new Thread(futureTask2, "BB");
		thread2.start();
		Thread thread3 = new Thread(futureTask3, "CC");
		thread3.start();

		thread1.join();
		int i1 = futureTask1.get();
		thread2.join();
		int i2 = futureTask2.get();
		thread3.join();
		int i3 = futureTask3.get();

		System.out.println(i1 + i2 + i3);
	}

	static class MyThread implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			Thread.sleep(2000);
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
