package com.asiainfo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Executor框架
 *
 * @author zhangzhiwang
 * @date 2019年12月1日 下午2:06:36
 */
public class ExecutorTest2 extends Thread {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		// Executors可以创建三种ThreadPoolExecutor
		// 1、创建固定线程数的线程池
		ExecutorService executorService1 = Executors.newFixedThreadPool(10);
		// 2、创建单个线程的线程池
		ExecutorService executorService2 = Executors.newSingleThreadExecutor();
		// 3、创建一个会根据需要创建线程的线程池
		ExecutorService executorService3 = Executors.newCachedThreadPool();
		
		// Executors可以创建两种ScheduledThreadPoolExecutor
		// 1、创建包含若干核心线程的ScheduledThreadPoolExecutor
		ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(10);
		// 2、创建只包含一个线程的ScheduledThreadPoolExecutor
		ScheduledExecutorService scheduledExecutorService2 = Executors.newSingleThreadScheduledExecutor();
	}
	
	public void run() {
		System.out.println("do something...");
	}
}
