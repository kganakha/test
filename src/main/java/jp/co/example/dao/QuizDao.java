package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Question;

public interface QuizDao {
	public  List<Question> findQuiz();

	public List<Question> SerchQuiz(String question);

	public List<Question> SerchAns(String question);

	public List<Question> SerchQuizAns(String quiz,String ans);

	public void insert(Question question);

	public void delete(String id);
}
