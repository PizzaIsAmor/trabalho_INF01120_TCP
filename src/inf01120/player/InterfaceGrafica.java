package inf01120.player;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;
import inf01120.player.DesignDeTela;

public class InterfaceGrafica {
	private boolean VISIVEL = true;
	private JFrame janela = new JFrame( );
	
	InterfaceGrafica() {
		super();
		this.setDefault( );
	}
	
	private void setDefault( ) {
		Container tela = janela.getContentPane( );
		DesignDeTela opcao = new DesignDeTela( );
		
		tela.setLayout( new BorderLayout(5,5) );
		tela.add(opcao.constroiBarraMenu( ), BorderLayout.NORTH);
		tela.add(opcao.constroiBotoes( ), BorderLayout.SOUTH);
		tela.add(opcao.constroiAreaTexto( ), BorderLayout.CENTER);
		
		this.setJanela( );
	}
	
	private void setJanela() {
		janela.setTitle( DadosInterface.NOME_APLICATIVO );
		janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		janela.setSize(DadosInterface.LARGURA_DEFAULT, DadosInterface.ALTURA_DEFAULT);
		janela.setVisible( VISIVEL );
	}

	/*Método que roda a aplicação */
	public static void main( String []args ){
		new InterfaceGrafica( );
	}
}