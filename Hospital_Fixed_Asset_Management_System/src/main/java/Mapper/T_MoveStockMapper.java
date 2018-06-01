package Mapper;

import java.util.List;

import domain.T_MoveStock;

public interface T_MoveStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_MoveStock record);

    int insertSelective(T_MoveStock record);

    T_MoveStock selectByPrimaryKey(Integer id);
    
    domainextand.T_MoveStock selectById(domainextand.T_MoveStock id);
    
    List<T_MoveStock> selectByBillNo(T_MoveStock record);
    
    List<domainextand.T_MoveStock> selectByAssetId(domainextand.T_MoveStock record);

    int updateByPrimaryKeySelective(T_MoveStock record);

    int updateByPrimaryKey(T_MoveStock record);
    
    int updateByPrimaryKeySelective2(domainextand.T_MoveStock record);
}