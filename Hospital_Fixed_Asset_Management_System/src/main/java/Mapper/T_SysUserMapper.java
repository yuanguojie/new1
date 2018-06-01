package Mapper;

import java.util.List;

import domain.T_SysUser;

public interface T_SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_SysUser record);

    int insertSelective(T_SysUser record);

    T_SysUser selectByPrimaryKey(Integer id);
    
    T_SysUser selectByLoginAccount(T_SysUser user);
    
    List<T_SysUser> selectByLoginAccount2(T_SysUser name);

    int updateByPrimaryKeySelective(T_SysUser record);

    int updateByPrimaryKey(T_SysUser record);
}