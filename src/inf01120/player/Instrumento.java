package inf01120.player;

public class Instrumento {
	private static final int DEFAULT = 0;
	private static final int ULTIMO_INSTRUMENTO_VALIDO = 127;
	private static final int QUANTIDADE_DE_INSTRUMENTOS = Instrumento.ULTIMO_INSTRUMENTO_VALIDO + 1;
	private static final char COMANDO_JFUGUE = 'I';
	private static final int CODIGO_HARPSICHORD = 6;
	private static final int CODIGO_TUBULARBELLS = 14;
	private static final int CODIGO_PANFLUTE = 75;
	private static final int CODIGO_CHURCHORGAN = 19;
	private int codigoInstrumento;

	Instrumento(){
		this.codigoInstrumento = Instrumento.DEFAULT;
	}
	
	public String lerInstrumento(){
		return Instrumento.COMANDO_JFUGUE + Integer.toString(this.codigoInstrumento);
	}
	
	public void novoInstrumento (int intervalo) {
		this.codigoInstrumento += intervalo;
		
		if( this.foraDoIntervaloValido() )
			this.reiniciaCodigoInstrumento();
	}
	
	public void setHarpsichord(){
		this.codigoInstrumento = Instrumento.CODIGO_HARPSICHORD;
	}
	
	public void setTubularBells(){
		this.codigoInstrumento = Instrumento.CODIGO_TUBULARBELLS;
	}
	
	public void setPanFlute(){
		this.codigoInstrumento = Instrumento.CODIGO_PANFLUTE;
	}
	
	public void setChurchOrgan(){
		this.codigoInstrumento = Instrumento.CODIGO_CHURCHORGAN;
	}
	
	private void reiniciaCodigoInstrumento() {
		this.codigoInstrumento -= (Instrumento.QUANTIDADE_DE_INSTRUMENTOS);
	}

	private boolean foraDoIntervaloValido() {
		return Instrumento.ULTIMO_INSTRUMENTO_VALIDO < this.codigoInstrumento;
	}
}