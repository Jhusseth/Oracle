package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Panel_Develop extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SAVE = "save";
	
	private InterfazPolynomial main;
	
	private JTextField a0;
	private JTextField a1;
	private JTextField a2;
	private JTextField a3;
	private JTextField a4;
	private JTextField a5;
	private JTextField a6;
	private JTextField a7;
	private JTextField a8;
	private JTextField a9;
	private JTextField a10;
	
	private JButton btnSave;
	
	private JTextArea lb1;
	private JTextArea  lb2;
	
	public Panel_Develop(InterfazPolynomial main) {
		this.main=main;
		setLayout(new BorderLayout());
		
		a0= new JTextField("0");
		a1= new JTextField("0");
		a2= new JTextField("0");
		a3= new JTextField("0");
		a4= new JTextField("0");
		a5= new JTextField("0");
		a6= new JTextField("0");
		a7= new JTextField("0");
		a8= new JTextField("0");
		a9= new JTextField("0");
		a10= new JTextField("0");
		
		a0.setHorizontalAlignment(SwingConstants.CENTER);
		a1.setHorizontalAlignment(SwingConstants.CENTER);
		a2.setHorizontalAlignment(SwingConstants.CENTER);
		a3.setHorizontalAlignment(SwingConstants.CENTER);
		a4.setHorizontalAlignment(SwingConstants.CENTER);
		a5.setHorizontalAlignment(SwingConstants.CENTER);
		a6.setHorizontalAlignment(SwingConstants.CENTER);
		a7.setHorizontalAlignment(SwingConstants.CENTER);
		a8.setHorizontalAlignment(SwingConstants.CENTER);
		a9.setHorizontalAlignment(SwingConstants.CENTER);
		a10.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JPanel p1= new JPanel();
		p1.setLayout(new BorderLayout());
		btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		btnSave.setActionCommand(SAVE);
		JPanel p2= new JPanel();
		p2.setLayout(new GridLayout(1,11,10,20));
		
		JLabel lb = new JLabel("Escribir coeficientes del polinomio");
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(lb,BorderLayout.SOUTH);
		p1.add(p2,BorderLayout.CENTER);
		p1.add(new JLabel("            "),BorderLayout.WEST);
		p1.add(btnSave,BorderLayout.EAST);
		p1.add(new JLabel("            "),BorderLayout.NORTH);
		
		p2.add(a0);
		p2.add(a1);
		p2.add(a2);
		p2.add(a3);
		p2.add(a4);
		p2.add(a5);
		p2.add(a6);
		p2.add(a7);
		p2.add(a8);
		p2.add(a9);
		p2.add(a10);
		
		JPanel p3= new JPanel();
		p3.setLayout(new BorderLayout());
	
	
		p3.add(p1,BorderLayout.CENTER);	
		add(p3,BorderLayout.NORTH);
		
		JPanel p5= new JPanel();
		p5.setLayout(new BorderLayout());
		
		JPanel p4= new JPanel();
		p4.setLayout(new GridLayout(1,2,5,0));
		
		JPanel p6= new JPanel();
		p6.setLayout(new GridLayout(1,2,5,0));
		
		lb1 = new  JTextArea ();
		lb2= new  JTextArea ();
		
		lb1.setEditable(false);
		lb2.setEditable(false);
		
		JLabel lbp =new JLabel("Polynomials :");
		JLabel lbs =new JLabel("Solutions :");
		
		lbs.setHorizontalAlignment(SwingConstants.CENTER);
		lbp.setHorizontalAlignment(SwingConstants.CENTER);
		
		p6.add(lbp);
		p6.add(lbs);
		
		JScrollPane scroll = new JScrollPane( );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
        scroll.getViewport( ).add( p4 );
		
		p4.add(lb1);
		p4.add(lb2);
		p5.add( scroll, BorderLayout.CENTER );
		p5.add(p6,BorderLayout.NORTH);
//		p5.add(p4,BorderLayout.CENTER);
		
		add(p5,BorderLayout.CENTER);
		
	}


	public void setLb1(String lb1) {
		this.lb1.setText(lb1);
	}

	public void setLb2(String lb2) {
		this.lb2.setText(lb2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals(SAVE)){
			main.Message(arrayT());
		}
		
	}
	
	public int[] arrayT(){
		int[] Cpoly = new int[11];
		
		try{
		int x0 = Integer.parseInt(a0.getText());
		Cpoly[10]=x0;
		
		int x1 = Integer.parseInt(a1.getText());
		Cpoly[9]=x1;
		
		int x2 = Integer.parseInt(a2.getText());
		Cpoly[8]=x2;
		
		int x3 = Integer.parseInt(a3.getText());
		Cpoly[7]=x3;
		
		int x4 = Integer.parseInt(a4.getText());
		Cpoly[6]=x4;
		
		int x5 = Integer.parseInt(a5.getText());
		Cpoly[5]=x5;
		
		int x6 = Integer.parseInt(a6.getText());
		Cpoly[4]=x6;
		
		int x7 = Integer.parseInt(a7.getText());
		Cpoly[3]=x7;
		
		int x8 = Integer.parseInt(a8.getText());
		Cpoly[2]=x8;
		
		int x9 = Integer.parseInt(a9.getText());
		Cpoly[1]=x9;
		
		int x10 = Integer.parseInt(a10.getText());
		Cpoly[0]=x10;
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return Cpoly;
	}
	
	
	public void generateDate(int x0,int x1, int x2,int x3, int x4,int x5, int x6,int x7, int x8,int x9, int x10){
		a0.setText("" +x10);
		a1.setText("" +x9);
		a2.setText("" +x8);
		a3.setText("" +x7);
		a4.setText("" +x6);
		a5.setText("" +x5);
		a6.setText("" +x4);
		a7.setText("" +x3);
		a8.setText("" +x2);
		a9.setText("" +x1);
		a10.setText("" +x0);
	}
	
	
	public void clear(){
		a0.setText("0");
		a1.setText("0");
		a2.setText("0");
		a3.setText("0");
		a4.setText("0");
		a5.setText("0");
		a6.setText("0");
		a7.setText("0");
		a8.setText("0");
		a9.setText("0");
		a10.setText("0");
		
		lb1.setText("");
		lb2.setText("");
	}
	
	public void write(){
		a0.setEditable(true);
		a1.setEditable(true);
		a2.setEditable(true);
		a3.setEditable(true);
		a4.setEditable(true);
		a5.setEditable(true);
		a6.setEditable(true);
		a7.setEditable(true);
		a8.setEditable(true);
		a9.setEditable(true);
		a10.setEditable(true);
	}
	
	public void noWrite(){
		a0.setEditable(false);
		a1.setEditable(false);
		a2.setEditable(false);
		a3.setEditable(false);
		a4.setEditable(false);
		a5.setEditable(false);
		a6.setEditable(false);
		a7.setEditable(false);
		a8.setEditable(false);
		a9.setEditable(false);
		a10.setEditable(false);
	}

}
