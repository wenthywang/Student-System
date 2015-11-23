package service;

import entity.Users;

//用户逻辑接口
public interface UsersDao {
	//用户登录方法
	public boolean usersLogin(Users u);

}
