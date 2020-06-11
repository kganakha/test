package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.UserIdDao;
import jp.co.example.entity.UserInfo;

@Repository
public class PgUserDao implements UserIdDao {

	private static final String SELECT_ID = "SELECT * FROM user_info";
	private static final String CHANGE_ID = "UPDATE user_info SET user_id = :id , pass = :pass";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<UserInfo> findId() {
		String sql = SELECT_ID;
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
	}

	@Override
	public void changeId(String id, String pass) {
		String sql = CHANGE_ID;

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		param.addValue("pass", pass);

		jdbcTemplate.update(sql, param);
	}

}
