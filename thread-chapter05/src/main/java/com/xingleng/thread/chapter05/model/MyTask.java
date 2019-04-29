package com.xingleng.thread.chapter05.model;

import java.util.Date;
import java.util.TimerTask;

/**@author Michael.Zhang
 * @Date Apr 29, 2019
 * @Desc [演示: jdk 中的 timer 例子演示 ]
**/
public class MyTask extends TimerTask {
	
	@Override
	public void run() {
		System.out.println("运行了!时间为="+new Date());
	}
	
}
