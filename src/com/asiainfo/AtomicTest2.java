package com.asiainfo;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子更新数组
 *
 * @author zhangzhiwang
 * @date 2019年11月30日 下午12:39:49
 */
public class AtomicTest2 {
	public static void main(String[] args) {
		int[] ii = new int[] {1, 2};
		AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(ii);
		int r = atomicIntegerArray.getAndSet(1, 10);// 返回修改前的值
		System.out.println(r);
		System.out.println(atomicIntegerArray.get(1));
		System.out.println("----------------");
		
		int r2 = atomicIntegerArray.addAndGet(0, 20);// 返回修改后的值
		System.out.println(r2);
		System.out.println(atomicIntegerArray.get(0));
		System.out.println("----------------");
		
		System.out.println(atomicIntegerArray.get(0));
		System.out.println(atomicIntegerArray.get(1));
		System.out.println(ii[0]);// new AtomicIntegerArray(ii)只是将数组ii复制了一份，然后操作的是复制后的数组，不会改变原属组的值
		System.out.println(ii[1]);
	}
}