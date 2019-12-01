package com.asiainfo;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 原子更新字段类
 *
 * @author zhangzhiwang
 * @date 2019年11月30日 下午12:39:49
 */
public class AtomicTest4 {
	public static void main(String[] args) {
		AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class,
				"age");
		User user = new User(10, "aa");
		System.out.println(user);
		System.out.println(atomicIntegerFieldUpdater.getAndIncrement(user));
		System.out.println(atomicIntegerFieldUpdater.get(user));
		System.out.println(user.getAge());
		System.out.println(user);
	}

	static class User {
		private volatile int age;
		private String name;

		public User(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "User [age=" + age + ", name=" + name + "]";
		}

	}
}