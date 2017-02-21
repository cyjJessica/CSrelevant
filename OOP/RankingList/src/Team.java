
public class Team
{
	 String name;
	 int wins,losses;//胜场、负场
	 double winPct;//计算胜率作为排序依据
	
	Team(String name,int wins,int losses)
	{
		this.name=name;
		this.wins=wins;
		this.losses=losses;
	}
	
	public double CalWinPct()
	{
		winPct=(double)wins/(wins+losses);//把wins转为double型再计算，否则胜率始终是0.0
		return winPct;
	}
	
	public String toString()
	{
		return ("Team:"+this.name+"\tWins:"+wins+" \tLosses:"+losses+"\tWinPct:"+winPct);
	}
}

