package com.asiainfo;

/**
 * 写一个死循环，用top命令和jstack命令进行分析
 *
 * @author zhangzhiwang
 * @date Dec 3, 2019 3:40:26 PM
 */
public class DeadTLoop {
	public static void main(String[] args) {
		for(;;) {}
	}
}
