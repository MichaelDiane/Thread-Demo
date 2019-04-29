package com.xingleng.thread.chapter04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xingleng.thread.chapter04.model.FairService;
import com.xingleng.thread.chapter04.model.MyService;
import com.xingleng.thread.chapter04.model.MyService2;
import com.xingleng.thread.chapter04.model.MyService3;
import com.xingleng.thread.chapter04.model.MyService4;
import com.xingleng.thread.chapter04.thread.MyThread;
import com.xingleng.thread.chapter04.thread.MyThread2;
import com.xingleng.thread.chapter04.thread.MyThread3;
import com.xingleng.thread.chapter04.thread.MyThread4;
import com.xingleng.thread.chapter04.thread.MyThread5;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadChapter04ApplicationTests {

	@Test
	public void contextLoads() {//演示 使用 ReentrantLock 类实现同步
		try {
			
			MyService myService= new MyService();
			MyThread myThread = new MyThread(myService);
			myThread.setName("A");
			myThread.start();
			
			Thread.sleep(100);
			
			MyThread2 myThread2 = new MyThread2(myService);
			myThread2.setName("B");
			myThread2.start();
			
		 	myThread2.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void myThread3Test() {//演示:使用 ReentrantLock 结合 Condition 实现等待/通知功能
		MyService2 myService = new MyService2();
		MyThread3 myThread3 = new MyThread3(myService);
		myThread3.start();
	}
	
	@Test
	public void myThread3_2Test() {//演示:使用 ReentrantLock 结合 Condition 实现等待/通知功能
		try {
			
			MyService2 myService = new MyService2();
			MyThread3 myThread3 = new MyThread3(myService);
			myThread3.start();
			
			Thread.sleep(3000);
			
			myService.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void myThread4Test() {//演示:使用 ReentrantLock 结合 Condition 通知部分线程
		try {
			
			MyService3 myService = new MyService3();
			
			MyThread4 myThread4 = new MyThread4(myService);
			myThread4.setName("A");
			myThread4.start();
			
			Thread.sleep(3000);
			
			MyThread5 myThread5 = new MyThread5(myService);
			myThread5.setName("B");
			myThread5.start();
			
			myService.signalA();//只通知,释放a线程
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void fairTest() {//演示ReentrantLock 创建公平锁  例子演示
		FairService fairService = new FairService(true);
		Runnable runable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("⭐️线程"+Thread.currentThread().getName()+"运行了");
				fairService.lockMethod();
			}
		};
		
		Thread[] threadArray = new Thread[5];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] =  new Thread(runable);
		}
		
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i].start();
		}
		
	}
	@Test
	public void unFairTest() {//演示ReentrantLock 创建 非公平锁 例子演示
		FairService fairService = new FairService(false);
		Runnable runable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("⭐️线程"+Thread.currentThread().getName()+"运行了");
				fairService.lockMethod();
			}
		};
		
		Thread[] threadArray = new Thread[5];
		for (int i = 0; i < 5; i++) {
			threadArray[i] =  new Thread(runable);
		}
		
		for (int i = 0; i < 5; i++) {
			threadArray[i].start();
		}
		
	}
	
	@Test
	public void myService4Test() {//演示ReentrantReadWriteLock 演示读写互斥例子
		try {
			MyService4 myService4= new MyService4();
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					myService4.read();
				}
			});
			thread.setName("A");
			thread.start();
			
			Thread.sleep(1000);
			
			Thread thread2 = new Thread(new Runnable() {
				@Override
				public void run() {
					myService4.write();
				}
			});
			thread2.setName("B");
			thread2.start();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void myService4_2Test() {//演示ReentrantReadWriteLock 演示写读互斥例子
		try {
			MyService4 myService4= new MyService4();
			
			Thread thread2 = new Thread(new Runnable() {
				@Override
				public void run() {
					myService4.write();
				}
			});
			thread2.setName("B");
			thread2.start();
			
			Thread.sleep(1000);
			
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					myService4.read();
				}
			});
			thread.setName("A");
			thread.start();
			
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
