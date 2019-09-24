package inf01120.player;

public abstract class Nota {
	// Atributos
	private Oitava oitava;
	
	// Construtor e metodos
	public Nota(){
		this.oitava = new Oitava();
	}
	
	public abstract String lerNota();
	
	protected String lerOitava(){
		return Integer.toString(this.oitava.lerOitava());
	}
}