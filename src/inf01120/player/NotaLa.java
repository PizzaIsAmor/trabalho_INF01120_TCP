package inf01120.player;

public class NotaLa extends Nota{
	
	private char note = 'A';
	
	// Construtor e metodos
	public NotaLa() {
		super();
	}
	
	public String lerNota() {
		return note + super.lerOitava();
	}
}
