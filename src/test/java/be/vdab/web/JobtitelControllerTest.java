package be.vdab.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import be.vdab.entities.Jobtitel;
import be.vdab.services.JobtitelService;

public class JobtitelControllerTest {
	private JobtitelService jobtitelService;
	private JobtitelController jobtitelController;
	private Jobtitel jobtitel;

	@Before
	public void setUp() {
		jobtitel = new Jobtitel();
		jobtitelService = mock(JobtitelService.class);
		when(jobtitelService.findOne(1L)).thenReturn(Optional.of(jobtitel));
		jobtitelController = new JobtitelController(jobtitelService);
	}
	
	@Test
	public void readActiveertJuisteView() {
		assertEquals("jobtitels", jobtitelController.read("1").getViewName());
	}
	@Test
	public void readMetBestaandeIDGeeftJobtitelTerug() {
		assertSame(jobtitel,
				jobtitelController.read("1").getModelMap().get("jobtitel"));
	}
	@Test
	public void readMetOnbestaandeIDReturnsNull() {
		assertEquals(null, jobtitelController.read("666").getModelMap().get("jobtitel"));
	}
}