package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		setBackground(Color.BLACK);
		this.main=main;
		setLayout(new BorderLayout());
		
		a0= new JTextField("");
		a0.setBackground(Color.GRAY);
		a0.setForeground(Color.RED);
		a1= new JTextField("");
		a1.setBackground(Color.GRAY);
		a1.setForeground(Color.RED);
		a2= new JTextField("");
		a2.setBackground(Color.GRAY);
		a2.setForeground(Color.RED);
		a3= new JTextField("");
		a3.setBackground(Color.GRAY);
		a3.setForeground(Color.RED);
		a4= new JTextField("");
		a4.setBackground(Color.GRAY);
		a4.setForeground(Color.RED);
		a5= new JTextField("");
		a5.setBackground(Color.GRAY);
		a5.setForeground(Color.RED);
		a6= new JTextField("");
		a6.setBackground(Color.GRAY);
		a6.setForeground(Color.RED);
		a7= new JTextField("");
		a7.setBackground(Color.GRAY);
		a7.setForeground(Color.RED);
		a8= new JTextField("");
		a8.setBackground(Color.GRAY);
		a8.setForeground(Color.RED);
		a9= new JTextField("");
		a9.setBackground(Color.GRAY);
		a9.setForeground(Color.RED);
		a10= new JTextField("");
		a10.setBackground(Color.GRAY);
		a10.setForeground(Color.RED);
		
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
		p1.setBackground(Color.BLACK);
		p1.setLayout(new BorderLayout());
		btnSave = new JButton("Save");
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(Color.CYAN);
		btnSave.addActionListener(this);
		btnSave.setActionCommand(SAVE);
		JPanel p2= new JPanel();
		p2.setBackground(Color.BLACK);
		p2.setForeground(Color.RED);
		p2.setLayout(new GridLayout(1,11,10,20));
		
		JLabel lb = new JLabel("Escribir coeficientes del polinomio");
		lb.setForeground(Color.WHITE);
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(lb,BorderLayout.SOUTH);
		p1.add(p2,BorderLayout.CENTER);
		p1.add(new JLabel("            "),BorderLayout.WEST);
		p1.add(btnSave,BorderLayout.EAST);
		JLabel label = new JLabel("            ");
		label.setBackground(Color.BLACK);
		p1.add(label,BorderLayout.NORTH);
		
		p2.add(a10);
		p2.add(a9);
		p2.add(a8);
		p2.add(a7);
		p2.add(a6);
		p2.add(a5);
		p2.add(a4);
		p2.add(a3);
		p2.add(a2);
		p2.add(a1);
		p2.add(a0);
		
		JPanel p3= new JPanel();
		p3.setBackground(Color.BLACK);
		p3.setLayout(new BorderLayout());
	
	
		p3.add(p1,BorderLayout.CENTER);	
		add(p3,BorderLayout.NORTH);
		
		JPanel p5= new JPanel();
		p5.setBackground(Color.BLACK);
		p5.setForeground(Color.WHITE);
		p5.setLayout(new BorderLayout());
		
		JPanel p4= new JPanel();
		p4.setForeground(Color.BLACK);
		p4.setLayout(new GridLayout(1,2,5,0));
		
		JPanel p6= new JPanel();
		p6.setForeground(Color.WHITE);
		p6.setBackground(Color.BLACK);
		p6.setLayout(new GridLayout(1,2,5,0));
		
		lb1 = new  JTextArea ();
		lb1.setForeground(Color.BLACK);
		lb1.setBackground(Color.LIGHT_GRAY);
		lb2= new  JTextArea ();
		lb2.setForeground(Color.BLACK);
		lb2.setBackground(Color.LIGHT_GRAY);
		
		lb1.setEditable(false);
		lb2.setEditable(false);
		
		JLabel lbp =new JLabel("Polynomials :");
		lbp.setBackground(Color.BLACK);
		lbp.setForeground(Color.WHITE);
		JLabel lbs =new JLabel("Solutions :");
		lbs.setBackground(Color.BLACK);
		lbs.setForeground(Color.WHITE);
		
		lbs.setHorizontalAlignment(SwingConstants.CENTER);
		lbp.setHorizontalAlignment(SwingConstants.CENTER);
		
		p6.add(lbp);
		p6.add(lbs);
		
		JScrollPane scroll = new JScrollPane( );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
        scroll.setViewportView(p4);
        scroll.setBackground(Color.BLACK);
        p4.setBackground(Color.BLACK);
		
		p4.add(lb1);
		p4.add(lb2);
		p5.add( scroll, BorderLayout.CENTER );
		p5.add(p6,BorderLayout.NORTH);
		
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
			try{
			main.Message(arrayT(main.grade()));
			}
			catch(Exception ex){
				
			}
		}
		
	}
	
	public double[] arrayT(int n){
		
		JTextField[] aTxt = new JTextField[11];
		double[] cPoly = new double[n+1];
		aTxt[0] = a0;
		aTxt[1] = a1;
		aTxt[2] = a2;
		aTxt[3] = a3;
		aTxt[4] = a4;
		aTxt[5] = a5;
		aTxt[6] = a6;
		aTxt[7] = a7;
		aTxt[8] = a8;
		aTxt[9] = a9;
		aTxt[10] = a10;
		try{
		
		for(int i =0;i<aTxt.length;i++){
			if(!aTxt[i].getText().equals("")||!aTxt[i].getText().equals("0") ){
				double num = Integer.parseInt(aTxt[i].getText());
				cPoly[i]=num;
			}
		}
		}
		catch(Exception e){
		}
		
		return cPoly;
	}
	
	
	public void generateDate(int x0,int x1, int x2,int x3, int x4,int x5, int x6,int x7, int x8,int x9, int x10){
		a0.setText("" +x0);
		a1.setText("" +x1);
		a2.setText("" +x2);
		a3.setText("" +x3);
		a4.setText("" +x4);
		a5.setText("" +x5);
		a6.setText("" +x6);
		a7.setText("" +x7);
		a8.setText("" +x8);
		a9.setText("" +x9);
		a10.setText("" +x10);
	}
	
	
	public void clear(){
		a0.setVisible(false);
		a0.setText("");
		a1.setText("");
		a2.setText("");
		a3.setText("");
		a4.setText("");
		a5.setText("");
		a6.setText("");
		a7.setText("");
		a8.setText("");
		a9.setText("");
		a10.setText("");
		
		lb1.setText("");
		lb2.setText("");
		
		look();
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
	
	
	public void Hide(int d){
		JTextField[] aTxt = new JTextField[11];
		aTxt[0] = a0;
		aTxt[1] = a1;
		aTxt[2] = a2;
		aTxt[3] = a3;
		aTxt[4] = a4;
		aTxt[5] = a5;
		aTxt[6] = a6;
		aTxt[7] = a7;
		aTxt[8] = a8;
		aTxt[9] = a9;
		aTxt[10] = a10;
		
		for(int i =10;i>d;i--){
			aTxt[i].setVisible(false);
		}
	}
	
	
	public void look(){
		JTextField[] aTxt = new JTextField[11];
		aTxt[0] = a0;
		aTxt[1] = a1;
		aTxt[2] = a2;
		aTxt[3] = a3;
		aTxt[4] = a4;
		aTxt[5] = a5;
		aTxt[6] = a6;
		aTxt[7] = a7;
		aTxt[8] = a8;
		aTxt[9] = a9;
		aTxt[10] = a10;
		
		for(int i =0;i<aTxt.length;i++){
			aTxt[i].setVisible(true);
		}
	}
	
	

}
