package entity;



import java.util.Date;

//学生类
public class Students{
     
     private String sid; //学生学号
     private String sname;//学生名字
     private Date birthday;//生日
     private String gender;//性别
     private String address;//地址
     
     
     
     //保留无参的构造方法
	public Students() {
//		super();
	}
	//使用带参的构造方法
	public Students(String sid, String sname, Date birthday, String gender,
			String address) {
//		super();
		this.sid = sid;
		this.sname = sname;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	//重写toString方法 方便测试
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", birthday="
				+ birthday + ", gender=" + gender + ", address=" + address
				+ "]";
	}
     
     

	

}
