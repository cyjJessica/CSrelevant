
public class NarcissisticNum
{
	public static void main(String args[])
	{
		int Num = 100;
		int Digits, Tens, Hundreds;
		System.out.println("Narcissistic numbers are:");
		for (; Num <= 999; Num++)
		{
			Hundreds = Num / 100;
			Tens = (Num - 100 * Hundreds) / 10;
			Digits = (Num - 100 * Hundreds - 10 * Tens);
			if (Num == Math.pow(Hundreds, 3) + Math.pow(Tens, 3) + Math.pow(Digits, 3))
				System.out.println(Num);
		}
	}

}
