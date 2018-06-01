package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.T_InStock;
import domain.T_InStockDtl;
import domain.T_RemainStock;

import Mapper.T_InStockDtlMapper;
import Mapper.T_InStockMapper;
import Mapper.T_RemainStockMapper;

@Service
public class instockflowservice {

	@Autowired
	private T_InStockMapper instock;
	
	@Autowired
	private T_InStockDtlMapper instockdtl;
	
	@Autowired T_RemainStockMapper remainstock;
	
	public List<T_InStock> SelectInstockFlow(T_InStock name){
		return instock.selectbyBillNo(name);
	}
	
	public List<T_InStockDtl> SelectInStock(T_InStockDtl name){
		return instockdtl.selectByAssetId(name);
	}
	
	public boolean updateInstockFlow(T_InStock name){
		boolean ret = false;
		if(instock.updateByPrimaryKeySelective(name) > 0){
			ret = true;
		}
		return ret;
	}
	
	public boolean insertintoRemainStock(T_RemainStock record){
		boolean ret = false;
		if(remainstock.insertSelective(record) > 0){
			ret  = true;
		}
		return ret;
	}
	

}
