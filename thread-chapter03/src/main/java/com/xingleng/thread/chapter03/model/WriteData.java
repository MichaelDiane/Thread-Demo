package com.xingleng.thread.chapter03.model;

import java.io.IOException;
import java.io.PipedOutputStream;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc 演示多线程之间通过 管道流(pipeStream)进行通信
**/
public class WriteData {
	
	public void writeMethod(PipedOutputStream out) {
		
		try {
			System.out.println(" Write : ");
			for (int i = 0; i < 300; i++) {
				String outData = ""+(i+1);
				out.write(outData.getBytes());
				System.out.println(outData);
			}
			System.out.println();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
