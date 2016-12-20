package be.vdab.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class JobtitelTest {
	private Jobtitel jobtitel;
	private Jobtitel jobtitel2;

	@Before
	public void before() {
		jobtitel = new Jobtitel();
		jobtitel2 = new Jobtitel("dummy");
	}

	@Test
	public void maakEenJobTitel() {
		assertEquals(jobtitel, new Jobtitel());
	}
	@Test
	public void maakEenJobTitelMetNaam() {
		assertEquals(new Jobtitel("dummy"), jobtitel2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void maakEenJobTitelMetNullNaam() {
		assertEquals(new Jobtitel(null), jobtitel2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void maakEenJobTitelMetEmptyNaam() {
		assertEquals(new Jobtitel(""), jobtitel2);
	}
	@Test
	public void getNaamReturnedCorrecteNaam(){
		assertEquals("dummy", jobtitel2.getNaam());
	}
}
