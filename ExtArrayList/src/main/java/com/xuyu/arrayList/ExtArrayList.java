package com.xuyu.arrayList;

import java.util.Arrays;

/**
 * �Զ���ArrayList����
 * @author Administrator
 *
 */
@SuppressWarnings("all")

public class ExtArrayList<E> implements ExtList<E> {

	//ArrayList�ײ����������
	private transient Object [] elementData;
	//Ĭ����������
	private static final int DEFAULT_CAPACITY=10;
	//��¼ʵ��ArrayList��С
	private int size;
	
	//��ArrayList��ʼ������
	public ExtArrayList(int initialCapacity) {
		if(initialCapacity<0) {
			throw new IllegalArgumentException("��ʼ����������С��0");
		}
		elementData=new Object[initialCapacity];
	}
	
	//Ĭ�ϳ�ʼ������Ϊ10
	public ExtArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	//�̰߳�ȫ����
	public void add(E e) {
		//��ԭ������������С+1
		ensureExplicitCapacity(size+1);
		//2.ʹ���±��������и�ֵ
		elementData[size++]=e;
	}
	//�����±����Ԫ��
	public void add(int index,E e) {
		//1.��������±��Ƿ�Խ��
		rangeCheck(index);
		//2.�����߼�����
		ensureExplicitCapacity(size+1);
		//��λ
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		//�滻ָ���±�λ��Ԫ��
		elementData[index]=e;
		//���鳤�ȼ�1
		size++;

	}
	//�����߼�����
	private void ensureExplicitCapacity(int minCapacity){
		//1.�ж�ʵ�ʴ�ŵ����������Ƿ����elementData--Ĭ��10
		if(size==elementData.length) {
			//ԭ������elementData������С
			int oldCapacity=elementData.length;
			//��������С
			int newCapacity=oldCapacity+(oldCapacity >> 1);
			//minCapacity������С��������--ԭ������+1
			if(newCapacity-minCapacity<0) {
				//���ٱ�֤������ԭ����������1
				newCapacity=minCapacity;
			}
			//�������鸳ֵ�������� ������������ָ��������
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	
	}
	//ʹ���±��ȡ����Ԫ��
	public E get(int index) {
		//�ж������±��Ƿ�Խ��
		rangeCheck(index);
		return elementData(index);
	}
	E elementData(int  index) {
		return (E) elementData;
	}
	//���������±�λ��ɾ��
	public E remove(int index) {
		//1.ʹ���±��ȡ����Ԫ��
		E e = get(index);
		//2,����ɾ��Ԫ�غ���ĳ���
		int numMoved=size-index-1;
		if(numMoved>0) {
			//ɾ��ԭ����� ʹ��arraycopy��ǰ�ƶ����ݣ������һ����Ϊ��
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}else {
			//�����һ��Ԫ���ÿ�
			elementData[--size]=null;
		}
		return e;	
	}
	//�����������ɾ��
	public boolean remove(E e) {
		//1.ѭ����������
		for (int i = 0; i < elementData.length; i++) {
			//�õ�ÿ�������±��Ӧ��ֵ
			Object value = elementData[i];
			//�ж�ѭ���õ�������ֵ��Ҫɾ����Ԫ��ֵ�Ƿ����
			if(value.equals(e)) {
				//��ȵĻ�������Ԫ���±�λ��ɾ��
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	//��������±��Ƿ�Խ��
	private void rangeCheck(int index) {
		if(index>=size) {
			throw new IndexOutOfBoundsException("����Խ����");
		}
	}
	public int getSize() {
		return size;
	}
}




