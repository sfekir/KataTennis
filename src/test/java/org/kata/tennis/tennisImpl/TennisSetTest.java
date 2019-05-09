package org.kata.tennis.tennisImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kata.tennis.model.Player;

public class TennisSetTest {

	private TennisSet tennisSet;
	private Player player1;
	private Player player2;

	@Before
	public void setUp() throws Exception {
		player1 = new Player("JACK");
		player2 = new Player("MANUEL");
		tennisSet = new TennisSet(player1, player2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_returnPlayer1_IsWinner() {
		addScoreSet(6, 4);

		Assert.assertEquals("JACK is the winner of the set",
				tennisSet.getWinner());
	}

	@Test
	public void should_returnPlayer2_IsWinner() {
		addScoreSet(4, 7);

		Assert.assertEquals("MANUEL is the winner of the set",
				tennisSet.getWinner());
	}

	@Test
	public void should_returNoWinner_whenPlayeScore1_6_PlayerScore2_5() {
		addScoreSet(6, 5);

		Assert.assertTrue("".equals(tennisSet.getWinner()));
	}

	@Test
	public void should_returnPlayer1_IsWinnertieRule() {
		addScoreSet(6, 6);
		addTieBreakScore(7, 2);
		Assert.assertEquals("JACK is the winner of the Set and the Match",
				tennisSet.getWinner());
		Assert.assertEquals(7, player1.getScoreSet().getScore());

	}

	@Test
	public void should_returnPlayer2_IsWinnertieRule() {
		addScoreSet(6, 6);
		addTieBreakScore(5, 7);
		Assert.assertEquals("MANUEL is the winner of the Set and the Match",
				tennisSet.getWinner());
		Assert.assertEquals(7, player2.getScoreSet().getScore());

	}

	private void addScoreSet(int scoreplayer1, int scoreplayer2) {
		for (int i = 0; i < scoreplayer1; i++) {
			player1.getScoreSet().addScore();
		}
		for (int i = 0; i < scoreplayer2; i++) {
			player2.getScoreSet().addScore();
		}
	}

	private void addTieBreakScore(int tieBreakScore1, int tieBreakScore2) {
		for (int i = 0; i < tieBreakScore1; i++) {
			player1.getScoreSet().addTieBreakScore();
		}
		for (int i = 0; i < tieBreakScore2; i++) {
			player2.getScoreSet().addTieBreakScore();
		}
	}
}
