package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.T_Dept;
import domain.T_Emp;
import domain.T_Fixed_Asset_Type;
import domain.T_Storage;
import domain.T_SysRole;
import domain.T_SysUser;
import domain.T_Unit;



@Service
public class UIservice {

	@Autowired
	private Basedatamanageservice bservice;
	@Autowired
	private Systemmanageservice sysservice;
	
	public String rolelist(){
		String result = "";
		String options = "<option value='%s'>%s</option>\r\n";
		List<T_SysRole> sysrolelist = sysservice.selectSysRole(null);
		for(T_SysRole role : sysrolelist){
			result += String.format(options, role.getId().toString(),role.getName());
		}
		return result;
	}
	
	public String Deptlist(){
		String result = "";
		String options = "<option value='%s'>%s</option>\r\n";
		List<T_Dept> deptlist = bservice.selectDept(null);
		for(T_Dept dept : deptlist){
			result += String .format(options, dept.getId().toString(),dept.getName());
		}
		
		return result;
	}
	
	public String storagelist(){
		String result = "";
		String options = "<option value='%s'>%s</option>\r\n";
		List<T_Storage> storagelist = bservice.selectStorage(null);
		for(T_Storage storage : storagelist){
			result += String .format(options, storage.getId().toString(),storage.getName());
		}
		
		return result;
	}
	
	public String assettypelist(){
		String result = "";
		String options = "<option value='%s'>%s</option>\r\n";
		List<T_Fixed_Asset_Type> assettypelist = bservice.selectFixedAssetType(null);
		for(T_Fixed_Asset_Type type : assettypelist){
			result += String.format(options, type.getId().toString(),type.getName());
		}
		return result;
	}
	
	public String unitlist(){
		String result = "";
		String options = "<option value='%s'>%s</option>\r\n";
		List<T_Unit> ulist = bservice.selectUnit(null);
		for(T_Unit unit : ulist){
			result += String.format(options, unit.getId().toString(),unit.getName());
		}
		return result;
	}
	
	public String Emplist(){
		String result = "";
		String options = "<option value='%s'>%s</option>\r\n";
		List<T_Emp> emplist = bservice.selectEmp(null);
		for(T_Emp emp : emplist){
			result += String.format(options, emp.getId().toString(),emp.getName());
		}
		return result;
	}
	
	public String Userlist(){
		String result = "";
		String options = "<option value='%s'>%s</option>\r\n";
		List<T_SysUser> userlist = sysservice.selectSysUser(null);
		for(T_SysUser user : userlist){
			result += String.format(options, user.getId().toString(),user.getName());
		}
		return result;
	}
	
}
