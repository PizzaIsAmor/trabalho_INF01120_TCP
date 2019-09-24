package inf01120.player;

public class Oitava {
	private static final int DEFAULT = 5;
	private static final int MAXIMO = 10;
	private static final int MINIMO = 0;
	private static int controleDeOitava = Oitava.DEFAULT;
	private int oitava;
	
	Oitava( ){
		this.oitava = Oitava.controleDeOitava;
	}
	
	public int lerOitava( ){
		return this.oitava;
	}
	
	public void aumenta( ){
		if( noIntervaloValido() )
			Oitava.controleDeOitava++;
		else
			this.reiniciaControleDeOitava();
	}
	
	public void diminui( ){
		if( noIntervaloValido() )
			Oitava.controleDeOitava--;
		else
			this.reiniciaControleDeOitava();
	}
	
	private boolean noIntervaloValido(){
		return Oitava.MINIMO < Oitava.controleDeOitava && Oitava.controleDeOitava < Oitava.MAXIMO;
	}
	
	public void reiniciaControleDeOitava( ){
		Oitava.controleDeOitava = Oitava.DEFAULT;
	}
}