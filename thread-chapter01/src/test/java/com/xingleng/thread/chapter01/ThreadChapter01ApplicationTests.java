package com.xingleng.thread.chapter01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xingleng.thread.chapter01.model.MyObject;
import com.xingleng.thread.chapter01.model.SynchronizedObject;
import com.xingleng.thread.chapter01.runnable.MyRunnable;
import com.xingleng.thread.chapter01.thread.MyThread;
import com.xingleng.thread.chapter01.thread.MyThread2;
import com.xingleng.thread.chapter01.thread.MyThread3;
import com.xingleng.thread.chapter01.thread.MyThread4;
import com.xingleng.thread.chapter01.thread.MyThread5;
import com.xingleng.thread.chapter01.thread.MyThread6;
import com.xingleng.thread.chapter01.thread.MyThread7;
import com.xingleng.thread.chapter01.thread.MyThread8;
import com.xingleng.thread.chapter01.thread.MyThread10;
import com.xingleng.thread.chapter01.thread.MyThread11;
import com.xingleng.thread.chapter01.thread.MyThread12;
import com.xingleng.thread.chapter01.thread.MyThread13;
import com.xingleng.thread.chapter01.thread.MyThread14;
import com.xingleng.thread.chapter01.thread.MyThread15;
import com.xingleng.thread.chapter01.thread.MyThread16;

