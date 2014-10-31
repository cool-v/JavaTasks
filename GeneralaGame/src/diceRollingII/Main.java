package diceRollingII;

import java.util.Scanner;

import diceRolling.DiceRollingGame;
import diceRolling.Player;

public class Main
{
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args)
	{
		// Task DiceRolling Part II
		initializeGame();
	}

	private static void initializeGame()
	{
		System.out.println("DICE ROLLING GAME");
		System.out.print("Enter number of players: ");
		int numberOfPlayers = input.nextInt();
		System.out.print("Enter number of rounds: ");
		int numberOfRounds = input.nextInt();
		System.out.print("Enter number of dice: ");
		int numberOfDice = input.nextInt();
		input.nextLine();

		DiceRollingGame game = new DiceRollingGame(numberOfPlayers, numberOfRounds, numberOfDice);
		for (int i = 0; i < game.getPlayersCount(); i++)
		{
			System.out.print("Enter name for player " + (i + 1) + ": ");
			String name = input.nextLine();
			game.addPlayer(name);
		}

		System.out.println("Game started...");

		for (int roundIndex = 0; roundIndex < game.getRoundsCount(); roundIndex++)
		{
			System.out.println("Round " + (roundIndex + 1));
			for (int playerIndex = 0; playerIndex < game.getPlayersCount(); playerIndex++)
			{
				Player currentPlayer = game.playPlayerTurn(roundIndex, playerIndex);

				System.out.println("Player " + currentPlayer.getName() + " rolled: "
						+ currentPlayer.getRoundsDiceResults(roundIndex));
				System.out.println("Score: " + currentPlayer.getRoundScore(roundIndex) + " points");
			}
		}

		System.out.println("Game ended!");
		System.out.println("Winner is " + game.getWinnerName() + " with total score " + game.getWinnerScore()
				+ " points");
	}
}
