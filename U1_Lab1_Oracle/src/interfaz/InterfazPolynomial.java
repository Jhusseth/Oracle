package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Solve;

import java.awt.Color;

public class InterfazPolynomial extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Solve g ;
	private Panel_Develop pDev;
	private PanelOptions pOpt;
	
	private ArrayList<double[]> arr;
	
	public InterfazPolynomial(){
		getContentPane().setBackground(Color.BLACK);
		pDev = new Panel_Develop(this);
		pDev.setBackground(Color.BLACK);
		pOpt = new PanelOptions(this);
		pOpt.setBackground(Color.BLACK);
		
		inicial();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void inicial(){
		setTitle("-------> Oracle_Polynomial <--------");
		setSize(708,360);
		setLocationRelativeTo(null); 
		getContentPane().setLayout(new BorderLayout());
		
		getContentPane().add(pDev,BorderLayout.CENTER);
		getContentPane().add(pOpt,BorderLayout.SOUTH);
		setResizable(false);
		
		arr = new ArrayList<double[]>();
		
		disableWrite();
		
		g = new Solve();
	}
	 
	public static void main(String[] args) {
		InterfazPolynomial windows = new InterfazPolynomial();
		windows.setVisible(true);
		
	}
	
	public void Message(double[] array){
		arr.add(array);
		int contador =1;
		String m = "1. ) ";
		for(int i =0;i<arr.size();i++){
			for(int j =arr.get(i).length-1;j>=0;j--){
				m += arr.get(i)[j]+ "X" + "^"+ j + " + ";		
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
		ArrayList<double[]> arrAux = new ArrayList<double[]>();
		arr = arrAux;
	}
	
    public void Solution(){
    	try{
    	for(int i =0;i<arr.size();i++){	
    		double[] arg = new double[arr.get(i).length];
    		for(int j =arr.get(i).length-1;j>=0;j--){
    			arg[j]=arr.get(i)[j];
    		}
    		g = new Solve(arg);
    		pDev.setLb2(g.toString());   		
    	}
    	}
    	catch(Exception e){
    		JOptionPane.showMessageDialog(null, "Error en la solucion del polinomio");
    		Clean();
    	}
	}
    
    public void Generate(int grade){
    	pDev.look();
    	pDev.Hide(grade);
    	
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
    
    public void activeWrite(int grade){
    	pDev.look();
    	pDev.write();
    	pDev.Hide(grade);
    }
    
    public void disableWrite(){
    	pDev.noWrite();
    }   
    
    public int grade(){
    	 return pOpt.getGrado();
    }
	
}
