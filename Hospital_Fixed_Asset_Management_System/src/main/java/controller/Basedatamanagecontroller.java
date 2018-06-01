package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import common.AjaxResult;

import domain.T_ADA;
import domain.T_Depreciation;
import domain.T_Depreciationmethod;
import domain.T_Dept;
import domain.T_Emp;
import domain.T_Fixed_Asset;
import domain.T_Fixed_Asset_Type;
import domain.T_InStock;
import domain.T_InStockDtl;
import domain.T_MoveStock;
import domain.T_MoveStockDtl;
import domain.T_RemainStock;
import domain.T_Storage;
import domain.T_TakeStock;
import domain.T_TakeStockDtl;
import domain.T_Unit;
import domainextand.remainstockview;


import services.Basedatamanageservice;

@Controller
public class Basedatamanagecontroller {
	
	@Autowired
	private Basedatamanageservice basedataservice;
	
	/*
	 * 各基础数据查询
	 */
	@RequestMapping(value="/empselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_Emp> EmpSelect(T_Emp name, HttpSession session) {
		List<T_Emp> listemp = basedataservice.selectEmp(name);
		for(T_Emp emp : listemp){
			emp.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnempedit' onclick='getemp("+emp.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnempremove' onclick='removeemp("+emp.getId()+")' href='#'></a>" +
							"<input name='Empid' type='hidden' value="+emp.getId()+">");
		}
		return listemp;
	}
	@RequestMapping(value="/deptselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_Dept> DeptSelect(T_Dept name, HttpSession session) {
		List<T_Dept> listdept = basedataservice.selectDept(name);
		for(T_Dept dept : listdept){
			dept.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btndeptedit' onclick='getdept("+dept.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btndeptremove' onclick='removedept("+dept.getId()+")' href='#'></a>" +
							"<input name='Deptid' type='hidden' value="+dept.getId()+">");
		}
		return listdept;
	}
	@RequestMapping(value="/fdtselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_Fixed_Asset> FixedAssetSelect(T_Fixed_Asset name, HttpSession session) {
		List<T_Fixed_Asset> listfdt = basedataservice.selectFixedAsset(name);
		for(T_Fixed_Asset fdt : listfdt){
			fdt.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnfdtedit' onclick='getfdt("+fdt.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnfdtremove' onclick='removefdt("+fdt.getId()+")' href='#'></a>" +
							"<input name='Fdtid' type='hidden' value="+fdt.getId()+">");
		}
		return listfdt;
	}
	@RequestMapping(value="/fdttypeselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_Fixed_Asset_Type> FixedAssetTypeSelect(T_Fixed_Asset_Type name, HttpSession session) {
		List<T_Fixed_Asset_Type> listfdttype = basedataservice.selectFixedAssetType(name);
		for(T_Fixed_Asset_Type fdttype : listfdttype){
			fdttype.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnfdttypeedit' onclick='getfdttype("+fdttype.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnfdttyperemove' onclick='removefdttype("+fdttype.getId()+")' href='#'></a>" +
							"<input name='Fdttypeid' type='hidden' value="+fdttype.getId()+">");
		}
		return listfdttype;
	}
	@RequestMapping(value="/getfdttype",method = RequestMethod.POST)
	@ResponseBody
	public T_Fixed_Asset_Type getFixedAssetType(int id){
		return basedataservice.selectFixedAssetType2(id);
	}
	@RequestMapping(value="/depreselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_Depreciation> DepreciationSelect(T_Depreciation name, HttpSession session) {
		List<T_Depreciation> listdepre = basedataservice.selectDepreciation(name);
		for(T_Depreciation depre : listdepre){
			depre.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btndepreedit' onclick='getdepre("+depre.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btndepreremove' onclick='removedepre("+depre.getId()+")' href='#'></a>" +
							"<input name='Depreid' type='hidden' value="+depre.getId()+">");
		}
		return listdepre;
	}
	@RequestMapping(value="/depremselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_Depreciationmethod> DepreciationmethodSelect(T_Depreciationmethod name, HttpSession session) {
		List<T_Depreciationmethod> listdeprem = basedataservice.selectDepreciationmethod(name);
		for(T_Depreciationmethod deprem : listdeprem){
			deprem.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btndepremedit' onclick='getdeprem("+deprem.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btndepremremove' onclick='removedeprem("+deprem.getId()+")' href='#'></a>" +
							"<input name='Depremid' type='hidden' value="+deprem.getId()+">");
		}
		return listdeprem;
	}
	@RequestMapping(value="/adaselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_ADA> ADASelect(T_ADA name, HttpSession session) {
		List<T_ADA> listada = basedataservice.selectADA(name);
		for(T_ADA ada : listada){
			ada.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnadaedit' onclick='getada("+ada.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnadaremove' onclick='removeada("+ada.getId()+")' href='#'></a>" +
							"<input name='ADAid' type='hidden' value="+ada.getId()+">");
		}
		return listada;
	}	
	@RequestMapping(value="/instockselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_InStock> InStockSelect(T_InStock name, HttpSession session) {
		List<T_InStock> listinstock = basedataservice.selectInStock(name);
		for(T_InStock instock : listinstock){
			instock.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btninstockedit' onclick='getinstock("+instock.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btninstockremove' onclick='removeinstock("+instock.getId()+")' href='#'></a>" +
							"<input name='InStockid' type='hidden' value="+instock.getId()+">");
		}
		return listinstock;
	}	
	@RequestMapping(value="/instockdtlselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_InStockDtl> InStockDtlSelect(T_InStockDtl name, HttpSession session) {
		List<T_InStockDtl> listinstockdtl = basedataservice.selectInStockDtl(name);
		for(T_InStockDtl instockdtl : listinstockdtl){
			instockdtl.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btninstockdtledit' onclick='getinstockdtl("+instockdtl.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btninstockdtlremove' onclick='removeinstockdtl("+instockdtl.getId()+")' href='#'></a>" +
							"<input name='InStockDtlid' type='hidden' value="+instockdtl.getId()+">");
		}
		return listinstockdtl;
	}	
	@RequestMapping(value="/movestockselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_MoveStock> MoveStockSelect(T_MoveStock name, HttpSession session) {
		List<T_MoveStock> listmovestock = basedataservice.selectMoveStock(name);
		for(T_MoveStock movestock : listmovestock){
			movestock.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnmovestockedit' onclick='getmovestock("+movestock.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnmovestockremove' onclick='removemovestock("+movestock.getId()+")' href='#'></a>" +
							"<input name='MoveStockid' type='hidden' value="+movestock.getId()+">");
		}
		return listmovestock;
	}	
	@RequestMapping(value="/movestockdtlselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_MoveStockDtl> MoveStockDtlSelect(T_MoveStockDtl name, HttpSession session) {
		List<T_MoveStockDtl> listmovestockdtl = basedataservice.selectMoveStockDtl(name);
		for(T_MoveStockDtl movestockdtl : listmovestockdtl){
			movestockdtl.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnmovestockdtledit' onclick='getmovestockdtl("+movestockdtl.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnmovestockdtlremove' onclick='removemovestockdtl("+movestockdtl.getId()+")' href='#'></a>" +
							"<input name='MoveStockDtlid' type='hidden' value="+movestockdtl.getId()+">");
		}
		return listmovestockdtl;
	}	
	@RequestMapping(value="/rstockselect",method = RequestMethod.GET)
	@ResponseBody
	public List<remainstockview> RemainStockSelect(T_RemainStock name, HttpSession session) {
		List<T_RemainStock> listrstock = basedataservice.selectRemainStock(name);
		List<remainstockview> remainstocklist = new ArrayList<remainstockview>();
		for(T_RemainStock rstock : listrstock){
			remainstockview remainstock = new remainstockview();
			remainstock.setId(rstock.getId());
			remainstock.setAmount(rstock.getAmount());
			remainstock.setAssetId(basedataservice.selectFixedAssetbyId(rstock.getAssetId()).getName());
			remainstock.setDeptId(basedataservice.selectDeptbyid(rstock.getDeptId()).getName());
			remainstock.setStorageId(basedataservice.selectStoragebyid(rstock.getStorageId()).getName());
			remainstock.setPrice(rstock.getPrice());
			remainstock.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnrstockedit' onclick='getrstock("+rstock.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnrstockremove' onclick='removerstock("+rstock.getId()+")' href='#'></a>" +
							"<input name='Rstockid' type='hidden' value="+rstock.getId()+">");
			remainstocklist.add(remainstock);
		}
		return remainstocklist;
	}	
	@RequestMapping(value="/storageselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_Storage> StorageSelect(T_Storage name, HttpSession session) {
		List<T_Storage> liststorage = basedataservice.selectStorage(name);
		for(T_Storage storage : liststorage){
			storage.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnstorageedit' onclick='getstorage("+storage.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnstorageremove' onclick='removestorage("+storage.getId()+")' href='#'></a>" +
							"<input name='Storageid' type='hidden' value="+storage.getId()+">");
		}
		return liststorage;
	}	
	@RequestMapping(value="/tstockselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_TakeStock> TakeStockSelect(T_TakeStock name, HttpSession session) {
		List<T_TakeStock> listtstock = basedataservice.selectTakeStock(name);
		for(T_TakeStock tstock : listtstock){
			tstock.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btntstockedit' onclick='gettstock("+tstock.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btntstockremove' onclick='removetstock("+tstock.getId()+")' href='#'></a>" +
							"<input name='TStockid' type='hidden' value="+tstock.getId()+">");
		}
		return listtstock;
	}	
	@RequestMapping(value="/tstockdtlselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_TakeStockDtl> TakeStockDtlSelect(T_TakeStockDtl name, HttpSession session) {
		List<T_TakeStockDtl> listtstockdtl = basedataservice.selectTakeStockDtl(name);
		for(T_TakeStockDtl tstockdtl : listtstockdtl){
			tstockdtl.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btntstockdtledit' onclick='gettstockdtl("+tstockdtl.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btntstockdtlremove' onclick='removetstockdtl("+tstockdtl.getId()+")' href='#'></a>" +
							"<input name='TStockDtlid' type='hidden' value="+tstockdtl.getId()+">");
		}
		return listtstockdtl;
	}	
	@RequestMapping(value="/unitselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_Unit> UnitSelect(T_Unit name, HttpSession session) {
		List<T_Unit> listunit = basedataservice.selectUnit(name);
		for(T_Unit unit : listunit){
			unit.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnunitedit' onclick='getunit("+unit.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnunitremove' onclick='removeunit("+unit.getId()+")' href='#'></a>" +
							"<input name='Unitid' type='hidden' value="+unit.getId()+">");
		}
		return listunit;
	}

