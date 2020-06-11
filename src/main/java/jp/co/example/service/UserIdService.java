package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.UserInfo;

public interface UserIdService {
	public List<UserInfo> findId();

	public void changeId(String id,String pass);
}
