
public class Team
{
	String name;
	int wins, losses;// ʤ��������
	int homewin, abroadwin;// �����ͳ�ʤ����
	int homeloss, abroadloss;// �����ͳ�������
	int consecutiveness;//��ʤ/��������
	String flag;//ָʾ��ʤ���������ı��
	double winPct;// ����ʤ����Ϊ��������

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
