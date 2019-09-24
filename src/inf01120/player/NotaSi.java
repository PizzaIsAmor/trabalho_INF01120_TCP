package inf01120.player;

public class NotaSi extends Nota{
	
	private char note = 'B';
	
	// Construtor e metodos
	public NotaSi() {
		super();
	}
	
	public String lerNota() {
		return note + super.lerOitava();
	}
}