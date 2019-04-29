package com.xingleng.thread.chapter03.thread;

import com.xingleng.thread.chapter03.model.MyList;

/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc 演示 线程之间的通信例子
**/
public class MyThread extends Thread {
	
	private MyList list;

	public MyThread(MyList list) {
		super();
		this.list = list;
	}
	
	@Override
	public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					list.add();
					System.out.println("添加了"+(i+1)+"个元素");
						Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
