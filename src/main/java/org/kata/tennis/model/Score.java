package org.kata.tennis.model;

/*
 * Created by Samia FEKIR 
 * Creation Date : 08/05/2019
 */
abstract class Score {
	private int score;

	public Score() {
		initScore();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addScore() {
		score++;
	}

	public void initScore() {
		score = 0;
	}

}
