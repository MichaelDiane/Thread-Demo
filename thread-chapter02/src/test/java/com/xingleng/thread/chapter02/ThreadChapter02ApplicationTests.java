package com.xingleng.thread.chapter02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xingleng.thread.chapter02.model.HasSelfPrivateNum;
import com.xingleng.thread.chapter02.model.HasSelfPrivateNum2;
import com.xingleng.thread.chapter02.model.HasSelfPrivateNum3;
import com.xingleng.thread.chapter02.model.ObjectService;
import com.xingleng.thread.chapter02.runnable.MyRunnable;
import com.xingleng.thread.chapter02.thread.MyThread;
import com.xingleng.thread.chapter02.thread.MyThread10;
import com.xingleng.thread.chapter02.thread.MyThread11;
import com.xingleng.thread.chapter02.thread.MyThread12;
import com.xingleng.thread.chapter02.thread.MyThread13;
import com.xingleng.thread.chapter02.thread.MyThread2;
import com.xingleng.thread.chapter02.thread.MyThread3;
import com.xingleng.thread.chapter02.thread.MyThread4;
import com.xingleng.thread.chapter02.thread.MyThread5;
import com.xingleng.thread.chapter02.thread.MyThread6;
import com.xingleng.thread.chapter02.thread.MyThread7;
import com.xingleng.thread.chapter02.thread.MyThread8;
import com.xingleng.thread.chapter02.thread.MyThread9;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadChapter02ApplicationTests {

	@Test
	public void contextLoads() {//演示方法内变量为私有变量,其为线性安全的.不会出现非线性安全问题.
			HasSelfPrivateNum numRef = new HasSelfPrivateNum();
			MyThread myThread= new MyThread(numRef);
			myThread.start();
			
			MyThread2 MyThread2 = new MyThread2(numRef);
			MyThread2.start();
		
	}
	
	@Test
	public void selfNum2Test() {//演示方法内变量为私有变量,其为线性安全的.不会出现非线性安全问题.
		
		HasSelfPrivateNum2 numRef = new HasSelfPrivateNum2();
		HasSelfPrivateNum2 numRef2 = new HasSelfPrivateNum2();
		
		MyThread3 myThread3= new MyThread3(numRef);
		myThread3.start();
		
		MyThread4 myThread4 = new MyThread4(numRef2);
		myThread4.start();
		
	}
	/***
	 *   begin methodA threadName=Thread-5
		 begin methodB threadName=Thread-6
		 end endTime=1556186505556
		 end B
		 begin methodC threadName=Thread-7
		 总结:
		    1、上述结果表面:5线程先持有object 对象的Lock锁,6线程可以异步方式调用Object对象非synchronized 类型方法
		    2、上述结果表面:5线程先持有object 对象的Lock锁,7线程如果这时调用Object对象中的synchronized类型的方法,需要等待即同步调用
	 */
	
	@Test
	public void selfNum3Test() {//演示线程 synchronized 同步方法鱼锁对象 示例
		
		HasSelfPrivateNum3 hasSelfPrivateNum3 = new HasSelfPrivateNum3();
		
		MyThread5 thread5 = new  MyThread5(hasSelfPrivateNum3);
		thread5.start();
		
		MyThread6 thread6 = new MyThread6(hasSelfPrivateNum3);
		thread6.start();
		
		MyThread7 thread7 = new MyThread7(hasSelfPrivateNum3);
		thread7.start();
		
	}
	
	/***
	 * son print i=9
	 * father print i=8
	 * son print i=7
	 * father print i=6
	 * son print i=5
	 * father print i=4
	 * son print i=3
	 * father print i=2
	 * son print i=1
	 * father print i=0
	 * 总结:存在父子继承关系时,子类可通过 “可重入锁” 特性,调用父类中的同步方法.
	 * @throws InterruptedException
	 */
	@Test
	public void myThread8Test() throws InterruptedException {//演示线程 重入锁 特性;通过子类通过该特性调用父类的同步方法
		MyThread8 thread = new MyThread8();
		thread.start();
		Thread.sleep(2000);//为了让主线程(main)生命周期不中断,子进行方可运行结束
	}
	
	/***
	 * MethodA begin time=1556201565202
	 * MethodA end time=1556201567205
	 * MethodB begin time=1556201567206
	 * MethodB end time=1556201569209
	 * 总结:结果输出并未交叉输出,即同步输出;说明synchronized(this)的监视器为同一个,同时同步代码块锁定的是对象
	 * @throws InterruptedException
	 */
	@Test
	public void myThread9Test() throws InterruptedException {//演示线程 演示同步代码块的阻碍塞问题
		
		ObjectService object = new ObjectService();
		
		MyThread9 myThread9 = new MyThread9(object);
		myThread9.start();
		
		MyThread10 myThread10 = new MyThread10(object);
		myThread10.start();
		
	}
	
	@Test
	public void myThread11Test() throws InterruptedException {//演示线程 死锁演示
		MyThread11 myThread11 = new MyThread11();
		myThread11.setUserName("a");
		
		Thread thread = new  Thread(myThread11);
		thread.start();
		
		Thread.sleep(100);
		
		myThread11.setUserName("b");
		Thread thread_2 = new  Thread(myThread11);
		thread_2.start();
		
	}
	
	
	@Test
	public void myRunnableTest()  {//演示线程 通过多线程-同步解决同步死循环问题
		MyRunnable runable= new MyRunnable();
		Thread thread =  new Thread(runable);
		thread.start();
		System.out.println("我要停止它!ThreadName="+Thread.currentThread().getName());
		runable.setContinuePrint(false);
	}
	
	@Test
	public void myThread12Test()  {//演示线程 通过多线程-解决异步死循环问题(死循环)
		try {
			MyThread12 myThread12 =new MyThread12();
				myThread12.start();
			Thread.sleep(1000);
			myThread12.setRunning(false);
			System.out.println("已赋值为false!");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void myThread13Test()  {//演示线程 通过多线程-使用volatile 解决异步死循环问题
		try {
			MyThread13 myThread13 =new MyThread13();
			myThread13.start();
			Thread.sleep(1000);
			myThread13.setRunning(false);
			System.out.println("已赋值为false!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
