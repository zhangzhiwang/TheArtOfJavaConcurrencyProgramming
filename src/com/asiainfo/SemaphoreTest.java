package com.asiainfo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

/**
 * Semaphore——控制访问共享资源的线程数量
 *
 * @author zhangzhiwang
 * @date 2019年11月30日 下午3:54:52
 */
public class SemaphoreTest {
	private static volatile int num = 100;

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(3);// 最多只能允许3个线程访问共享资源

		for (int i = 0; i < 10; i++) {
			Callable<Integer> callable = new A(semaphore);
			FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
			Thread t = new Thread(futureTask);
			t.start();
		}
		
		Thread.sleep(100);
		System.out.println(semaphore.availablePermits());// 具体详见课本p197
//		for(int i = 0; i < 10; i++) {
//			System.out.println(semaphore.hasQueuedThreads());
//			System.out.println(semaphore.getQueueLength());
//			Thread.sleep(1000);
//		}
	}

	static class A implements Callable<Integer> {
		private Semaphore semaphore;

		public A(Semaphore semaphore) {
			super();
			this.semaphore = semaphore;
		}

		public Integer call() throws Exception {
			semaphore.acquire();// 获取“许可证”
			int i = num;// 访问共享资源
			Thread.sleep(100000);
			semaphore.release();// 释放“许可证”
			return i;
		}
	}
}
