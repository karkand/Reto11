
public class Crokevo extends Croker implements Evo {
	private Producto[] despensa;
	private Kupolo bussines;
	private double bolsa;

	public Crokevo (double a,double b,int c){
		super(a,b);
		if(c<0){
			c=0;
		}
		despensa=new Producto[c];
		bussines=null;
		bolsa=125.5;
	}
	
	public boolean entra(Kupolo k){
		boolean resul=false;
		if(k!=null && bussines==null){
			Coordenadas cord;
			double vueltas;
			cord=k.busquedaInferior();
			if(cord!=null){
				vueltas=k.vendeEntrada(this, cord, bolsa);
				if(vueltas!=(-1)){
					bolsa=vueltas;
					resul=true;
				}
			}
		}
		return(resul);
	}
	public boolean sale(Kupolo k){
		boolean x=false;
		if(bussines!=null && k!=null){
			if(k==bussines){
				x=k.sale(this);
			}
		}
		return(x);
	}	

	public boolean aCubierto(){
		boolean x=false;
		if(bussines!=null){
			x=true;
		}
		return(x);
	}	
	public boolean estasAqui(Kupolo k){
		boolean x=false;
		if(k!=null && bussines!=null){
			if(k==bussines){
				x=true;
			}
		}
		return(x);
	}
	public void sms(Kupolo k){
		bussines=k;
	}
	public void premia(double d){
		fuerza=fuerza +d;
	}
	
	public void recolecta(String s){
		if(s!=null){
			Producto[] despensa2;
			int i;
			boolean x=false;
			Producto aseite;
			aseite=new Producto(s, s.compareTo(s.toUpperCase()));
			for(i=0;i<despensa.length && x==false;i++){
				if(despensa[i]==null){
					despensa[i]=aseite;
					x=true;
				}
			}
			if(x==false){
				despensa2=new Producto[despensa.length+10];
				for(i=0;i<despensa.length;i++){
					despensa2[i]=despensa[i];
				}
				despensa=despensa2;
				for(i=0;i<despensa.length && x==false;i++){
					if(despensa[i]==null){
						despensa[i]=aseite;
						x=true;
					}
				}
			}
			
		}
	}
	public void cobra(int i){
		if(i>0){
			fuerza=fuerza+i;
		}
	}
	public Producto[] getDespensa(){
		return(despensa);
	}
	
	public void caza(Nelfi n){
		if(n!=null && despensa!=null){
			int i;
			double z;
			boolean x=false;
			for(i=0;i<despensa.length && x==false; i++){
				if(despensa[i]!=null){
					x=true;
				}
			}

			if(x==true){
				z=(n.cultiva(despensa[i-1]));
				if(z!=0){
					bolsa=bolsa+z;
					despensa[i-1]=null;
				}
			}
		}
	}
	
	public Croker corteja(Croker c){
		Crokevo i=null;
		if(c!=null){
			if(c.getClass()==this.getClass()){
			i=(Crokevo)super.corteja(c);
			}
		}
		return(i);
	}
	
	public Croker acepta(Croker c){
		
		Croker hijo=null;
		if(this.getSexo()=='H' && c.getSexo()=='M'){
			double nuevopeso=(int)c.getPeso(), pesohijo,g, h;
			int i=0;
		
			if(nuevopeso==1){
				i=1;
			}
			if(nuevopeso==0){
				i=0;
			}
			else{do{
				if(nuevopeso%2==1){
					i++;
				}
				nuevopeso=(int)(nuevopeso/2);
			
			}while(nuevopeso>=2);
			i++;
			}
			pesohijo=i*10;
		
			if(pesohijo<peso){
				
				hijo=new Crokevo(pesohijo, getFuerza(), despensa.length);
				g=peso;
				h=g*0.4;
				peso=g-h;
				
			}
		}
		return(hijo);
	}

	public double getBolsa(){
		return(bolsa);
	}
}
