package com.xingleng.thread.chapter03.thread;

import java.io.PipedOutputStream;

import com.xingleng.thread.chapter03.model.WriteData;

/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc 演示 多线程之间通过 管道流(pipeStream)进行通信
**/
public class MyThread5 extends Thread {
	
	private WriteData writeData;
	private  PipedOutputStream out;
	
	public MyThread5(WriteData writeData, PipedOutputStream out) {
		super();
		this.writeData = writeData;
		this.out = out;
	}
	
	@Override
	public void run() {
		writeData.writeMethod(out);
	}
	
	
}
