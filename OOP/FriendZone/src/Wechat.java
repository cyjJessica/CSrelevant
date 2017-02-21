
public class Wechat
{
	static int num;//用户总数
	static User[] users;
	static int count;//当前用户 计数

	Wechat(int n)
	{
		num = n;
		users = new User[num];
	}

	public User signIn(String id, String name)
	{
		User t = new User(id, name);
		users[count] = t;
		count++;
		return t;
	}

	public static User searchUser(String id)
	{
		int j = 0;
		boolean match = false;//标记是否匹配成功
		for (int i = 0; i < num; i++)
		{
			if (id.equals(users[i].id))
			{
				j = i;
				match = true;
				break;
			}
		}
		if (match == false)
			return null;
		else
			return users[j];
	}

}
