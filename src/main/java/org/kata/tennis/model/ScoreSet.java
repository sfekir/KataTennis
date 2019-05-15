package org.kata.tennis.model;

/*
 * Created by Samia FEKIR 
 * Creation Date : 08/05/2019
 */
public class ScoreSet extends PlayerScore {
	private int tieBreak;

	public int getTieBreak() {
		return tieBreak;
	}

	public void setTieBreak(int tieBreak) {
		this.tieBreak = tieBreak;
	}

	public void addTieBreakScore() {
		tieBreak++;
	}

	public void initTieBreak() {
		tieBreak = 0;
	}
}
