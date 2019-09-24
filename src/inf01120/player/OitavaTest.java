package inf01120.player;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OitavaTest {
	private static final int _MAX_VALUE_ = 10;
	private static final int _MIN_VALUE_ = 0;
	private static final int _DEFAULT_ = 5;
	private Oitava umaOitava;
	
	@Before
	public void setUp()throws Exception{
		umaOitava = new Oitava();
	}
	
	@After
	public void reset(){
		umaOitava.reiniciaControleDeOitava();
	}
	
	@Test
	public void testeValorInicial() {
		assertEquals(_DEFAULT_, this.umaOitava.lerOitava());
	}
	
	@Test
	public void testeAumento(){
		this.umaOitava.aumenta();
		
		Oitava novaOitava = new Oitava();
		
		assertEquals(_DEFAULT_+1, novaOitava.lerOitava());
	}
	
	@Test
	public void testeLimiteAumento(){
		this.umaOitava.aumenta();
		this.umaOitava.aumenta();
		this.umaOitava.aumenta();
		this.umaOitava.aumenta();
		this.umaOitava.aumenta();
		
		Oitava novaOitava = new Oitava();
		
		assertEquals(_MAX_VALUE_, novaOitava.lerOitava());
	}
	
	@Test
	public void testeReiniciaValorPorAumento(){
		this.umaOitava.aumenta();
		this.umaOitava.aumenta();
		this.umaOitava.aumenta();
		this.umaOitava.aumenta();
		this.umaOitava.aumenta();
		this.umaOitava.aumenta();
		
		Oitava novaOitava = new Oitava();
				
		assertEquals(_DEFAULT_, novaOitava.lerOitava());
	}
	
	@Test
	public void testeNaoAlteraNivel(){
		Oitava novaOitava = new Oitava();
		
		assertEquals(_DEFAULT_, novaOitava.lerOitava());
	}
	
	@Test
	public void testeDiminui(){
		this.umaOitava.diminui();
		
		Oitava novaOitava = new Oitava();
		
		assertEquals(_DEFAULT_-1, novaOitava.lerOitava());
	}
	
	@Test
	public void testeLimiteDiminui(){
		this.umaOitava.diminui();
		this.umaOitava.diminui();
		this.umaOitava.diminui();
		this.umaOitava.diminui();
		this.umaOitava.diminui();
		
		Oitava novaOitava = new Oitava();
		
		assertEquals(_MIN_VALUE_, novaOitava.lerOitava());
	}
	
	@Test
	public void testeReiniciaValorPorDiminuicao(){
		this.umaOitava.diminui();
		this.umaOitava.diminui();
		this.umaOitava.diminui();
		this.umaOitava.diminui();
		this.umaOitava.diminui();
		this.umaOitava.diminui();
		
		Oitava novaOitava = new Oitava();
		
		assertEquals(_DEFAULT_, novaOitava.lerOitava());
	}
	
	@Test
	public void testeReinicia(){
		this.umaOitava.aumenta();
		this.umaOitava.reiniciaControleDeOitava();
		
		Oitava novaOitava = new Oitava();
		
		assertEquals(_DEFAULT_, novaOitava.lerOitava());
	}
}