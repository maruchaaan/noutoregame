package model;

import java.util.ArrayList;

public class count {
	private int qcount; //今何問目か
	private ArrayList rndnumber;
	private int corrcount; //今の正解数

	public count() {
	}

	public count(ArrayList rndnumber) {
		this.rndnumber = rndnumber;
		corrcount = 0;
		qcount = 0;
	}

	public ArrayList getRndnumber() {
		return rndnumber;
	}
	
	public int getCorrCount() { return corrcount; }
	public int getQcount() { return qcount; }
	
	public void setQcount() { qcount++; } //問題数＋１
	public void setCorrCount() { corrcount++; } //正解数＋１
	
	public void setRndnumber(ArrayList rndnumber) {
		this.rndnumber = rndnumber;
	}
}
