package Mapper;

import domain.SysRole_SysFuncKey;

public interface SysRole_SysFuncMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole_SysFuncKey record);

    int insertSelective(SysRole_SysFuncKey record);
}