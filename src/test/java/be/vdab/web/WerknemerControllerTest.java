package be.vdab.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import be.vdab.entities.Werknemer;
import be.vdab.services.WerknemerService;

public class WerknemerControllerTest {
	private WerknemerService werknemerService;
	private WerknemerController werknemerController;
	private Werknemer werknemer;

	@Before
	public void setUp() {
		werknemer = new Werknemer("voornaam", "familienaam", "email@domain.com", BigDecimal.TEN);
		werknemerService = mock(WerknemerService.class);
		when(werknemerService.findOne(1L)).thenReturn(Optional.of(werknemer));
		werknemerController = new WerknemerController(werknemerService);
	}
	
	@Test
	public void readActiveertJuisteView() {
		assertEquals("hierarchie", werknemerController.read("1").getViewName());
	}
	@Test
	public void readMetBestaandeIDGeeftFiliaalTerug() {
		assertSame(werknemer,
			werknemerController.read("1").getModelMap().get("werknemer"));
	}
	@Test()
	public void readMetOnbestaandeIDGeeftNull() {
		assertEquals(null, werknemerController.read("666").getModelMap().get("werknemer"));
	}
}