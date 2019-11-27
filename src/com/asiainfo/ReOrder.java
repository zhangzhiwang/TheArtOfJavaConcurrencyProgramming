package com.asiainfo;

/**
 * 指令重排序
 *
 * @author zhangzhiwang
 * @date Nov 20, 2019 9:39:53 PM
 */
public class ReOrder {
	private int i = 0;
	private boolean flag = false;

	public void write() {
		i = 1;
		flag = true;
	}

	public void read() {
		int j = 0;
		if (flag) {
			j = i * i;
			if (j == 0) {
				System.out.println("出错了");
			}
		}
	}

	public static void main(String[] args) {
		for (;;) {
			final ReOrder reOrder = new ReOrder();
			new Thread(new Runnable() {

				@Override
				public void run() {
					reOrder.write();
				}
			}).start();

			new Thread(new Runnable() {

				@Override
				public void run() {
					reOrder.read();
				}
			}).start();
		}
	}
}
