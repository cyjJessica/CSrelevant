
public class Equations
{
	double a, b, c;// 二元一次方程系数
	double x1, x2;// 存放方程的解
	double real, imaginary;// 存放复数根的实部和虚部
	int index;// 标记求得根的情况

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
				imaginary = (double) Math.round(imaginary * 1000) / 1000;// 保留三位小数的方法，在另一作业中解释
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
			return ("不是一元二次方程");
		else
		{
			switch (index)
			{
			case (0):
				return ("方程有两个复数根，为" + real + "+" + imaginary + "i 和" + real + "-" + imaginary + "i");
			case (1):
				return ("方程有两个相等实根，为x1=x2=" + x1);
			case (2):
				return ("方程有两个不等实根，为x1=" + x1 + ",  x2=" + x2);
			}
		}
		return ("");
	}

}
