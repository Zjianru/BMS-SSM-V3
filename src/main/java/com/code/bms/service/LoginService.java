package com.code.bms.service;

import com.code.bms.pojo.ReaderCard;

public interface LoginService {
    boolean hasMatchReader(int id, String passwd);

    boolean hasMatchAdmin(int id, String passwd);

    ReaderCard findReaderCardByUserId(int id);

    String getAdminPasswd(int id);

    boolean adminRePasswd(int id, String newPasswd);
}
