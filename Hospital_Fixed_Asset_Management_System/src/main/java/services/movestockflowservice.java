package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domainextand.T_MoveStock;

import Mapper.T_MoveStockDtlMapper;
import Mapper.T_MoveStockMapper;

@Service
public class movestockflowservice {

	@Autowired
	private T_MoveStockMapper movestockmapper;
	
	@Autowired
	private T_MoveStockDtlMapper movestockdtlmapper;
	
	public List<T_MoveStock> Selectmoveflow(T_MoveStock move){
		return movestockmapper.selectByAssetId(move);
	}
	
	public T_MoveStock SelectmovebyId(T_MoveStock move){
		return movestockmapper.selectById(move);
	}
	
	public boolean updatamoveflow(T_MoveStock move){
		boolean ret = false;
		if(movestockmapper.updateByPrimaryKeySelective2(move) > 0){
			ret = true;
		}
		return ret;
	}
}
