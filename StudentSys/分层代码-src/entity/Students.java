package entity;



import java.util.Date;

//ѧ����
public class Students{
     
     private String sid; //ѧ��ѧ��
     private String sname;//ѧ������
     private Date birthday;//����
     private String gender;//�Ա�
     private String address;//��ַ
     
     
     
     //�����޲εĹ��췽��
	public Students() {
//		super();
	}
	//ʹ�ô��εĹ��췽��
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
	//��дtoString���� �������
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", birthday="
				+ birthday + ", gender=" + gender + ", address=" + address
				+ "]";
	}
     
     

	

}
