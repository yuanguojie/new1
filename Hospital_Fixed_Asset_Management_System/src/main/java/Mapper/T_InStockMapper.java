package Mapper;

import java.util.List;

import domain.T_InStock;

public interface T_InStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(domainextand.T_InStock record);

    int insertSelective(domainextand.T_InStock record);

    T_InStock selectByPrimaryKey(Integer id);
    
    List<T_InStock> selectById(T_InStock record);
    
    List<T_InStock> selectbyBillNo(T_InStock record);

    int updateByPrimaryKeySelective(T_InStock record);

    int updateByPrimaryKey(T_InStock record);
}