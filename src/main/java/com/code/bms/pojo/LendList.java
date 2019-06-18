package com.code.bms.pojo;

import java.util.Date;

public class LendList {
    private Long sernum;

    private Long bookId;

    private Integer readerId;

    private Date lendDate;

    private Date backDate;

    public Long getSernum() {
        return sernum;
    }

    public void setSernum(Long sernum) {
        this.sernum = sernum;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }
}