package service;

import java.util.List;

import entity.Students;

//ѧ��ҵ���߼��ӿ�
public interface StudentsDao {

	//��ѯ����ѧ����Ϣ
	public List<Students> queryAllStudent();
	//��ѯ����ѧ����Ϣ,����ѧ�����
	public Students queryStudent(String sid);
	//��ѯ����ѧ����Ϣ,����ѧ������
	public Students queryStudentByName(String sname);
	//���ѧ����Ϣ
	public boolean addStudent(Students s);
	
	public boolean updateStudent(Students s);
	//ɾ��ѧ����Ϣ
	public boolean deleteStudent(String sid);
	
}
