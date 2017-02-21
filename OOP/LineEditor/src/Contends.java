

public class Contends
{
	private static final int MAXLINE = 9;// 定义编辑的最大行数
	private StringBuffer[] buf={new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer()}; // 存储缓冲区
	private int currentLineCount;// 现有行数
	
	public void append(String newString)
	{
		if (currentLineCount < MAXLINE)//当前行数小于最大行数时，对当前行数对应的对象作append操作
		{
			buf[currentLineCount].append(newString);
			currentLineCount++;
		}
		// 如果已经存储缓冲区满了,不做任何操作
	}

	public void delete(int linenum)
	{
		if (linenum <= currentLineCount)//删除linenum对应的对象，并对该对象之后的数组元素前移，当前行数-1
		{
			buf[linenum] = null;
		
		for (int i = linenum; i < currentLineCount; i++)
			buf[i] = buf[i + 1];
		
		currentLineCount--;
		}
		// 如果没有该行,不做任何操作
	}

	public void modifyLine(int linenum, String newcontent)
	{
		if (linenum <= currentLineCount)//修改可以看成两种操作的叠加：清空原内容，增加新内容
		{
			buf[linenum].delete(0, buf[linenum].length());
			buf[linenum].append(newcontent);
		}
		// 如果没有该行,不做任何操作
	}

	public StringBuffer[] list()
	{
		System.out.println("Contends:");
		for (int i = 0; i < currentLineCount; i++)
			System.out.println(buf[i]);
		return buf;
	}

	public void replace(int linenum,String s,String d)
	{
		if (linenum <= currentLineCount)
		{
//			int start=buf[linenum].indexOf(s);//找到字符串s所在位置
//			int end=start+s.length();//找到s结束位置
//			buf[linenum].delete(start,end);//清空s对应位置内容
//			buf[linenum].insert(start,d);//插入新的字符串，完成修改
			String temp=buf[linenum].toString().replaceAll(s, d);
			buf[linenum].setLength(0);
			buf[linenum].append(temp);
		}
		//如果没有该行,不做任何操作
	}

	public int  getCurLineCount()
	{
		return currentLineCount+1;//为方便数组运算，定义当前行数从0开始，真正得到的行数需要+1
	}

}
