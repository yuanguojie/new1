package Mapper;

import java.util.List;

import domain.T_Unit;

public interface T_UnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Unit record);

    int insertSelective(T_Unit record);

    T_Unit selectByPrimaryKey(Integer id);
    
    List<T_Unit> selectByName(T_Unit record);

    int updateByPrimaryKeySelective(T_Unit record);

    int updateByPrimaryKey(T_Unit record);
}