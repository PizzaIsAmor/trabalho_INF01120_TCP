package inf01120.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ActionListenerAbrir implements ActionListener {
	private JTextArea texto;
	
	ActionListenerAbrir(JTextArea umTexto){
		this.texto = umTexto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			JFileChooser chooser = new JFileChooser("/caelum/cursos/16");
		    int retorno = chooser.showOpenDialog(null);
		    
		    chooser.setFileFilter(new FileNameExtensionFilter("Apenas txt", "txt"));
		    
		    if (retorno == JFileChooser.APPROVE_OPTION) {
		        FileReader reader = new FileReader(chooser.getSelectedFile());
		        
		        texto.setText( Arquivos.lerTXT(reader) );
		    }
		    
		}
		catch(FileNotFoundException exception){
			System.out.println("ERRO");
		}
	}
}