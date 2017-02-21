
public class Team
{
	String name;
	int wins, losses;// 胜场、负场
	int homewin, abroadwin;// 主、客场胜场数
	int homeloss, abroadloss;// 主、客场负场数
	int consecutiveness;//连胜/连负场数
	String flag;//指示连胜还是连负的标记
	double winPct;// 计算胜率作为排序依据

	Team(String name)
	{
		this.name = name;
	}

	public String toString()
	{
		return ("Team:" + this.name + "\tW:" + wins + " \tL:" + losses + "\tWinPct:" + winPct
				+"\tHome:"+homewin+" W "+homeloss+" L "+"\tAbroad:"+abroadwin+" W "+abroadloss+" L "
				+"\tWin/Loss streak:"+consecutiveness+flag);
	}
}
