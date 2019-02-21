package Test;
import static org.junit.Assert.assertEquals;
import model.Solve;

import  org.junit.Test ;

public class TestSolve {
	
	public Solve s;
	
	public void stage(){
		s= new Solve();	
	}
	
	
	@Test
	public void sceneSolve(){
		stage();
		double[] d  =  new double[]{1,2,1};
		s = new Solve(d);
		s.finsRoot();
		
		int c = 0;
		
		for(int i =0; i<s.realRoots.length;i++){
			if(s.realRoots[i]!=0){
				c++;
			}
		}
		assertEquals(2, c);
	}
	
	@Test
	public void scenOne(){
		stage();
		
	}
	
	@Test
	public void sceneTwo(){
		stage();
		
	}
	
	@Test
	public void sceneThree(){
		stage();
		
	}
	
	

}
