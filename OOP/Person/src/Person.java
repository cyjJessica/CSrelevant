import java.awt.*;

class Person
{
	private int neckX, neckY;
	private int leftHandX, leftHandY, rightHandX, rightHandY;

	public Person(int x, int y)
	{
		neckX = x;
		neckY = y;
		leftHandX = neckX - 20;
		leftHandY = neckY + 30;
		rightHandX = neckX + 20;
		rightHandY = neckY + 30;
	}

	public void draw(Graphics g)
	{
		g.drawOval(neckX - 10, 0, neckY, neckY);
		g.drawLine(neckX, neckY, neckX, neckY + 40);
		g.drawLine(neckX, neckY + 10, leftHandX, leftHandY);
		g.drawLine(neckX, neckY + 10, rightHandX, rightHandY);
		g.drawLine(neckX, neckY + 40, neckX - 20, neckY + 60);
		g.drawLine(neckX, neckY + 40, neckX + 20, neckY + 60);
	}

	public int getneckX()
	{
		return neckX;
	}

	public int getneckY()
	{
		return neckY;
	}

	public void setleftHandX(int x)
	{
		leftHandX = x;
	}

	public void setleftHandY(int y)
	{
		leftHandY = y;
	}

	public void setrightHandX(int x)
	{
		rightHandX = x;
	}

	public void setrightHandY(int y)
	{
		rightHandY = y;
	}

}// ¿‡Ω· ¯
