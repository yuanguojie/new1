package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.T_TakeStock;
import domain.T_TakeStockDtl;
import domainextand.T_TakeStock2;

import Mapper.T_TakeStockDtlMapper;
import Mapper.T_TakeStockMapper;

@Service
public class takestockflowservice {

	
	@Autowired
	private T_TakeStockMapper takestock;
	
	@Autowired
	private T_TakeStockDtlMapper takestockdtl;
	
	public List<T_TakeStock2> selectTakeStockFlow(T_TakeStock2 billNo){
		return takestockdtl.selectFlowByBillNo(billNo);
	}
	public T_TakeStock2 SelectTakeStockFlowbyid(T_TakeStock2 id){
		return takestockdtl.selectFlowByID(id);
	}
	
	public T_TakeStock selectTakeStock(int id){
		return takestock.selectByPrimaryKey(id);
	}
	public T_TakeStockDtl selectTakeStockDtl(int id){
		return takestockdtl.selectByPrimaryKey(id);
	}
	
	public boolean insertTakeStock(T_TakeStock TS){
		boolean ret = false;
		if(takestock.insertSelective(TS) > 0){
			ret = true;
		}
		return ret;
	}
	
	public boolean insertTakeStockDtl(T_TakeStockDtl TSD){
		boolean ret = false;
		if(takestockdtl.insertSelective(TSD) > 0){
			ret = true;
		}
		return ret;
	}
	
	public boolean updateTakeStock(T_TakeStock TS){
		boolean ret = false;
		if(takestock.updateByPrimaryKeySelective(TS) > 0){
			ret = true;
		}
		return ret;
	}
	public boolean updateTakeStockDtl(T_TakeStockDtl TSd){
		boolean ret = false;
		if(takestockdtl.updateByPrimaryKeySelective(TSd) > 0){
			ret = true;
		}
		return ret;
	}
}
