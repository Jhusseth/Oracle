package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Graeffe;

public class InterfazPolynomial extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Graeffe g ;
	private Panel_Develop pDev;
	private PanelOptions pOpt;
	
	private ArrayList<double[]> arr;
	
	public InterfazPolynomial(){
		pDev = new Panel_Develop(this);
		pOpt = new PanelOptions(this);
		
		inicial();
	}
	
	public void inicial(){
		setTitle("-------> Oracle_Polynomial <--------");
		setSize(708,360);
		setLocationRelativeTo(null); 
		setLayout(new BorderLayout());
		
		add(pDev,BorderLayout.CENTER);
		add(pOpt,BorderLayout.SOUTH);
		setResizable(false);
		
		arr = new ArrayList<double[]>();
		
		disableWrite();
		
		g = new Graeffe();
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
		 
//		 double[] coef = {10,11,3,-10};
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
	
	public void Message(double[] array){
		arr.add(array);
		int contador =1;
		String m = "1. ) ";
		for(int i =0;i<arr.size();i++){
			for(int j =arr.get(i).length-1;j>=0;j--){
				m += arr.get(i)[j]+ "X" + "^"+ j + " ";		
			}
			contador++;
			
			m +="\n" + contador + " ). ";
		}
		
		pDev.setLb1(m + "\n");
	}
	
	public ArrayList<double[]> getArray(){
		return arr;
	}
	
	public void Clean(){
		pDev.clear();
	}
	
    public void Solution(){
    	try{
    	for(int i =0;i<arr.size();i++){	
    		g = new Graeffe(arr.get(i));
    	}
    	
    	pDev.setLb2(g.toString());
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	g.mostrarRaices();
	}
    
    public void Generate(int grade){
    	
    	int[] n = new int [11];

    	for(int i =0;i<n.length;i++){
    		n[i] = 0; 		
       	}
    	
    	for(int i =0;i<=grade;i++){
    		int num = (int)(Math.random()*100);
    		n[i]=num;
    	}
    	
    	pDev.generateDate(n[0], n[1], n[2], n[3], n[4], n[5], n[6], n[7], n[8], n[9], n[10]);
    	
    }
    
    public void activeWrite(){
    	pDev.write();
    }
    
    public void disableWrite(){
    	pDev.noWrite();
    }    
	
}
