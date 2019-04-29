package com.xingleng.thread.chapter01.model;
/**@author Michael.Zhang
 * @Date Apr 25, 2019
 * @Desc [演示 suspend 于 resume 方法的缺点-不同步问题]
**/
public class MyObject {	
	
		private String userName="1";
		private String password = "11";
		
		public void setValue(String u,String p) {
			this.userName = u;
			
			if(Thread.currentThread().getName().equals("a")) {
				System.out.println("停止a线程====>"+Thread.currentThread().getName());
				Thread.currentThread().suspend(); //该例子演示了,使用supend()方法后导致的数据不同步的问题.    
				
			}
			
			this.password=p;
		}
		
		public void printUserNameAndPassword() {
			System.out.println("线程===>"+Thread.currentThread().getName()+" , "+userName+","+password);
			
		}
		
}
