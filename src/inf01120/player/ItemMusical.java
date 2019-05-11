package inf01120.player;

public abstract class ItemMusical {
	private boolean ehUmaNota;
	
	ItemMusical(boolean ehNota){
		this.ehUmaNota = ehNota;
	}
	
	public boolean ehNota( ){
		return this.ehUmaNota;
	}
	
	public boolean ehParametro( ){
		return !this.ehUmaNota;
	}
}
