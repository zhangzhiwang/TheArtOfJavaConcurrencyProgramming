package com.asiainfo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞队列
 *
 * @author zhangzhiwang
 * @date 2019年12月1日 下午2:49:40
 */
public class BlockingQueueTest {
	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10, true);// 基于数组的有界阻塞队列
		LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<Integer>();// 基于链表的有界阻塞队列
		LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<Integer>();// 基于链表的双向无界阻塞队列
	}
}
