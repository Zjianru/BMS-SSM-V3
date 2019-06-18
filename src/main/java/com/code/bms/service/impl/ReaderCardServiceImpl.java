package com.code.bms.service.impl;

import com.code.bms.mapper.ReaderCardMapper;
import com.code.bms.pojo.ReaderCard;
import com.code.bms.service.ReaderCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderCardServiceImpl implements ReaderCardService {
    @Autowired
    private ReaderCardMapper readerCardMapper;

    @Override
    public boolean updateName(Integer readerId, String name) {
        ReaderCard readerCard = new ReaderCard();
        readerCard.setName(name);
        return 1 == readerCardMapper.updateByPrimaryKeySelective(readerCard);
    }

    @Override
    public boolean updatePasswd(int readerId, String newPasswd) {
        ReaderCard readerCard = new ReaderCard();
        readerCard.setPasswd(newPasswd);
        return 1 == readerCardMapper.updateByPrimaryKeySelective(readerCard);
    }
}
