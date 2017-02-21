
import java.util.Random;

class Poker
{

	int id[] = new int[52];// 52张牌， 下标数字代表：黑桃 0-12，红桃13-25，方块26-38，梅花39-51
	// 数组元素的值为0代表还没有发过

	Poker()
	{
		for (int i = 0; i < 52; i++)
		{
			id[i] = 0;
		}

	}

	int genCode()
	{
		Random random = new Random(System.currentTimeMillis());
		int p = random.nextInt(52);
		return p;
	}

	void deal(int num, int card[])
	{
		for (int i = 0; i < 3; i++)
		{
			for (;;)
			{// 生成[0,51]的随机数，四舍五入
				int onecard = genCode();
				if (id[onecard] == 1)
					continue;// 如果本次生成的牌已经发过了，生成下一个数继续发（循环直到找到一张未发过的牌）
				else
				{
					card[i] = onecard;// 如果这张牌没有发过，则发出，同时标记为已发，避免以后重复发牌，break开始发下一张（跳到外循环）
					id[onecard] = 1; // 值修改为1，代表这张牌发过了
					break;
				} // for inner
			} // for outer
		}

	}

	void reset()
	{
		for (int i = 0; i < 52; i++)
			id[i] = 0;
	}
};

class Player
{

	String name;
	int mycard[] = new int[3];// 记录三张牌mycard[i]为0-51， 数字代表：黑桃
								// 0-12，红桃13-25，方块26-38，梅花39-51
	int type[] = new int[3];// 记录三张牌的花色
	int mycardNum[] = new int[3]; // 记录三张牌的大小为1-13,忽略花色

	Player(String name,int id[])
	{
		this.name = name;
	
		mycard[0] = id[0];
		mycard[1] = id[1];
		mycard[2] = id[2];
		// 花色代表：type[i]代表3张牌的各自花色。 花色 黑桃 0，红桃1，方块2，梅花3.
		type[0] = mycard[0] / 13;
		type[1] = mycard[1] / 13;
		type[2] = mycard[2] / 13;
		mycardNum[0] = 1 + mycard[0] % 13;// 计算三张牌的大小为1-13,忽略花色
		mycardNum[1] = 1 + mycard[1] % 13;
		mycardNum[2] = 1 + mycard[2] % 13;
		
	}
	


	Player Compare(Player ano)
	{ // 三张牌的数字（不考虑花色的数字1-13）加起来，和大的赢牌
		int meTotal = mycardNum[0] + mycardNum[1] + mycardNum[2];
		int anoTotal = ano.mycardNum[0] + ano.mycardNum[1] + ano.mycardNum[2];
		boolean b = meTotal > anoTotal;
		// if(meTotal==anoTotal)//找到最大的黑桃****
		// return this->mycardNum[0]>ano.mycardNum[0];
		if (b)
			return this;
		else
			return ano;
	}

	public String toString()// 直接用0-51数字把三张牌用字符串表示出来
	{

		return (name + "\t" + mycard[0] + "\t" + mycard[1] + "\t" + mycard[2]);

	}

	String toString1()// 用花色把三张牌用字符串表示出来
	{
		String typeString[] = { "黑桃", "红桃", "方块", "梅花" };
		return (name + "\t" + typeString[type[0]] + ":" + mycardNum[0] + "\t" + typeString[type[1]] + ":" + mycardNum[1]
				+ "\t" + typeString[type[2]] + ":" + mycardNum[2]);

	}

}

// int main(void)
// {
// Player *p1, *p2, *p3, *p4;
// Poker pok;
// int c[3]={-1};
//
// pok.deal(3,c);
// p1 = new Player("Zhang", c);
// pok.deal(3,c);
// p2 = new Player("Li", c);
// pok.deal(3,c);
// p3 = new Player("Wang", c);
// pok.deal(3,c);
// p4 = new Player("Zhao", c);
// cout<<p1->toString() << "\n" << p2->toString() << "\n"
// << p3->toString() << "\n" << p4->toString()<<endl;
// cout<<p1->toString1() << "\n" << p2->toString1() << "\n"
// << p3->toString1() << "\n" << p4->toString1()<<endl;
// cout<<"\nwinner:"<<endl;
// cout<<p1->Compare(*p2).Compare(*p3).Compare(*p4).toString1();
//
//
