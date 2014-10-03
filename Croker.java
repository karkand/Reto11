//DNI 74390471 SEMPERE MANAS, JONATAN

public class Croker {
	protected double fuerza;
	protected double peso;
	protected char sexo;
	static int hembras=0;
	static int machos=0;
	
	public Croker(double a, double b){
		peso=a;
		fuerza=b;
		if(hembras<(2*machos)){
			sexo='H';
			hembras ++;
		}
		else{
			sexo='M';
			machos ++;
		}
	}
	
	public void caza(Nelfi v){
		if(v!=null){
			double t;
			t=v.extrae(this);
			fuerza=fuerza + t*0.6;
		}
	}
	
	public Croker corteja(Croker p){
		Croker nuevo=null, perraco;
		if(sexo=='M' && p!=null && p.getSexo()=='H'){
			perraco=p.acepta(this);
			if(perraco!=null){
				double j, i, pesohijo;
				int x=0,z=0;
				pesohijo=((int)perraco.getPeso());
				if(pesohijo==1){
					i=1;
				}
				else{
				for(i=(pesohijo-1);z==0 && i>0;i--){
					if(pesohijo%i==0){
						x=0;
						for(j=(i-1);x==0 && j>0;j--){
							if(i%j==0){
								x++;
							}
							if(i%j==0 && j==1 && x==1){
								z++;
								i++;
							}		
						}
					}
					
					if(i==1 && pesohijo>1){
						i=pesohijo;
					}
					
				}
				}
				nuevo=perraco;
				peso=peso-i;
				
			}
			
		}
		return(nuevo);
	}
	
	public Croker acepta(Croker p){
		Croker hijo=null;
		if(this.getSexo()=='H' && p.getSexo()=='M'){
			double nuevopeso=(int)p.getPeso(), pesohijo,g, h;
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
				
				hijo=new Croker(pesohijo, getFuerza());
				g=peso;
				h=g*0.4;
				peso=g-h;
				
			}
		}
		return(hijo);
	}
	
	public double combate(Croker p){
		double valia=0, p1, f1, p2, f2, fuerza2;
		if(p!=null){
		
		p1=peso;
		p2=p.getPeso();
		f1=fuerza;
		f2=p.getFuerza();

		
		valia=(((p2+p1)/f2)/(Math.sqrt((Math.abs(Math.pow(f2, 2)-(Math.pow(f1, 2)))))));
	
		if(f2!=f1 &&f2!=0){
		if(valia>0.2){

			fuerza=fuerza+(p.getFuerza()*0.1);
			fuerza2=p.getFuerza()-p.getFuerza()*0.1;
			p.setFuerza(fuerza2);
			
		}
		else{
			
			fuerza2=p.getFuerza()+(fuerza*0.1);
			fuerza=fuerza-(fuerza*0.1);
			p.setFuerza(fuerza2);
		}}}
		return(valia);
		
	}
	
	public double alquimia(){
		double arrosh;
		arrosh=(0.5*(Math.sqrt(((Math.pow(fuerza, 2)+16*(Math.pow(peso, 2)))))))+((Math.pow(fuerza, 2))/(8*peso))*(Math.log((((4*peso)+(Math.sqrt(Math.pow(fuerza, 2)+(16*(Math.pow(peso,2)))))))/fuerza));
		

		if(arrosh<fuerza){
			fuerza=fuerza-arrosh;
			peso=peso+arrosh;
		}
		else{
			arrosh=0;
		}
		return(arrosh);
	}
	
	public static void poblacion(){
		System.out.println("M "+machos);
		System.out.println("H "+hembras);
	}
	
	public double getFuerza(){
		return(fuerza);
	}
	
	public double getPeso(){
		return(peso);
	}
	
	public char getSexo(){
		return(sexo);
	}
	
	public void setFuerza(double f){
		fuerza=f;
	}
	
	
}
