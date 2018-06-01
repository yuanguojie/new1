package Mapper;

import java.util.List;

import domain.T_SysRole;

public interface T_SysRolekey{
    int deleteByPrimaryKey(Integer id);

    int insert(T_SysRole record);

    int insertSelective(T_SysRole record);

    T_SysRole selectByPrimaryKey(Integer id);
    
    List<T_SysRole> selectByName(T_SysRole name);

    int updateByPrimaryKeySelective(T_SysRole record);

    int updateByPrimaryKey(T_SysRole record);
}