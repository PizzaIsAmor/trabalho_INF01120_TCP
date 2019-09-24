package inf01120.player;

public class NotaMi extends Nota{
	
	private char note = 'E';
	
	// Construtor e metodos
	public NotaMi() {
		super();
	}
	
	public String lerNota() {
		return note + super.lerOitava();
	}
}
