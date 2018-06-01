package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import common.AjaxResult;

import domain.SysMenu_SysRoleKey;
import domain.T_SysMenu;
import domain.T_SysRole;
import domain.T_SysUser;

import services.Systemmanageservice;

@Controller
public class Systemmanagecontroller {

	@Autowired
	private Systemmanageservice mgservice;
	/*
	 * role的增删改查
	 * 
	 */
	@RequestMapping(value="/roleselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_SysRole> RoleSelect(T_SysRole name, HttpSession session) {
		List<T_SysRole> listrole = mgservice.selectSysRole(name);
		for(T_SysRole role:listrole){
			role.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnroleedit' onclick='getrole("+role.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnroleremove' onclick='removerole("+role.getId()+")' href='#'></a>" +
							"<input name='Roleid' type='hidden' value="+role.getId()+">");
		}
		return listrole;
	}
	@RequestMapping(value="/getrole",method = RequestMethod.POST)
	@ResponseBody
	public T_SysRole getRole(int id){
		return mgservice.selectSysRole2(id);
	}
	
	@RequestMapping(value="/addrole",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult addRole(T_SysRole role){
		AjaxResult ret = new AjaxResult();
		if((mgservice.selectSysRole(role)).size() > 0){
			ret.setSuccess(false);
			ret.setMessage("该角色已存在");
		}else{
			if(mgservice.insertSysRole(role)){
				ret.setSuccess(true);
				ret.setMessage("添加角色成功");
			}else{
				ret.setSuccess(false);
				ret.setMessage("添加角色失败");
			}
		}
		return ret;
	}
	
	@RequestMapping(value="/updaterole",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult updateRole(T_SysRole role){
		AjaxResult ret = new AjaxResult();
		if(mgservice.UpdateRole(role)){
			ret.setSuccess(true);
			ret.setMessage("修改成功");
		}else{
			ret.setSuccess(false);
			ret.setMessage("修改失败");
		}
		
		return ret;
	}
	
	@RequestMapping(value="/removerole",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult removeRole(int id){
		AjaxResult ret = new AjaxResult();
		if(mgservice.RemoveRole(id)){
			ret.setSuccess(true);
			ret.setMessage("删除成功");
		}else{
			ret.setSuccess(false);
			ret.setMessage("删除失败");
		}
		return ret;
	}
	
	/*
	 * 菜单的增删改查
	 */
	
	@RequestMapping(value="/menuselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_SysMenu> MenuSelect(T_SysMenu name, HttpSession session){
		List<T_SysMenu> ListMenu = mgservice.selectSysMenu(name);
		for(T_SysMenu menu : ListMenu){
			menu.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnmenuedit' onclick='getmenu("+menu.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnmenuremove' onclick='removemenu("+menu.getId()+")' href='#'></a>" +
							"<input name='Menuid' type='hidden' value="+menu.getId()+">");
		}
		return ListMenu;
		
	}
	@RequestMapping(value="/getmenu",method = RequestMethod.POST)
	@ResponseBody
	public T_SysMenu getMenu(int id){
		return mgservice.selectSysMenu2(id);
	}
	@RequestMapping(value="/addmenu",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult addMenu(T_SysMenu menu,SysMenu_SysRoleKey menu_rolekey){
		AjaxResult ret = new AjaxResult();
		// 得到将要添加的菜单信息数据
		List<T_SysMenu> menus = mgservice.selectSysMenu(menu);
		// 判断该菜单数据是否存在
		if(menus.size() > 0){
			// 存在该菜单数据继续判断当前菜单对应角色是否重复
			menu_rolekey.setSysMenuId((menus.get(0)).getId());
			if((mgservice.selectmenu_role(menu_rolekey)).size()>0){
				// 菜单角色重复，不添加新的菜单角色 
				ret.setSuccess(false);
				ret.setMessage("该菜单以注册");
				return ret;
			}else{
				// 不重复，添加新角色
				if(mgservice.insertmenu_role(menu_rolekey)){
					ret.setSuccess(true);
					ret.setMessage("添加菜单成功");
				}else{
					ret.setSuccess(false);
					ret.setMessage("意外原因添加菜单失败");
				}
			}
		}else{
			// 菜单不存在，直接添加该菜单及菜单角色
			if(mgservice.insertSysMenu(menu)){
				menu_rolekey.setSysMenuId(((mgservice.selectSysMenu(menu)).get(0)).getId());
				if(mgservice.insertmenu_role(menu_rolekey)){
					ret.setSuccess(true);
					ret.setMessage("添加菜单成功");
				}else{
					ret.setSuccess(false);
					ret.setMessage("意外原因添加菜单失败");
				}
			}
		}
		return ret;
	}
	
	@RequestMapping(value="/userselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_SysUser> UserSelect(T_SysUser name, HttpSession session){
		List<T_SysUser> ListUser = mgservice.selectSysUser(name);
		for(T_SysUser user : ListUser){
			user.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnuseredit' onclick='getuser("+user.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnuserremove' onclick='removeuser("+user.getId()+")' href='#'></a>" +
							"<input name='Userid' type='hidden' value="+user.getId()+">");
		}
		return ListUser;
	}
}
