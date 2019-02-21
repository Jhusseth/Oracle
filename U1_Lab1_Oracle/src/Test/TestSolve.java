package Test;

import static org.junit.Assert.*;
import model.Solve;

import  org.junit.Test ;

public class TestSolve {
	
	public Solve s;
	
	public void stage(){
		s= new Solve(new double[]{1,2,1});	
	}
	
	@Test
	public void sceneSolve(){
		stage();
		
	}
	
	@Test
	public void scenOne(){
		stage();
		
	}
	
	@Test
	public void sceneTwo(){
		stage();
		s.finsRoot();
		
	}
	
	@Test
	public void sceneThree(){
		stage();
		
	}
	
	

}
