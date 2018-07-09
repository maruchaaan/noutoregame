package model;

import java.util.ArrayList;

public class QuizLibrary {
	//問題文
	String[] qstList = {"文字の色がくろなのはどっち？","文字の色があおなのはどっち？",
			"文字の色がしろなのはどっち？","右を指しているのはどっち？","左を指しているのはどっち？",
			"左を指しているのはどっち？","右を指しているのはどっち？","計算すると値が大きいのはどっち？",
			"計算すると値が小さいのはどっち？","計算すると値が大きいのはどっち？"};
	//右の画像名
	String[] qleftList = {"sw1.png","sw12.png","sw5.png","swright1.jpg","swleft2.png","swleft3.jpg",
			"swright4.jpg","sw6.png","sw8.png","sw10.png"};
	//左の画像名
	String[] qrightList = {"sw2.png","sw3.png","sw4.png","swleft1.png","swright2.png","swright3.png",
			"swleft4.png","sw7.png","sw9.png","sw11.png"};
	//正解の画像名
	String[] answerList = {"sw1.png","sw3.png","sw5.png","swright1.jpg","swleft2.png","swleft3.jpg",
			"swright4.jpg","sw6.png","sw9.png","sw11.png"};
	
	//servletで生成された乱数
	private ArrayList rndnumber;
	private int qtimes; //0~9　何問目か
	
	public QuizLibrary() {}
	public QuizLibrary(ArrayList rndnumber) {
		this.rndnumber = rndnumber;
		qtimes = 0;
	}
	
	public void setQtimes() { qtimes++; }
	
	public String getQst() { return qstList[qtimes]; }
	public String getQleft() { return qleftList[qtimes]; }
	public String getQright() { return qrightList[qtimes]; }
	public String getAnswer() { return answerList[qtimes]; }
	public int getQtimes() { return qtimes; }

}
