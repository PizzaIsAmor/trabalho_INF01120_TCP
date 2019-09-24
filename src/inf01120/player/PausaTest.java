package inf01120.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PausaTest {
	private static final String _COMANDO_DE_PAUSA_ = "R";
	private Pausa espera;
	
	@Before
	public void setUp() throws Exception {
		espera = new Pausa();
	}

	@Test
	public void test() {
		assertEquals(_COMANDO_DE_PAUSA_, espera.lerPausa());
	}
}