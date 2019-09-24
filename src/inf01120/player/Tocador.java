package inf01120.player;

import org.jfugue.player.Player;

public class Tocador {
	private Musica musica;
	
	Tocador(Musica umaMusica){
		this.musica = umaMusica;
	}
	
	Tocador(String umTexto){
		this.musica = new Musica(umTexto);
	}
	
	public void play(){
		Player umPlayer = new Player();
				
		umPlayer.play( this.musica.lerMusica() );
	}
}