package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;



public class testStudents {
	
	@Test
	public void testSchemaExport(){
		//创建配置对象
		 Configuration config =new Configuration().configure();
		 //创建服务注册对象
		 ServiceRegistry seriviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//获得会话工厂
		 SessionFactory sessionFactory=config.buildSessionFactory(seriviceRegistry);
		 //打开会话工厂
		 Session session=sessionFactory.getCurrentSession();
		 //调用hibernate的schemaexport
		 SchemaExport export=new SchemaExport(config);
		 //第一个参数，创建表结构
		 //第二个参数，输出sql语句
		 export.create(true, true);
		 
		 
	}
	@Test
	public void testSaveStudents(){
		//创建配置对象
		 Configuration config =new Configuration().configure();
		 //创建服务注册对象
		 ServiceRegistry seriviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//获得会话工厂
		 SessionFactory sessionFactory=config.buildSessionFactory(seriviceRegistry);
		 //打开会话工厂
		 Session session=sessionFactory.getCurrentSession();
		 //调用hibernate的schemaexport
		Transaction tx=session.beginTransaction();
		   //创建学生对象 保存到数据中
		Students stu1=new Students("S0000001","王歌",new Date(),"男","广大");
		Students stu2=new Students("S0000002","慕课",new Date(),"女","华工");
		Students stu3=new Students("S0000003","张珊珊",new Date(),"男","广药");
		Students stu4=new Students("S0000004","李海峰",new Date(),"女","广工");
		Students stu5=new Students("S0000005","许生气",new Date(),"男","中大");
		Students stu6=new Students("S0000006","王歌",new Date(),"男","广大");
		Students stu7=new Students("S0000007","慕课",new Date(),"女","华工");
		Students stu8=new Students("S0000008","张珊珊",new Date(),"男","广药");
		Students stu9=new Students("S0000009","李海峰",new Date(),"女","广工");
		Students stu10=new Students("S0000010","许生气",new Date(),"男","中大");
		session.save(stu1);
		session.save(stu2);
		session.save(stu3);
		session.save(stu4);
		session.save(stu5);
		session.save(stu6);
		session.save(stu7);
		session.save(stu8);
		session.save(stu9);
		session.save(stu10);
		
	
		tx.commit();
	   
		 
		 
	}

}
