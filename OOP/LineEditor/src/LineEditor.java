import java.io.*;

public class LineEditor
{
	public static void main(String args[]) throws IOException
	{
		Contends cont = new Contends();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (;;)
		{
			System.out.println("Your order:");
			String str = br.readLine();

			String[] array1 = str.split(" ", 2);//用于分解append命令的数组
			String[] array2 = str.split(" ", 3);//分解modify命令的数组
			String[] array3 = str.split(" ", 4);//分解其他命令的数组

			if (array1[0].equals("a"))
			{
				cont.append(array1[1]);
				cont.list();
			} else if (array3[0].equals("d"))
			{
				cont.delete(Integer.valueOf(array3[1]).intValue() - 1);//String类型转化为int类型，并减去1后进行数组运算，下同
				cont.list();
			} else if (array2[0].equals("m"))
			{
				cont.modifyLine(Integer.valueOf(array2[1]).intValue() - 1, array2[2]);
			cont.list();
			} else if (array3[0].equals("r"))
			{
				cont.replace(Integer.valueOf(array3[1]).intValue() - 1, array3[2], array3[3]);
				cont.list();
			} else if (array3[0].equals("l"))
			{
				cont.list();
			} else if (array3[0].equals("q"))
			{
				break;
			}
		}
	}
}
