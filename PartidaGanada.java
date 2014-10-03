///DNI 48724157Z RUIZ DIAZ SILVIA
public class PartidaGanada extends Exception{
	public PartidaGanada(){
	super();
	}
	
	public PartidaGanada(Ficha f){
	super(f.getColor()+"("+f.getFila()+","+f.getColumna()+")");
	}
}
