package org.kata.tennis.impl;

import org.kata.tennis.ItennisService;
import org.kata.tennis.model.Player;

/*
 * Created by Samia FEKIR 
 * Creation Date : 08/05/2019
 */
public class TennisGame implements ItennisService {

	private static final String IS_THE_WINNER_OF_THE_GAME = " is the winner of the game";
	private static final String BOTH_PLAYERS_ARE_DEUCE = "Both players are Deuce";
	private static final String HAS_THE_ADVANTAGE = " has the advantage";
	private Player player1;
	private Player player2;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getGameState() {
		String result = "";
		result = getWinner();

		if (hasAdvantage()) {
			result = highestPlayerScore().concat(HAS_THE_ADVANTAGE);
		}

		if (isDeuce()) {
			result = result.concat(BOTH_PLAYERS_ARE_DEUCE);
		}
		return result;
	}

	private boolean isDeuce() {
		return (player1.getScoreGame().getScore() >= 3 || player2
				.getScoreGame().getScore() >= 3)
				&& player2.getScoreGame().getScore() == player1.getScoreGame()
						.getScore();
	}

	public String highestPlayerScore() {
		if (player1.getScoreGame().getScore() > player2.getScoreGame()
				.getScore()) {
			return player1.getName();
		} else {
			return player2.getName();
		}
	}

	public boolean hasWinner() {
		return isWinner(player1, player2) || isWinner(player2, player1);
	}

	public boolean isWinner(final Player player, final Player player2) {
		return player.getScoreGame().getScore() >= 4
				&& player.getScoreGame().getScore() >= player2.getScoreGame()
						.getScore() + 2;
	}

	private boolean hasAdvantage() {
		return isAdvantage(player1, player2) || isAdvantage(player2, player1);

	}

	public boolean isAdvantage(final Player player, final Player player2) {
		return player2.getScoreGame().getScore() >= 4
				&& player2.getScoreGame().getScore() == player.getScoreGame()
						.getScore() + 1;
	}

	@Override
	public String getWinner() {
		String winner = "";
		if (hasWinner()) {
			winner = highestPlayerScore().concat(IS_THE_WINNER_OF_THE_GAME);
		}
		return winner;
	}

}
