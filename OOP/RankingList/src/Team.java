
public class Team
{
	 String name;
	 int wins,losses;//ʤ��������
	 double winPct;//����ʤ����Ϊ��������
	
	Team(String name,int wins,int losses)
	{
		this.name=name;
		this.wins=wins;
		this.losses=losses;
	}
	
	public double CalWinPct()
	{
		winPct=(double)wins/(wins+losses);//��winsתΪdouble���ټ��㣬����ʤ��ʼ����0.0
		return winPct;
	}
	
	public String toString()
	{
		return ("Team:"+this.name+"\tWins:"+wins+" \tLosses:"+losses+"\tWinPct:"+winPct);
	}
}

