package inf01120.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class ActionListenerTocador implements ActionListener {
	private JTextArea texto;
	
	ActionListenerTocador(JTextArea umTexto){
		this.texto = umTexto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Tocador umTocador = new Tocador(texto.getText());
		
		umTocador.play();
	}
}
