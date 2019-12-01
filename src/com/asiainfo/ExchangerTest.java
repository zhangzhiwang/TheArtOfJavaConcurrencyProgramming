package com.asiainfo;

import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Exchanger——用于线程间的数据交换
 *
 * @author zhangzhiwang
 * @date 2019年11月30日 下午4:19:16
 */
public class ExchangerTest {
	public static void main(String[] args) throws InterruptedException {
		Exchanger<String> exchanger = new Exchanger<String>();
		A a = new A(exchanger);
		B b = new B(exchanger);
		
		FutureTask<Integer> fu1 = new FutureTask<Integer>(a);
		FutureTask<Integer> fu2 = new FutureTask<Integer>(b);
		Thread t1 = new Thread(fu1, "mt_1");
		Thread t2 = new Thread(fu2, "mt_2");
		t1.start();
		Thread.sleep(10);
		t2.start();
	}

	static class A implements Callable<Integer> {
		private Exchanger<String> exchanger;

		public A(Exchanger<String> exchanger) {
			super();
			this.exchanger = exchanger;
		}

		public Integer call() throws Exception {
//			exchanger.exchange("result_A");
			exchanger.exchange("result_A", 3, TimeUnit.SECONDS);
			return null;
		}
	}
	
	static class B implements Callable<Integer> {
		private Exchanger<String> exchanger;

		public B(Exchanger<String> exchanger) {
			super();
			this.exchanger = exchanger;
		}

		public Integer call() throws Exception {
//			String a = exchanger.exchange("result_B");
//			System.out.println("线程B拿到了线程A的数据：" + a);
			return null;
		}
	}
}
