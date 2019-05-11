package inf01120.player;

public class Oitava {
	private static final int DEFAULT = 5;
	private static final int MAXIMO = 10;
	private static final int MINIMO = 0;
	private static int oitavaAtual = Oitava.DEFAULT;
	
	Oitava( ){}
	
	public int lerOitava( ){
		return Oitava.oitavaAtual;
	}
	
	public int aumentaOitava( ){
		if(Oitava.oitavaAtual <= Oitava.MAXIMO){
			Oitava.oitavaAtual++;
		}
		
		return Oitava.oitavaAtual;
	}
	
	public int diminuiOitava( ){
		if(Oitava.oitavaAtual >= Oitava.MINIMO){
			Oitava.oitavaAtual--;
		}
		
		return Oitava.oitavaAtual;
	}
	
	public int reiniciaOitava( ){
		Oitava.oitavaAtual = Oitava.DEFAULT;

		return Oitava.oitavaAtual;
	}
}
