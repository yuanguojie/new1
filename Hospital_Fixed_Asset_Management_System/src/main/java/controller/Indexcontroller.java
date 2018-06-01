package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import common.EasyUITree;
import common.Tools;
import domain.T_SysUser;


import services.Indexservice;
import services.Menuservice;

@Controller
public class Indexcontroller {
	
	@Autowired
	private Indexservice indexservice;
	
	@Autowired
	private Menuservice menuservice;
	
	@RequestMapping(value = "/index")
	public String indexbrowse(Model model, HttpSession session) {
		String projectName = Tools.getPropertiesByKey("/config.properties", "projectName");

		model.addAttribute("projectName", projectName);
		T_SysUser user = (T_SysUser) session.getAttribute("user");
		if (user==null){
			return "/sysuser/register";
		}
		String ModuleString = menuservice.getModuleString(user.getId());
		model.addAttribute("ModuleString", ModuleString);
		return "/home/index";
	}
	
	@RequestMapping("/getTree/{parentId}")
	@ResponseBody
	public List<EasyUITree> getTrees(@PathVariable(value = "parentId") String parentId, HttpSession session) {
		T_SysUser user = (T_SysUser) session.getAttribute("user");
		return menuservice.getTreeNode(user.getId(), Integer.parseInt(parentId));

	}
		
}
