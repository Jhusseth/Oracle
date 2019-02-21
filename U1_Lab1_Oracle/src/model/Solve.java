package model;

public class Solve {
	
	public int n;                                      
    public double[] realRoots;
    public Polynomial[] complextRoots=new Polynomial[4]; 
    public int numReales;                              
    public int numComplejas;                          
    private double[][] a;                       
    private int pot2=1;                         
    private int m;                              
    private final int MAX_ITER=10;                      
    private static final double CERO=0.0001;
    private double[] modComplex=new double[2];

    public Solve(double[] coef) {
        n=coef.length-1;                        
        realRoots=new double[n];      
        a= new double[MAX_ITER][n+1];
        for(int j=0; j<n+1; j++){
            a[0][j]=coef[j];
        }
        for(int m=1; m<MAX_ITER; m++){
            for(int j=0; j<n+1; j++){
                a[m][j]=0.0;
            }
        }
        numReales=0;
        numComplejas=0;
    }
    
    public Solve() {
    	
    }

    private void table(){
        int k,l, signo;
        for(int i=1; i<n+1; i++){
            a[0][i]/=a[0][0];
        }
        a[0][0]=1.0;
        m=1;
exterior:
        do{
            for(int i=0; i<n+1; i++){
                a[m][i]=a[m-1][i]*a[m-1][i];
                if(Double.isInfinite(a[m][i])){
                    break exterior;
                }
            }      
            for(int i=1; i<n; i++){
                for(int s=1; s<n/2+1; s++){
                    k=i-s;      l=i+s;
                    if((k<0)||(l>n))    break;  
                    signo=(s%2==0)? +1: -1;
                    a[m][i]+=signo*2*a[m-1][k]*a[m-1][l];
                    if(Double.isInfinite(a[m][i])){
                        break exterior;
                    }
                }
            }
            m++;
        }while(m<MAX_ITER);
        m--;
        pot2=1;
        for(int i=1; i<=m; i++){
            pot2*=2;
        }
    }
    
    public double polinimialValue(double x){
        double y=0.0;
        double[] pot_x=new double[n+1];
        pot_x[0]=1.0;
        for(int i=1; i<n+1; i++){
            pot_x[i]=pot_x[i-1]*x;
        }
        
        for(int i=0; i<n+1; i++){
            y+=a[0][i]*pot_x[n-i];
        }
        return y;
    }
    public Polynomial valorPolinomio(Polynomial x){
    	Polynomial y=new Polynomial();
        for(int i=0; i<n+1; i++){
            y=Polynomial.suma(y, Polynomial.producto(a[0][i], Polynomial.potencia(x, (n-i))));
        }
        return y;
    }

    private void simpleRealRoot(int j){
        double logaritmo=(Math.log(a[m][j])-Math.log(a[m][j-1]))/pot2;
        double raiz=Math.exp(logaritmo);
        realRoots[numReales]=(Math.abs(polinimialValue(raiz))<Math.abs(polinimialValue(-raiz)))? raiz : -raiz;
        numReales++;
    }

    private void doubleRealRoot(int j){
        double logaritmo=(Math.log(a[m][j+1])-Math.log(a[m][j-1]))/(2*pot2);
        double raiz=Math.exp(logaritmo);
        boolean bPositiva=false, bNegativa=false;
        if (Math.abs(polinimialValue(raiz))<CERO){
           realRoots[numReales]=raiz;
           numReales++;
           bPositiva=true;
        }
        if (Math.abs(polinimialValue(-raiz))<CERO){
           realRoots[numReales]=-raiz;
           numReales++;
           bNegativa=true;
        }
        if(bPositiva && !bNegativa){
          realRoots[numReales]=raiz;
          numReales++;
        }
        if(!bPositiva && bNegativa){
          realRoots[numReales]=-raiz;
          numReales++;
        }
    }

    private void oneComplexRoot(){
        double suma=0.0;
        for(int i=0; i<numReales; i++){
            suma+=realRoots[i];
        }
        double u, v;
        u=-(a[0][1]+suma)/2;
        v=Math.sqrt(modComplex[0]*modComplex[0]-u*u);
        complextRoots[0]=new Polynomial(u, v);
        complextRoots[1]=new Polynomial(u, -v);
    }
    private void twoComplexRoot(){
        double suma=0.0;
        double producto=1.0;
        double inversa=0.0;
        for(int i=0; i<numReales; i++){
            suma+=realRoots[i];
            producto*=realRoots[i];
            inversa+=1/realRoots[i];
        }
        double r1=modComplex[0];
        double r2=modComplex[1];
        double y=-(a[0][1]+suma)/2;
        int signo=((n-1)%2==0)? +1: -1;
        double z=signo*a[0][n-1]/(2*producto)-r1*r1*r2*r2*inversa/2;
        double u1=(y*r1*r1-z)/(r1*r1-r2*r2);
        double u2=(-y*r2*r2+z)/(r1*r1-r2*r2);
        double v1=Math.sqrt(r1*r1-u1*u1);
        double v2=Math.sqrt(r2*r2-u2*u2);
        complextRoots[0]=new Polynomial(u1, v1);
        complextRoots[1]=new Polynomial(u1, -v1);
        complextRoots[2]=new Polynomial(u2, v2);
        complextRoots[3]=new Polynomial(u2, -v2);
    }

    public boolean changeSign(int j){
        double logaritmo;
        for(int k=2; k<=m; k++){
            if(a[k][j]>0)   continue;
            numComplejas++;
            if(numComplejas<3){
                logaritmo=(Math.log(a[m][j+1])-Math.log(a[m][j-1]))/(2*pot2);
                modComplex[numComplejas-1]=Math.exp(logaritmo);
                return true;
            }
        }
        return false;
    }

    public void finsRoot(){
        table();
        for(int i=1; i<n+1; i++){      
            if(changeSign(i)){
                i++;
                continue;
            }
            
            double logaritmo=Math.log(a[m][i])-2*Math.log(a[m-1][i]);
            if(Math.abs(logaritmo)<CERO){
                simpleRealRoot(i);
            }else{
               doubleRealRoot(i);
                i++;
                continue;
            }
        }
        if(numComplejas==1){
            oneComplexRoot();
        }
        if(numComplejas==2){
            twoComplexRoot();
        }
     }


    public void showRoots(){
        finsRoot();
        System.out.println("Raíces reales");
        for(int i=0; i<numReales; i++){
            System.out.println((double)Math.round(realRoots[i]*100)/100);
        }
        System.out.println("");
        System.out.println("Raíces complejas");
        for(int i=0; i<numComplejas; i++){
            System.out.println(complextRoots[2*i]);
            System.out.println(complextRoots[2*i+1]);
        }
        System.out.println("");
    }

	@Override
	public String toString() {
		
		finsRoot();
		String MsjR = "";
		String MsjC = "";
		for(int i=0; i<numReales; i++){
			MsjR+= "Raices Reales: " + (double)Math.round(realRoots[i]*100)/100 + "\n";
		}
		
		for(int i=0; i<numComplejas; i++){
			MsjC+= "Raices Complejas: " + complextRoots[2*i] + "\n";
		}
		
		return MsjR + "\n" + MsjC ;
		
	}

}
