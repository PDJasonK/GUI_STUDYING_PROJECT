package BCDLOGDATA;

public class LoginVo {
	   private String id;
	   private String pwd;
	   private String resid;
	   private String name;
	   private String PhoneNums;
	   private String teacher;
	   

	   public LoginVo() {

	   }

	   public LoginVo(String id, String pwd , String resid , String name , String PhoneNums , String  teacher) {
	      this.id = id;
	      this.pwd = pwd;
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
		      return pwd;
		   }
	   public String getPhoneNums() {
		      return pwd;
		   }
	   public String getteacher() {
		      return teacher;
		   }
	}