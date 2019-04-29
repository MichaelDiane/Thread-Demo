package com.xingleng.thread.chapter03.thread;

import java.io.PipedInputStream;

import com.xingleng.thread.chapter03.model.ReadData;

/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc 演示 多线程之间通过 管道流(pipeStream)进行通信
**/
public class MyThread6 extends Thread {
	
	private ReadData readData;
	private  PipedInputStream input;
	
	public MyThread6( ReadData readData,PipedInputStream input) {
		super();
		this.readData = readData;
		this.input = input;
	}
	
	@Override
	public void run() {
		readData.writeMethod(input);
	}
	
	
}
