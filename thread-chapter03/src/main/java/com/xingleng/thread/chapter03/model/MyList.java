package com.xingleng.thread.chapter03.model;

import java.util.ArrayList;
import java.util.List;

/**@author Michael.Zhang
 * @Date Apr 27, 2019
 * @Desc []
**/
public class MyList {
	
	private List<String> list = new ArrayList<String>();

	public void add() {
		list.add("MichaelDiane");
	}
	
	public int size() {
		return list.size();
	}
	
}
