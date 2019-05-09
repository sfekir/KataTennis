package org.kata.tennis.tennisImpl;

import org.kata.tennis.model.Player;
import org.kata.tennis.tennisInterface.ItennisService;

/*
 * Created by Samia FEKIR 
 * Creation Date : 08/05/2019
 */
public class TennisGame implements ItennisService {

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
			result = highestPlayerScore().concat(" has the advantage");
		}

		if (isDeuce()) {
			result = result.concat("Both players are Deuce");
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
		if (player2.getScoreGame().getScore() >= 4
				&& player2.getScoreGame().getScore() >= player1.getScoreGame()
						.getScore() + 2)
			return true;
		if (player1.getScoreGame().getScore() >= 4
				&& player1.getScoreGame().getScore() >= player2.getScoreGame()
						.getScore() + 2)
			return true;
		return false;
	}

	private boolean hasAdvantage() {
		if (player2.getScoreGame().getScore() >= 4
				&& player2.getScoreGame().getScore() == player1.getScoreGame()
						.getScore() + 1)
			return true;
		if (player1.getScoreGame().getScore() >= 4
				&& player1.getScoreGame().getScore() == player2.getScoreGame()
						.getScore() + 1)
			return true;

		return false;

	}

	@Override
	public String getWinner() {
		String winner = "";
		if (hasWinner()) {
			winner = highestPlayerScore().concat(" is the winner of the game");
		}
		return winner;
	}

}
