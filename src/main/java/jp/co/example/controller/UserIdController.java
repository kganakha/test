package jp.co.example.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.entity.UserInfo;
import jp.co.example.service.UserIdService;
import jp.co.example.unit.ParamUtil;

@Controller
public class UserIdController {

	@Autowired
	UserIdService userIdService;

	@RequestMapping("/index")
	public String ind(@ModelAttribute("userInfo") UserInfo entity, Model model) {
		return "index";
	}
	@RequestMapping("/top")
	public String top() {
		return "top";
	}

	@RequestMapping(value = "/login",params = "set",method = RequestMethod.POST)
	public String lo(@ModelAttribute("userInfo") UserInfo entity, Model model ) {
//		UserInfo infoForm = new UserInfo(entity.getUserId(),entity.getPass());
		List<UserInfo> list = userIdService.findId();
//		if("master".equals(entity.getUserId()) && "pass".equals(entity.getPass())) {
		if(entity.getUserId().equals(list.get(0).getUserId()) && (entity.getPass().equals(list.get(0).getPass()))){
			return "top";
		}else {
			String msg = "入力されていないか、間違えています";
			model.addAttribute("msg",msg);
			return "index";
		}
	}

	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}

	@RequestMapping("/idChange")
	public String change(@ModelAttribute("userInfo") UserInfo entity, Model model) {
		return "idChange";
	}

	@RequestMapping(value = "/change",params = "set",method = RequestMethod.POST)
	public String ch(@ModelAttribute("userInfo") UserInfo entity, Model model ) {
		Pattern numberArufa = Pattern.compile("^(?=.*\\d)(?=.*\\D).*$");
		Matcher m = numberArufa.matcher(entity.getPass());
		if(ParamUtil.isNullOrEmpty(entity.getUserId())) {
			String msg = "IDが入力されていません";
			model.addAttribute("msg",msg);
			return "idChange";
		}else if(entity.getPass().length() < 6) {
			String msg = "passは6文字以上にしてください";
			model.addAttribute("msg",msg);
			return "idChange";
		}else if(!m.find()){
			String msg = "passは数字とアルファベットの両方を使用したものにしてください";
			model.addAttribute("msg",msg);
			return "idChange";
		}else {
			userIdService.changeId(entity.getUserId(),entity.getPass());
			return "idChangeResult";
		}
	}
}