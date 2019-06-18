package com.code.bms.mapper;

import com.code.bms.pojo.LendList;
import com.code.bms.pojo.LendListExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LendListMapper {
    int countByExample(LendListExample example);

    int deleteByExample(LendListExample example);

    int deleteByPrimaryKey(Long sernum);

    int insert(LendList record);

    int insertSelective(LendList record);

    List<LendList> selectByExample(LendListExample example);

    LendList selectByPrimaryKey(Long sernum);

    int updateByExampleSelective(@Param("record") LendList record, @Param("example") LendListExample example);

    int updateByExample(@Param("record") LendList record, @Param("example") LendListExample example);

    int updateByPrimaryKeySelective(LendList record);

    int updateByPrimaryKey(LendList record);
}