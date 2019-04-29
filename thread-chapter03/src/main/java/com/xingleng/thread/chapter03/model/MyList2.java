package com.xingleng.thread.chapter03.model;

import java.util.ArrayList;
import java.util.List;

/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc []
**/
public class MyList2 {
	
	private static List<String> list = new ArrayList<String>();

	public static void add() {
		list.add("MichaelDiane");
	}
	
	public static int size() {
		return list.size();
	}
	
}
