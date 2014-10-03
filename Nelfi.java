//DNI 74390471 SEMPERE MANAS, JONATAN

public class Nelfi {
	
	protected double aura;
	protected Producto[] bienes;
	protected double montante;
	private static Nelfi curandero;
	private static int num=0;
	
	public Nelfi(double a,Producto[] b){
		int tam, i;
		if(a<0){
			a=0;
		}
		if(b==null){
			aura=a;
			bienes=null;
		}
		else if(b!=null){
			
			aura=a;
			tam=b.length;
			bienes= new Producto[tam];
			for(i=0;i<tam;i++){
				if(b[i]!=null){
				bienes[i]= new Producto(b[i].getNombre(), b[i].getValor());	
			}}
			montante=0;
			
		}
		num++;
		
	}
	
	public void actualizaValores(String s){
		
		int i, tam;
		tam=bienes.length;
		for(i=0;i<tam;i++){
			if(bienes[i]!=null){
			bienes[i].calculaValor(s);
		}}
	}
	
	
	public void recarga(){
		int i, tam, n=0;
		double suma=0;
		if(bienes!=null){
		tam=bienes.length;
		
		if (aura>0){
			
			for(i=0;i<tam;i++){
				if(bienes[i]!=null){
					n++;
					
					suma=suma+bienes[i].getValor();
				}
			}	
			
		
			aura=aura+(suma/n);
		}
		else{
			if(curandero!=null){
				montante=montante/2;
				
				aura=aura + (curandero.cura(montante));
			}
		}
		if(curandero==null && aura>=300){
			curandero=this;
		}
	}
	}
	public int cura(double p){
		int x=0;
		if (this==curandero && bienes!=null){
			
			int tam ,i ,j=0;
			double v ,vtotal=0 ,V ,Vtotal=0, varianza;
			tam=bienes.length;
			montante=montante+p;
			
			for(i=0; i<tam; i++){
				if(bienes[i]!=null){
					v=Math.pow(bienes[i].getValor(),2);
					
					vtotal=vtotal+v;
					V=bienes[i].getValor();
					
					Vtotal=Vtotal+V;
					j++;
				}
			}
			Vtotal=Vtotal/j;
			Vtotal=Math.pow(Vtotal, 2);
			varianza=(vtotal/j)-Vtotal;
		
			
			x=(int)(varianza+num);
			
		}
		return(x);
		
	}
	public double cultiva(Producto p){
		int i, k=0;
		double x=0;
		boolean z=false;
		if(p!=null && bienes!=null){
	
			for(i=0;i<bienes.length && z==false;i++){
			if(bienes[i]==null){
				
				k=i;
				z=true;
				}
			}
		}
		if(z==true && aura>=(p.getNombre().length())){
			bienes[k]=new Producto(p.getNombre(), p.getValor());
			aura=aura-(p.getNombre().length());
			x=(p.getNombre().length());
		}
		return(x);
		}

	public Producto comercia(String p){
		int i;
		boolean x=false;
		Producto gengar=null;
		if(p!=null && bienes!=null){
		for(i=0;i<bienes.length && x==false;i++){
			if(bienes[i]!=null){
			x=bienes[i].getNombre().equalsIgnoreCase(p);
			if(x==true){
				montante=montante+(bienes[i].getValor());
				gengar=new Producto(bienes[i].getNombre(), bienes[i].getValor());
				bienes[i]=null;
			}
		}}}
		
		return(gengar);
	}
	
	public double extrae(Croker c){
		double devolver=0;
		if(c!=null && bienes!=null){
			double fuerza=c.getFuerza();
			int tam ,i ,j=0;
			double  v ,vtotal=0 ,V ,Vtotal=0, varianza, desv;
			tam=bienes.length;
			
			
			for(i=0; i<tam; i++){
				if(bienes[i]!=null){
					v=Math.pow(bienes[i].getValor(),2);
					vtotal=vtotal+v;
					V=bienes[i].getValor();
					Vtotal=Vtotal+V;
					j++;
				}
			}
			Vtotal=Vtotal/j;
			Vtotal=Math.pow(Vtotal, 2);
			varianza=(vtotal/j)-Vtotal;
			desv=Math.sqrt(varianza)+aura;
			if(desv<fuerza){
				devolver=aura;
				aura=0;
				if(this==curandero){
					curandero=null;
				}
			}
			else{
				devolver=-aura;
			}
		}
		return(devolver);	
	}
	
	public boolean esCurandero(){
		boolean x=false;
		if(this==curandero){
			x=true;}
		return(x);
	}
	
	public double getAura(){
		return(aura);
	}
	
	public double getMontante(){
		return(montante);
	}
	
	public void muestraBienes(){
		int i;
		if(bienes!=null){
		for(i=0;i<bienes.length;i++){
			if(bienes[i]!=null){
			System.out.println(bienes[i].getNombre()+" "+bienes[i].getValor());
			}
		}
	}
}
}