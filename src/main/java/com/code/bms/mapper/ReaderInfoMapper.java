package com.code.bms.mapper;

import com.code.bms.pojo.ReaderInfo;
import com.code.bms.pojo.ReaderInfoExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReaderInfoMapper {
    int countByExample(ReaderInfoExample example);

    int deleteByExample(ReaderInfoExample example);

    int deleteByPrimaryKey(Integer readerId);

    int insert(ReaderInfo record);

    int insertSelective(ReaderInfo record);

    List<ReaderInfo> selectByExample(ReaderInfoExample example);

    ReaderInfo selectByPrimaryKey(Integer readerId);

    int updateByExampleSelective(@Param("record") ReaderInfo record, @Param("example") ReaderInfoExample example);

    int updateByExample(@Param("record") ReaderInfo record, @Param("example") ReaderInfoExample example);

    int updateByPrimaryKeySelective(ReaderInfo record);

    int updateByPrimaryKey(ReaderInfo record);
}