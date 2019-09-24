package inf01120.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RitmoTest {
	private static final String _DEFAULT_ = "T120";
	private Ritmo umRitmo;
	@Before
	public void setUp() throws Exception {
		umRitmo = new Ritmo();
	}

	@Test
	public void testDefault() {
		assertEquals(_DEFAULT_, umRitmo.lerRitmo());
	}

	@Test
	public void testAumenta() {
		umRitmo.aumenta();
		
		assertEquals("T170", umRitmo.lerRitmo());
	}
	
	@Test
	public void testDiminui() {
		umRitmo.diminui();

		assertEquals("T70", umRitmo.lerRitmo());
	}
	
	@Test
	public void testehValidoAumentando() {
		umRitmo.aumenta();
		umRitmo.aumenta();
		
		assertEquals("T220", umRitmo.lerRitmo());
	}
	
	@Test
	public void testehValidoDiminuindo() {
		umRitmo.diminui();
		umRitmo.diminui();
		
		assertEquals("T40", umRitmo.lerRitmo());
	}
}
