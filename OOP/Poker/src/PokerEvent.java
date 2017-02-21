import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class PokerEvent extends Applet implements ActionListener
{
	Player[] players = new Player[4];
	Poker poker = new Poker();
	Button play = new Button("play");
	Label result = new Label("____--------------____________________________");

	int cards[] = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	String path = "E:\\2016-2017-1\\java\\cards";

	public void init()
	{
		 
		this.add(play);
		this.add(result);
		this.setSize(1600,900);
		this.setVisible(true);
		play.addActionListener(this);
		
	}

	public void paint(Graphics g)
	{
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[0] + 1)+".jpg"), 450, 50, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[1] + 1)+".jpg"), 570, 50, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[2] + 1)+".jpg"), 690, 50, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[3] + 1)+".jpg"), 200, 130, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[4] + 1)+".jpg"), 200, 300, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[5] + 1)+".jpg"), 200, 470, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[6] + 1)+".jpg"), 450, 500, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[7] + 1)+".jpg"), 570, 500, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[8] + 1)+".jpg"), 690, 500, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[9] + 1)+".jpg"), 940, 130, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[10] + 1)+".jpg"),940, 300, this);
		g.drawImage(getToolkit().getImage(path + "\\" + String.valueOf(cards[11] + 1)+".jpg"), 940, 470, this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == play)
		{
			int c[] = { -1, -1, -1 };
			poker.deal(3, c);
			players[0] = new Player("Henry", c);
			poker.deal(3, c);
			players[1] = new Player("Mike", c);
			poker.deal(3, c);
			players[2] = new Player("Robort", c);
			poker.deal(3, c);
			players[3] = new Player("Lisa", c);

			cards[0] = players[0].mycard[0];
			cards[1] = players[0].mycard[1];
			cards[2] = players[0].mycard[2];

			cards[3] = players[1].mycard[0];
			cards[4] = players[1].mycard[1];
			cards[5] = players[1].mycard[2];

			cards[6] = players[2].mycard[0];
			cards[7] = players[2].mycard[1];
			cards[8] = players[2].mycard[2];

			cards[9] = players[3].mycard[0];
			cards[10] = players[3].mycard[1];
			cards[11] = players[3].mycard[2];
			

			result.setText(showResult());

			repaint();
		}

	}

	public String showResult()
	{

		return (players[0].toString1() +"\n"+ players[1].toString1());
	}

}
