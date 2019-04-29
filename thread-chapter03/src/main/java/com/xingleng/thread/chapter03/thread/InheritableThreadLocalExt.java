package com.xingleng.thread.chapter03.thread;

import java.util.Date;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [ 演示 InheritableThreadLocal 让子线程获取父线程继承下来的值 ]
**/
public class InheritableThreadLocalExt extends InheritableThreadLocal<Object> {
	
	@Override
	protected Object initialValue() {//演示子线程获取父线程的值
		return new Date().getTime();
	}
	
	@Override
	protected Object childValue(Object parentValue) {//演示:子线程更改父线程的值
		return super.childValue(parentValue+" Michael ");
	}
	
}
