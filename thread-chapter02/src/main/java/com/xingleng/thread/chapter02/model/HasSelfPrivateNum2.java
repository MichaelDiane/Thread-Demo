package com.xingleng.thread.chapter02.model;

/**@author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc 演示线程多对象多锁多线程例子
**/
public class HasSelfPrivateNum2 {
	private int num=0;
    synchronized public void add(String userName) {
		 try {
			 if(userName.equals("a")) {
				 num = 100;
				 System.out.println(" a set over! ");
				 Thread.sleep(200);
			 }else {
				 num=200;
				 System.out.println(" b set over! ");
			 }
			 System.out.println(userName + " num = "+num);
			 
		 } catch (InterruptedException e) {
				e.printStackTrace();
		 }
	}
}
