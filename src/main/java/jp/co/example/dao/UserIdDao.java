package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.UserInfo;

public interface UserIdDao {
	public List<UserInfo> findId();

	public void changeId(String id,String pass);
}
