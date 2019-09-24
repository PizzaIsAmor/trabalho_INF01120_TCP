package inf01120.player;

public class NotaDo extends Nota{
	
	private char note = 'C';
	
	// Construtor e metodos
	public NotaDo() {
		super();
	}
	
	public String lerNota() {
		return this.note + super.lerOitava();
	}
}