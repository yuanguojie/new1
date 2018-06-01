package Mapper;

import java.util.List;

import domain.T_Emp;

public interface T_EmpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Emp record);

    int insertSelective(T_Emp record);

    T_Emp selectByPrimaryKey(Integer id);
    
    List<T_Emp> selectByName(T_Emp record);

    int updateByPrimaryKeySelective(T_Emp record);

    int updateByPrimaryKey(T_Emp record);
}