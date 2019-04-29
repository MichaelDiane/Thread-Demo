package com.xingleng.thread.chapter03;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xingleng.thread.chapter03.model.MyList;
import com.xingleng.thread.chapter03.model.ReadData;
import com.xingleng.thread.chapter03.model.WriteData;
import com.xingleng.thread.chapter03.thread.MyThread;
import com.xingleng.thread.chapter03.thread.MyThread2;
import com.xingleng.thread.chapter03.thread.MyThread3;
import com.xingleng.thread.chapter03.thread.MyThread4;
import com.xingleng.thread.chapter03.thread.MyThread5;
import com.xingleng.thread.chapter03.thread.MyThread6;
import com.xingleng.thread.chapter03.thread.MyThread7;
import com.xingleng.thread.chapter03.thread.MyThread8;
import com.xingleng.thread.chapter03.tools.Tools;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadChapter03ApplicationTests {

	@Test
	public void contextLoads() {
		
		MyList myList =  new MyList();
		
		MyThread  myThread =  new MyThread(myList);
		myThread.setName("A");
		myThread.start();
		
		MyThread2  myThread2 =  new MyThread2(myList);
		myThread2.setName("B");
		myThread2.start();
	}
	
	@Test
	public void myThread3Test() {//演示 多线程 wait() 和 notity() 之间通信和交互
		try {
			Object lock= new Object();
			
			MyThread3  myThread3 =  new MyThread3(lock);
			myThread3.start();
			
			MyThread4  myThread4 =  new MyThread4(lock);
			myThread4.start();
			
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void myRunnableTest() {//演示 多线程 wait(long) 的方法使用
		try {
			MyRunnable myRunnable = new MyRunnable();
			Thread thread = new Thread(myRunnable);
			thread.start();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void myThread5Test() {//演示多线程之间通过 管道流(pipeStream) 进行通信
		try {
			
			WriteData writeData =  new WriteData();
			ReadData readData = new ReadData();
			
			PipedInputStream input=new PipedInputStream();
			PipedOutputStream out =  new PipedOutputStream();
			
			//input.connect(out);
			out.connect(input);
			
			MyThread5 myThread5 = new MyThread5(writeData,out);
			myThread5.start();
			
			Thread.sleep(2000);
			
			MyThread6 myThread6 = new MyThread6(readData,input);
			myThread6.start();
			
		} catch (IOException e) {
			e.printStackTrace(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void myThread7Test() {//演示多线程 join() 演示
		try {
			MyThread7 myThread7=new MyThread7();
			myThread7.start();
			myThread7.join();
			System.out.println("我想当ThreadTest对象执行完毕后我再执行,我做到了么?");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void myThread8Test() {//演示多线程 join() 演示
		try {
			
			for (int i = 0; i < 5; i++) {
				System.out.println(" 在Main 线程中获得值"+Tools.ext.get());
				Thread.sleep(100);
			}
			
			Thread.sleep(5000);
			
			MyThread8 myThread8=new MyThread8();
			myThread8.start();
			myThread8.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
