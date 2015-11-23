package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import service.StudentsDao;
import service.impl.StudentsDaoImpl;
import entity.Students;

public class StudentsAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 查询所有学生方法
	public String query() {
		StudentsDao sdao = new StudentsDaoImpl();
		List<Students> list = null;
		if(request.getParameter("query_name")==null||"".equals(request.getParameter("query_name").trim())){
			System.out.println(request.getParameter("query_name"));
			list = sdao.queryAllStudent();
			session.setAttribute("studentList", list);
			return "query_success";
		}
		else{
			System.out.println(request.getParameter("query_name"));
		   Students s=sdao.queryStudentByName(request.getParameter("query_name").trim());
		    System.out.println(s);
//		    list = sdao.queryAllStudent();
		   session.setAttribute("studentList", s);
		  return "query_success";
		}
		
	}

	// 删除学生方法
	public String delete() {

		StudentsDao sdao = new StudentsDaoImpl();
		sdao.deleteStudent(request.getParameter("sid"));
		return "delete_success";

	}

	public String update() {
		StudentsDao sdao = new StudentsDaoImpl();
		Students s = sdao.queryStudent(request.getParameter("sid"));
		session.setAttribute("student", s);

		return "student_update";
	}

	public String save() throws Exception {
		Students s = new Students();
		s.setSid(request.getParameter("sid"));
		s.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setGender(request.getParameter("gender"));
		s.setSname(request.getParameter("sname"));

		StudentsDao sdao = new StudentsDaoImpl();
		sdao.updateStudent(s);
		return "update_success";
	}
	
	public String add() throws Exception{
		Students s = new Students();
			s.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setGender(request.getParameter("gender"));
		s.setSname(request.getParameter("sname"));

		StudentsDao sdao = new StudentsDaoImpl();
		sdao.addStudent(s);
		return "add_success";
	}

}
