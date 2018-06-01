package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import common.Constants;

import common.AjaxResult;

import domain.SysUser_SysRoleKey;
import domain.T_SysUser;

import services.Loginservice;

@Controller
public class Logincontroller {
	
	@Autowired
	private Loginservice loginservice;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult login(T_SysUser user,SysUser_SysRoleKey user_role,HttpSession session){
		AjaxResult result = new AjaxResult();
		T_SysUser ruser = loginservice.loginuser(user);
		if(ruser != null){
			user_role.setSysUserId(ruser.getId());
			List<SysUser_SysRoleKey> ruser_role = loginservice.selectuserrole(user_role);
			if(ruser_role.size() > 0){
				String Password = ruser.getPassWord();
				if (!Password.equals(user.getPassWord())) {
					result.setMessage("用户名密码错误");
					return result;
				}
				if (ruser.getStatus() == Constants.LONGIN_STATUS) {
					result.setMessage("用户已被禁用");
					return result;
				}
				result.setSuccess(true);
				result.setUrl("/index");
				session.setAttribute("user", ruser);
			}else{
				result.setSuccess(false);
				result.setMessage("该用户不在该此登录权限内");	
			}
		}else{
			result.setSuccess(false);
			result.setMessage("该账号不存在");
		}
		return result;
		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult logout(HttpSession session,HttpServletRequest request){
		AjaxResult result = new AjaxResult();
		session = request.getSession(false);
		session.removeAttribute("user");
		return result;
	}
	
	
}
