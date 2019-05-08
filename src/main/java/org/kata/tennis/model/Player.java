package org.kata.tennis.model;

/*
 * Created by Samia FEKIR 
 * Creation Date : 08/05/2019
 */
public class Player {

	private String name;
	private ScoreGame scoreGame;
	private ScoreSet scoreSet;

	public Player() {

	}

	public Player(String name) {
		super();
		scoreGame = new ScoreGame();
		scoreSet = new ScoreSet();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ScoreGame getScoreGame() {
		return scoreGame;
	}

	public ScoreSet getScoreSet() {
		return scoreSet;
	}

}