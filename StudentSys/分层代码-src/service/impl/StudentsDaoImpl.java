package service.impl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import service.StudentsDao;
import entity.Students;

public class StudentsDaoImpl implements StudentsDao {

	@Override
	public List<Students> queryAllStudent() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			// hql语句对应实体的类来查找，有大小写之分
			hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
			// 查询出来的结果集排序，按升序排序
			Collections.sort(list, new StudentComparator());
			tx.commit();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.commit();
			return list;
		} finally {
			if (tx != null) {
				tx = null;
			}

		}
	}

	// 查询单个学生信息bysid
	@Override
	public Students queryStudent(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Students s = null;

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			s = (Students) session.get(Students.class, sid);
			tx.commit();
			return s;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.commit();
			return s;
		} finally {
			if (tx != null) {
				tx = null;
			}

		}
	}

	// 添加学生信息
	@Override
	public boolean addStudent(Students s) {
		Transaction tx = null;
		s.setSid(this.getNewSid());
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();

			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}

		}
	}

	// 删除学生信息
	@Override
	public boolean deleteStudent(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();

			Students s = (Students) session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {

				tx = null;
			}

		}
	}

	// 修改学生信息
	@Override
	public boolean updateStudent(Students s) {
		Transaction tx = null;

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}

		}
	}

	// 生成唯一主键方法
	private String getNewSid() {

		Transaction tx = null;
		String hql = "";
		String sid = null;

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			// 查找数据库中最大的sid 再加一
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();
			if (sid == null || "".equals(sid)) {
				sid = "S0000001";
			} else {
				String temp = sid.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				temp = String.valueOf(i);
				int len = temp.length();
				for (int j = 0; j < 7 - len; j++) {
					temp = "0" + temp;
				}
				sid = "S" + temp;
			}
			tx.commit();
			return sid;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.commit();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}

		}

	}

	@Override
	public Students queryStudentByName(String sname) {
		// TODO Auto-generated method stub

		Transaction tx = null;
		Students s = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql="from Students where sname=?";
			Query query=session.createQuery(hql);	
			query.setParameter(0,sname);
			s=(Students) query.uniqueResult();
			tx.commit();
			return s;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.commit();
			return s;
		} finally {
			if (tx != null) {
				tx = null;
			}

		}
	}

}
