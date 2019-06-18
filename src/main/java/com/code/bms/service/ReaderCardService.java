package com.code.bms.service;

public interface ReaderCardService {

    boolean updateName(Integer readerId, String name);

    boolean updatePasswd(int readerId, String newPasswd);
}
