package entity;

//用户类
public class Users {
	 private int uid;//用户id
	 private String name;//用户名字
	 private String password;//用户密码
	 
	 //无参构造方法
	 public Users(){
		 
	 }
	 //有参构造方法
	public Users(int uid, String name, String password) {
//		super();
		this.uid = uid;
		this.name = name;
		this.password = password;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 

}
