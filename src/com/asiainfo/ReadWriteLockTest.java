package com.asiainfo;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 读写锁
 *
 * @author zhangzhiwang
 * @date Nov 27, 2019 10:01:03 PM
 */
public class ReadWriteLockTest {
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static ReadLock readLock = readWriteLock.readLock();
	private static WriteLock writeLock = readWriteLock.writeLock();

	public void read() {
		readLock.lock();
		try {
			System.out.println("reading...");
		} finally {
			readLock.unlock();
		}
	}

	public void write() {
		writeLock.lock();
		try {
			System.out.println("writing...");
		} finally {
			writeLock.unlock();
		}
	}
}
