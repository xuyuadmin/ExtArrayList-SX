package com.xuyu.test;

import com.xuyu.arrayList.ExtArrayList;
import com.xuyu.arrayList.ExtList;

public class Test001 {

	//�ײ�������鷽ʽ
	//��ô��֤���ϴ����޴�С--�������ݼ���
	public static void main(String[] args) {
	
		//������Ʋ��ܻ�ȡ���������ͣ�ͨ���ֽ��뼼����ȡ��
		//���Ͳž������� ���Ͳ���
		ExtList<Object>listString=new ExtArrayList<Object>();
		listString.add("С��");
		listString.add("��");
		listString.add("cd");
		for (int i = 0; i < listString.getSize(); i++) {
			System.out.println(listString.get(0));
		}
	}
}
