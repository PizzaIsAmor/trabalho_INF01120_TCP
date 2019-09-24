package inf01120.player;

public class Volume {
	private static final int MAXIMO = 127;
	private static final int MINIMO = 0;
	private static final int DEFAULT = 40;
	private int volume;
	
	Volume(){
		this.volume = Volume.DEFAULT;
	}
	
	public void dobro() {	
		this.volume*= 2;
		
		if (ehVolumeInvalido())
			this.volume = Volume.MAXIMO;
	}
	
	public void metade() {	
		this.volume = (int) volume / 2;
		
		if (ehVolumeInvalido())
			this.volume = Volume.MAXIMO;
	}
	
	public void aumenta() {
		this.volume += (int) this.volume*0.10;
		
		if (ehVolumeInvalido())
			this.volume = Volume.MAXIMO;
	}
	
	public void diminui() {
		this.volume -= (int) this.volume*0.10;
		
		if (ehVolumeInvalido())
			this.volume = Volume.MINIMO;
	}
	
	public String lerVolume() {
		return ":CON(7," + this.volume + ")";
	}
	
	private boolean ehVolumeInvalido() {
		return this.volume < Volume.MINIMO || Volume.MAXIMO < this.volume;
	}
}
