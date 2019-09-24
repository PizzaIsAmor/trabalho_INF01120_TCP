package inf01120.player;

public class NotaRe extends Nota{
	
	private char note = 'D';
	
	// Construtor e metodos
	public NotaRe() {
		super();
	}
	
	public String lerNota() {
		return note + super.lerOitava();
	}
}