package Mapper;

import java.util.List;

import domain.T_ADA;

public interface T_ADAMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_ADA record);

    int insertSelective(T_ADA record);

    T_ADA selectByPrimaryKey(Integer id);
    
    List<T_ADA> selectByName(T_ADA record);

    int updateByPrimaryKeySelective(T_ADA record);

    int updateByPrimaryKey(T_ADA record);
}