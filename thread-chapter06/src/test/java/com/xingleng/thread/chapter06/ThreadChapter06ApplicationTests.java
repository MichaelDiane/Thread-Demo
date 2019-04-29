package com.xingleng.thread.chapter06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xingleng.thread.chapter06.thread.MyThread;
import com.xingleng.thread.chapter06.thread.MyThread2;
import com.xingleng.thread.chapter06.thread.MyThread3;
import com.xingleng.thread.chapter06.thread.MyThread4;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadChapter06ApplicationTests {

	@Test
	public void myThreadTest() { //演示 “饿汉模式”
		MyThread myThread = new MyThread();
		MyThread myThread2 = new MyThread();
		MyThread myThread3 = new MyThread();
		
		myThread.start();
		myThread2.start();
		myThread3.start();
	}
	
	@Test
	public void myThread2Test() { //演示 “懒汉模式”
		MyThread2 myThread = new MyThread2();
		myThread.start();
	}
	
	@Test
	public void myThread3Test() { //演示 多线程与单例模式 示例 使用静态内部类实现单例模式
		MyThread3 myThread = new MyThread3();
		MyThread3 myThread2 = new MyThread3();
		MyThread3 myThread3 = new MyThread3();
		MyThread3 myThread4 = new MyThread3();
		myThread.start();
		myThread2.start();
		myThread3.start();
		myThread4.start();
	}
	@Test
	public void myThread4Test() { //演示  使用static 代码块实现单例模式
		MyThread4 myThread = new MyThread4();
		MyThread4 myThread2 = new MyThread4();
		MyThread4 myThread3 = new MyThread4();
		MyThread4 myThread4 = new MyThread4();
		myThread.start();
		myThread2.start();
		myThread3.start();
		myThread4.start();
	}

}
