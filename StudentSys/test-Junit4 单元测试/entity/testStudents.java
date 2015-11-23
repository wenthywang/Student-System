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
		//�������ö���
		 Configuration config =new Configuration().configure();
		 //��������ע�����
		 ServiceRegistry seriviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//��ûỰ����
		 SessionFactory sessionFactory=config.buildSessionFactory(seriviceRegistry);
		 //�򿪻Ự����
		 Session session=sessionFactory.getCurrentSession();
		 //����hibernate��schemaexport
		 SchemaExport export=new SchemaExport(config);
		 //��һ��������������ṹ
		 //�ڶ������������sql���
		 export.create(true, true);
		 
		 
	}
	@Test
	public void testSaveStudents(){
		//�������ö���
		 Configuration config =new Configuration().configure();
		 //��������ע�����
		 ServiceRegistry seriviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//��ûỰ����
		 SessionFactory sessionFactory=config.buildSessionFactory(seriviceRegistry);
		 //�򿪻Ự����
		 Session session=sessionFactory.getCurrentSession();
		 //����hibernate��schemaexport
		Transaction tx=session.beginTransaction();
		   //����ѧ������ ���浽������
		Students stu1=new Students("S0000001","����",new Date(),"��","���");
		Students stu2=new Students("S0000002","Ľ��",new Date(),"Ů","����");
		Students stu3=new Students("S0000003","��ɺɺ",new Date(),"��","��ҩ");
		Students stu4=new Students("S0000004","���",new Date(),"Ů","�㹤");
		Students stu5=new Students("S0000005","������",new Date(),"��","�д�");
		Students stu6=new Students("S0000006","����",new Date(),"��","���");
		Students stu7=new Students("S0000007","Ľ��",new Date(),"Ů","����");
		Students stu8=new Students("S0000008","��ɺɺ",new Date(),"��","��ҩ");
		Students stu9=new Students("S0000009","���",new Date(),"Ů","�㹤");
		Students stu10=new Students("S0000010","������",new Date(),"��","�д�");
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
