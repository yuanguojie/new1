package controller;

import java.math.BigDecimal;
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

import domain.T_MoveStockDtl;
import domain.T_RemainStock;
import domainextand.T_MoveStock;
import domainextand.movestockview;

import services.Basedatamanageservice;
import services.movestockflowservice;

@Controller
public class movestockflowcontroller {

	@Autowired
	private movestockflowservice movestock;
	
	@Autowired
	private Basedatamanageservice basedata;
	
	@RequestMapping(value="/moveselect",method = RequestMethod.GET)
	@ResponseBody
	public List<movestockview> selectmoveflow(T_MoveStock name, HttpSession session){
		List<T_MoveStock> movestockflow = movestock.Selectmoveflow(name);
		List<movestockview> movestocklist = new ArrayList<movestockview>();
		for(T_MoveStock m : movestockflow){
			movestockview view = new movestockview();
			view.setId(m.getId());
			view.setAssetId(basedata.selectFixedAssetbyId(m.getAssetId()).getName());
			view.setBillNo(m.getBillNo());
			view.setTotalCost(m.getTotalCost());
			view.setDeptId(basedata.selectDeptbyid(m.getDeptId()).getName());
			view.setOutDate(m.getOutDate());
			view.setCreateEmpId(basedata.selectEmpbyid(m.getCreateEmpId()).getName());
			view.setOutEmpId(basedata.selectEmpbyid(m.getOutEmpId()).getName());
			view.setOutStorageId(basedata.selectStoragebyid(m.getOutStorageId()).getName());
			view.setInDeptId(basedata.selectDeptbyid(m.getInDeptId()).getName());
			view.setInStorageId(basedata.selectStoragebyid(m.getInStorageId()).getName());
			view.setInEmpId(basedata.selectEmpbyid(m.getInEmpId()).getName());
			view.setOutAmount(m.getOutAmount());
			view.setPrice(m.getPrice());
			view.setOperation("&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnmedit' onclick='getm("+m.getId()+")' href='#'></a>"+
					"&nbsp;&nbsp;&nbsp;&nbsp;<a name='btnmremove' onclick='removem("+m.getId()+")' href='#'></a>" +
							"<input name='Mid' type='hidden' value="+m.getId()+">");
			movestocklist.add(view);
		}
		return movestocklist;
	}
	
	@RequestMapping(value="/addmlog",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult insertmovelog(domain.T_MoveStock msk,T_MoveStockDtl mskd){
		AjaxResult result = new AjaxResult();
		T_MoveStock movesk = new T_MoveStock();
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int size = (movestock.Selectmoveflow(movesk)).size();
		mskd.setPrice(basedata.selectFixedAssetbyId(mskd.getAssetId()).getPrice());
		msk.setTotalCost(mskd.getOutAmount() * mskd.getPrice());
		msk.setBillNo("00"+(size+1));
		mskd.setId("00"+(size+1));
		msk.setInDate(df.format(day));
		msk.setOutDate(df.format(day));
		if(basedata.addmovestock(msk) && basedata.addmovestockdtl(mskd)){
			result.setMessage("出库资产登记成功");
			result.setSuccess(true);
		}else{
			result.setMessage("登记出错");
			result.setSuccess(false);
		}
		return result;
	}
	
	@RequestMapping(value="/agreemovestock",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult movestockagree(T_MoveStock move){
		AjaxResult result = new AjaxResult();
		T_MoveStock msk = new T_MoveStock();
		msk = movestock.SelectmovebyId(move);
		T_RemainStock remainsk = new T_RemainStock();
		int amount = 0;
		// 执行出库流程
		msk.setFlowFlag(1);
		
		// 出库减库存
		remainsk.setAssetId(msk.getAssetId());
		remainsk.setDeptId(msk.getDeptId());
		remainsk.setStorageId(msk.getOutStorageId());
		
		remainsk = basedata.selectRemainStock2(remainsk);
		if(remainsk != null){
			// 出库库存存在
			amount = remainsk.getAmount()-msk.getOutAmount();
			if(amount > 0){
				remainsk.setAmount(amount);
				if(basedata.updateremainstock(remainsk)){
					result.setMessage("出库成功。");
				}else{
					result.setMessage("出库失败。");
				}
			}else{
				if(basedata.deleteremainstock(remainsk.getId())){
					result.setMessage("出库成功。");
				}else{
					result.setMessage("出库失败。");
				}
			}
			if(msk.getInDeptId() != null && msk.getInStorageId() != null){
				// 转入新库加库存
				remainsk.setDeptId(msk.getInDeptId());
				remainsk.setStorageId(msk.getInStorageId());
				
				if(basedata.selectRemainStock2(remainsk) != null){
					// 该部门仓库原本有该资产
					remainsk = basedata.selectRemainStock2(remainsk);
					remainsk.setAmount(msk.getOutAmount()+remainsk.getAmount());
					if(basedata.updateremainstock(remainsk)){
						result.setMessage(result.getMessage()+"入库成功。");
						result.setSuccess(true);
						movestock.updatamoveflow(msk);
					}else{
						result.setMessage(result.getMessage()+"入库失败。");
						result.setSuccess(false);
					}
					
				}else{
					// 库存原本无该资产
					remainsk.setAmount(msk.getOutAmount());
					remainsk.setPrice((basedata.selectFixedAssetbyId(remainsk.getAssetId()).getPrice()));
					if(basedata.addremainstock(remainsk)){
						result.setMessage(result.getMessage()+"入库成功。");
						result.setSuccess(true);
						movestock.updatamoveflow(msk);
					}else{
						result.setMessage(result.getMessage()+"入库失败。");
						result.setSuccess(false);
					}
					
				}
			}else{
				// 资产报销
				result.setMessage(result.getMessage()+"已报销。");
				result.setSuccess(true);
				movestock.updatamoveflow(msk);
			}
		}else{
			// 出库库存不存在
			result.setMessage("出库库存不存在");
			result.setSuccess(false);
		}

		return result;
	}
}
