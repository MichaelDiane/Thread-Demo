package com.xingleng.thread.chapter03.thread;

import com.xingleng.thread.chapter03.model.MyList;

/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc 演示 线程之间的通信例子
**/
public class MyThread2 extends Thread {
	
	private MyList list;

	public MyThread2(MyList list) {
		super();
		this.list = list;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				if(list!=null && list.size() == 5) {
					System.out.println(" list.size==5了,MyThread2 线程退出! ");
					throw new InterruptedException();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
