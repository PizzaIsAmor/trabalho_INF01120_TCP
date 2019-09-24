package inf01120.player;

public final class Musica {
	
	private static final String DEFAULT = "";
	private static final char ESPACO = ' ';
	private static final char AUMENTO_VOLUME = 'O';
	private static final char DIMINUI_VOLUME = 'U';
	private static final char METADE_VOLUME = 'I';
	private static final char DOBRO_VOLUME = Musica.ESPACO;
	private static final int NL = 10;
	private static final char CHURCHORGAN = ',';
	private static final char PANFLUTE = ';';
	private static final char HARPSICHORD = '!';
	private static final char TUBULARBELLS = NL;
	private static final char NOTA_DO = 'C';
	private static final char NOTA_RE = 'D';
	private static final char NOTA_MI = 'E';
	private static final char NOTA_FA = 'F';
	private static final char NOTA_SOL = 'G';
	private static final char NOTA_LA = 'A';
	private static final char NOTA_SI = 'B';
	private static final char DIMINUI_OITAVA = '.';
	private static final char AUMENTA_OITAVA = '?';
	private String musica;
	
	Musica(String texto){
		this.musica = Musica.DEFAULT;
		this.decodifica( texto );
	}
	
	Musica(Musica umaMusica){
		this.musica = umaMusica.lerMusica();
	}

	public String lerMusica() {
		return  this.musica;
	}

	private void decodifica(String texto) {
		Instrumento umInstrumento = new Instrumento();
		Volume umVolume = new Volume();
		
		this.inicializaMusica(umInstrumento, umVolume);
		
		for(int i = 0; i < texto.length(); i++){
			char letraAtual = texto.charAt(i);
			
			if( this.ehNota(letraAtual) )
				decodificaNota(letraAtual);
			else if( this.ehVolume(letraAtual) )
				decodificaVolume(letraAtual, umVolume);
			else if( this.ehInstrumento(letraAtual) )
				decodificaInstrumento(letraAtual, umInstrumento);
			else if( this.ehOitava(letraAtual) )
				decodificaOitava(letraAtual);
			else
				verificaLetraAnterior(i);
			
			this.colocaEspaco();
		}
	}

	private void inicializaMusica(Instrumento umInstrumento, Volume umVolume) {
		this.musica += umInstrumento.lerInstrumento();
		this.colocaEspaco();
		this.musica += umVolume.lerVolume();
		this.colocaEspaco();
	}

	private void colocaEspaco() {
		this.musica += Musica.ESPACO;
	}

	private void verificaLetraAnterior(int i) {
		char letraAnterior = this.musica.charAt(i-1);
		
		if( ehNota(letraAnterior) )
			this.musica += letraAnterior;
		else
			this.musica = new Pausa().lerPausa();
	}

	private void decodificaOitava(char letra) {
		if(letra == Musica.AUMENTA_OITAVA)
			new Oitava().aumenta();
		else
			new Oitava().diminui();
	}

	private void decodificaInstrumento(char letra, Instrumento umInstrumento) {
		if( ehAumentaInstrumento(letra) ){
			int incremento = Character.getNumericValue(letra);
			
			umInstrumento.novoInstrumento(incremento);
		}
		else 
			switch(letra){
				case Musica.HARPSICHORD:
					umInstrumento.setHarpsichord();
					break;
				case Musica.PANFLUTE:
					umInstrumento.setPanFlute();
					break;
				case Musica.CHURCHORGAN:
					umInstrumento.setChurchOrgan();
					break;
				case Musica.TUBULARBELLS:
					umInstrumento.setTubularBells();
					break;
			}
		
		this.musica += umInstrumento.lerInstrumento();
	}

	private void decodificaVolume(char letra, Volume umVolume) {
		switch(letra){
		case Musica.AUMENTO_VOLUME:
			umVolume.aumenta();
			break;
		case Musica.DOBRO_VOLUME:
			umVolume.dobro();;
			break;
		case Musica.METADE_VOLUME:
			umVolume.metade();
			break;
		case Musica.DIMINUI_VOLUME:
			umVolume.diminui();
		}
		
		this.musica += umVolume.lerVolume();
	}

	private void decodificaNota(char letra) {
		switch(letra){
			case Musica.NOTA_LA:
				this.musica += new NotaLa().lerNota();
				break;
			case Musica.NOTA_SI:
				this.musica += new NotaSi().lerNota();
				break;
			case Musica.NOTA_DO:
				this.musica += new NotaDo().lerNota();
				break;
			case Musica.NOTA_RE:
				this.musica += new NotaRe().lerNota();
				break;
			case Musica.NOTA_MI:
				this.musica += new NotaMi().lerNota();
				break;
			case Musica.NOTA_FA:
				this.musica += new NotaFa().lerNota();
				break;
			case Musica.NOTA_SOL:
				this.musica += new NotaSol().lerNota();	
				break;
		}
	}

	private boolean ehOitava(char letra) {
		return letra == Musica.AUMENTA_OITAVA || letra == Musica.DIMINUI_OITAVA;
	}

	private boolean ehInstrumento(char letra) {
		return this.ehAumentaInstrumento(letra) || this.ehIntrumentoEspecifico(letra);
	}

	private boolean ehIntrumentoEspecifico(char letra) {
		return letra == Musica.HARPSICHORD || letra == Musica.PANFLUTE ||
			   letra == Musica.CHURCHORGAN || letra == Musica.TUBULARBELLS;
	}

	private boolean ehAumentaInstrumento(char letra) {
		return '0' <= letra && letra <= '9';
	}

	private boolean ehVolume(char letra) {
		letra = Character.toUpperCase(letra);
		
		return letra == Musica.DOBRO_VOLUME || letra == Musica.AUMENTO_VOLUME ||
			   letra == Musica.METADE_VOLUME || letra == Musica.DIMINUI_VOLUME ;
	}

	private boolean ehNota(char letra) {
		return Musica.NOTA_LA <= letra && letra <= Musica.NOTA_SOL;
	}
}