package Mapper;

import java.util.List;

import domain.SysMenu_SysRoleKey;

public interface SysMenu_SysRoleMapper {
    int deleteByPrimaryKey(SysMenu_SysRoleKey key);

    int insert(SysMenu_SysRoleKey record);

    int insertSelective(SysMenu_SysRoleKey record);
    
    List<SysMenu_SysRoleKey> selectMenu_Role(SysMenu_SysRoleKey record);
}