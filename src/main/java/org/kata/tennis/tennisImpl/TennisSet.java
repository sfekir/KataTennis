package org.kata.tennis.tennisImpl;

import org.kata.tennis.model.Player;
import org.kata.tennis.tennisInterface.ItennisService;

/*
 * Created by Samia FEKIR 
 * Creation Date : 08/05/2019
 */
public class TennisSet implements ItennisService {

	private Player player1;
	private Player player2;

	public TennisSet(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getWinner() {
		String result = "";
		if (hasWinner()) {
			result = highestPlayerScore().concat(" is the winner of the set");
		}
		if (tieBreak()) {

			if (tieBreakEndRule()) {
				result = highestPlayerScore().concat(
						" is the winner of the Set and the Match");

			}
		}
		return result;
	}

	public boolean hasWinner() {
		if (player1.getScoreSet().getScore() == 7
				|| player2.getScoreSet().getScore() == 7) {
			return true;
		}

		if ((player1.getScoreSet().getScore() == 6 || player2.getScoreSet()
				.getScore() == 6)
				&& (player1.getScoreSet().getScore() <= 4 || player2
						.getScoreSet().getScore() <= 4)) {
			return true;
		}
		return false;
	}

	private boolean tieBreakEndRule() {
		int tieBreakScore = player1.getScoreSet().getTieBreak()
				- player2.getScoreSet().getTieBreak();

		if ((player1.getScoreSet().getTieBreak() >= 7 || player2.getScoreSet()
				.getTieBreak() >= 7) && Math.abs(tieBreakScore) >= 2) {
			if (tieBreakScore >= 0) {
				player1.getScoreSet().addScore();
			} else if (tieBreakScore < 0) {
				player2.getScoreSet().addScore();

			}
			return true;
		}
		return false;
	}

	private boolean tieBreak() {
		boolean tieBreak = false;
		if (player1.getScoreSet().getScore() == 6
				&& player2.getScoreSet().getScore() == 6) {
			tieBreak = true;
		}
		return tieBreak;
	}

	public String highestPlayerScore() {
		if (player1.getScoreSet().getScore() > player2.getScoreSet().getScore()) {
			return player1.getName();
		} else {
			return player2.getName();
		}
	}

}
