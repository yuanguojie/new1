package domain;

public class registerUser {
	private String name;

    private String loginAccount;

    private String passWord;

    private Integer status;
    
    private Integer Roleid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRoleid() {
		return Roleid;
	}

	public void setRoleid(Integer roleid) {
		Roleid = roleid;
	}
}
