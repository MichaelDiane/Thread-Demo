package com.xingleng.thread.chapter07;

import java.lang.Thread.UncaughtExceptionHandler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xingleng.thread.chapter07.group.MyThreadGroup;
import com.xingleng.thread.chapter07.thread.MyThread;
import com.xingleng.thread.chapter07.thread.MyThread2;
import com.xingleng.thread.chapter07.thread.MyThread3;
import com.xingleng.thread.chapter07.thread.MyThread4;
import com.xingleng.thread.chapter07.thread.MyThread5;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadChapter07ApplicationTests {

	@Test
	public void contextLoads() {//查看线程状态
		try {
			MyThread myThread = new MyThread();
			System.out.println("main 方法中的状态 1:"+ myThread.getState());
			myThread.start();
			
			Thread.sleep(1000);
			System.out.println("main 方法中的状态 2:"+ myThread.getState());
			
			myThread.join();
			
			System.out.println("main 方法中的状态 3:"+ myThread.getState());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void MyThread2Test() throws InterruptedException {//线程中出现异常处理,利用 UncaughtExceptionHandler 进行异常处理,而方法 DefaultUncaughtExceptionHandler 方法对所有线程对象的异常处理机制
		
		MyThread2 myThread = new MyThread2();
		myThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("线程 "+ myThread.getName()+" 出现了异常");
				e.printStackTrace();
			}
		});
		
		myThread.setName("myThread");
		myThread.start();
		
		MyThread2.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(" 默认异常处理 , 线程 "+ myThread.getName()+" 出现了异常");
				e.printStackTrace();
			}
		});
		
		MyThread2 myThread2 = new MyThread2();
		myThread2.setName("myThread2");
		myThread2.start();
		
	}
	
	@Test
	public void MyThread3Test() throws InterruptedException {//线程组内中出现异常
		ThreadGroup group = new ThreadGroup("A");
		
		MyThread3[] myThread = new MyThread3[2];
		for (int i = 0; i < myThread.length; i++) {
			myThread[i] = new MyThread3(group,"线程"+(i+1),"1");
			myThread[i].start();
		}
		
		MyThread3 myThread3 =  new MyThread3(group, "线程组报错", "a");
		myThread3.start();
		
	}
	
	@Test
	public void MyThread4Test() throws InterruptedException {//线程组内中出现异常处理
		MyThreadGroup group = new MyThreadGroup("A");
		MyThread4[] myThread = new MyThread4[2];
		for (int i = 0; i < myThread.length; i++) {
			myThread[i] = new MyThread4(group,"线程"+(i+1),"1");
			myThread[i].start();
		}
		MyThread4 myThread3 =  new MyThread4(group, "线程组报错", "a");
		myThread3.start();
		
	}
	
	@Test
	public void MyThread5Test() throws InterruptedException {//线程异常处理传递-对象异常处理优先于类的默认异常处理
		MyThreadGroup group = new MyThreadGroup("A");
		MyThread5 myThread5 = new MyThread5(group,"B","1");
//		MyThread5.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
//		myThread5.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
		myThread5.start();
		
	}
	

}
