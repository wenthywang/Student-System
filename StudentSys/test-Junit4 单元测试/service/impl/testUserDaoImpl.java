package service.impl;

import junit.framework.Assert;

import org.junit.Test;

import service.UsersDao;
import entity.Users;

public class testUserDaoImpl {
	
	@Test
	public void testUsersLogin(){
		Users u =new Users(1,"ÍõÎÄ»Ô","wwh199326");
		UsersDao udao=new UserDaoImpl();
	    
		Assert.assertEquals(true,udao.usersLogin(u));
		
		
		
		
		
			
		}
	
}
