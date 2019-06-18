package com.code.bms.mapper;

import com.code.bms.pojo.ReaderCard;
import com.code.bms.pojo.ReaderCardExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReaderCardMapper {
    int countByExample(ReaderCardExample example);

    int deleteByExample(ReaderCardExample example);

    int deleteByPrimaryKey(Integer readerId);

    int insert(ReaderCard record);

    int insertSelective(ReaderCard record);

    List<ReaderCard> selectByExample(ReaderCardExample example);

    ReaderCard selectByPrimaryKey(Integer readerId);

    int updateByExampleSelective(@Param("record") ReaderCard record, @Param("example") ReaderCardExample example);

    int updateByExample(@Param("record") ReaderCard record, @Param("example") ReaderCardExample example);

    int updateByPrimaryKeySelective(ReaderCard record);

    int updateByPrimaryKey(ReaderCard record);
}