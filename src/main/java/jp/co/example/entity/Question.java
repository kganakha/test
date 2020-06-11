package jp.co.example.entity;

public class Question {
	private String questId;
	private String quest;
	private String ans;

	public Question() {

	}

	public String getQuestId() {
		return questId;
	}

	public void setQuestId(String questId) {
		this.questId = questId;
	}

	public Question(String quest,String ans) {
		this.quest = quest;
		this.ans = ans;
	}

	public String getQuest() {
		return quest;
	}
	public void setQuest(String quest) {
		this.quest = quest;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}

}
