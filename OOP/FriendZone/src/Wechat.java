
public class Wechat
{
	static int num;//�û�����
	static User[] users;
	static int count;//��ǰ�û� ����

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
		boolean match = false;//����Ƿ�ƥ��ɹ�
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
