package diceRolling;

import java.util.ArrayList;
import java.util.List;

public class DiceHandler
{
	public static int rollADie()
	{
		return (int)(Math.random() * 6) + 1;
	}
	
	public static List<Integer> rollMultipleDice(int diceCount)
	{
		ArrayList<Integer> diceResults = new ArrayList<Integer>();
		for (int i = 0; i < diceCount; i++)
		{
			diceResults.add(rollADie());
		}
		
		return diceResults;
	}
}
