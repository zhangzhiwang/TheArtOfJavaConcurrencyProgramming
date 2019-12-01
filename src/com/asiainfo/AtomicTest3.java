package com.asiainfo;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子更新引用类型
 *
 * @author zhangzhiwang
 * @date 2019年11月30日 下午12:39:49
 */
public class AtomicTest3 {
	public static void main(String[] args) {
		User user = new User(1, "aa");
		AtomicReference<User> atomicReference = new AtomicReference<User>(user);
		System.out.println(atomicReference.get().getAge());
		System.out.println(atomicReference.get().getName());
		System.out.println("------------");
		
		User user2 = new User(20, "bb");
		atomicReference.set(user2);
		System.out.println(atomicReference.get().getAge());
		System.out.println(atomicReference.get().getName());
	}

	static class User {
		private int age;
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

	}
}