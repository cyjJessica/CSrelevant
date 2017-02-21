import java.io.IOException;

public class testWechat
{
	public static void main(String[] args) throws IOException
	{
		
	Wechat wechat = new Wechat(4);
	User u1=wechat.signIn("1001", "Mills");
	User u2=wechat.signIn("1002", "Bob");
	User u3=wechat.signIn("1003", "Nicolas");
	User u4=wechat.signIn("1004", "Henry");
	
	u2.postInfo();
	u2.postInfo();
	u3.postInfo();
	u1.addFriend();
	u1.addFriend();
	u1.printfriend();
	u1.viewInfo();
	
	}
}
