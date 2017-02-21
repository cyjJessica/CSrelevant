
public class CalHeight
{
	public static void main(String args[])
	{
		double H0 = 100;// 初始高度
		double TotalLen = 0;// 轨迹总长度
		double CurH = H0;// 当前高度

		for (int i = 1; i <= 10; i++)
		{

			TotalLen += CurH + CurH / 2;// 每次轨迹长度增量为下落高度与反弹高度之和
			CurH /= 2;
		}
		System.out.println("The total length is " + TotalLen);
		System.out.println("The last height is " + CurH);
	}
}
