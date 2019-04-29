package com.xingleng.thread.chapter04.thread;

import com.xingleng.thread.chapter04.model.MyService3;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [ 演示:使用 ReentrantLock 结合 Condition 通知部分线程 ]
**/
public class MyThread4 extends Thread {
	private MyService3 myService3;

	public MyThread4(MyService3 myService3) {
		super();
		this.myService3 = myService3;
	}
	
	@Override
	public void run() {
		this.myService3.awaitA();
	}
	
}
