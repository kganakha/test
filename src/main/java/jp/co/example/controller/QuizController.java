package jp.co.example.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.entity.Question;
import jp.co.example.service.QuizService;
import jp.co.example.unit.ParamUtil;

@Controller
public class QuizController {

	@Autowired
	QuizService quizService;

	@Autowired
	HttpSession session;


	Random random = new Random();
	int quizNomber = 0;


	@RequestMapping("/insert")
	public String ins(@ModelAttribute("questionInsert") Question entity,Model model) {
		return "insert";
	}
	@RequestMapping(value = "/insertSet",params = "set",method = RequestMethod.POST)
	public String quizInsert(@ModelAttribute("questionInsert") Question entity, Model model ) {
		if(ParamUtil.isNullOrEmpty(entity.getQuest()) || ParamUtil.isNullOrEmpty(entity.getAns())) {
			String msg = "どちらかが入力されていません";
			model.addAttribute("msg",msg);
			return "insert";
		}else {
			Question question = new Question(entity.getQuest(),entity.getAns());
			quizService.insert(question);
			return "insertResult";
		}
	}


	@RequestMapping("/search")
	public String sea(@ModelAttribute("questionSearch") Question entity,Model model) {
		return "search";
	}
	@RequestMapping(value = "/SearchSet",params = "set",method = RequestMethod.POST)
	public String quizSearch(@ModelAttribute("questionSearch") Question entity, Model model ) {
		List<Question> list;
		if(ParamUtil.isNullOrEmpty(entity.getQuest()) && ParamUtil.isNullOrEmpty(entity.getAns())) {
			String msg = "どちらかを入力してください";
			model.addAttribute("msg",msg);
			return "search";
		}else if(ParamUtil.isNullOrEmpty(entity.getQuest())){
			list = quizService.SearchAns(entity.getAns());
			model.addAttribute("result",list);
			return "searchResult";
		}else if(ParamUtil.isNullOrEmpty(entity.getAns())){
			list = quizService.SearchQuiz(entity.getQuest());
			model.addAttribute("result",list);
			return "searchResult";
		}else {
			list = quizService.SearchQuizAns(entity.getQuest(),entity.getAns());
			model.addAttribute("result",list);
			return "searchResult";
		}
	}


	@RequestMapping("/questionTop")
	public String queT(Model model) {
		return "questionTop";
	}

	@RequestMapping("/question")
	public String que(@ModelAttribute("questionAns") Question entity, Model model) {
		List<Question> list = quizService.findQuiz();
		quizNomber = random.nextInt(list.size());
		model.addAttribute("quiz",list.get(quizNomber).getQuest());
		return "question";
	}

	@RequestMapping(value = "/QuestionAns",params = "set",method = RequestMethod.POST)
	public String quizAns(@ModelAttribute("questionAns") Question entity, Model model ) {
		List<Question> list = quizService.findQuiz();
		if(list.get(quizNomber).getAns().equals(entity.getAns())) {
			String msg = "正解";
			model.addAttribute("msg",msg);
			model.addAttribute("quest",list.get(quizNomber).getQuest());
			model.addAttribute("ans",list.get(quizNomber).getAns());
			return "questionResult";
		}else {
			String msg = "不正解";
			model.addAttribute("msg",msg);
			model.addAttribute("quest",list.get(quizNomber).getQuest());
			model.addAttribute("ansR",list.get(quizNomber).getAns());
			return "questionResult";
		}
	}

//	@RequestMapping("/deleteResult")
//	public String dele(@ModelAttribute("questionSearch") Question entity,Model model) {
//		//quizService.delete((String)type);
//		return "deleteResult";
//	}
//
//	@RequestMapping(value = "/deleteSet",params = "set",method = RequestMethod.POST)
//	public String del(HttpServletRequest request ,Model model) {
////		String id = request.getParameter("id");
////		quizService.delete(id);
//		return "deleteResult";
//	}
//
//	@RequestMapping(value = "/delete",params = "set",method = RequestMethod.POST)
//	public String delet(@ModelAttribute("quizDelete") Question entity,Model model) {
//		quizService.delete(entity.getQuestId());
//		return "deleteResult";
//	}
}
