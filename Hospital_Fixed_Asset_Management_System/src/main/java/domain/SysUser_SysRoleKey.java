package domain;

public class SysUser_SysRoleKey {
    private Integer sysUserId;

    private Integer sysRoleId;
    
    private T_SysUser User;
    
    private T_SysRole Role;
    

    public T_SysUser getUser() {
		return User;
	}

	public void setUser(T_SysUser user) {
		this.User = user;
	}

	public T_SysRole getRole() {
		return Role;
	}

	public void setRole(T_SysRole role) {
		Role = role;
	}

	public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
}