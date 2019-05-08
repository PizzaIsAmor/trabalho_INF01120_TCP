package inf01120.player;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class MyApp {

	
	
	
	 public static void main(String[] args) 
	 
	 {
		 Player player = new Player();
		 Pattern pattern = new Pattern("V0 I1 :CON(7, 50) C D E F G A B :CON(7, -1) C D E F G A B :CON(7,127) C D E F G A B");
		 player.play(pattern);
		 System.exit(0); // If using Java 1.4 or lower
	 }
}
