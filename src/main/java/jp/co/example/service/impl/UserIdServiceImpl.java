package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.UserIdDao;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.UserIdService;

@Service
public class UserIdServiceImpl implements UserIdService {

	@Autowired
	private UserIdDao userIdDao;

	@Override
	public List<UserInfo> findId() {
		return userIdDao.findId();
	}

	@Override
	public void changeId(String id, String pass) {
		userIdDao.changeId(id, pass);

	}

}
