package test;

import controller.GestioneTurniCaritas;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestModificaTurno {
	
	private GestioneTurniCaritas gestioneTurni;
	
	public TestModificaTurno() {
		gestioneTurni = new GestioneTurniCaritas();
	}
	
	@Test
	public void checkModificaTurno() {
		assertEquals(false, gestioneTurni.modificaTurno(11,"test", 17));
		
	}
}
