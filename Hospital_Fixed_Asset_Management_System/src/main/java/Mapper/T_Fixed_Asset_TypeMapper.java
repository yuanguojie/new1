package Mapper;

import java.util.List;

import domain.T_Fixed_Asset_Type;

public interface T_Fixed_Asset_TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Fixed_Asset_Type record);

    int insertSelective(T_Fixed_Asset_Type record);

    T_Fixed_Asset_Type selectByPrimaryKey(Integer id);
    
    List<T_Fixed_Asset_Type> selectByName(T_Fixed_Asset_Type record);

    int updateByPrimaryKeySelective(T_Fixed_Asset_Type record);

    int updateByPrimaryKey(T_Fixed_Asset_Type record);
}