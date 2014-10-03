
public class Kupolo {
	private Evo[][] gradas;
	private double caja;
	
	public Kupolo(int a,int b,double c){
		if(a<=0){
			a=2;
		}
		if(b<=0){
			b=2;
		}
		gradas=new Evo[a][b];
		if(c<=0){
			caja=300;
		}
		if(c>0){
			caja=c;
		}
		
	}
	
	public Coordenadas busquedaSuperior(){
		Coordenadas enviar=null;
		if(gradas!=null){
		int filacentral, filas, columnas,i,j;
		boolean x=false;
		columnas=gradas[0].length;
		filas=gradas.length;
		
		filacentral=(filas/2)+(filas%2);
		for(i=filas-1;i>=(filacentral) && x==false;i--){
			for(j=0;j<columnas && x==false;j++){
				if(gradas[i][j]==null){
					x=true;
					enviar= new Coordenadas(i,j);
				}
			}
		}
		}
		return(enviar);
	}
	
	public Coordenadas busquedaInferior(){
		Coordenadas enviar=null;
		if(gradas!=null){
		int filacentral, filas, columnas,i,j;
		boolean x=false;
		columnas=gradas[0].length;
		filas=gradas.length;
		filacentral=(filas/2)+(filas%2);
		for(i=0;i<=filacentral && x==false;i++){
			for(j=0;j<columnas && x==false;j++){
				if(gradas[i][j]==null){
					x=true;
					enviar= new Coordenadas(i,j);
				}
			}
		}
		}
		return(enviar);
	}
	
	public double vendeEntrada(Evo e,Coordenadas c,double i){
		double vueltas=(-1), costeEntrada;
		if(e!=null && gradas!=null){
			
			int fil, col,ocupantes=0;
			fil=c.getX();
			col=c.getY();
			if(fil>=0 && fil<gradas.length){
				if(col>=0 && col<gradas[0].length){
				
			if(gradas[fil][col]==null && e.aCubierto()==false){
				
				ocupantes=this.getOcupantes();
				
				costeEntrada=((((double)fil)*((double)col))/((double)(ocupantes)+1));
				
				if(costeEntrada<=i){
					vueltas=i-costeEntrada;
					caja=caja+costeEntrada;
					
				}
				if(vueltas!=(-1)){
					e.sms(this);
					gradas[fil][col]=e;
				}
			}
		}}}
		return(vueltas);
	}
	
	public boolean sale(Evo e){
		boolean esta=false,muyayo=false;
		if(e!=null && gradas!=null){
		int x,y;
		
			for(x=0;x<gradas.length && esta==false;x++){
				for(y=0;y<gradas[0].length && esta==false;y++){
					if(gradas[x][y]==e){
						esta=true;
						gradas[x][y]=null;
					}
				}
			}
			if(esta==true){
			e.sms(null);
			muyayo=true;
			}
		}
		return(muyayo);
	}
	
	public void konkordo(){
		if(gradas!=null){
			int x, y,i=0,k=0;	
			double auraT=0, fuerzaT=0,auramedia=0, fuerzamedia=0, aura, fuerza, total=0;
			for(x=0;x<gradas.length;x++){
				for(y=0;y<gradas[0].length;y++){
					if(gradas[x][y]!=null){
						if(gradas[x][y] instanceof Nelfevo){
							aura=(((Nelfevo) gradas[x][y]).getAura());
							i++;
							auraT=auraT+aura;
						}
						if(gradas[x][y] instanceof Crokevo){
							fuerza=(((Crokevo) gradas[x][y]).getFuerza());
							k++;
							fuerzaT=fuerzaT+fuerza;
						}
					}
				}
			}
			if(i!=0) {
			auramedia=auraT/i;}
			if(k!=0){
			fuerzamedia=fuerzaT/k;
			}
			total=(auramedia+fuerzamedia)/3;

			if(total*(this.getOcupantes())<=caja){
				for(x=0;x<gradas.length;x++){
					for(y=0;y<gradas[0].length;y++){
						if(gradas[x][y]!=null){
							gradas[x][y].premia(total);
						}
					}
				}
				caja=caja-(total*(this.getOcupantes()));

			}
		}
	}
		
		
	public int getOcupantes(){
		int x, y, ocupantes=0;
		if(gradas!=null){
			
			for(x=0;x<gradas[0].length;x++){
				for(y=0;y<gradas.length;y++){
					if(gradas[y][x]!=null){
						ocupantes++;
					}
				}	
			}
		
		}
		return(ocupantes);
	}
}