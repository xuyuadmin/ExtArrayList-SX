package com.xuyu.test;

import com.xuyu.arrayList.ExtArrayList;
import com.xuyu.arrayList.ExtList;

public class Test001 {

	//底层采用数组方式
	//怎么保证集合存无限大小--数组扩容技术
	public static void main(String[] args) {
	
		//反射机制不能获取到泛型类型（通过字节码技术获取）
		//泛型才决定类型 泛型擦除
		ExtList<Object>listString=new ExtArrayList<Object>();
		listString.add("小孩");
		listString.add("修");
		listString.add("cd");
		for (int i = 0; i < listString.getSize(); i++) {
			System.out.println(listString.get(0));
		}
	}
}
