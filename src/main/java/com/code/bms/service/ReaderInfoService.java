package com.code.bms.service;

import com.code.bms.pojo.PageResult;
import com.code.bms.pojo.ReaderInfo;

public interface ReaderInfoService {
    PageResult<ReaderInfo> readerInfos(Integer pageNum, Integer pageSize);

    boolean deleteReaderInfo(Integer readerId);

    ReaderInfo getReaderInfo(Integer readerId);

    boolean editReader(ReaderInfo readerInfo);

    boolean addReader(ReaderInfo readerInfo);
}