/***
 * @author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc {多线程基础方法和api演示示例}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadChapter01ApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("===========当前线程名称=================>"+Thread.currentThread().getName());
	}
	
	@Test
	public void myThreadTest() {
		MyThread myThread =  new MyThread();
		myThread.start();
		System.out.println("==============运行结束=================");
	}
	
	@Test
	public void myThread2Test() {
		try {
			MyThread2 myThread =  new MyThread2();
			myThread.setName("myThread2");
			/***
			 * 此 start 方法是通知 线程规划器 此线程已经准备就绪,等待屌用爱称对象的run方法;
			 * start() 与 run() 方法有着本质区别,若这里调用run则为同步调用;且不会交给线程规划器去管理和调配;
			 * 同时 start() 顺序并不代表 线程执行顺序
			 */
			myThread.start(); 
			for (int i = 0; i < 10; i++) {
				int time = (int)Math.random()*1000;
				Thread.sleep(time);
				System.out.println("===test==="+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void myThread3Test() {
			MyThread3 myThread =  new MyThread3(1);
			MyThread3 myThread2 =  new MyThread3(2);
			MyThread3 myThread3 =  new MyThread3(3);
			MyThread3 myThread4 =  new MyThread3(4);
			MyThread3 myThread5 =  new MyThread3(5);
			MyThread3 myThread6 =  new MyThread3(6);
			MyThread3 myThread7 =  new MyThread3(7);
			MyThread3 myThread8 =  new MyThread3(8);
			MyThread3 myThread9 =  new MyThread3(9);
			MyThread3 myThread10 =  new MyThread3(10);
			MyThread3 myThread11 =  new MyThread3(11);
			myThread11.start();
			myThread.start();
			myThread2.start();
			myThread3.start();
			myThread4.start();
			myThread5.start();
			myThread6.start();
			myThread7.start();
			myThread8.start();
			myThread9.start();
			myThread10.start();
	}

	@Test
	public void myRunnableTest() {
		Runnable myRunnable= new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
		System.out.println("运行结束!");
		
	}
	
	@Test
	public void myThread4Test() {
		MyThread4 a = new MyThread4("A");
		MyThread4 b = new MyThread4("B");
		MyThread4 c = new MyThread4("C");
		a.start();
		b.start();
		c.start();
	}
	
	@Test
	public void synchronizedObjectTest() {
		try {
			final SynchronizedObject object = new SynchronizedObject();
			Thread thread = new Thread() {
				@Override
				public void run () {
					object.printString();
				}
			};
			thread.setName("A线程");
			thread.start();
			
			Thread.sleep(1000);
			
			Thread thread2=new Thread() {
				@Override
				public void run() {
					System.out.println("thread2启动了,但进入不了printString()方法,只打印1个Begin");
					System.out.println("因为pringString()方法被a线程锁定并且永远suspend 暂停了!");
					object.printString();
				}
			};
			thread2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void myThread5Test() {
		try {
			MyThread5 thread = new MyThread5("A");
			
			thread.start();
			Thread.sleep(1000);
			thread.suspend();
			
			System.out.println(" main end ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void myThread6Test() {
		try {
			MyThread6 thread = new MyThread6("6");
			thread.start();
			Thread.sleep(1000);
			thread.suspend();
			System.out.println(" main end ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void myObjectTest() throws InterruptedException {
		
		 final	MyObject myObject = new MyObject();
		 
		 Thread thread =  new Thread() {
			public void run() {
				myObject.setValue("a", "aa");
			}
		 };
		 
		 thread.setName("a");
		 thread.start();
		 
		 Thread.sleep(500);
		 Thread thread2 =  new Thread() {
			public void run() {
				myObject.printUserNameAndPassword();
			}
		 };
		 
		 thread2.setName("b");
		 thread2.start();
		 
		 System.out.println("====线程名称====>"+Thread.currentThread().getName());
	}
	
	@Test
	public void myThread7Test() {//通过 yield方法,将CPU资源放弃 演示
		MyThread7 thread = new MyThread7(); 
		thread.start();
	}
	
	@Test
	public void myThread8Test() {//优先级具有继承性演示
		System.out.println(" main thread  begin priority="+Thread.currentThread().getPriority());
		//Thread.currentThread().setPriority(6);
		System.out.println(" main thread  end priority="+Thread.currentThread().getPriority());
		MyThread8 myThread8 = new MyThread8();
		myThread8.start();
	}
	
	@Test
	public void myThread10Test() {//演示线程优先级具有规则性演示
		/***
		 *  =====Thread  2 Use Time=====86
		 *  =====Thread  1 Use Time=====99
		 *  =====Thread  1 Use Time=====82
		 *  =====Thread  2 Use Time=====87
		 *  =====Thread  2 Use Time=====72
		 *  =====Thread  1 Use Time=====74
		 *  =====Thread  1 Use Time=====59
		 *  =====Thread  1 Use Time=====108
		 *  上述数据输出 优先级高的大部门得以输出,但并未全部执行完;而且当线程优先级的登记差距很大时,谁先执行完和代码调用顺序无关.
		 */
		for (int i = 0; i < 5; i++) {
			MyThread10 thread10 =  new MyThread10();
			thread10.setPriority(10);
			thread10.start();
			
			MyThread11 thread11 =  new MyThread11();
			thread11.setPriority(1);
			thread11.start();			
		}
	}
	
	@Test
	public void myThread11Test() {//演示线程优先级具有规则性演示
		/***
		 * =====Thread  10 Use Time=====43
		 * =====Thread  11 Use Time=====48
		 * =====Thread  10 Use Time=====48
		 * =====Thread  11 Use Time=====48
		 * =====Thread  10 Use Time=====44
		 * =====Thread  11 Use Time=====37
		 * =====Thread  10 Use Time=====37
		 * =====Thread  11 Use Time=====42
		 *  上述数据输出 优先级高的大部门得以输出,但并未全部执行完;而且当线程优先级的登记差距很大时,谁先执行完和代码调用顺序无关.也说明CPU的资源优先给优先级高的线程处理
		 */
		for (int i = 0; i < 5; i++) {
			MyThread10 thread10 =  new MyThread10();
			thread10.setPriority(1);
			thread10.start();
			
			MyThread11 thread11 =  new MyThread11();
			thread11.setPriority(10);
			thread11.start();			
		}
	}
	
	/***
	 *  =====Thread  12 Use Time=====1
		=====Thread  13 Use Time=====0
		=====Thread  12 Use Time=====0
		=====Thread  13 Use Time=====0
		=====Thread  12 Use Time=====0
		=====Thread  13 Use Time=====0
		=====Thread  12 Use Time=====0
		=====Thread  13 Use Time=====0
		=====Thread  12 Use Time=====0
		=====Thread  13 Use Time=====1
	 */
	@Test
	public void myThread12Test() {//演示线程优先级具有随机性 演示:优先级设置的高低,并不能决定输出的结果顺序无关.其具有不确定性
		for (int i = 0; i < 5; i++) {
			
			MyThread12 myThread12 =  new MyThread12();
			myThread12.setPriority(5);
			myThread12.start();
			
			MyThread13 myThread13 =  new MyThread13();
			myThread13.setPriority(6);
			myThread13.start();		
			
		}
	}
	
	/***
	 * thread14=1299097761
       thread15=1300095594
	 * @throws InterruptedException
	 */
	@Test
	public void myThread14Test() throws InterruptedException {//演示线程谁跑的更快:结果显示 优先级高的运行的快(但有时并不是绝对的)
		MyThread14 thread14 = new MyThread14();
		thread14.setPriority(Thread.NORM_PRIORITY-3);
		thread14.start();
		
		MyThread15 thread15 = new MyThread15();
		thread15.setPriority(Thread.NORM_PRIORITY+3);
		thread15.start();
		
		Thread.sleep(2000);
		
		thread14.stop();
		thread15.stop();
		
		System.out.println("thread14="+thread14.getCount());
		System.out.println("thread15="+thread15.getCount());
		
		
	}
	
	@Test
	public void myThread16Test() throws InterruptedException {//演示 守护线程
		MyThread16 thread16 = new MyThread16();
		thread16.setDaemon(true); //开启线程守护
		thread16.start();
		Thread.sleep(2000);
		System.out.println(" 离开thread对象也不在打印了,也就是停止! ");
		
		
	}
	

}