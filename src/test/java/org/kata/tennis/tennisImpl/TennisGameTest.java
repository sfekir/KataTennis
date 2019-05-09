package org.kata.tennis.tennisImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kata.tennis.model.Player;

public class TennisGameTest {
	private TennisGame tennisGame;
	private Player player1;
	private Player player2;

	@Before
	public void setUp() throws Exception {
		player1 = new Player("Jack");
		player2 = new Player("Gabriel");
		tennisGame = new TennisGame(player1, player2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_returnPlayer1Win_whenScorePlayer1_4_player2_0() {
		ScoreGamePlayers(4, 0);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Jack is the winner of the game", score);

	}

	@Test
	public void should_returnPlayer2Win_whenScorePlayer1_2_player2_4() {
		ScoreGamePlayers(2, 4);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Gabriel is the winner of the game", score);

	}

	@Test
	public void should_return_Players_Deuce() {
		ScoreGamePlayers(4, 4);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Both players are Deuce", score);
	}

	@Test
	public void should_return_Player1HasAdvantage() {
		ScoreGamePlayers(5, 4);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Jack has the advantage", score);

	}

	@Test
	public void should_return_Player2HasAdvantage() {
		ScoreGamePlayers(4, 5);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Gabriel has the advantage", score);

	}

	public void should_returnPlayer2Wins_AfterAdvantage() {
		ScoreGamePlayers(5, 7);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Jack is the winner of the game", score);
	}

	public void testPlayer1Wins_AfterAdvantage() {
		ScoreGamePlayers(7, 5);
		String score = tennisGame.getGameState();
		Assert.assertEquals("Gabriel is the winner of the game", score);
	}

	private void ScoreGamePlayers(int pointsplayer1, int pointsplayer2) {
		for (int i = 0; i < pointsplayer1; i++) {
			player1.getScoreGame().addScore();
		}
		for (int i = 0; i < pointsplayer2; i++) {
			player2.getScoreGame().addScore();

		}
	}
}
