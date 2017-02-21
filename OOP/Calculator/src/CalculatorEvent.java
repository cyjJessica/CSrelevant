import java.awt.*;
import java.awt.event.*;


public class CalculatorEvent extends Frame implements ActionListener, WindowListener
{
	private String[] calculations = { "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x", "1", "2", "3", "-", "+", ".",
			"0", "=" };//���ֺ������������
	private String[] command = { "Backspace", "CE", "C" };//���ܼ�������
	TextField result = new TextField("0");//�����ʾ��
	Button[] calButton = new Button[calculations.length];
	Button[] cmdButton = new Button[command.length];
	
	double  calResult=0.0;//����������ʼ��Ϊ0
	boolean firstClick=true;//����Ƿ�Ϊ��һ������
	String lastCmd="=";//�����һ�ε��������

	public CalculatorEvent()
	{
		super("Calculator");
		init();//��ʼ��������
		this.setBackground(Color.gray);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.addWindowListener(this);
	}

	public void init()//ʵ�ֳ�ʼ�� ����
	{
		result.setBackground(Color.white);//�����ı��򱳾�ɫ
		result.setEditable(false);//�ı��򲻿ɱ༭
		
		Panel calPanel = new Panel();//�������ֺ�������Ļ���
		GridLayout g1 = new GridLayout(4,5,3,3);
		calPanel.setLayout(g1);
		for (int i = 0; i < calculations.length; i++)
		{
			calButton[i] = new Button(calculations[i]);
			calPanel.add(calButton[i]);
			calButton[i].setForeground(Color.blue);
		}

		Panel cmdPanel = new Panel();//���ù��ܼ��Ļ���
		GridLayout g2 = new GridLayout(1, 3, 3, 3);
		cmdPanel.setLayout(g2);
		for (int i = 0; i < command.length; i++)
		{
			cmdButton[i] = new Button(command[i]);
			cmdPanel.add(cmdButton[i]);
			cmdButton[i].setForeground(Color.red);
		}

		Panel p1 = new Panel();// ���������������һ���»�����
		p1.setLayout(new BorderLayout(3, 3));
		p1.add("North", cmdPanel);
		p1.add("South", calPanel);

		Panel p2 = new Panel();//�����ı���Ļ���
		p2.setLayout(new BorderLayout());
		p2.add("Center", result);

		setLayout(new BorderLayout(3, 5));//�����µ������������frame��
		add("Center", p1);
		add("North", p2);

		for (int i = 0; i < calculations.length; i++)//ע��
		{
			calButton[i].addActionListener(this);
		}
		for (int i = 0; i < command.length; i++)
		{
			cmdButton[i].addActionListener(this);
		}

	}
//�����¼�
	
	  public void actionPerformed(ActionEvent e)
	 {
		 
		 String click=e.getActionCommand();
		  if (e.getSource()==cmdButton[0])//�����˸��
				BackspaceEvent();//�����˸��
			else if (e.getSource()==cmdButton[1])//����CE��
				result.setText("0");//�ı�������Ϊ0
			else if (e.getSource()==cmdButton[2])//����C��
				ClearEvent();//����C��
			else if ("0123456789.".indexOf(click)>=0)//�������ּ���С����
				NumberEvent(click);//�������ּ���С����
			else 
				OperatorEvent(click);//���������
	 }
	
	 private void BackspaceEvent()//�����˸��
	 {
		 String temp=result.getText();
		 int i=temp.length();
		 if (i>1)//�����ǰ�ı�������һ�������ַ��������һ���ַ�ɾȥ
		 {
			 temp=temp.substring(0,i-1);
		 }
		 else if (i==1)//���ֻ��һ���ַ�������Ϊ0
		 {
			 result.setText("0");
		 }
		 result.setText(temp);	 
	 }
	 
	 private void ClearEvent()//����C������ȫ��������Ϊ��ֵ
	 {
		 result.setText("0");
		 calResult=0.0;
		 firstClick=true;
	 }
	 
	 private void NumberEvent(String click)//�������ֻ�С����
	 {
		 if (firstClick)//����ǵ�һ������
			 result.setText(click);//�ı�����ʾ����ֵ
		 else if (click.equals(".")&&(result.getText().indexOf(".")<0))//�������С������֮ǰû��С���㣬���ı����ݺ��С����
			 result.setText(result.getText()+".");
		 else if (!click.equals("."))//������µĲ���С���㣬���������ݼ����ı����
			 result.setText(result.getText()+click);
		 firstClick=false;//�Ժ����ǵ�һ������
	 }
	 
	 private void OperatorEvent(String click)
	 //��������������ڰ����������ֻ��һ�����֣���ʱ�޷��������㣬��Ҫ����һ�ε����������������ʹ��һ�ΰ��������ʱʹ�õ����ϴε��������������
	 {
		 if (lastCmd.equals("+"))//�ӷ�
		 {
			 calResult+=Double.valueOf(result.getText());
		 }
		 else if (lastCmd.equals("-"))//����
		 {
			 calResult-=Double.valueOf(result.getText());
		 }
		 else if (lastCmd.equals("*"))//�˷�
		 {
			 calResult*=Double.valueOf(result.getText());
		 }
		 else if (lastCmd.equals("/"))//����
		 {
			 if (Double.valueOf(result.getText())==0.0)
				 result.setText("Wrong Input");
			 else
			 calResult-=Double.valueOf(result.getText());
		 }
		 else if (lastCmd.equals("1/x"))//����
		 {
			 if (Double.valueOf(result.getText())==0.0)
				 result.setText("Wrong Input");
			 else
			 calResult=1/calResult;
		 }
		 else if (lastCmd.equals("%"))//�ٷ���
		 {
			 calResult=Double.valueOf(result.getText())*100;
		 }
		 else if (lastCmd.equals("="))//��ֵ
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
