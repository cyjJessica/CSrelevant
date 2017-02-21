
import java.util.Random;

class Poker
{

	int id[] = new int[52];// 52���ƣ� �±����ִ������� 0-12������13-25������26-38��÷��39-51
	// ����Ԫ�ص�ֵΪ0����û�з���

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
			{// ����[0,51]�����������������
				int onecard = genCode();
				if (id[onecard] == 1)
					continue;// ����������ɵ����Ѿ������ˣ�������һ������������ѭ��ֱ���ҵ�һ��δ�������ƣ�
				else
				{
					card[i] = onecard;// ���������û�з������򷢳���ͬʱ���Ϊ�ѷ��������Ժ��ظ����ƣ�break��ʼ����һ�ţ�������ѭ����
					id[onecard] = 1; // ֵ�޸�Ϊ1�����������Ʒ�����
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
	int mycard[] = new int[3];// ��¼������mycard[i]Ϊ0-51�� ���ִ�������
								// 0-12������13-25������26-38��÷��39-51
	int type[] = new int[3];// ��¼�����ƵĻ�ɫ
	int mycardNum[] = new int[3]; // ��¼�����ƵĴ�СΪ1-13,���Ի�ɫ

	Player(String name,int id[])
	{
		this.name = name;
	
		mycard[0] = id[0];
		mycard[1] = id[1];
		mycard[2] = id[2];
		// ��ɫ����type[i]����3���Ƶĸ��Ի�ɫ�� ��ɫ ���� 0������1������2��÷��3.
		type[0] = mycard[0] / 13;
		type[1] = mycard[1] / 13;
		type[2] = mycard[2] / 13;
		mycardNum[0] = 1 + mycard[0] % 13;// ���������ƵĴ�СΪ1-13,���Ի�ɫ
		mycardNum[1] = 1 + mycard[1] % 13;
		mycardNum[2] = 1 + mycard[2] % 13;
		
	}
	


	Player Compare(Player ano)
	{ // �����Ƶ����֣������ǻ�ɫ������1-13�����������ʹ��Ӯ��
		int meTotal = mycardNum[0] + mycardNum[1] + mycardNum[2];
		int anoTotal = ano.mycardNum[0] + ano.mycardNum[1] + ano.mycardNum[2];
		boolean b = meTotal > anoTotal;
		// if(meTotal==anoTotal)//�ҵ����ĺ���****
		// return this->mycardNum[0]>ano.mycardNum[0];
		if (b)
			return this;
		else
			return ano;
	}

	public String toString()// ֱ����0-51���ְ����������ַ�����ʾ����
	{

		return (name + "\t" + mycard[0] + "\t" + mycard[1] + "\t" + mycard[2]);

	}

	String toString1()// �û�ɫ�����������ַ�����ʾ����
	{
		String typeString[] = { "����", "����", "����", "÷��" };
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
