package Mapper;

import domain.SysFunc;

public interface SysFuncMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysFunc record);

    int insertSelective(SysFunc record);

    SysFunc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysFunc record);

    int updateByPrimaryKey(SysFunc record);
}