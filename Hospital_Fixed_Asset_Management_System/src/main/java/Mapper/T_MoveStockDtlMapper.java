package Mapper;

import java.util.List;

import domain.T_MoveStockDtl;

public interface T_MoveStockDtlMapper {
    int deleteByPrimaryKey(String id);

    int insert(T_MoveStockDtl record);

    int insertSelective(T_MoveStockDtl record);

    T_MoveStockDtl selectByPrimaryKey(String id);
    
    List<T_MoveStockDtl> selectByAssetId(T_MoveStockDtl record);

    int updateByPrimaryKeySelective(T_MoveStockDtl record);

    int updateByPrimaryKey(T_MoveStockDtl record);
}