package inf01120.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class ActionListenerSalvar implements ActionListener {
	private JTextArea texto;
	
	ActionListenerSalvar(JTextArea umTexto){
		this.texto = umTexto;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Arquivos umArquivo = new Arquivos( "umnome" );
		
		umArquivo.salvaMIDI( this.texto.getText() );
	}
}