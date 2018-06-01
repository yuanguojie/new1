package Mapper;

import java.util.List;

import domain.T_Storage;

public interface T_StorageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Storage record);

    int insertSelective(T_Storage record);

    T_Storage selectByPrimaryKey(Integer id);
    
    List<T_Storage> selectByName(T_Storage record);

    int updateByPrimaryKeySelective(T_Storage record);

    int updateByPrimaryKey(T_Storage record);
}