package org.kata.tennis;

import org.kata.tennis.model.Player;
import org.kata.tennis.tennisImpl.TennisGame;
import org.kata.tennis.tennisImpl.TennisSet;

/**
 * 
 *
 */
public class App {
	private static Player player1 = new Player("FRANCOIS");
	private static Player player2 = new Player("JEAN");
	private static TennisGame tennisGame = new TennisGame(player1, player2);
	private static TennisSet tennisSet = new TennisSet(player1, player2);

	public static void main(String[] args) {
		/*
		 * User Story 1 : As a tennis referee I want to manage the score of a
		 * game of a set of a tennis match between 2 players with simple Game
		 * rules In order to display the current Game score of each player
		 * 
		 * Rules details: · The game starts with a score of 0 point for each
		 * player · Each time a player win a point, the Game score changes as
		 * follow: 0 -> 15 -> 30 -> 40-> Win game
		 */
		scoreGamePlayers(4, 2);
		System.out.println(tennisGame.getGameState() + "\n");

		/*
		 * User Story 2 : As a tennis referee I want to manage the specific of
		 * the rule DEUCE at the end of a Game In order to display the current
		 * Game score of each player
		 * 
		 * Rules details: · If the 2 players reach the score 40, the DEUCE rule
		 * is activated · If the score is DEUCE , the player who win the point
		 * take the ADVANTAGE · If the player who has the ADVANTAGE win the
		 * point, he win the game · If the player who has the ADVANTAGE looses
		 * the point, the score is DEUCE
		 */
		initialiseScore();
		scoreGamePlayers(3, 4);
		System.out.println(tennisGame.getGameState());

		initialiseScore();
		scoreGamePlayers(4, 4);
		System.out.println(tennisGame.getGameState());

		/*
		 * User Story 1 : As a tennis referee I want to manage the score of a
		 * set of a tennis match between 2 players In order to display the
		 * current Game (SPRINT 1) & Set score of each player
		 * 
		 * Rules details: · The set starts with a score of 0 Game for each
		 * player · Each time a player win a Game (see SPRINT 1), the Set score
		 * changes as follow: 1 -> 2 -> 3 -> 4 -> 5 -> 6 (-> 7) · If a player
		 * reach the Set score of 6 and the other player has a Set score of 4 or
		 * lower, the player win the Set · If a player wins a Game and reach the
		 * Set score of 6 and the other player has a Set score of 5, a new Game
		 * must be played and the first player who reach the score of 7 wins the
		 * match
		 */
		initialiseScore();
		scoreSetPlayers(7, 3);
		System.out.println(tennisSet.getWinner());

		initialiseScore();
		scoreSetPlayers(4, 6);
		System.out.println(tennisSet.getWinner());

		/*
		 * User Story 2 : As a tennis referee I want to manage the specific of
		 * the rule of Tie-Break at the end of the Set In order to display the
		 * current Game, Set score & Tie-Break score of each player
		 * 
		 * Rules details: · If the 2 players reach the score of 6 Games , the
		 * Tie-Break rule is activated · Each time a player win a point, the
		 * score changes as follow: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 (-> 8-> 9->
		 * 10-> …) · The Tie-Break ends as soon as a player gets a least 7
		 * points and 2 points more than his opponent · The player who wins the
		 * Tie-Break wins the Set and the match
		 */
		initialiseScore();
		scoreSetPlayers(6, 6);
		scoreTieBreakPlayer(5, 7);
		System.out.println(tennisSet.getWinner());

	}

	public static void scoreGamePlayers(int playerScoreGame1,
			int playerScoreGame2) {
		for (int i = 0; i < playerScoreGame1; i++) {
			player1.getScoreGame().addScore();
		}
		for (int i = 0; i < playerScoreGame2; i++) {
			player2.getScoreGame().addScore();
		}
	}

	public static void scoreSetPlayers(int playerScoreSet1, int playerScoreSet2) {
		for (int i = 0; i < playerScoreSet1; i++) {
			player1.getScoreSet().addScore();
		}
		for (int i = 0; i < playerScoreSet2; i++) {
			player2.getScoreSet().addScore();
		}
	}

	public static void scoreTieBreakPlayer(int tieBreakScore1,
			int tieBreakScore2) {
		for (int i = 0; i < tieBreakScore1; i++) {
			player1.getScoreSet().addTieBreakScore();
			;
		}
		for (int i = 0; i < tieBreakScore2; i++) {
			player2.getScoreSet().addTieBreakScore();
		}
	}

	public static void initialiseScore() {
		player1.getScoreGame().initScore();
		player2.getScoreGame().initScore();
		player1.getScoreSet().initScore();
		player2.getScoreSet().initScore();
		player1.getScoreSet().initTieBreak();

	}
}
