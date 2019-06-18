package com.code.bms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.code.bms.mapper.BookInfoMapper;
import com.code.bms.pojo.BookInfo;
import com.code.bms.pojo.BookInfoExample;
import com.code.bms.pojo.PageResult;
import com.code.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookInfoMapper bookInfoMapper;

    @Override
    public PageResult<BookInfo> getAllBooks(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BookInfo> books = this.bookInfoMapper.selectByExample(null);
        return convert(books,pageNum,pageSize);
    }

    @Override
    public boolean matchBook(String searchWord) {
        BookInfoExample bookInfoExample = new BookInfoExample();
        BookInfoExample.Criteria criteria = bookInfoExample.createCriteria();
        criteria.andNameLike("%" + searchWord + "%");
        try {
            this.bookInfoMapper.countByExample(bookInfoExample);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<BookInfo> queryBook(String searchWord) {
        BookInfoExample bookInfoExample = new BookInfoExample();
        BookInfoExample.Criteria criteria = bookInfoExample.createCriteria();
        criteria.andNameLike("%" + searchWord + "%");
        return this.bookInfoMapper.selectByExample(bookInfoExample);
    }

    @Override
    public boolean addBook(BookInfo bookInfo) {
        try {
            this.bookInfoMapper.insertSelective(bookInfo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public BookInfo getBook(Long bookId) {
        return this.bookInfoMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public boolean editBook(BookInfo bookInfo) {
        try {
            this.bookInfoMapper.updateByPrimaryKeySelective(bookInfo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int deleteBook(Long bookId) {
        return this.bookInfoMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public List<BookInfo> bookRank() {
        BookInfoExample bookInfoExample = new BookInfoExample();
        bookInfoExample.setOrderByClause("count DESC LIMIT 5");
        return this.bookInfoMapper.selectByExample(bookInfoExample);
    }

    @Override
    public List<BookInfo> getTopBooks() {
        return bookInfoMapper.findByCount();
    }


    private PageResult<BookInfo> convert(List<BookInfo> books,Integer pageNum, Integer pageSize){
        PageInfo<BookInfo> pageInfo = new PageInfo<>(books);
        long total = pageInfo.getTotal();
        int pages = pageInfo.getPages();
        PageResult<BookInfo> page = new PageResult<>();
        page.setList(books);
        page.setPageNum(pageNum);
        page.setPages(pages);
        page.setPageSize(pageSize);
        page.setTotal(total);
        return page;
    }
}
