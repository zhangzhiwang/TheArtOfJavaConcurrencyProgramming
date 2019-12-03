package com.asiainfo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类测试
 *
 * @author zhangzhiwang
 * @date Nov 29, 2019 2:05:34 PM
 */
public class AtomicTest {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(10);
		System.out.println(atomicInteger.get());
		System.out.println(atomicInteger.addAndGet(1));
		System.out.println(atomicInteger.compareAndSet(11, 12));
		System.out.println(atomicInteger.get());
		System.out.println("------------------");
		System.out.println(atomicInteger.get());
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.get());
		System.out.println("------------------");
		System.out.println(atomicInteger.getAndSet(100));
		System.out.println(atomicInteger.get());
	}
}
