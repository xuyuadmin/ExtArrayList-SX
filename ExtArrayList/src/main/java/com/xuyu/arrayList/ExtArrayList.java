package com.xuyu.arrayList;

import java.util.Arrays;

/**
 * 自定义ArrayList集合
 * @author Administrator
 *
 */
@SuppressWarnings("all")

public class ExtArrayList<E> implements ExtList<E> {

	//ArrayList底层采用数组存放
	private transient Object [] elementData;
	//默认数组容量
	private static final int DEFAULT_CAPACITY=10;
	//记录实际ArrayList大小
	private int size;
	
	//对ArrayList初始化容量
	public ExtArrayList(int initialCapacity) {
		if(initialCapacity<0) {
			throw new IllegalArgumentException("初始化容量不能小于0");
		}
		elementData=new Object[initialCapacity];
	}
	
	//默认初始化容量为10
	public ExtArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	//线程安全问题
	public void add(E e) {
		//传原来数组容量大小+1
		ensureExplicitCapacity(size+1);
		//2.使用下标对数组进行赋值
		elementData[size++]=e;
	}
	//根据下标添加元素
	public void add(int index,E e) {
		//1.检查数组下标是否越界
		rangeCheck(index);
		//2.扩容逻辑处理
		ensureExplicitCapacity(size+1);
		//移位
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		//替换指定下标位置元素
		elementData[index]=e;
		//数组长度加1
		size++;

	}
	//扩容逻辑处理
	private void ensureExplicitCapacity(int minCapacity){
		//1.判断实际存放的数据容量是否大于elementData--默认10
		if(size==elementData.length) {
			//原来本身elementData容量大小
			int oldCapacity=elementData.length;
			//新容量大小
			int newCapacity=oldCapacity+(oldCapacity >> 1);
			//minCapacity代表最小扩容容量--原来容量+1
			if(newCapacity-minCapacity<0) {
				//最少保证容量比原来容量增加1
				newCapacity=minCapacity;
			}
			//将老数组赋值到新数组 把老数组引用指向新数组
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	
	}
	//使用下表获取数组元素
	public E get(int index) {
		//判断数组下标是否越界
		rangeCheck(index);
		return elementData(index);
	}
	E elementData(int  index) {
		return (E) elementData;
	}
	//根据数组下标位置删除
	public E remove(int index) {
		//1.使用下表获取数组元素
		E e = get(index);
		//2,计算删除元素后面的长度
		int numMoved=size-index-1;
		if(numMoved>0) {
			//删除原理分析 使用arraycopy往前移动数据，将最后一个变为空
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}else {
			//将最后一个元素置空
			elementData[--size]=null;
		}
		return e;	
	}
	//根据数组对象删除
	public boolean remove(E e) {
		//1.循环遍历数组
		for (int i = 0; i < elementData.length; i++) {
			//得到每个数组下标对应的值
			Object value = elementData[i];
			//判断循环得到的所有值与要删除的元素值是否相等
			if(value.equals(e)) {
				//相等的话，根据元素下标位置删除
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	//检查数组下标是否越界
	private void rangeCheck(int index) {
		if(index>=size) {
			throw new IndexOutOfBoundsException("数组越界了");
		}
	}
	public int getSize() {
		return size;
	}
}




