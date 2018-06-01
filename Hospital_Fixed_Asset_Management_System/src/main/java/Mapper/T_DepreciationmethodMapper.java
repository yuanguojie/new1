package Mapper;

import java.util.List;

import domain.T_Depreciationmethod;

public interface T_DepreciationmethodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Depreciationmethod record);

    int insertSelective(T_Depreciationmethod record);

    T_Depreciationmethod selectByPrimaryKey(Integer id);
    
    List<T_Depreciationmethod> selectByName(T_Depreciationmethod record);

    int updateByPrimaryKeySelective(T_Depreciationmethod record);

    int updateByPrimaryKey(T_Depreciationmethod record);
}