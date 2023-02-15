package BCDLOGDATA;

public class SignupVo {
	private String id;
	private String pwd;
	private String resid;
	private String name;
	private String PhoneNums;
	private String teacher;

	public SignupVo() {

	}

	public SignupVo(String id, String pwd, String resid, String name, String PhoneNums, String teacher) {
		this.id = id;
		this.pwd = pwd;
		this.resid = resid;
		this.name = name;
		this.PhoneNums = PhoneNums;
		this.teacher = teacher;

	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getresid() {
		return resid;
	}

	public String getname() {
		return name;
	}

	public String getPhoneNums() {
		return PhoneNums;
	}

	public String getteacher() {
		return teacher;
	}
}