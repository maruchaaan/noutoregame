package model;

public class Quizz {
	private String qst; //問題文
	private String qleft; //左の画像名
	private String qright; //右の画像名
	private String qanswer; //答えの画像名
	
	public Quizz() { }
	public Quizz(String qst, String qleft, String qright, String qanswer) {
		this.qst = qst;
		this.qleft = qleft;
		this.qright = qright;
		this.qanswer = qanswer;
	}
	
	public String getQst() { return qst; }
	public String getQLeft() { return qleft; }
	public String getQRight() { return qright; }
	public String getQAnswer() { return qanswer; }
	
}
