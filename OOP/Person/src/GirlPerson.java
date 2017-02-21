import java.awt.Graphics;

public class GirlPerson extends Person
{
	private int dressX;
	private int dressY;
	Person p;

	public GirlPerson(int x, int y)
	{
		super(x, y);
		p = new Person(x, y);
		dressX = p.getneckX() - 10;
		dressY = p.getneckY() + 50;
	}

	public void drawDress(Graphics g)
	{
		g.drawLine(dressX, dressY, dressX + 20, dressY);
	}
}
