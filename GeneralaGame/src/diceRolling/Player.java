package diceRolling;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player
{
	private String name;

	private List<List<Integer>> roundsDiceResult;
	
	private List<Integer> roundScores;

	public Player(String name)
	{
		this.setName(name);
		this.roundsDiceResult = new ArrayList<List<Integer>>();
		this.roundScores = new ArrayList<Integer>();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Integer> getRoundsDiceResults(int roundIndex)
	{
		return roundsDiceResult.get(roundIndex);
	}

	public void addRoundDiceResults(List<Integer> roundDiceResults)
	{
		this.roundsDiceResult.add(roundDiceResults);
	}
	
	public int getRoundScore(int roundIndex)
	{
		return this.roundScores.get(roundIndex);
	}
	
	public void addRoundScore(int roundScore)
	{
		this.roundScores.add(roundScore);
	}
	
	
	public int getTotalScore()
	{
		int totalScore = 0;
		for (int i = 0; i < this.roundsDiceResult.size(); i++)
		{
			totalScore += this.getRoundScore(i);
		}

		return totalScore;
	}

	public static Comparator<Player> getWinnerComperator()
	{
		return new Comparator<Player>()
		{
			@Override
			public int compare(Player player0, Player player1)
			{
				return Integer.compare(player0.getTotalScore(), player1.getTotalScore());
			}
		};
	}

}
