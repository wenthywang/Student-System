package service.impl;

import java.util.Comparator;

import entity.Students;
/*
 * ��ʱ�ıȽϹ���
 */
public class StudentComparator implements Comparator<Students> {


	@Override
	public int compare(Students s1, Students s2) {
		// TODO Auto-generated method stub
		//�ȽϹ���
		return s1.getSid().compareTo(s2.getSid());
	}

}
