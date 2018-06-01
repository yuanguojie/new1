package Mapper;

import java.util.List;

import domain.T_Dept;

public interface T_DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Dept record);

    int insertSelective(T_Dept record);

    T_Dept selectByPrimaryKey(Integer id);
    
    List<T_Dept> selectByName(T_Dept record);

    int updateByPrimaryKeySelective(T_Dept record);

    int updateByPrimaryKey(T_Dept record);
}