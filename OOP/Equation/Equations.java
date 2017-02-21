
public class Equations
{
	double a, b, c;// ��Ԫһ�η���ϵ��
	double x1, x2;// ��ŷ��̵Ľ�
	double real, imaginary;// ��Ÿ�������ʵ�����鲿
	int index;// �����ø������

	public Equations(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void SolveEqu()
	{
		double delta = b * b - 4 * a * c;
		if (a != 0)
		{
			if (delta < 0)
			{
				real = -b / (2 * a);
				imaginary = Math.sqrt(-delta);
				imaginary = (double) Math.round(imaginary * 1000) / 1000;// ������λС���ķ���������һ��ҵ�н���
				index = 0;
			} else if (delta == 0)
			{
				x1 = x2 = -b / (2 * a);
				index = 1;
			} else
			{
				x1 = (-b + Math.sqrt(delta)) / (2 * a);
				x2 = (-b - Math.sqrt(delta)) / (2 * a);
				index = 2;
			}
		}

	}

	public String toString()
	{
		if (a == 0)
			return ("����һԪ���η���");
		else
		{
			switch (index)
			{
			case (0):
				return ("������������������Ϊ" + real + "+" + imaginary + "i ��" + real + "-" + imaginary + "i");
			case (1):
				return ("�������������ʵ����Ϊx1=x2=" + x1);
			case (2):
				return ("��������������ʵ����Ϊx1=" + x1 + ",  x2=" + x2);
			}
		}
		return ("");
	}

}
