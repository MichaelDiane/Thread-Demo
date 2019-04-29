package com.xingleng.thread.chapter06.thread;

import com.xingleng.thread.chapter06.model.MyObject4;

/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [演示: 使用static 代码块实现单例模式]
**/
public class MyThread4  extends Thread {
	
	@Override
	public void run() {
			System.out.println( MyObject4.getInstance().hashCode() );
	}
	
}
