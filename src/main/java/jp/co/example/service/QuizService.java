package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Question;

public interface QuizService {
	public List<Question> findQuiz();

	public List<Question> SearchQuiz(String question);

	public List<Question> SearchAns(String question);

	public List<Question> SearchQuizAns(String quiz,String ans);

	public void insert(Question question);

	public void delete(String id);
}
