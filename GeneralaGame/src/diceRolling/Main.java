package diceRolling;

import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		 //Task DiceRolling Part I
		 List<Integer> diceResults = DiceHandler.rollMultipleDice(2);
		
		 for (int i = 0; i < diceResults.size(); i++)
		 {
		 System.out.printf("Die %d is %d\n", i + 1, diceResults.get(i));
		 }
		
		 System.out.println("Total score is " + DiceRollingGame.calculateTurnScore(diceResults));
	}
}
