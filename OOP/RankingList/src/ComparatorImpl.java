import java.util.Comparator;

class ComparatorImpl implements Comparator<Team>
{
	public int compare(Team t1, Team t2)
	{
		double winPct1 = t1.CalWinPct();
		double winPct2 = t2.CalWinPct();
		if (winPct1 > winPct2)
		{
			return -1;
		} else if (winPct1 < winPct2)
		{
			return 1;
		} else
		{
			return 0;
		}
	}
}