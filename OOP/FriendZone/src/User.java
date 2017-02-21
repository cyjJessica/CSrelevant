import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class User
{
	String id;
	String name;
	Photo ph;
	List<User> friendList = new ArrayList<User>();//�����ӵĺ���
	String[] text = new String[100];//��ŷ���������Ȧ
	int count;//����Ȧ����

	User(String id, String name)
	{
		this.id = id;
		this.name = name;
		Random random = new Random(System.currentTimeMillis());
		int type = random.nextInt(3);
		ph = new Photo(type);
	}

	void postInfo() throws IOException
	{
		//�������+���ݣ������text������
		System.out.println("->Now post a new moment");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("->Headline:");
		String headline = br.readLine();
		System.out.println("->Context:");
		String context = br.readLine();
		String moment = ("#" + headline + "#" + context);
		text[count] = moment;
		count++;
	}

	void addFriend() throws IOException
	{
		//����id�������û����󣬼���friendList�б�
		System.out.println("->Now add a new friend");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input id:(All ids are 1001,1002,1003,1004)");
		String str = br.readLine();
		User newfreiend = Wechat.searchUser(str);
		friendList.add(newfreiend);
	}

	List<User> printfriend()
	{
		System.out.println("->This is your friendlist:");
		for (User u : friendList)
		{
			if (u != null)
				System.out.println(u.id + '\t' + u.name);
		}
		return friendList;
	}

	void viewInfo() throws IOException
	{
		System.out.println("->Now you see all your friends' moments:");
		for (User u : friendList)
		{
			if (u != null)
			{
				System.out.println(u.name);
				int i = 0;
				while (u.text[i] != null)
				{
					System.out.println(u.text[i]);
					i++;
				}
			}
		}
	}

}
