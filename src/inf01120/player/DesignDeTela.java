package inf01120.player;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class DesignDeTela {
	private JTextArea guardaTexto = this.addTexto( );
	
	private JMenuItem addMenuItem( String nome ) {
		return new JMenuItem( nome );
	}
	
	private JButton addBotao( String nome ) {
		return new JButton( nome );
	}
	
	private JPanel addEspacoVazio( ) {
		return new JPanel( );
	}
	
	@SuppressWarnings("unused")
	private JLabel addLabel( String nome ) {
		return new JLabel( nome );
	}
	
	private JTextArea addTexto( ) {
		return new JTextArea( );
	}
	
	private JPanel addAreaTexto( ) {
		JPanel novaTab = new JPanel( new BorderLayout(3, 3) ); 
		
		novaTab.add(this.guardaTexto, BorderLayout.CENTER);
		novaTab.add(this.addEspacoVazio( ), BorderLayout.NORTH);
		novaTab.add(this.addEspacoVazio( ), BorderLayout.SOUTH);
		novaTab.add(this.addEspacoVazio( ), BorderLayout.EAST);
		novaTab.add(this.addEspacoVazio( ), BorderLayout.WEST);
		
		return novaTab;
	}
	
	private JMenu addMenu(	String categoria, List<String> itens ){
		JMenu categoriaMenu = new JMenu( categoria );
		
		if(itens!= null) {
			for(String item : itens){
				categoriaMenu.add( this.addMenuItem( item ) );
			}
		}
		
		return categoriaMenu;
	}
	
	private JMenu menuConfiguracao( ) {
		List<String> menuItens= Arrays.asList(DadosInterface.MENU_CONFIG_BPM, DadosInterface.MENU_CONFIG_OITAVA, DadosInterface.MENU_CONFIG_VOLUME);

		return this.addMenu( DadosInterface.MENU_CONFIG, menuItens );
	}

	private JMenu menuArquivo( ) {
		List<String> menuItens= Arrays.asList(DadosInterface.MENU_ARQUIVO_ABRIR, DadosInterface.MENU_ARQUIVO_SALVAR);

		return this.addMenu( DadosInterface.MENU_ARQUIVO, menuItens );
	}
	
	private JMenu menuAjuda( ) {
		return this.addMenu( DadosInterface.MENU_AJUDA, null);
	}
	
	private JMenu menuViews( ) {
		List<String> menuItens= Arrays.asList(DadosInterface.MENU_VIEWS_NOVA_ABA);

		return this.addMenu( DadosInterface.MENU_VIEWS, menuItens );
	}
	
	public JMenuBar constroiBarraMenu( ) {
		JMenuBar barraMenu = new JMenuBar( );
		
		barraMenu.add( this.menuArquivo( ) );
		barraMenu.add( this.menuViews( ) );
		barraMenu.add( this.menuConfiguracao( ) );
		barraMenu.add( this.menuAjuda( ) );
		
		return barraMenu;
	}

	public Component constroiBotoes() {
		Container botoes = new JPanel( new GridLayout(0, 4, 5, 10) );
		
		JButton play = this.addBotao( DadosInterface.BOTAO_PLAY);
		play.addActionListener( new ActionListenerTocador(this.guardaTexto)	);
		
		JButton abrir = this.addBotao( DadosInterface.BOTAO_ARQUIVO);
		abrir.addActionListener( new ActionListenerAbrir(this.guardaTexto) );
		
		JButton salvar = this.addBotao( DadosInterface.BOTAO_SALVAR);
		salvar.addActionListener( new ActionListenerSalvar(this.guardaTexto) );
		
		botoes.add( abrir, 0, 0);
		botoes.add( this.addEspacoVazio( ), 0, 1);
		botoes.add( salvar, 0, 2);
		botoes.add( play, 0, 3);
		
		return botoes;
	}

	public Component constroiAreaTexto( ) {
		JTabbedPane abas = new JTabbedPane();
		
		abas.add("Area de Texto 1", this.addAreaTexto( ));
		
		return abas;
	}
}