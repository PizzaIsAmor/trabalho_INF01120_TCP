package inf01120.player;

public class NotaDo extends Nota {
	
	NotaDo( ){
		super( );
	}
	
	public String lerNota( ){
		return 'C' + super.lerOitava( );
	}
}
