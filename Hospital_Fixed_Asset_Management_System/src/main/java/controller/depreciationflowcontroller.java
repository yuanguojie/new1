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

import common.AjaxResult;
import common.Funcoperation;

import services.Basedatamanageservice;
import services.depreciationflowservice;

import domain.Deprecollect;
import domain.T_Fixed_Asset;
import domainextand.T_DepreciationFlow;

@Controller
public class depreciationflowcontroller {

	@Autowired
	private depreciationflowservice depreflowservice;
	
	@Autowired
	private Basedatamanageservice baseservice;
	
	@RequestMapping(value="/deprefselect",method = RequestMethod.GET)
	@ResponseBody
	public List<T_DepreciationFlow> DepreciationSelect(T_DepreciationFlow name, HttpSession session) {
		List<T_DepreciationFlow> listdepref = depreflowservice.selectDepre(name);
		for(T_DepreciationFlow depref : listdepref){
			depref.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btndeprefedit' onclick='getdepref("+depref.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btndeprefremove' onclick='removedepref("+depref.getId()+")' href='#'></a>" +
							"<input name='Deprefid' type='hidden' value="+depref.getId()+">");
		}
		return listdepref;
	}
	
	@RequestMapping(value="/startdepref",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult DepreciationStart(T_DepreciationFlow dflow, HttpSession session){
		AjaxResult result = new AjaxResult();
		List<T_DepreciationFlow> listdepref = depreflowservice.selectDepre(dflow);
		List<T_DepreciationFlow> listbyassetid = new ArrayList<T_DepreciationFlow>();
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Funcoperation func = new Funcoperation();
		for(T_DepreciationFlow depref : listdepref){
			depref.setMethodId(dflow.getMethodId());
			depref.setDTime(df.format(day));
			depref.setEmpId(dflow.getEmpId());
			listbyassetid = depreflowservice.selectDeprebyassetid(depref);
			// 如果有过折旧记录的调用折旧值进行累计折旧，没有进行过折旧的调用原值进行折旧
			if(listbyassetid.size() > 1){
				depref.setCost(func.average(((listbyassetid.get(listbyassetid.size()-2)).getCost()), depref.getExpected_life()));
			}else{
				depref.setCost(func.average(depref.getPrice(), depref.getExpected_life()));
			}
			if(depreflowservice.updatedepre(depref)){
				result.setSuccess(true);
				result.setMessage("折旧完成");
			}else{
				result.setMessage("折旧失败");
				return result;
			}
		}
		return result;
	}
	
	@RequestMapping(value="/collect",method = RequestMethod.GET)
	@ResponseBody
	public List<Deprecollect> deprecollect(){
		List<Deprecollect> depreclist = new ArrayList<Deprecollect>();
		List<T_Fixed_Asset> fixedlist = new ArrayList<T_Fixed_Asset>();
		List<T_DepreciationFlow> depreflowlist = new ArrayList<T_DepreciationFlow>();
		T_DepreciationFlow depreflow = new T_DepreciationFlow();
		Funcoperation fun = new Funcoperation();
		int num;
		fixedlist = baseservice.selectFixedAsset(null);
		num = fixedlist.size();
		for(int i = 0;i < num;i++){
			depreflow.setAssetId((fixedlist.get(i)).getId());
			depreflowlist = depreflowservice.selectDeprebyassetid(depreflow);
			if(depreflowlist.size() <= 0){
				
			}else{
				Deprecollect deprecollect = new Deprecollect();
				deprecollect.setAsset((fixedlist.get(i)).getName());
				deprecollect.setPrice((fixedlist.get(i)).getPrice());
				deprecollect.setLimitage((fixedlist.get(i)).getExpected_life());
				deprecollect.setRemain_ratio(0.05);
				deprecollect.setRemain((fixedlist.get(i)).getPrice() * 0.05);
				
				
				deprecollect.setDeprecost(deprecollect.getPrice()-fun.average(deprecollect.getPrice(), deprecollect.getLimitage()));
				deprecollect.setAddepre((fixedlist.get(i)).getPrice()-(depreflowlist.get(depreflowlist.size()-1)).getCost());
				deprecollect.setDepretime((depreflowlist.get(depreflowlist.size()-1)).getDTime());
	
				depreclist.add(deprecollect);
				depreflowservice.insertdeprecollect(deprecollect);
			}
		}
		return depreclist;
	}
	
	@RequestMapping(value="/collectselect",method = RequestMethod.GET)
	@ResponseBody
	public List<Deprecollect> collectSelect(Deprecollect collect){
		List<Deprecollect> collectlist = new ArrayList<Deprecollect>();
		collect.setDepretime(collect.getDepretime()+"%");
		collectlist = depreflowservice.selectdeprecollect(collect);
		
		return collectlist;
	}
	
}
