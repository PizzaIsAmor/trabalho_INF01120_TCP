package inf01120.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VolumeTest {
	
	private static final int _DEFAULT_ = 22;
	private static final int _VOLUME_MAXIMO_ = 127;
	private static final int _VOLUME_MINIMO_ = 0;
	private Volume umVolume;
	
	@Before
	public void setUp() throws Exception {
		umVolume = new Volume();
	}

	@Test
	public void testDobraVolume() {
		umVolume.dobro();
		
		assertEquals(":CON(7," + (_DEFAULT_*2) + ")", umVolume.lerVolume());
	}
	
	@Test
	public void testaAumento() {
		umVolume.aumenta();
		
		assertEquals(":CON(7," + 24 + ")", umVolume.lerVolume());
	}
	
	@Test
	public void testaAumentoSucessivo() {
		umVolume.aumenta();
		umVolume.aumenta();
		umVolume.aumenta();
		umVolume.aumenta();
		umVolume.aumenta();
		
		assertEquals(":CON(7," + 33 + ")", umVolume.lerVolume());
	}
	
	@Test
	public void testInicial() {
		assertEquals(":CON(7," + _DEFAULT_ + ")", umVolume.lerVolume());
	}
	
	@Test
	public void testVolumeInvalidoPorAumento() {
		umVolume.dobro();
		umVolume.dobro();
		umVolume.dobro();
		
		assertEquals(":CON(7," + _VOLUME_MAXIMO_ + ")", umVolume.lerVolume());
	}
	
	@Test
	public void testaVolumeInvalidoPorDecremento() {
		umVolume.metade();
		umVolume.metade();
		umVolume.metade();
		umVolume.metade();
		umVolume.metade();
		umVolume.metade();
		
		assertEquals(":CON(7," + _VOLUME_MINIMO_ + ")", umVolume.lerVolume());
	}
}
