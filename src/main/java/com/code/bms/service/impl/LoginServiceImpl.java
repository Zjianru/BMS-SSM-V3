package com.code.bms.service.impl;

import com.code.bms.mapper.AdminMapper;
import com.code.bms.mapper.ReaderCardMapper;
import com.code.bms.pojo.Admin;
import com.code.bms.pojo.ReaderCard;
import com.code.bms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private ReaderCardMapper readerCardMapper;

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public boolean hasMatchReader(int id, String passwd) {
		ReaderCard readerCard = readerCardMapper.selectByPrimaryKey(id);
		if (readerCard == null) {
			return false;
		}
		return readerCard.getPasswd().equals(passwd);
	}

	@Override
	public boolean hasMatchAdmin(int id, String passwd) {
		Admin admin = adminMapper.selectByPrimaryKey(id);
		if (admin == null){
			return false;
		}
		return admin.getPassword().equals(passwd);
	}

	@Override
	public ReaderCard findReaderCardByUserId(int id) {
		return this.readerCardMapper.selectByPrimaryKey(id);
	}

	@Override
	public String getAdminPasswd(int id) {
		Admin admin = this.adminMapper.selectByPrimaryKey(id);
		return admin.getPassword();
	}

	@Override
	public boolean adminRePasswd(int id, String newPasswd) {
		Admin admin = this.adminMapper.selectByPrimaryKey(id);
		admin.setPassword(newPasswd);
		try {
			this.adminMapper.updateByPrimaryKeySelective(admin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
