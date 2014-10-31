package diceRolling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceRollingGame
{
	private int roundsCount;

	private int playersCount;

	private int diceCount;

	private List<Player> players;

	public DiceRollingGame(int playersCount, int roundsCount, int diceCount)
	{
		this.setPlayersCount(playersCount);
		this.setRoundsCount(roundsCount);
		this.setDiceCount(diceCount);
		this.players = new ArrayList<Player>();
	}

	public int getRoundsCount()
	{
		return roundsCount;
	}

	public void setRoundsCount(int roundsCount)
	{
		this.roundsCount = roundsCount;
	}

	public int getPlayersCount()
	{
		return playersCount;
	}

	public void setPlayersCount(int playersCount)
	{
		this.playersCount = playersCount;
	}

	public int getDiceCount()
	{
		return diceCount;
	}

	public void setDiceCount(int diceCount)
	{
		this.diceCount = diceCount;
	}

	public Player getPlayerByIndex(int index)
	{
		return this.players.get(index);
	}

	public void addPlayer(String name)
	{
		Player player = new Player(name);
		this.players.add(player);
	}

	public Player playPlayerTurn(int roundIndex, int playerIndex)
	{
		Player currentPlayer = this.getPlayerByIndex(playerIndex);
		List<Integer> diceResults = DiceHandler.rollMultipleDice(this.getDiceCount());
		currentPlayer.addRoundDiceResults(diceResults);
		int currentScore = this.getRoundsScore(currentPlayer.getRoundsDiceResults(roundIndex));
		currentPlayer.addRoundScore(currentScore);
		
		return currentPlayer;
	}
	
	public int getRoundsScore(List<Integer> diceResults)
	{
		int roundScore = 0;
		for (int i = 0; i < diceResults.size(); i++)
		{
			roundScore += diceResults.get(i);
		}
		
		return roundScore;
	}

	public static int calculateTurnScore(List<Integer> diceResults)
	{
		int turnScore = 0;
		for (int i = 0; i < diceResults.size(); i++)
		{
			turnScore += diceResults.get(i);
		}

		return turnScore;
	}

	public String getWinnerName()
	{
		return this.getWinner().getName();
	}

	public int getWinnerScore()
	{
		return this.getWinner().getTotalScore();
	}

	private Player getWinner()
	{
		return Collections.max(players, Player.getWinnerComperator());
	}

}