	/*
	 * 各数据的添加
	 */
	@RequestMapping(value="/addfdttype",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult FixedAssetTypeAdd(T_Fixed_Asset_Type name){
		AjaxResult result = new AjaxResult();
		if(basedataservice.addFixedAssetType(name)){
			result.setSuccess(true);
			result.setMessage("数据添加成功");
		}else{
			result.setSuccess(false);
			result.setMessage("数据添加失败");
		}
		return result;
	}
	@RequestMapping(value="/addfdt",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult FixedAssetAdd(T_Fixed_Asset name){
		AjaxResult result = new AjaxResult();
		if(basedataservice.addFixedAsset(name)){
			List<T_Fixed_Asset> fa = new ArrayList<T_Fixed_Asset>();
			fa = basedataservice.selectFixedAsset(name);
			result.setValue((fa.get(fa.size()-1)).getId());
			result.setSuccess(true);
			result.setMessage("数据添加成功");
		}else{
			result.setSuccess(false);
			result.setMessage("数据添加失败");
		}
		
		return result;
	}

	/*
	 * 各数据的修改
	 */
	@RequestMapping(value="/updatefdttype",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult FixedAssetTypeUpdate(T_Fixed_Asset_Type name){
		AjaxResult result = new AjaxResult();
		if(basedataservice.updateFixedAssetType(name)){
			result.setSuccess(true);
			result.setMessage("数据修改成功");
		}else{
			result.setSuccess(false);
			result.setMessage("数据修改失败");
		}
		return result;
	}

	/*
	 * 各数据的删除
	 */
	@RequestMapping(value="/removefdttype",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult FixedAssetTypeDelete(int id){
		AjaxResult result = new AjaxResult();
		if(basedataservice.deleteFixedAssetType(id)){
			result.setSuccess(true);
			result.setMessage("数据删除成功");
		}else{
			result.setSuccess(false);
			result.setMessage("数据删除失败");
		}
		return result;
	}
}
