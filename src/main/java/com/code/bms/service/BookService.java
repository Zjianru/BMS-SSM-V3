package com.code.bms.service;

import com.code.bms.pojo.BookInfo;
import com.code.bms.pojo.PageResult;

import java.util.List;

public interface BookService {

    PageResult<BookInfo> getAllBooks(Integer pageNum, Integer pageSize);

    boolean matchBook(String searchWord);

    List<BookInfo> queryBook(String searchWord);

    boolean addBook(BookInfo bookInfo);

    BookInfo getBook(Long bookId);

    boolean editBook(BookInfo bookInfo);

    int deleteBook(Long bookId);

    List<BookInfo> bookRank();

    List<BookInfo> getTopBooks();
}
