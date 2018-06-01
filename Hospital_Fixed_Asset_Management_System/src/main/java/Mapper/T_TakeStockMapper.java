package Mapper;

import java.util.List;

import domain.T_TakeStock;
public interface T_TakeStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_TakeStock record);

    int insertSelective(T_TakeStock record);

    T_TakeStock selectByPrimaryKey(Integer id);
    
    List<T_TakeStock> selectByBillNo(T_TakeStock record);

    int updateByPrimaryKeySelective(T_TakeStock record);

    int updateByPrimaryKey(T_TakeStock record);
}