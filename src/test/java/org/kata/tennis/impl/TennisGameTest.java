package org.kata.tennis.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kata.tennis.model.Player;

public class TennisGameTest {
	private TennisGame tennisGame;
	private Player player1;
	private Player player2;

	@Before
	public void setUp() {
		player1 = new Player("Jack");
		player2 = new Player("Gabriel");
		tennisGame = new TennisGame(player1, player2);
	}

	@Test
	public void shouldReturnPlayer1WinWhenScorePlayer1Is4AndPlayer2Is0() {
		scoreGamePlayers(4, 0);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Jack is the winner of the game", score);

	}

	@Test
	public void shouldReturnPlayer2WinWhenScorePlayer1Is2AndPlayer2Is4() {
		scoreGamePlayers(2, 4);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Gabriel is the winner of the game", score);

	}

	@Test
	public void shouldReturnPlayersDeuce() {
		scoreGamePlayers(4, 4);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Both players are Deuce", score);
	}

	@Test
	public void shouldReturnPlayer1HasAdvantage() {
		scoreGamePlayers(5, 4);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Jack has the advantage", score);

	}

	@Test
	public void shouldReturnPlayer2HasAdvantage() {
		scoreGamePlayers(4, 5);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Gabriel has the advantage", score);

	}

	public void shouldReturnPlayer2WinsAfterAdvantage() {
		scoreGamePlayers(5, 7);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Jack is the winner of the game", score);
	}

	public void testPlayer1WinsAfterAdvantage() {
		scoreGamePlayers(7, 5);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Gabriel is the winner of the game", score);
	}

	private void scoreGamePlayers(int pointsplayer1, int pointsplayer2) {
		for (int i = 0; i < pointsplayer1; i++) {
			player1.getScoreGame().addScore();
		}
		for (int i = 0; i < pointsplayer2; i++) {
			player2.getScoreGame().addScore();

		}
	}
}
