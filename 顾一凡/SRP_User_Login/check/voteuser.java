package check;



public class voteuser {
	private long Id;			//ID序列号
	private String UserName;	//用户名
	private String PassWord;    //密码
	private String Names;		//姓名
	private String Sex;			//性别
	private String Address;		//地址
	private String Phone;		//电话
	private String Post;		//邮编
	private String Email;   	//电子邮件地址
	private String RegTime; 	//用户注册时间
	private String RegIpAddress; //用户注册时IP地址	

	public voteuser() {
		Id = 0;
		UserName = "";
		PassWord = "";
		Names = "";
		Sex = "";
		Address = "";
		Phone = "";
		Post = "";
		Email = "";
		RegTime = "";
		RegIpAddress = "";
	}

    public long getId() {
		return Id;
	}

	public void setId(long newId) {
		this.Id = newId;
	}

	public String getUserName() {
		return UserName;
	}
	
	public void setUserName(String newUserName) {
		this.UserName = newUserName;
	}

	public String getPassWord() {
		return PassWord;
	}
	
	public void setPassWord(String newPassWord) {
		this.PassWord = newPassWord;
	}

	public String getNames() {
		return Names;
	}
	
	public void setNames(String newNames) {
		this.Names = newNames;
	}

	public String getSex() {
		return Sex;
	}
	
	public void setSex(String newSex) {
		this.Sex = newSex;
	}

	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String newAddress) {
		this.Address = newAddress;
	}

	public String getPhone() {
		return Phone;
	}
	
	public void setPhone(String newPhone) {
		this.Phone = newPhone;
	}

	public String getPost() {
		return Post;
	}
	
	public void setPost(String newPost) {
		this.Post = newPost;
	}

	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String newEmail) {
		this.Email = newEmail;
	}

	public String getRegTime() {
		return RegTime;
	}
	
	public void setRegTime(String newRegTime) {
		this.RegTime = newRegTime;
	}

	public String getRegIpAddress() {
		return RegIpAddress;
	}
	
	public void setRegIpAddress(String newRegIpAddress) {
		this.RegIpAddress = newRegIpAddress;
	}


}

