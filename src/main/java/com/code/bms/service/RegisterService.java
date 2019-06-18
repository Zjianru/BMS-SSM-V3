package com.code.bms.service;

import java.util.Date;

public interface RegisterService {
    boolean addReaderCard(Integer readerId, String name, String passwd, String sex, Date birth, String address,
                          String telcode);
}
