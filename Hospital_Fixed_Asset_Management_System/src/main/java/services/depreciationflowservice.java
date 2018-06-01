package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import domain.Deprecollect;
import domain.T_Depreciation;
import domainextand.T_DepreciationFlow;

import Mapper.DeprecollectMapper;
import Mapper.T_DepreciationMapper;
import Mapper.T_DepreciationmethodMapper;

@Service
public class depreciationflowservice {
	
	@Autowired
	private T_DepreciationMapper depremapper;
	
	@Autowired
	private T_DepreciationmethodMapper depremethodmapper;
	
	@Autowired
	private DeprecollectMapper deprecollectmapper;
	
	public List<T_DepreciationFlow> selectDepre(T_DepreciationFlow depre){
		return depremapper.selectByPrimary2(depre);
	}
	public List<T_Depreciation> selectDepre2(T_Depreciation depre){
		return depremapper.selectByPrimaryKey2(depre);
	}
	
	public boolean updatedepre(T_DepreciationFlow depre){
		boolean ret = false;
		if(depremapper.updateByPrimaryKeySelective2(depre) > 0){
			ret = true;
		}
		return ret;
	}
	
	public boolean insertdepre(T_Depreciation depre){
		boolean ret = false;
		if(depremapper.insertSelective(depre) > 0){
			ret = true;
		}
		return ret;
	}
	
	public List<T_DepreciationFlow> selectDeprebyassetid(T_DepreciationFlow depre){
		return depremapper.selectByassetId(depre);
	}
	
	public List<Deprecollect> selectdeprecollect(Deprecollect depre){
		return deprecollectmapper.SelectBydepre(depre);
	}
	
	public boolean insertdeprecollect(Deprecollect depre){
		boolean ret = false;
		if(deprecollectmapper.Insertdepreselective(depre) > 0){
			ret = true;
		}
		return ret;
	}
}
