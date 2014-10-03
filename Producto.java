//DNI 74390471 SEMPERE MANAS, JONATAN

public class Producto {

	private String nombre;
	private int valor;

	public Producto(String s){
		if(s!=null){
			nombre=new String(s);
			valor=0;
		}
	}
	
	public Producto(String n,int v){
		if(n!=null){
			nombre=new String(n);
			valor=v;
		}
	}
	
	public void calculaValor(String s){
		if(s==null){
			s="";
		}
		valor=Math.abs(s.compareTo(nombre));
	}
	public void veInfo(){
		System.out.println(nombre+" "+valor);
	}
	
	public String getNombre(){
		return(nombre);
	}
	
	public int getValor(){
		return(valor);
	}
	
	
}
