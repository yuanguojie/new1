package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Mapper.T_TakeStockDtlMapper;
import Mapper.T_TakeStockMapper;

import common.AjaxResult;
import domain.T_Depreciation;
import domain.T_Fixed_Asset;
import domain.T_TakeStock;
import domain.T_TakeStockDtl;
import domainextand.T_TakeStock2;
import domainextand.takestockview;

import services.Basedatamanageservice;
import services.depreciationflowservice;
import services.takestockflowservice;

@Controller
public class takestockflowcontroller {

	@Autowired
	private takestockflowservice tsflow;
	
	@Autowired
	private depreciationflowservice depreflowservice;
	
	@Autowired
	private Basedatamanageservice baserive;
	
	@RequestMapping(value="/tsfselect",method = RequestMethod.GET)
	@ResponseBody
	public List<takestockview> SelectTSFlow(T_TakeStock2 billNo){
		List<T_TakeStock2> takestock = tsflow.selectTakeStockFlow(billNo);
		List<takestockview> tsviewlist = new ArrayList<takestockview>();
		for(T_TakeStock2 tsf : takestock){
			takestockview tsview = new takestockview();
			tsview.setBillNo(tsf.getBillNo());
			tsview.setAssetId(baserive.selectFixedAssetbyId(tsf.getAssetId()).getName());
			tsview.setCreateEmpId(baserive.selectEmpbyid(tsf.getCreateEmpId()).getName());
			tsview.setDepr_id(tsf.getDepr_id());
			tsview.setDeptId(baserive.selectDeptbyid(tsf.getDeptId()).getName());
			tsview.setFlowFlag(tsf.getFlowFlag());
			tsview.setId(tsf.getId());
			tsview.setLostAmount(tsf.getLostAmount());
			tsview.setSortCode(tsf.getSortCode());
			tsview.setStorageId(baserive.selectStoragebyid(tsf.getStorageId()).getName());
			tsview.setTotalAmount(tsf.getTotalAmount());
			tsview.setTSDate(tsf.getTSDate());
			tsview.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btntsfedit' onclick='gettsf("+tsf.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btntsfremove' onclick='removetsf("+tsf.getId()+")' href='#'></a>" +
							"<input name='Tsfid' type='hidden' value="+tsf.getId()+">");
			tsviewlist.add(tsview);
		}
		return tsviewlist;
	}
	
	@RequestMapping(value="/addtsf",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult AddTSFlow(T_TakeStock ts,T_TakeStockDtl tsdtl,HttpSession session){
		AjaxResult result = new AjaxResult();
		ts.setBillNo("00"+((tsflow.selectTakeStockFlow(null)).size()+1));
		if(tsflow.insertTakeStock(ts) && tsflow.insertTakeStockDtl(tsdtl)){
			result.setSuccess(true);
			result.setMessage("添加成功");
		}else{
			result.setSuccess(false);
			result.setMessage("添加失败");
		}
		return result;
	}
	
	@RequestMapping(value="/setdepreciation",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult setDepreciation(T_TakeStock ts){
		AjaxResult result = new AjaxResult();
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		T_TakeStock ttakestock = tsflow.selectTakeStock(ts.getId());
		T_TakeStockDtl ttakestockdtl = tsflow.selectTakeStockDtl(ts.getId());
		T_Depreciation depref = new T_Depreciation();
		List<T_Depreciation> depreflist = new ArrayList<T_Depreciation>();
		depref.setAssetId(ttakestockdtl.getAssetId());
		if(depreflowservice.insertdepre(depref)){
			depreflist = depreflowservice.selectDepre2(depref);
			ttakestockdtl.setDepr_id((depreflist.get(depreflist.size()-1)).getId());
		}
		ttakestock.setTakeEmpId(ts.getTakeEmpId());
		ttakestock.setCheckDateT(df.format(day));
		ttakestock.setCheckEmpId(ts.getTakeEmpId());
		ttakestock.setFlowFlag(1);
		if(tsflow.updateTakeStock(ttakestock) && tsflow.updateTakeStockDtl(ttakestockdtl)){
			result.setSuccess(true);
			result.setMessage("添加成功");
		}else{
			result.setSuccess(false);
			result.setMessage("添加失败");
		}
		return result;
	}
	
	@RequestMapping(value="/assetname",method = RequestMethod.POST)
	@ResponseBody
	public T_Fixed_Asset selectassetname(T_Fixed_Asset assetid){
		return baserive.selectFixedAssetbyId(assetid.getId());
	}
}
