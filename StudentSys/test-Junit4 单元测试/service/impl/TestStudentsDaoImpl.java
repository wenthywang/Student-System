package service.impl;

import java.util.List;

import org.junit.Test;

import service.StudentsDao;
import entity.Students;

public class TestStudentsDaoImpl {
	@Test
	public void testQueryAllStudents(){
	     
		 List<Students> stuList=null;
		 StudentsDao stu=new StudentsDaoImpl();
		 stuList=stu.queryAllStudent();
		  for (Students s : stuList) {
			System.out.println(s);
		}
	
		
		
		
		
		
			
		}
}
