package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import service.UsersDao;
import service.impl.UserDaoImpl;

import entity.Users;

//ʹ��ģ��������װʵ��
public class UsersAction extends SuperAction implements ModelDriven<Users> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();

	// �û���¼����
	public String login() {
		UsersDao udao = new UserDaoImpl();
		if (udao.usersLogin(user)) {

			session.setAttribute("username", user.getName());

			return "login_success";
		} else {
			return INPUT;
		}
	}

	// struts ��֤��ܻᴦ������action�����з��� ����Ҫ����Ҫskip
	@SkipValidation
	public String logout() {

		if (session.getAttribute("username") != null) {
			session.removeAttribute("username");
		}
		return "logout_success";
	}

	// ��֤���
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if ((user.getName().trim()).equals("")) {
			// ��ǰ̨��������������Ϣ
			this.addFieldError("usernameError", "�û�������Ϊ�գ�");
		}
		if (user.getPassword().length() < 6) {
			this.addFieldError("passwordError", "���벻��������λ��");
		}

	}

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
