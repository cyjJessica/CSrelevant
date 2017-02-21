import java.util.*;

public class Game
{
	Team[] teams;
	int num ;// 球队数
	int round ;// 比赛轮次
	List<Team> list;
	int result[][];// 存放每轮胜负情况的二维数组，如第一行为第一轮各支球队的胜负情况

	public Game(Team[] ts, int r, int n)
	{
		round = r;
		num = n;
		teams = ts;
		result = new int[round][num];
	}

	public void writeResult(int r)// 写入第r轮赛果
	{
		Random random = new Random(System.currentTimeMillis());// 写入种子，使得每次执行程序得到的结果不同
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();// 选择用linkedHashSet存放随机数，保证每次得到的随机数不同(如果遇到相同的数不会插入）

		while (linkedHashSet.size() < num / 2)// 插入num/2个随机数，相当于随机选择num/2支球队在该轮赢球
			linkedHashSet.add(random.nextInt(num - 1));// 在编号1-num支球队中随机选择，相当于在0-（num-1）中生成随机数

		for (Integer w : linkedHashSet)// 对于linkedHashSet中的数，使该轮其所代表球队的成绩记为1
		{
			result[r - 1][w] = 1;
		}

	}

	public void printResult(int r)// 打印第r轮赛果
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

	private void getdata1(int r)// 取得队伍在r轮比赛结束后的胜场数、负场数
	{
		for (int i = 0; i < num; i++)// 球队循环
		{
			teams[i].wins = teams[i].losses = 0;
			for (int j = 0; j < r; j++)// 轮次循环
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
		// 取得r轮比赛后队伍的主客场胜负数，假设前num/2支队伍先打主场，后num/2支队伍先打客场
		for (int j = 0; j < num / 2; j++)// 前num/2支球队循环
		{
			teams[j].homewin = teams[j].homeloss = teams[j].abroadwin = teams[j].abroadloss = 0;// 归零
			for (int i = 0; i < r; i += 2)
			// 从第一场开始，每隔两场累加胜场数，得到主场胜场数；累加负场数，得到主场负场数
			{
				if (result[i][j] == 1)
					teams[j].homewin++;
				if (result[i][j] == 0)
					teams[j].homeloss++;
			}

			teams[j].abroadwin = teams[j].wins - teams[j].homewin;
			teams[j].abroadloss = teams[j].losses - teams[j].homeloss;
		}

		for (int j = num / 2; j < num; j++)// 后num/2支球队循环
		{
			teams[j].homewin = teams[j].homeloss = teams[j].abroadwin = teams[j].abroadloss = 0;// 归零
			for (int i = 0; i < r; i += 2)
			// 从第一场开始，每隔两场累加胜场数，得到客场胜场数；累加负场数，得到客场负场数
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
			teams[i].winPct = ((double) teams[i].wins) / r;// 把wins转为double型再计算，否则胜率始终是0.0
			teams[i].winPct=(double)Math.round(teams[i].winPct*1000)/1000;//乘1000，四舍五入，除以1000，得到胜率保留三位小数四舍五入后的结果
			//保留三位小数还可以使用类DecimalFormat和NumberFormat，但得到结果是String型，要在比较器中使用，需要转回double，使用Double.valueOf(str).doubleValue();
		}
	}

	private void getConsecutiveness(int r)
	{
		for (int i = 0; i < num; i++)
		{
			teams[i].consecutiveness = 1;//连胜连负最少为1
			for (int j = r - 1; j > 0; j--)
			{
				if (result[j][i] == result[j - 1][i])//如果当前轮次和上一轮结果相同，可认为是在streak中
					teams[i].consecutiveness++;
			}
			if (result[r - 1][i] == 1)//当前轮次结果决定streak状态
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
		list = new ArrayList<Team>();//把队伍放进顺序表排序
		for (int i = 0; i < num; i++)
		{
			list.add(teams[i]);
		}
		Comparator<Team> comp = new ComparatorImpl();//用比较器对顺序表排序
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
