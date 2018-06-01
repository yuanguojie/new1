package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.SysMenu_SysRoleKey;
import domain.SysUser_SysRoleKey;
import domain.T_SysMenu;
import domain.T_SysRole;
import domain.T_SysUser;

import Mapper.SysMenu_SysRoleMapper;
import Mapper.SysUser_SysRoleMapper;
import Mapper.T_SysMenuMapper;
import Mapper.T_SysRolekey;
import Mapper.T_SysUserMapper;

@Service
public class Systemmanageservice {

	@Autowired
	private T_SysRolekey sysrole;
	
	@Autowired
	private T_SysMenuMapper sysmenu;
	
	@Autowired
	private T_SysUserMapper sysuser;
	
	@Autowired
	private SysMenu_SysRoleMapper menu_role;
	
	@Autowired
	private SysUser_SysRoleMapper user_role;
	
	
	public List<T_SysRole> selectSysRole(T_SysRole name){
		return sysrole.selectByName(name);
	}
	public T_SysRole selectSysRole2(int id){
		return sysrole.selectByPrimaryKey(id);
	}
	public boolean UpdateRole(T_SysRole role){
		boolean ret = false;
		if(sysrole.updateByPrimaryKey(role) > 0){
			ret = true;
		}
		return ret;
	}
	public boolean RemoveRole(int id){
		boolean ret = false;
		if(sysrole.deleteByPrimaryKey(id) > 0){
			ret = true;
		}
		return ret;
	}
	public boolean insertSysRole(T_SysRole role){
		boolean ret = false;
		if(sysrole.insertSelective(role) > 0){
			ret = true;
		}
		return ret;
	}
	
	
	
	public List<T_SysMenu> selectSysMenu(T_SysMenu name){
		return sysmenu.selectByName(name);
	}
	public T_SysMenu selectSysMenu2(int id){
		return sysmenu.selectByPrimaryKey(id);
	}
	public boolean insertSysMenu(T_SysMenu menu){
		boolean ret = false;
		if(sysmenu.insertSelective(menu) > 0){
			ret = true;
		}
		return ret;
	}
	
	public List<T_SysUser> selectSysUser(T_SysUser name){
		return sysuser.selectByLoginAccount2(name);
		
	}
	
	public List<SysMenu_SysRoleKey> selectmenu_role(SysMenu_SysRoleKey menu_rolekey){
		return menu_role.selectMenu_Role(menu_rolekey);
		
	}
	
	public boolean insertmenu_role(SysMenu_SysRoleKey menu_rolekey){
		boolean ret = false;
		if(menu_role.insert(menu_rolekey) > 0){
			ret = true;
		}
		return ret;
	}
	
	public List<SysUser_SysRoleKey> selectuser_role(SysUser_SysRoleKey user_rolekey){
		return user_role.selectUser_Role(user_rolekey);
	}
	
	public boolean insertuser_role(SysUser_SysRoleKey user_rolekey){
		boolean ret = false;
		if(user_role.insert(user_rolekey) > 0){
			ret = true;
		}
		return ret;
	}
	
}
