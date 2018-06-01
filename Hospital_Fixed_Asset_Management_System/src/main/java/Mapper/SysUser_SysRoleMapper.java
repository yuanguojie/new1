package Mapper;

import java.util.List;

import domain.SysUser_SysRoleKey;


public interface SysUser_SysRoleMapper{
    int deleteByPrimaryKey(SysUser_SysRoleKey key);

    int insert(SysUser_SysRoleKey record);

    int insertSelective(SysUser_SysRoleKey record);
    
    List<SysUser_SysRoleKey> selectUser_Role(SysUser_SysRoleKey record);
}