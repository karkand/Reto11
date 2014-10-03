
public class Nelfevo extends Nelfi implements Evo {
	
	private Kupolo office;
	
	public Nelfevo(double a,Producto[] b){
		super(a, b);
		office=null;
	}
	
	public boolean entra(Kupolo k){
		boolean resul=false;
	
		if(k!=null && office==null){
			Coordenadas cord;
			double vueltas;
			
			cord=k.busquedaSuperior();
			
			if(cord!=null){
			
				vueltas=k.vendeEntrada(this, cord, montante);
			
				if(vueltas!=(-1)){
					
					montante=vueltas;
					resul=true;
				}
			}
		}
		return(resul);
	}
	
	public boolean sale(Kupolo k){
		boolean x=false;
		if(office!=null && k!=null){
			x=k.sale(this);
			}
		return(x);
	}
	
	public void sms(Kupolo k){
		office=k;
		
	}
	
	public boolean aCubierto(){
		boolean x=false;
		if(office!=null){
			x=true;
		}
		return(x);
	}
	
	public void premia(double d){
		aura=aura +d;
	}
	
	public void calculaIntereses(){
		if(bienes!=null){
			int i,valorT=0, valor;
			for(i=0;i<bienes.length;i++){
				if(bienes[i]!=null){
					valor=bienes[i].getValor();
					valorT=valorT +valor;
				}
			}
			montante=montante+(valorT*0.3);
		}
		
	}
	
	public int comercia(Crokevo c){
		int t=0;
		if(c!=null && office!=null){
			if(c.estasAqui(office)==true){
				if(c.getDespensa()!=null && bienes!=null){
					int i,j;
					boolean x;
					Producto[] despensa=c.getDespensa();
					
					for(i=0; i<despensa.length;i++){
						x=false;
						if(despensa[i]!=null){
						if(aura>=despensa[i].getValor()){
							for(j=0;j<bienes.length && x==false;j++){
								
								if(bienes[j]==null){
									
									bienes[j]=despensa[i];
									aura=aura-despensa[i].getValor();
									c.cobra(despensa[i].getValor());
									despensa[i]=null;
									x=true;
									t++;
								}
							}
						}}
					}
					
				}
			}
		}
	return(t);	
	}
	
	public double extrae(Croker c){
		int i, t=0;
		if(c!=null && bienes!=null){
			for(i=0; i<bienes.length; i++){
				if(bienes[i]!=null){
					if(t==0){
						t=bienes[i].getValor();
					}
					if((bienes[i].getValor())<t){
						t=bienes[i].getValor();
					}
				}
			}
		}
		return(t*(-1));
	}
		
	

}
