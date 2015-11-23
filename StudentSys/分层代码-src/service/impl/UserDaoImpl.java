package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.UsersDao;
import db.MyHibernateSessionFactory;
import entity.Users;

public class UserDaoImpl implements UsersDao {

	@Override
	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		String hql="";
		
		try {
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		    
			tx=session.beginTransaction();
		
			hql="from Users where name=? and password=? ";
			Query query=session.createQuery(hql);	
			query.setParameter(0,u.getName());
			query.setParameter(1,u.getPassword());
			List list=query.list();
			tx.commit();//提交事务
			if(list.size()>0){
				return true;
			}
			else{
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally{
			if(tx!=null){
				
				tx=null;
			}
		}
	}

}
