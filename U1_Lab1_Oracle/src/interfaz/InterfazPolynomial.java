package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.border.Border;

import model.Graeffe;

public class InterfazPolynomial extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Graeffe g ;
	private Panel_Develop pDev;
	private PanelOptions pOpt;
	
	public InterfazPolynomial(){
		pDev = new Panel_Develop(this);
		pOpt = new PanelOptions(this);
		
		inicial();
	}
	
	public void inicial(){
		setTitle("-------> Oracle_Polynomial <--------");
		setSize(400,150);
		setLocationRelativeTo(null); 
		setLayout(new BorderLayout());
		
		add(pDev,BorderLayout.CENTER);
		add(pOpt,BorderLayout.SOUTH);
		setResizable(true);
		
	}
	 
	public static void main(String[] args) {
//	        double[] coef={1, -4, 1, 6};
//	        Graeffe g=new Graeffe(coef);
//	        g.mostrarRaices();
//	        double[] coef1={1, -7, 16, -12};
//	        g=new Graeffe(coef1);
//	        g.mostrarRaices();
//	        double[] coef2={1, -7, 25, -39};
//	        g=new Graeffe(coef2);
//	        g.mostrarRaices();
//	        double[] coef3={1, 0, -5, 0, 4, -10};
//	        g=new Graeffe(coef3);
//	        g.mostrarRaices();
//
//	        double[] coef4={1, -6, 11, -7};
//	        g=new Graeffe(coef4);
//	        g.mostrarRaices();
//	        double[] coef5={1, 2, 2, 2};
//	        g=new Graeffe(coef5);
//	        g.mostrarRaices();
//
//	        double[] coef6={1, -1, -10, -1, 1};
//	        g=new Graeffe(coef6);
//	        g.mostrarRaices();
//
//	        double[] coef7={4, 16, 25, 21, 9};
//	        g=new Graeffe(coef7);
//	        g.mostrarRaices();
//	        double[] coef8={16, -16, -12, 12, 0, 1};
//	        g=new Graeffe(coef8);
//	        g.mostrarRaices();
//	        double[] coef9={1, -8, 17, -10, 0, 1};
//	        g=new Graeffe(coef9);
//	        g.mostrarRaices();
		 
//		 double[] coef = {};
//		 g = new Graeffe(coef);
//		 g.mostrarRaices();
//     
//		 try  {
//			 System.in.read();  
//		 }
//		 catch (Exception ex) { 
//			 System.out.println(ex);  
//		 }   
		 
		 
		InterfazPolynomial windows = new InterfazPolynomial();
		windows.setVisible(true);
		
	}
	
	public void save(int[] array){
		
	}
	
}
