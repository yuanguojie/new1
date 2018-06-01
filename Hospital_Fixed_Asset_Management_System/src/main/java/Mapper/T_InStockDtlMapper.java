package Mapper;

import java.util.List;

import domain.T_InStockDtl;

public interface T_InStockDtlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_InStockDtl record);

    int insertSelective(T_InStockDtl record);

    T_InStockDtl selectByPrimaryKey(Integer id);
    
    List<T_InStockDtl> selectByAssetId(T_InStockDtl record);

    int updateByPrimaryKeySelective(T_InStockDtl record);

    int updateByPrimaryKey(T_InStockDtl record);
}