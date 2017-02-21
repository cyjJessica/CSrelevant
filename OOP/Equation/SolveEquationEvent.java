import java.awt.*;
import java.awt.event.*;

public class SolveEquationEvent extends Frame implements ActionListener, TextListener
{
	double a, b, c;
	Button cal = new Button("Calculate");
	TextField t1 = new TextField();
	TextField t2 = new TextField();
	TextField t3 = new TextField();
	Label l1 = new Label("二次项系数");
	Label l2 = new Label("一次项系数");
	Label l3 = new Label("常数项项系数");
	Label result = new Label("计算结果为：");

	public SolveEquationEvent()
	{
		super("Equation Solver");
		GridLayout f1 = new GridLayout(4,2,3,3);
		setLayout(f1);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(cal);
		add(result);
		this.setSize(800, 400);
		setVisible(true);
		
		t1.addTextListener(this);
		t2.addTextListener(this);
		t3.addTextListener(this);
		cal.addActionListener(this);
	}

	public void textValueChanged(TextEvent e)
	{
		if (e.getSource() == t1)
			a = Double.valueOf(t1.getText());
		else if (e.getSource() == t2)
			b = Double.valueOf(t2.getText());
		else if (e.getSource() == t3)
			c = Double.valueOf(t3.getText());
	}

	public void actionPerformed(ActionEvent e)
	{
		Equations eq = new Equations(a, b, c);
		eq.SolveEqu();
		result.setText(eq.toString());
	}
	
	public static void main(String argv[])
	{
		new SolveEquationEvent();
	}
}
