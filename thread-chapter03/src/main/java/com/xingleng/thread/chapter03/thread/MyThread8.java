package com.xingleng.thread.chapter03.thread;

import com.xingleng.thread.chapter03.tools.Tools;

/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc 演示多线程 join() 演示
**/
public class MyThread8 extends Thread {
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("在线程 TrheadA 中获取的值 = "+Tools.ext.get());
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
