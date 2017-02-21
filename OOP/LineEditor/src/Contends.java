

public class Contends
{
	private static final int MAXLINE = 9;// ����༭���������
	private StringBuffer[] buf={new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer(),new StringBuffer()}; // �洢������
	private int currentLineCount;// ��������
	
	public void append(String newString)
	{
		if (currentLineCount < MAXLINE)//��ǰ����С���������ʱ���Ե�ǰ������Ӧ�Ķ�����append����
		{
			buf[currentLineCount].append(newString);
			currentLineCount++;
		}
		// ����Ѿ��洢����������,�����κβ���
	}

	public void delete(int linenum)
	{
		if (linenum <= currentLineCount)//ɾ��linenum��Ӧ�Ķ��󣬲��Ըö���֮�������Ԫ��ǰ�ƣ���ǰ����-1
		{
			buf[linenum] = null;
		
		for (int i = linenum; i < currentLineCount; i++)
			buf[i] = buf[i + 1];
		
		currentLineCount--;
		}
		// ���û�и���,�����κβ���
	}

	public void modifyLine(int linenum, String newcontent)
	{
		if (linenum <= currentLineCount)//�޸Ŀ��Կ������ֲ����ĵ��ӣ����ԭ���ݣ�����������
		{
			buf[linenum].delete(0, buf[linenum].length());
			buf[linenum].append(newcontent);
		}
		// ���û�и���,�����κβ���
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
//			int start=buf[linenum].indexOf(s);//�ҵ��ַ���s����λ��
//			int end=start+s.length();//�ҵ�s����λ��
//			buf[linenum].delete(start,end);//���s��Ӧλ������
//			buf[linenum].insert(start,d);//�����µ��ַ���������޸�
			String temp=buf[linenum].toString().replaceAll(s, d);
			buf[linenum].setLength(0);
			buf[linenum].append(temp);
		}
		//���û�и���,�����κβ���
	}

	public int  getCurLineCount()
	{
		return currentLineCount+1;//Ϊ�����������㣬���嵱ǰ������0��ʼ�������õ���������Ҫ+1
	}

}
