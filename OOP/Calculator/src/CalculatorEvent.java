import java.awt.*;
import java.awt.event.*;


public class CalculatorEvent extends Frame implements ActionListener, WindowListener
{
	private String[] calculations = { "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x", "1", "2", "3", "-", "+", ".",
			"0", "=" };//数字和运算符的数组
	private String[] command = { "Backspace", "CE", "C" };//功能键的数组
	TextField result = new TextField("0");//结果显示框
	Button[] calButton = new Button[calculations.length];
	Button[] cmdButton = new Button[command.length];
	
	double  calResult=0.0;//计算结果，初始化为0
	boolean firstClick=true;//标记是否为第一次输入
	String lastCmd="=";//存放上一次的运算符号

	public CalculatorEvent()
	{
		super("Calculator");
		init();//初始化计算器
		this.setBackground(Color.gray);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.addWindowListener(this);
	}

	public void init()//实现初始化 函数
	{
		result.setBackground(Color.white);//设置文本框背景色
		result.setEditable(false);//文本框不可编辑
		
		Panel calPanel = new Panel();//放置数字和运算符的画板
		GridLayout g1 = new GridLayout(4,5,3,3);
		calPanel.setLayout(g1);
		for (int i = 0; i < calculations.length; i++)
		{
			calButton[i] = new Button(calculations[i]);
			calPanel.add(calButton[i]);
			calButton[i].setForeground(Color.blue);
		}

		Panel cmdPanel = new Panel();//放置功能键的画板
		GridLayout g2 = new GridLayout(1, 3, 3, 3);
		cmdPanel.setLayout(g2);
		for (int i = 0; i < command.length; i++)
		{
			cmdButton[i] = new Button(command[i]);
			cmdPanel.add(cmdButton[i]);
			cmdButton[i].setForeground(Color.red);
		}

		Panel p1 = new Panel();// 把上两个画板放入一个新画板中
		p1.setLayout(new BorderLayout(3, 3));
		p1.add("North", cmdPanel);
		p1.add("South", calPanel);

		Panel p2 = new Panel();//放置文本框的画板
		p2.setLayout(new BorderLayout());
		p2.add("Center", result);

		setLayout(new BorderLayout(3, 5));//把最新的两个画板放入frame中
		add("Center", p1);
		add("North", p2);

		for (int i = 0; i < calculations.length; i++)//注册
		{
			calButton[i].addActionListener(this);
		}
		for (int i = 0; i < command.length; i++)
		{
			cmdButton[i].addActionListener(this);
		}

	}
//处理事件
	
	  public void actionPerformed(ActionEvent e)
	 {
		 
		 String click=e.getActionCommand();
		  if (e.getSource()==cmdButton[0])//按下退格键
				BackspaceEvent();//处理退格键
			else if (e.getSource()==cmdButton[1])//按下CE键
				result.setText("0");//文本框重置为0
			else if (e.getSource()==cmdButton[2])//按下C键
				ClearEvent();//处理C键
			else if ("0123456789.".indexOf(click)>=0)//按下数字键或小数点
				NumberEvent(click);//处理数字键或小数点
			else 
				OperatorEvent(click);//处理运算符
	 }
	
	 private void BackspaceEvent()//处理退格键
	 {
		 String temp=result.getText();
		 int i=temp.length();
		 if (i>1)//如果当前文本框中有一个以上字符，把最后一个字符删去
		 {
			 temp=temp.substring(0,i-1);
		 }
		 else if (i==1)//如果只有一个字符，重置为0
		 {
			 result.setText("0");
		 }
		 result.setText(temp);	 
	 }
	 
	 private void ClearEvent()//处理C键，把全部参数置为初值
	 {
		 result.setText("0");
		 calResult=0.0;
		 firstClick=true;
	 }
	 
	 private void NumberEvent(String click)//处理数字或小数点
	 {
		 if (firstClick)//如果是第一次输入
			 result.setText(click);//文本框显示输入值
		 else if (click.equals(".")&&(result.getText().indexOf(".")<0))//如果按下小数点且之前没有小数点，在文本内容后加小数点
			 result.setText(result.getText()+".");
		 else if (!click.equals("."))//如果按下的不是小数点，把输入内容加在文本框后
			 result.setText(result.getText()+click);
		 firstClick=false;//以后不再是第一次输入
	 }
	 
	 private void OperatorEvent(String click)
	 //处理运算符，由于按下运算符是只有一个数字，此时无法进行运算，故要把上一次的运算符保留下来，使下一次按下运算符时使用的是上次的运算符进行运算
	 {
		 if (lastCmd.equals("+"))//加法
		 {
			 calResult+=Double.valueOf(result.getText());
		 }
		 else if (lastCmd.equals("-"))//减法
		 {
			 calResult-=Double.valueOf(result.getText());
		 }
		 else if (lastCmd.equals("*"))//乘法
		 {
			 calResult*=Double.valueOf(result.getText());
		 }
		 else if (lastCmd.equals("/"))//除法
		 {
			 if (Double.valueOf(result.getText())==0.0)
				 result.setText("Wrong Input");
			 else
			 calResult-=Double.valueOf(result.getText());
		 }
		 else if (lastCmd.equals("1/x"))//倒数
		 {
			 if (Double.valueOf(result.getText())==0.0)
				 result.setText("Wrong Input");
			 else
			 calResult=1/calResult;
		 }
		 else if (lastCmd.equals("%"))//百分数
		 {
			 calResult=Double.valueOf(result.getText())*100;
		 }
		 else if (lastCmd.equals("="))//赋值
		 {
			 calResult=Double.valueOf(result.getText());
		 }
		 lastCmd=click;
		 firstClick=true;
		 result.setText(String.valueOf(calResult));
	 }
	 
	
	 public void windowClosed(WindowEvent e){}
	
	 public void windowDeactivated(WindowEvent e) {}
	 
	 public void windowDeiconified(WindowEvent e){}
	 
	 public void windowIconified(WindowEvent e){}
	 
	 public void windowOpened(WindowEvent e){}
	 
	 public void windowActivated(WindowEvent e){}
	 
	 public void windowClosing(WindowEvent e)
	 {
		 System.exit(0);
	 }
	 
	public static void main(String argv[])
	{
		new CalculatorEvent().setVisible(true);
	}
}
