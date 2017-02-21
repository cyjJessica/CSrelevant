import java.util.Comparator;

class ComparatorImpl implements Comparator<Team>
{
	public int compare(Team t1, Team t2)
	{
		double winPct1 = t1.winPct;
		double winPct2 = t2.winPct;
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