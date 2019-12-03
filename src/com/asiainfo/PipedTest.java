package com.asiainfo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 线程管道通信
 *
 * @author zhangzhiwang
 * @date Nov 26, 2019 9:43:26 AM
 */
public class PipedTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		PipedInputStream pipedInputStream = new PipedInputStream();
		PipedOutputStream pipedOutputStream = new PipedOutputStream();
		pipedInputStream.connect(pipedOutputStream);// 将管道输入流和管道输出流关联起来建立“管道”，谁connect谁都可以，但是不能同时connect，也就是本行代码和下面一行代码二选一，如果同时connect会报异常：java.io.IOException: Already connected
//		pipedOutputStream.connect(pipedInputStream);

		// 建立连接的第二种方式：通过构造函数来连接
//		pipedInputStream = new PipedInputStream(pipedOutputStream);
//		pipedOutputStream = new PipedOutputStream(pipedInputStream);

		WriteThread writeThread = new WriteThread(pipedOutputStream);
		writeThread.start();
		
		Thread.sleep(1000);
		ReadThread readThread = new ReadThread(pipedInputStream);
		readThread.start();
	}

	static class WriteThread extends Thread {
		private PipedOutputStream out;

		public WriteThread(PipedOutputStream out) {
			super();
			this.out = out;
		}
		
		public void run() {
			String input = "hello world";
			try {
				out.write(input.getBytes(), 0, input.length());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	static class ReadThread extends Thread {
		private PipedInputStream in;

		public ReadThread(PipedInputStream in) {
			super();
			this.in = in;
		}
		
		public void run() {
			byte[] bs = new byte[1024];
			int len = 0;
			try {
				len = in.read(bs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("read:" + new String(bs, 0, len));
		}
	}
}
