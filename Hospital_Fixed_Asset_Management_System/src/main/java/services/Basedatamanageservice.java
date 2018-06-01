package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


import Mapper.T_ADAMapper;
import Mapper.T_DepreciationMapper;
import Mapper.T_DepreciationmethodMapper;
import Mapper.T_DeptMapper;
import Mapper.T_EmpMapper;
import Mapper.T_Fixed_AssetMapper;
import Mapper.T_Fixed_Asset_TypeMapper;
import Mapper.T_InStockDtlMapper;
import Mapper.T_InStockMapper;
import Mapper.T_MoveStockDtlMapper;
import Mapper.T_MoveStockMapper;
import Mapper.T_RemainStockMapper;
import Mapper.T_StorageMapper;
import Mapper.T_TakeStockDtlMapper;
import Mapper.T_TakeStockMapper;
import Mapper.T_UnitMapper;

@Service
public class Basedatamanageservice {
	/**
	 * 所需mapper对象注入
	 */
	@Autowired
	private T_EmpMapper emp;
	@Autowired
	private T_DeptMapper dept;
	@Autowired
	private T_Fixed_AssetMapper fixed_asset;
	@Autowired
	private T_Fixed_Asset_TypeMapper fixed_asset_type;
	@Autowired
	private T_DepreciationMapper depreciation;
	@Autowired
	private T_DepreciationmethodMapper depreciationmethod;
	@Autowired
	private T_InStockMapper instock;
	@Autowired
	private T_InStockDtlMapper instockdtl;
	@Autowired
	private T_MoveStockMapper movestock;
	@Autowired
	private T_MoveStockDtlMapper movestockdtl;
	@Autowired
	private T_RemainStockMapper remainstock;
	@Autowired
	private T_StorageMapper storage;
	@Autowired
	private T_TakeStockMapper takestock;
	@Autowired
	private T_TakeStockDtlMapper takestockdtl;
	@Autowired
	private T_UnitMapper unit;
	@Autowired
	private T_ADAMapper ada;
	
	
	
	/**
	 * 各基础数据的查询
	 */
	public List<T_Emp> selectEmp(T_Emp name){
		return emp.selectByName(name);
	}
	public T_Emp selectEmpbyid(int id){
		return emp.selectByPrimaryKey(id);
	}
	public List<T_Dept> selectDept(T_Dept name){
		return dept.selectByName(name);
	}
	public T_Dept selectDeptbyid(int id){
		return dept.selectByPrimaryKey(id);
	}
	public List<T_Fixed_Asset> selectFixedAsset(T_Fixed_Asset name){
		return fixed_asset.selectByName(name);
	}
	public T_Fixed_Asset selectFixedAssetbyId(int id){
		return fixed_asset.selectByPrimaryKey(id);
	}
	public List<T_Fixed_Asset_Type> selectFixedAssetType(T_Fixed_Asset_Type name){
		return fixed_asset_type.selectByName(name);
	}
	public T_Fixed_Asset_Type  selectFixedAssetType2(int fdttypeid){
		return fixed_asset_type.selectByPrimaryKey(fdttypeid);
	}
	public List<T_Depreciation> selectDepreciation(T_Depreciation name){
		return depreciation.selectByPrimary(name);
	}
	public List<T_Depreciationmethod> selectDepreciationmethod(T_Depreciationmethod name){
		return depreciationmethod.selectByName(name);
	}
	public List<T_ADA> selectADA(T_ADA name){
		return ada.selectByName(name);
	}
	public List<T_InStock> selectInStock(T_InStock name){
		return instock.selectById(name);
	}
	public List<T_InStockDtl> selectInStockDtl(T_InStockDtl name){
		return instockdtl.selectByAssetId(name);
	}
	public List<T_MoveStock> selectMoveStock(T_MoveStock name){
		return movestock.selectByBillNo(name);
	}
	public List<T_MoveStockDtl> selectMoveStockDtl(T_MoveStockDtl name){
		return movestockdtl.selectByAssetId(name);
	}
	public List<T_RemainStock> selectRemainStock(T_RemainStock name){
		return remainstock.selectByAssetId(name);
	}
	public T_RemainStock selectRemainStock2(T_RemainStock name){
		return remainstock.selectBy3id(name);
	}
	public List<T_Storage> selectStorage(T_Storage name){
		return storage.selectByName(name);
	}
	public T_Storage selectStoragebyid(int id){
		return storage.selectByPrimaryKey(id);
	}
	public List<T_TakeStock> selectTakeStock(T_TakeStock name){
		return takestock.selectByBillNo(name);
	}
	public List<T_TakeStockDtl> selectTakeStockDtl(T_TakeStockDtl name){
		return takestockdtl.selectByAssetId(name);
	}
	public List<T_Unit> selectUnit(T_Unit name){
		return unit.selectByName(name);
	}

	/*
	 * 各基础数据的添加
	 */
	public boolean addFixedAssetType(T_Fixed_Asset_Type name){
		boolean ret = false;
		if(fixed_asset_type.insertSelective(name) > 0){
			ret = true;
		}
		return ret;
	}
	public boolean addFixedAsset(T_Fixed_Asset name){
		boolean ret = false;
		if(fixed_asset.insertSelective(name) > 0){
			ret = true;
		}
		return  ret;
	}
	public boolean addInStockDtl(T_InStockDtl data){
		boolean ret = false;
		if(instockdtl.insertSelective(data) > 0){
			ret = true;
		}
		return ret;
	}
	public boolean addInStock(domainextand.T_InStock data){
		boolean ret = false;
		if(instock.insertSelective(data) > 0){
			ret = true;
		}
		return ret;
	}
	public boolean addmovestock(domain.T_MoveStock move){
		boolean ret = false;
		if(movestock.insertSelective(move) > 0){
			ret = true;
		}		
		return ret;
	}
	public boolean addmovestockdtl(T_MoveStockDtl movedtl){
		boolean ret = false;
		if(movestockdtl.insertSelective(movedtl) > 0){
			ret = true;
		}
		return ret;
	}
	public boolean addremainstock(T_RemainStock remainsk){
		boolean ret = false;
		if(remainstock.insertSelective(remainsk)> 0){
			ret = true;
		}
		return ret;
	}
	
	/*
	 * 各基础数据的修改
	 */
	public boolean updateFixedAssetType(T_Fixed_Asset_Type name){
		boolean ret = false;
		if(fixed_asset_type.updateByPrimaryKeySelective(name) > 0){
			ret = true;
		}
		return ret;
	}
	public boolean updateFixedAsset(T_Fixed_Asset name){
		boolean ret = false;
		if(fixed_asset.updateByPrimaryKeySelective(name) > 0){
			ret = true;
		}
		return ret;
	}
	public boolean updateremainstock(T_RemainStock remainsk){
		boolean ret = false;
		if(remainstock.updateByPrimaryKeySelective(remainsk) > 0){
			ret = true;
		}
		return ret;
	}
	/*
	 * 各基础数据的删除
	 */
	public boolean deleteFixedAssetType(int fdttypeid){
		boolean ret = false;
		if(fixed_asset_type.deleteByPrimaryKey(fdttypeid) > 0){
			ret = true;
		}
		return ret;
	}
	public boolean deleteremainstock(int remainskid){
		boolean ret = false;
		if(remainstock.deleteByPrimaryKey(remainskid) > 0){
			ret = true;
		}
		return ret;
	}
}
