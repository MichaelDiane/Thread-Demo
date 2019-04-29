package com.xingleng.thread.chapter03.model;

import java.io.IOException;
import java.io.PipedInputStream;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc 演示多线程之间通过 管道流(pipeStream)进行通信
**/
public class ReadData {
	
	public void writeMethod(PipedInputStream input) { 
		try {
			System.out.println(" Read : ");
			byte[] byteArray = new byte[20];
			int readLength = input.read(byteArray);
			while(readLength!=-1) {
				String newData =  new String(byteArray,0,readLength);
				System.out.println(newData);
				readLength = input.read(byteArray);
			}
			System.out.println();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
