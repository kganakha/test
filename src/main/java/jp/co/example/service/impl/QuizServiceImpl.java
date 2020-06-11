package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.QuizDao;
import jp.co.example.entity.Question;
import jp.co.example.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDao quizDao;

	@Override
	public List<Question> findQuiz() {
		return quizDao.findQuiz();
	}

	@Override
	public List<Question> SearchQuiz(String question) {
		return quizDao.SerchQuiz(question);
	}

	@Override
	public List<Question> SearchAns(String question) {
		return quizDao.SerchAns(question);
	}

	public void insert(Question question) {
		quizDao.insert(question);
	}

	@Override
	public List<Question> SearchQuizAns(String quiz, String ans) {
		return quizDao.SerchQuizAns(quiz,ans);
	}

	@Override
	public void delete(String id) {
		quizDao.delete(id);

	}
}
