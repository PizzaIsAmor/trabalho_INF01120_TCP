package inf01120.player;

public class NotaFa extends Nota{
	
	private char note = 'F';
	
	// Construtor e metodos
	public NotaFa() {
		super();
	}
	
	public String lerNota() {
		return note + super.lerOitava();
	}
}
