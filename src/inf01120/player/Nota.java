package inf01120.player;

public abstract class Nota extends ItemMusical implements ComportamentoNota {
	private int oitava;
	
	Nota( ){
		super( true );
		this.oitava = new Oitava( ).lerOitava( );
	}
	
	public abstract String lerNota( );	
	
	public String lerOitava( ){
		return Integer.toString( this.oitava );
	}
}
