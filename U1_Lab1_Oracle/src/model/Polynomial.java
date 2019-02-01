package model;

public class Polynomial {
	
	private double real;
    private double imag;

    public Polynomial() {
    	real=0.0;
    	imag=0.0;
    }
 
    public Polynomial(double real, double imag){
    	this.real=real;
    	this.imag=imag;
    }
 
    public static Polynomial conjugado(Polynomial c){
    	return new Polynomial(c.real, -c.imag); 
    }

    public static Polynomial opuesto(Polynomial c){
    	return new Polynomial(-c.real, -c.imag);
    }
 
    public double modulo(){
    	return Math.sqrt(real*real+imag*imag);
    }
    
 
    public double argumento(){
    	double angulo=Math.atan2(imag, real);     //devuelve el ángulo entre -PI y +PI
    	if(angulo<0)  angulo=2*Math.PI+angulo;
    	return angulo*180/Math.PI;
    }
    
    public static Polynomial suma(Polynomial c1, Polynomial c2){
    	double x=c1.real+c2.real;
    	double y=c1.imag+c2.imag;
    	return new Polynomial(x, y);
    }
    

    public static Polynomial producto(Polynomial c1, Polynomial c2){
    	double x=c1.real*c2.real-c1.imag*c2.imag;
    	double y=c1.real*c2.imag+c1.imag*c2.real;
    	return new Polynomial(x, y);
    }
 
    public static Polynomial producto(Polynomial c, double d){
    	double x=c.real*d;
    	double y=c.imag*d;
    	return new Polynomial(x, y);
    }
    
 
    public static Polynomial producto(double d, Polynomial c){
    	double x=c.real*d;
    	double y=c.imag*d;
    	return new Polynomial (x, y);
    }
 
    public static Polynomial cociente(Polynomial c1, Polynomial c2)throws ExceptionDivideZero{
    	double aux, x, y;
    	if(c2.modulo()==0.0){
    		throw new ExceptionDivideZero("Divide entre cero");
    	}else{
    		aux=c2.real*c2.real+c2.imag*c2.imag;
    		x=(c1.real*c2.real+c1.imag*c2.imag)/aux;
    		y=(c1.imag*c2.real-c1.real*c2.imag)/aux;
    	}
    	return new Polynomial(x, y);
 }
 
    public static Polynomial cociente(Polynomial c, double d)throws ExceptionDivideZero{
    	double x, y;
    	if(d==0.0){
    		throw new ExceptionDivideZero("Divide entre cero");
    	}else{
    		x=c.real/d;
    		y=c.imag/d;
    	}
    	return new Polynomial(x, y);
    }
 
    public static Polynomial exponencial(Polynomial c){
    	double x=Math.cos(c.imag)*Math.exp(c.real);
    	double y=Math.sin(c.imag)*Math.exp(c.real);
    	return new Polynomial(x, y);
    }


    public static Polynomial csqrt(double d){
    	if(d>=0) return new Polynomial(Math.sqrt(d), 0);
    	return new Polynomial(0, Math.sqrt(-d));
    }

 
    private static double potencia(double base, int exponente){
    	double resultado=1.0;
    	for(int i=0; i<exponente; i++){
    		resultado*=base;
    	}
    	return resultado;
    }

 
    private static double combinatorio(int m, int n){
    	long num=1;
    	long den=1;
    	for(int i=m; i>m-n; i--){
    		num*=i;
    	}
    	for(int i=2; i<=n; i++){
    		den*=i;
    	}
    	return (double)num/den;
    }
 
    public static Polynomial potencia(Polynomial c, int exponente){
    	double x=0.0, y=0.0;
    	int signo;
    	for(int i=0; i<=exponente; i++){
    		signo=(i%2==0)?+1:-1;
    		x+=combinatorio(exponente, 2*i)*potencia(c.real, exponente-2*i)*potencia(c.imag, 2*i)*signo;
    		if(exponente==2*i)  break;     
    		y+=combinatorio(exponente, 2*i+1)*potencia(c.real, exponente-(2*i+1))*potencia(c.imag, 2*i+1)*signo;
    	}
    	return new Polynomial(x, y);
    }

    public String toString(){
    	if(imag>0)     return new String((double)Math.round(100*real)/100+" + "+(double)Math.round(100*imag)/100+"*i");   
    	return new String((double)Math.round(100*real)/100+" - "+(double)Math.round(-100*imag)/100+"*i");
    }
}