package Mapper;

import java.util.List;


import domain.T_Depreciation;
import domainextand.T_DepreciationFlow;

public interface T_DepreciationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Depreciation record);

    int insertSelective(T_Depreciation record);

    T_Depreciation selectByPrimaryKey(Integer id);
    
    List<T_Depreciation> selectByPrimaryKey2(T_Depreciation record);
    
    List<T_Depreciation> selectByPrimary(T_Depreciation record);
    
    List<T_DepreciationFlow> selectByPrimary2(T_DepreciationFlow record);
    
    List<T_DepreciationFlow> selectByassetId(T_DepreciationFlow record);

    int updateByPrimaryKeySelective(T_Depreciation record);
    
    int updateByPrimaryKeySelective2(T_DepreciationFlow record);

    int updateByPrimaryKey(T_Depreciation record);
}