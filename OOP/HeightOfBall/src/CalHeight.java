
public class CalHeight
{
	public static void main(String args[])
	{
		double H0 = 100;// ��ʼ�߶�
		double TotalLen = 0;// �켣�ܳ���
		double CurH = H0;// ��ǰ�߶�

		for (int i = 1; i <= 10; i++)
		{

			TotalLen += CurH + CurH / 2;// ÿ�ι켣��������Ϊ����߶��뷴���߶�֮��
			CurH /= 2;
		}
		System.out.println("The total length is " + TotalLen);
		System.out.println("The last height is " + CurH);
	}
}
