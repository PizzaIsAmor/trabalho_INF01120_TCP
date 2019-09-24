package inf01120.player;

public class NotaSol extends Nota{
	
	private char note = 'G';
	
	// Construtor e metodos
	public NotaSol() {
		super();
	}
	
	public String lerNota() {
		return note + super.lerOitava();
	}
}
