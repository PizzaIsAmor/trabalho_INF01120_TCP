package inf01120.player;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class InstrumentoTest {
	private static final String _CODIGO_HARPSICHORD_ = "I6";
	private static final String _CODIGO_TUBULARBELLS_ = "I14";
	private static final String _CODIGO_PANFLUTE_ = "I75";
	private static final String _CODIGO_CHURCHORGAN_ = "I19";
	private static final String _DEFAULT_ = "I0";
	private Instrumento umInstrumento;
	
	@Before
	public void setUp() throws Exception {
		umInstrumento = new Instrumento();
	}

	@Test
	public void testeValorInicial() {
		assertEquals(_DEFAULT_, umInstrumento.lerInstrumento());
	}
	
	@Test
	public void testeTrocaInstrumentoDigito9() {
		umInstrumento.novoInstrumento( 9 );
		
		assertEquals("I9", umInstrumento.lerInstrumento());
	}
	
	@Test
	public void testeTrocaInstrumentoSucessivo() {
		Random numeroAleatorio = new Random();
		int primeiraTroca = numeroAleatorio.nextInt(10);
		int segundaTroca = numeroAleatorio.nextInt(10);
		
		umInstrumento.novoInstrumento( primeiraTroca );
		umInstrumento.novoInstrumento( segundaTroca );		
		
		assertEquals("I" + (primeiraTroca + segundaTroca), umInstrumento.lerInstrumento());
	}
	
	@Test
	public void testeReinicia() {
		umInstrumento.novoInstrumento( 128 );
		assertEquals("I0", umInstrumento.lerInstrumento());
	}
	
	@Test
	public void testeHarpsichord() {
		umInstrumento.setHarpsichord();
		
		assertEquals(_CODIGO_HARPSICHORD_, umInstrumento.lerInstrumento());
	}
	
	@Test
	public void testeTubularBells() {
		umInstrumento.setTubularBells();
		
		assertEquals(_CODIGO_TUBULARBELLS_, umInstrumento.lerInstrumento());
	}
	
	@Test
	public void testePanFlute() {
		umInstrumento.setPanFlute();
		
		assertEquals(_CODIGO_PANFLUTE_, umInstrumento.lerInstrumento());
	}
	
	@Test
	public void testeChurchOrgan() {
		umInstrumento.setChurchOrgan();
		
		assertEquals(_CODIGO_CHURCHORGAN_, umInstrumento.lerInstrumento());
	}
}
