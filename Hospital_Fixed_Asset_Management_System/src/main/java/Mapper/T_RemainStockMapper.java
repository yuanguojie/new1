package Mapper;

import java.util.List;

import domain.T_RemainStock;

public interface T_RemainStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_RemainStock record);

    int insertSelective(T_RemainStock record);

    T_RemainStock selectByPrimaryKey(Integer id);
    
    List<T_RemainStock> selectByAssetId(T_RemainStock record);
    
    T_RemainStock selectBy3id(T_RemainStock record);

    int updateByPrimaryKeySelective(T_RemainStock record);

    int updateByPrimaryKey(T_RemainStock record);
}