
public class MyComplexNumber extends ComplexNumber
{
	public MyComplexNumber(double real, double imaginary) {
        super(real,imaginary);
    }    

	public double magnitude()//求模定义  
	{
		return Math.pow(x, 2)+Math.pow(y, 2);
	}
	public MyComplexNumber minus(MyComplexNumber a)//减法定义
	{
		MyComplexNumber c=new MyComplexNumber(x,y);
		c.x=c.x-a.x;
		c.y=c.y-a.y;
		return c;
	}

	public String toString() 
	{
		if (y>0)
		{
			return (x+"+"+y+"i");
		}
		else
			return (x+y+"i");
	}
}
