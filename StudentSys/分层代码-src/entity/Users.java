package entity;

//�û���
public class Users {
	 private int uid;//�û�id
	 private String name;//�û�����
	 private String password;//�û�����
	 
	 //�޲ι��췽��
	 public Users(){
		 
	 }
	 //�вι��췽��
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
