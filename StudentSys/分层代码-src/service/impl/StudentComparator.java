package service.impl;

import java.util.Comparator;

import entity.Students;
/*
 * 临时的比较规则
 */
public class StudentComparator implements Comparator<Students> {


	@Override
	public int compare(Students s1, Students s2) {
		// TODO Auto-generated method stub
		//比较规则
		return s1.getSid().compareTo(s2.getSid());
	}

}
