package com.asiainfo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Executor框架
 *
 * @author zhangzhiwang
 * @date 2019年12月1日 下午2:06:36
 */
public class ExecutorTest extends Thread {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		// 使用Executor框架的步骤：
		// 1、创建任务。任务可以是Runnable或Callable接口的实现类
		Runnable runnable = new ExecutorTest();
		Callable<Object> callable = Executors.callable(runnable);// 该方法可以把Runnable对象转换成Callable对象
		
		// 2、将任务交由Excutor执行框架执行（Executor.execute(Runnable)）或者提交给Excutor执行框架执行（ExecutorService.submit(Callable<T>)或者ExecutorService.submit(Runnable)）
		// 注意：一般ThreadPoolExecutor不是直接创建的，而是用Executors的静态方法来创建出来的，比如Executors#newFixedThreadPool()
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(100));
//		threadPoolExecutor.execute(runnable);// execute方法只接受Runnable对象的任务，所以execute方法适用于执行不带返回值的任务
//		threadPoolExecutor.submit(runnable);// submit方法既可以接受Runnable对象的任务也可以接受Callable对象的任务，所以submit方法适用与执行带返回值的任务
		Future<Object> futureTask = threadPoolExecutor.submit(callable);// submit方法返回FutureTask，所以可以通过FutureTask#get()方法来获取返回值，但是get()方法会阻塞当前线程直到其他线程返回为止。
//		Object object = futureTask.get();
		Object object = futureTask.get(10, TimeUnit.SECONDS);// 也可以调用带超时时间的get方法，如果超时时间到了另一个线程还没有返回则本线程就不会阻塞继续往下运行。
		System.out.println("result = " + object.toString());
		futureTask.cancel(true);// 取消任务的执行
	}
	
	public void run() {
		System.out.println("do something...");
	}
}
