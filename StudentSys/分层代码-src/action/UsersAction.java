package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import service.UsersDao;
import service.impl.UserDaoImpl;

import entity.Users;

//使用模型驱动封装实体
public class UsersAction extends SuperAction implements ModelDriven<Users> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();

	// 用户登录动作
	public String login() {
		UsersDao udao = new UserDaoImpl();
		if (udao.usersLogin(user)) {

			session.setAttribute("username", user.getName());

			return "login_success";
		} else {
			return INPUT;
		}
	}

	// struts 验证框架会处理所有action的所有方法 不需要的需要skip
	@SkipValidation
	public String logout() {

		if (session.getAttribute("username") != null) {
			session.removeAttribute("username");
		}
		return "logout_success";
	}

	// 验证框架
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if ((user.getName().trim()).equals("")) {
			// 向前台传参数，错误信息
			this.addFieldError("usernameError", "用户名不能为空！");
		}
		if (user.getPassword().length() < 6) {
			this.addFieldError("passwordError", "密码不能少于六位！");
		}

	}

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
