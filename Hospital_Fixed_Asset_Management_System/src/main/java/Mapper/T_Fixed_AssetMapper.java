package Mapper;

import java.util.List;

import domain.T_Fixed_Asset;

public interface T_Fixed_AssetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Fixed_Asset record);

    int insertSelective(T_Fixed_Asset record);

    T_Fixed_Asset selectByPrimaryKey(Integer id);
    
    List<T_Fixed_Asset> selectByName(T_Fixed_Asset record);

    int updateByPrimaryKeySelective(T_Fixed_Asset record);

    int updateByPrimaryKey(T_Fixed_Asset record);
}