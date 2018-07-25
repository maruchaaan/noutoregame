package model;

import java.util.ArrayList;

public class Quizz {
	private String qst; //問題文
	private String qleft; //左の画像名
	private String qright; //右の画像名
	private String qanswer; //答えの画像名
	private int corrcount; //今の正解数
	
	public Quizz() { }
	public Quizz(String qst, String qleft, String qright, String qanswer) {
		this.qst = qst;
		this.qleft = qleft;
		this.qright = qright;
		this.qanswer = qanswer;
		//corrcount = 0;
	}
	
	public String getqst() { return qst; }
	public String getqLeft() { return qleft; }
	public String getqRight() { return qright; }
	public String getqAnswer() { return qanswer; }
	//public int getcorrcount() { return corrcount; }
	
}
