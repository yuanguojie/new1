package Mapper;

import java.util.List;

import domain.T_SysMenu;

public interface T_SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_SysMenu record);

    int insertSelective(T_SysMenu record);

    T_SysMenu selectByPrimaryKey(Integer id);
    
    List<T_SysMenu> selectByName(T_SysMenu name);

    int updateByPrimaryKeySelective(T_SysMenu record);

    int updateByPrimaryKey(T_SysMenu record);

	List<T_SysMenu> getMenusByUserId(Integer userId);
}