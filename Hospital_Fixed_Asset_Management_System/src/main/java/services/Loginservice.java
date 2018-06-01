package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.SysUser_SysRoleKey;
import domain.T_SysUser;

import Mapper.SysUser_SysRoleMapper;
import Mapper.T_SysUserMapper;


@Service
public class Loginservice {
	
	@Autowired
	private T_SysUserMapper sysusermapper;
	@Autowired
	private SysUser_SysRoleMapper user_rolemapper;
	
	public T_SysUser loginuser(T_SysUser user){
		return sysusermapper.selectByLoginAccount(user);
	}
	
	public List<SysUser_SysRoleKey> selectuserrole(SysUser_SysRoleKey user_role){
		return user_rolemapper.selectUser_Role(user_role);
	}
}
