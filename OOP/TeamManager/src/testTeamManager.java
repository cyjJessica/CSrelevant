
public class testTeamManager
{

	public static void main(String[] args)
	{
		Team teams[] = { new Team("Celtics "), new Team("Cavaliers"), new Team("Heats"), new Team("Rockets"),
				new Team("Warriors"), new Team("Clippers "), new Team("Mavericks "), new Team("Grizzlies ") };
		Game game = new Game(teams, 10, 8);
		
		game.writeResult(1);
		game.printResult(1);
		game.getData(1);
		game.sortByWinPct();
		game.printRanklist();

		game.writeResult(2);
		game.printResult(2);
		game.getData(2);
		game.sortByWinPct();
		game.printRanklist();

		game.writeResult(3);
		game.printResult(3);
		game.getData(3);
		game.sortByWinPct();
		game.printRanklist();

	}

}
