package com.myl.test;


public class ThreadTest1 {
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		MyThread1 t2 = new MyThread1();
		t1.setName("线程1");
		t2.setName("线程2");
		t1.flag = true;
		t2.flag = false;
		t1.start();
		t2.start();		
	}
}

class MyThread1 extends Thread {
	static Object o = new Object();
	boolean flag ;
	@Override
	public void run() {
		synchronized (o) {
			if (flag) {
				for (int i = 1; i < 100; i++) {
					for (int j = 1; j < 26; j++) {
						o.notifyAll();
						System.out.println(Thread.currentThread().getName() + "---："+i * j);
						try {
							sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						try {
							o.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				for (int i = 1; i < 100; i++) {
					for (char j = 'a'; j <= 'z'; j++) {
						o.notifyAll();
						System.out.println(Thread.currentThread().getName() + "---："+j);
						try {
							sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						try {
							o.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}		
	}	
}