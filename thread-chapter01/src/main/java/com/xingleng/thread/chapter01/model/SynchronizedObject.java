package com.xingleng.thread.chapter01.model;
/**
 * @author Michael.Zhang
 * @Date Apr 24, 2019
 * @Desc 线程独占演示
 */
public class SynchronizedObject {
	    synchronized public void printString() {
			System.out.println("begin");
			if(Thread.currentThread().getName().equals("a")) {
				System.out.println(" a 线程永远suspend了 !");
				Thread.currentThread().suspend();
			}
			System.out.println("end");
			
		}
}
