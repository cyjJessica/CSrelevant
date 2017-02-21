import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class PersonDrawTest extends Applet implements ActionListener
{
	Person[] person = new Person[5];
	GirlPerson[] girlperson = new GirlPerson[5];
	private Button btn = new Button("Move");
	private boolean up;

	public void init()
	{
		this.add(btn);
		btn.addActionListener(this);
		up = false;
		person[0] = new Person(50, 20);
		girlperson[0] = new GirlPerson(150, 20);
		person[1] = new Person(250, 20);
		girlperson[1] = new GirlPerson(350, 20);
		person[2] = new Person(450, 20);
		girlperson[2] = new GirlPerson(550, 20);
		person[3] = new Person(650, 20);
		girlperson[3] = new GirlPerson(750, 20);
		person[4] = new Person(850, 20);
		girlperson[4] = new GirlPerson(950, 20);
	}

	public void paint(Graphics g)
	{
		for (int i = 0; i < 5; i++)
			person[i].draw(g);
		for (int j = 0; j < 5; j++)
		{
			girlperson[j].draw(g);
			girlperson[j].drawDress(g);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btn)
		{
			up = !up;
			if (up)
			{
				for (int i = 0; i < 5; i++)
				{
					person[i].setleftHandY(person[i].getneckY() - 20);
					person[i].setrightHandY(person[i].getneckY() - 20);
				}
				for (int j = 0; j < 5; j++)
				{
					girlperson[j].setleftHandY(girlperson[j].getneckY() - 20);
					girlperson[j].setrightHandY(girlperson[j].getneckY() - 20);
				}
			} else
			{
				for (int i = 0; i < 5; i++)
				{
					person[i].setleftHandY(person[i].getneckY() + 30);
					person[i].setrightHandY(person[i].getneckY() + 30);
				}
				for (int j = 0; j < 5; j++)
				{
					girlperson[j].setleftHandY(girlperson[j].getneckY() + 30);
					girlperson[j].setrightHandY(girlperson[j].getneckY() + 30);
				}
			}
			repaint();
		}
	}
}
