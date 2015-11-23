package service;

import java.util.List;

import entity.Students;

//学生业务逻辑接口
public interface StudentsDao {

	//查询所有学生信息
	public List<Students> queryAllStudent();
	//查询单个学生信息,根据学生编号
	public Students queryStudent(String sid);
	//查询单个学生信息,根据学生名称
	public Students queryStudentByName(String sname);
	//添加学生信息
	public boolean addStudent(Students s);
	
	public boolean updateStudent(Students s);
	//删除学生信息
	public boolean deleteStudent(String sid);
	
}
