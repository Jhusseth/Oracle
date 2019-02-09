package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	
	private JLabel lb1;
	private JLabel lb2;
	
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
		p2.setLayout(new GridLayout(1,11,10,10));
		
		JLabel lb = new JLabel("Escribir coeficientes del polinomio");
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(lb,BorderLayout.NORTH);
		p1.add(p2,BorderLayout.CENTER);
		p1.add(new JLabel("            "),BorderLayout.WEST);
		p1.add(btnSave,BorderLayout.EAST);
		p1.add(new JLabel("            "),BorderLayout.SOUTH);
		
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
		add(p3,BorderLayout.CENTER);
		
		JPanel p4= new JPanel();
		p4.setLayout(new GridLayout(2,2,5,5));
		lb1 = new JLabel();
		lb2= new JLabel();
		
		p4.add(new JLabel("   Polynomials :"));
		p4.add(new JLabel("   Solution :"));
		p4.add(lb1);
		p4.add(lb2);
		add(p4,BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals(SAVE)){
			
		}
		
	}
	
	public int[] arrayT(){
		int[] Cpoly = new int[10];
		
		for(int i =0;i<Cpoly.length;i++){
			Cpoly[i] = Integer.parseInt("");
		}
		
		return Cpoly;
	}

}
