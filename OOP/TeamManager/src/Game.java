import java.util.*;

public class Game
{
	Team[] teams;
	int num ;// �����
	int round ;// �����ִ�
	List<Team> list;
	int result[][];// ���ÿ��ʤ������Ķ�ά���飬���һ��Ϊ��һ�ָ�֧��ӵ�ʤ�����

	public Game(Team[] ts, int r, int n)
	{
		round = r;
		num = n;
		teams = ts;
		result = new int[round][num];
	}

	public void writeResult(int r)// д���r������
	{
		Random random = new Random(System.currentTimeMillis());// д�����ӣ�ʹ��ÿ��ִ�г���õ��Ľ����ͬ
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();// ѡ����linkedHashSet������������֤ÿ�εõ����������ͬ(���������ͬ����������룩

		while (linkedHashSet.size() < num / 2)// ����num/2����������൱�����ѡ��num/2֧����ڸ���Ӯ��
			linkedHashSet.add(random.nextInt(num - 1));// �ڱ��1-num֧��������ѡ���൱����0-��num-1�������������

		for (Integer w : linkedHashSet)// ����linkedHashSet�е�����ʹ��������������ӵĳɼ���Ϊ1
		{
			result[r - 1][w] = 1;
		}

	}

	public void printResult(int r)// ��ӡ��r������
	{
		System.out.println("Round" + r +":");
		for (int i = 0; i < num; i++)
		{
			System.out.print(teams[i].name + "  ");
		}

		System.out.println();
		for (int i = 0; i < num; i++)
		{
			if (result[r - 1][i] == 1)
				System.out.print("W         " );
			else
				System.out.print("L          " );
		}
	}

	private void getdata1(int r)// ȡ�ö�����r�ֱ����������ʤ������������
	{
		for (int i = 0; i < num; i++)// ���ѭ��
		{
			teams[i].wins = teams[i].losses = 0;
			for (int j = 0; j < r; j++)// �ִ�ѭ��
			{
				if (result[j][i] == 1)
					teams[i].wins++;
				if (result[j][i] == 0)
					teams[i].losses++;
			}
		}
	}

	private void getdata2(int r)
	{
		// ȡ��r�ֱ������������ͳ�ʤ����������ǰnum/2֧�����ȴ���������num/2֧�����ȴ�ͳ�
		for (int j = 0; j < num / 2; j++)// ǰnum/2֧���ѭ��
		{
			teams[j].homewin = teams[j].homeloss = teams[j].abroadwin = teams[j].abroadloss = 0;// ����
			for (int i = 0; i < r; i += 2)
			// �ӵ�һ����ʼ��ÿ�������ۼ�ʤ�������õ�����ʤ�������ۼӸ��������õ�����������
			{
				if (result[i][j] == 1)
					teams[j].homewin++;
				if (result[i][j] == 0)
					teams[j].homeloss++;
			}

			teams[j].abroadwin = teams[j].wins - teams[j].homewin;
			teams[j].abroadloss = teams[j].losses - teams[j].homeloss;
		}

		for (int j = num / 2; j < num; j++)// ��num/2֧���ѭ��
		{
			teams[j].homewin = teams[j].homeloss = teams[j].abroadwin = teams[j].abroadloss = 0;// ����
			for (int i = 0; i < r; i += 2)
			// �ӵ�һ����ʼ��ÿ�������ۼ�ʤ�������õ��ͳ�ʤ�������ۼӸ��������õ��ͳ�������
			{
				if (result[i][j] == 1)
					teams[j].abroadwin++;
				if (result[i][j] == 0)
					teams[j].abroadloss++;
			}

			teams[j].homewin = teams[j].wins - teams[j].abroadwin;
			teams[j].homeloss = teams[j].losses - teams[j].abroadloss;
		}
	}

	private void getWinPct(int r)
	{
		for (int i = 0; i < num; i++)
		{
			teams[i].winPct = ((double) teams[i].wins) / r;// ��winsתΪdouble���ټ��㣬����ʤ��ʼ����0.0
			teams[i].winPct=(double)Math.round(teams[i].winPct*1000)/1000;//��1000���������룬����1000���õ�ʤ�ʱ�����λС�����������Ľ��
			//������λС��������ʹ����DecimalFormat��NumberFormat�����õ������String�ͣ�Ҫ�ڱȽ�����ʹ�ã���Ҫת��double��ʹ��Double.valueOf(str).doubleValue();
		}
	}

	private void getConsecutiveness(int r)
	{
		for (int i = 0; i < num; i++)
		{
			teams[i].consecutiveness = 1;//��ʤ��������Ϊ1
			for (int j = r - 1; j > 0; j--)
			{
				if (result[j][i] == result[j - 1][i])//�����ǰ�ִκ���һ�ֽ����ͬ������Ϊ����streak��
					teams[i].consecutiveness++;
			}
			if (result[r - 1][i] == 1)//��ǰ�ִν������streak״̬
				teams[i].flag = "win";
			if (result[r - 1][i] == 0)
				teams[i].flag = "loss";
		}
	}
	
	public void getData(int r)
	{
		getdata1(r);
		getdata2(r);
		getWinPct(r);
		getConsecutiveness(r);
	}

	public List<Team> sortByWinPct()
	{
		list = new ArrayList<Team>();//�Ѷ���Ž�˳�������
		for (int i = 0; i < num; i++)
		{
			list.add(teams[i]);
		}
		Comparator<Team> comp = new ComparatorImpl();//�ñȽ�����˳�������
		Collections.sort(list, comp);
		return list;
	}

	public void printRanklist()
	{
		System.out.println();
		for (Team t : (List<Team>) list)
		{
			System.out.println(t);
		}
	}
}
