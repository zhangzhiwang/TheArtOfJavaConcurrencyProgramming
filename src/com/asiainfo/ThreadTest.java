package com.asiainfo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 除了主线程外，JVM还默认启动了哪些线程
 *
 * @author zhangzhiwang
 * @date Nov 25, 2019 8:00:27 PM
 */
public class ThreadTest {
	public static void main(String[] args) {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] dumpAllThreads = threadMXBean.dumpAllThreads(false, false);
		for(ThreadInfo threadInfo : dumpAllThreads) {
			System.out.println(threadInfo.getThreadId() + " -> " + threadInfo.getThreadName());
		}
	}
}
