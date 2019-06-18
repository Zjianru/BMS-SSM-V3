package com.code.bms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.code.bms.mapper.ReaderInfoMapper;
import com.code.bms.pojo.PageResult;
import com.code.bms.pojo.ReaderInfo;
import com.code.bms.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderInfoServiceImpl implements ReaderInfoService {
    @Autowired
    private ReaderInfoMapper readerInfoMapper;

    @Override
    public PageResult<ReaderInfo> readerInfos(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ReaderInfo> readerInfos = this.readerInfoMapper.selectByExample(null);
        PageInfo<ReaderInfo> pageInfo = new PageInfo<>(readerInfos);
        long total = pageInfo.getTotal();
        int pages = pageInfo.getPages();
        PageResult<ReaderInfo> page = new PageResult<>();
        page.setList(readerInfos);
        page.setPageNum(pageNum);
        page.setPages(pages);
        page.setPageSize(pageSize);
        page.setTotal(total);
        return page;
    }

    @Override
    public boolean deleteReaderInfo(Integer readerId) {
        return this.readerInfoMapper.deleteByPrimaryKey(readerId) > 0;
    }

    @Override
    public ReaderInfo getReaderInfo(Integer readerId) {
        return this.readerInfoMapper.selectByPrimaryKey(readerId);
    }

    @Override
    public boolean editReader(ReaderInfo readerInfo) {
        try {
            this.readerInfoMapper.updateByPrimaryKeySelective(readerInfo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean addReader(ReaderInfo readerInfo) {
        try {
            this.readerInfoMapper.insertSelective(readerInfo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
