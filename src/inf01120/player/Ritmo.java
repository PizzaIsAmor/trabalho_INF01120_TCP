package inf01120.player;

public class Ritmo {
	private static final String COMANDO_DE_BPM = "T";
	private static final int MAXIMO = 220;
	private static final int MINIMO = 40;
	private static final int DEFAULT = 120;
	private static final int INCREMENTO = 50;
	private int bpm;
	
	Ritmo(){
		this.bpm = Ritmo.DEFAULT;
	}
	
	public String lerRitmo(){
		return Ritmo.COMANDO_DE_BPM + this.bpm;
	}
	
	public void aumenta(){
		this.bpm += Ritmo.INCREMENTO;
		
		if( ehIntervaloNaoValido() )
			this.bpm = Ritmo.MAXIMO;
	}
	
	public void diminui(){
		this.bpm -= Ritmo.INCREMENTO;

		if( ehIntervaloNaoValido() )
			this.bpm = Ritmo.MINIMO;
	}
	
	private boolean ehIntervaloNaoValido(){
		return this.bpm < Ritmo.MINIMO || Ritmo.MAXIMO < this.bpm;
	}
}