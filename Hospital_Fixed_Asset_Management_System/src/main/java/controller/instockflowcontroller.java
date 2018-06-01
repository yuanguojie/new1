package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import common.AjaxResult;

import services.Basedatamanageservice;
import services.instockflowservice;

import domain.T_InStock;
import domain.T_InStockDtl;
import domain.T_RemainStock;
import domainextand.instockview;

@Controller
public class instockflowcontroller {

	@Autowired
	private instockflowservice instockflow;
	
	@Autowired
	private Basedatamanageservice basedata;
	
	@RequestMapping(value="/iselect",method = RequestMethod.GET)
	@ResponseBody
	public List<instockview> selectInstockFlow(T_InStock name, HttpSession session){
		List<T_InStock> instock = instockflow.SelectInstockFlow(name);
		List<instockview> inview = new ArrayList<instockview>();
		for(T_InStock i : instock){
			instockview view = new instockview();
			view.setBillNo(i.getBillNo().getId());
			view.setByDate(i.getBuyDate());
			view.setSortCode(i.getBillNo().getSortCode());
			view.setTotalCost(i.getTotalCost());
			view.setPrice(i.getBillNo().getPrice());
			view.setAmount(i.getBillNo().getAmount());
			view.setAsset(basedata.selectFixedAssetbyId(i.getBillNo().getAssetId()).getName());
			view.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btniedit' onclick='geti("+i.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btniremove' onclick='removei("+i.getId()+")' href='#'></a>" +
							"<input name='Iid' type='hidden' value="+i.getId()+">");
			inview.add(view);
		}
		return inview;
	}
	@RequestMapping(value="/ininfo",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult instockinfoinsert(T_InStock name,T_RemainStock rid){
		AjaxResult result = new AjaxResult();
		List<T_InStock> instock = instockflow.SelectInstockFlow(name);
		for(T_InStock i : instock){
			rid.setPrice((i.getBillNo()).getPrice());
			rid.setAmount((i.getBillNo()).getAmount());
			rid.setAssetId((i.getBillNo()).getAssetId());
			if(instockflow.insertintoRemainStock(rid)){
				i.setFlowFlag(1);
				if(instockflow.updateInstockFlow(i)){
					result.setSuccess(true);
					result.setMessage("入库成功");
				}else{
					result.setMessage("flag修改失败");
					result.setSuccess(false);
				}
			}else{
				result.setSuccess(false);
				result.setMessage("入库失败");
				return result;
			}
		}
		return result;
	}
	
	@RequestMapping(value="/addilog",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult iloginsert(domainextand.T_InStock instock,T_InStockDtl instockdtl){
		AjaxResult result = new AjaxResult();
		int size = (instockflow.SelectInStock(null)).size();
		instockdtl.setId("00"+(size+1));
		if(basedata.addInStockDtl(instockdtl)){
			instock.setBillNo("00"+(size+1));
			if(basedata.addInStock(instock)){
				result.setSuccess(true);
				result.setMessage("登记成功");
			}else{
				result.setSuccess(false);
				result.setMessage("登记过程出错");
			}
		}else{
			result.setSuccess(false);
			result.setMessage("登记出错");
		}
		
		return result;
	}
}
