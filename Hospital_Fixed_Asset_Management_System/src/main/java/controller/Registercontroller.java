package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import common.AjaxResult;
import domain.SysUser_SysRoleKey;
import domain.T_SysRole;
import domain.T_SysUser;
import domain.registerUser;

import services.Registerservice;

@Controller
public class Registercontroller {
	
	@Autowired
	private Registerservice registerservice;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult register(registerUser registeruser){
		// 创建相关对象
		T_SysUser User = new T_SysUser();
		SysUser_SysRoleKey sysuser_sysrole = new SysUser_SysRoleKey();
		AjaxResult result = new AjaxResult();
		// 为需要插入的user添加值
		User.setLoginAccount(registeruser.getLoginAccount());
		User.setName(registeruser.getName());
		User.setPassWord(registeruser.getPassWord());
		// 检查插入的账号是否存在
		if(registerservice.checkuser(User)){
			result.setMessage("该账号已存在");
			result.setSuccess(false);
		}else{
			// 插入user成功后获得userid，为插入sysuser_sysrole做准备
			sysuser_sysrole.setSysUserId(registerservice.register_insertuser(User));
			sysuser_sysrole.setSysRoleId(registeruser.getRoleid());
			// 所有插入操作成功，注册成功
			if(registerservice.register_insertuserrole(sysuser_sysrole)){
				result.setSuccess(true);
				result.setUrl("/sysrolelist");
			}else{
				result.setMessage("注册失败");
				result.setSuccess(false);
			}
		}
		return result;
		
	}
}
