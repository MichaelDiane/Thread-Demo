package com.xingleng.thread.chapter03.tools;

import com.xingleng.thread.chapter03.thread.InheritableThreadLocalExt;

/**@author Michael.Zhang
 * @Date Apr 28, 2019
 * @Desc [ 演示 InheritableThreadLocal 让子线程获取父线程继承下来的值 ]
**/
public class Tools {
	public static InheritableThreadLocalExt ext=new InheritableThreadLocalExt();
}
