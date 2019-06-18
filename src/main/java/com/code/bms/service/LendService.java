package com.code.bms.service;

import com.code.bms.pojo.LendList;
import com.code.bms.pojo.PageResult;

import java.util.List;

public interface LendService {

    List<LendList> myLendList(Integer readerId);

    PageResult<LendList> lendList(Integer pageNum, Integer pageSize);

    boolean deleteLog(Long sernum);

    boolean matchLog(Integer searchWord);

    boolean bookLend(Long bookId, Integer readerId);

    boolean bookReturn(Long bookId);
}
