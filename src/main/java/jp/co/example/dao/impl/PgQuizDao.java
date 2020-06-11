package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.QuizDao;
import jp.co.example.entity.Question;

@Repository
public class PgQuizDao implements QuizDao {

	private static final String SELECT_QUIZ = "SELECT * FROM question";
	private static final String SELECT_QUESTION = "SELECT * FROM question WHERE quest LIKE :quest";
	private static final String SELECT_ANSER = "SELECT * FROM question WHERE ans = :ans";
	private static final String SELECT_QUESTION_ANSER = "SELECT * FROM question WHERE quest LIKE :quest AND ans = :ans";
	private static final String INSERT = "INSERT INTO question(quest,ans) VALUES(:quest , :ans)";
	private static final String DELETE = "DELETE FROM question WHERE quest_id = :id";


	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Question> findQuiz() {
		String sql = SELECT_QUIZ;
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Question>(Question.class));
	}

	@Override
	public List<Question> SerchQuiz(String question) {
		String sql = SELECT_QUESTION;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("quest","%" + question + "%");
		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<Question>(Question.class));
	}

	@Override
	public List<Question> SerchAns(String question) {
		String sql = SELECT_ANSER;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("ans",question);
		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<Question>(Question.class));
	}

	@Override
	public void insert(Question question) {
		String sql = INSERT;

		MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("quest", question.getQuest());
        param.addValue("ans", question.getAns());

        jdbcTemplate.update(sql, param);
	}

	@Override
	public List<Question> SerchQuizAns(String quiz, String ans) {
		String sql = SELECT_QUESTION_ANSER;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("quest","%" + quiz + "%");
		param.addValue("ans",ans);
		return jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<Question>(Question.class));
	}

	@Override
	public void delete(String id) {
		String sql = DELETE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id",id);
		 jdbcTemplate.update(sql, param);
	}

}
