package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import common.AjaxResult;

import services.UIservice;

@Controller
public class UIcontroller {

	@Autowired
	private UIservice ui;
	
	@RequestMapping(value = "/sysrolelist")
	public String rolelist(Model model){
		
		String sysrole = ui.rolelist();
		model.addAttribute("rolelist", sysrole);
		
		return "/sysuser/login";
	}
	
	@RequestMapping(value = "/deptlist")
	public String deptlist(Model model){
		
		String dept = ui.Deptlist();
		model.addAttribute("deptlist", dept);
		
		return "/sysuser/login";
	}
	
	@RequestMapping(value = "/storagelist")
	public String storagelist(Model model){
		
		String storage = ui.storagelist();
		model.addAttribute("storagelist", storage);
		
		return "/sysuser/login";
	}
	
	@RequestMapping(value = "/s_dlist")
	public String s_dlist(Model model){
		
		String storage = ui.storagelist();
		model.addAttribute("storagelist", storage);
		String dept = ui.Deptlist();
		model.addAttribute("deptlist", dept);
		return "/instockmanage/inflow";
	}
	
	@RequestMapping(value = "/addfixedasset")
	public String Addfixedasset(Model model){
		String fixedassettype = ui.assettypelist();
		model.addAttribute("assettype", fixedassettype);
		String unit = ui.unitlist();
		model.addAttribute("unit", unit);
		return "/fixedassetmanage/addfixedasset";
	}
	
	@RequestMapping(value = "/movestocklog")
	public String Movestocklog(Model model){
		String instorage = ui.storagelist();
		model.addAttribute("instoragelist", instorage);
		String indept = ui.Deptlist();
		model.addAttribute("indeptlist", indept);
		String outstorage = ui.storagelist();
		model.addAttribute("outstoragelist", outstorage);
		String outdept = ui.Deptlist();
		model.addAttribute("outdeptlist", outdept);
		String inemp = ui.Emplist();
		model.addAttribute("inemplist", inemp);
		String outemp = ui.Emplist();
		model.addAttribute("outemplist", outemp);
		
		return "/movestockmanage/movestocklog";
	}
	
	@RequestMapping(value = "/takestockaddflow")
	public String Takestockaddflow(Model model){
		String storage = ui.storagelist();
		model.addAttribute("storagelist", storage);
		String dept = ui.Deptlist();
		model.addAttribute("deptlist", dept);
		return "/takestockmanage/addflow";
	}
	
}
