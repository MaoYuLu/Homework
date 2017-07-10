package com.myl.test;



public class ThreadTest {
	public static void main(String[] args) {
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();	
		
//		MyRunnable mr = new MyRunnable();
//		Thread t1 = new Thread(mr);
//		Thread t2 = new Thread(mr);
//		t1.setName("t1");
//		t2.setName("t2");
//		t1.start();
//		t2.start();
		
	}
}
class MyThread extends Thread {
	static int balance = 1000; //将资源变成静态共享对象
	static Object o = new Object();  //只能同一对象进行访问
	@Override
	public void run() {
		synchronized (o) {
			if (balance > 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance -= 1000;
				System.out.println(Thread.currentThread().getName() + "取款后当前余额为:" + balance);
			} else {
				System.out.println("余额不足！");
			}
		}
	}
}

//class MyRunnable implements Runnable {
//	
//	int balance = 1000;
//	
//	@Override
//	public synchronized void run() {
//		if (balance>0) {
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			balance -= 1000;
//			System.out.println(Thread.currentThread().getName()+"取款后当前余额为:"+balance);
//		}else {
//			System.out.println("余额不足！");
//		}
//	}
//}