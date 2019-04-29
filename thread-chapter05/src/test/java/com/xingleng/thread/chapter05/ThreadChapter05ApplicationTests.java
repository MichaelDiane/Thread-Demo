package com.xingleng.thread.chapter05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xingleng.thread.chapter05.model.MyTask;

@RunWith(SpringRunner.class) 
@SpringBootTest
public class ThreadChapter05ApplicationTests {

	@Test
	public void contextLoads() {//演示: jdk 中的 timer 例子演示
		try {
			MyTask task = new MyTask();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date  =  "2019-04-29 10:33:55";
			Date time = format.parse(date);
			//Timer timer =  new Timer("A"); 非守护线程
			Timer timer =  new Timer("B",true); //守护线程
			timer.schedule(task, time); //即在这个时间执行这个任务.同时该方法无task追溯性; timer 争的锁quene锁而非对象锁
			timer.scheduleAtFixedRate(task, System.currentTimeMillis(), 5000);//在当前时间后枚5秒轮询一次;该方法具有对task有追溯性
			Thread.sleep(1000);
		} catch (ParseException | InterruptedException e) {
			e.printStackTrace();
			
		}
		
	}

}
