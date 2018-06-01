package Mapper;

import java.util.List;

import domain.T_TakeStockDtl;
import domainextand.T_TakeStock2;

public interface T_TakeStockDtlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_TakeStockDtl record);

    int insertSelective(T_TakeStockDtl record);

    T_TakeStockDtl selectByPrimaryKey(Integer id);
    
    List<T_TakeStockDtl> selectByAssetId(T_TakeStockDtl record);
    
    List<T_TakeStock2> selectFlowByBillNo(T_TakeStock2 record);
    
    T_TakeStock2 selectFlowByID(T_TakeStock2 record);

    int updateByPrimaryKeySelective(T_TakeStockDtl record);

    int updateByPrimaryKey(T_TakeStockDtl record);
}