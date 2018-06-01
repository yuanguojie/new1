package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.SysUser_SysRoleKey;
import domain.T_SysRole;
import domain.T_SysUser;

import Mapper.SysUser_SysRoleMapper;
import Mapper.T_SysRolekey;
import Mapper.T_SysUserMapper;

@Service
public class Registerservice {
	
	@Autowired
	private T_SysUserMapper sysuser;
	@Autowired
	private T_SysRolekey sysrole;
	@Autowired
	private SysUser_SysRoleMapper sysuser_sysrole;
	
	public boolean checkuser(T_SysUser user){
		boolean ret = false;
		if(sysuser.selectByLoginAccount(user) != null){
			ret = true;
		}
		return ret;
	}
	public int register_insertuser(T_SysUser user){
		int ret = 0;
		if(sysuser.insertSelective(user) == 1){
			ret = (sysuser.selectByLoginAccount(user)).getId();
		}
		return ret;
		
	}
	public boolean register_insertuserrole(SysUser_SysRoleKey sysUser_sysRole){
		boolean ret = false;
		if(sysuser_sysrole.insert(sysUser_sysRole) == 1){
			ret = true;
		}
		
		return ret;
	}

}
