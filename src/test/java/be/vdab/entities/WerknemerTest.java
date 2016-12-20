package be.vdab.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;


public class WerknemerTest {
	private Werknemer werknemer, werknemer2;

	@Before
	public void before() {
		werknemer = new Werknemer("voornaam", "familienaam", "email@domain.com", BigDecimal.TEN);
	}

	@Test
	public void maakEenWerknemer() {
		assertEquals(werknemer, new Werknemer("voornaam", "familienaam", "email@domain.com", BigDecimal.TEN));
	}

	@Test(expected = IllegalArgumentException.class)
	public void maakEenWerknemerMetNullVoornaam() {
		werknemer = new Werknemer(null, "familienaam", "user@domain.com", BigDecimal.TEN);
	}
	@Test(expected = IllegalArgumentException.class)
	public void maakEenWerknemerMetNullFamilienaam() {
		werknemer = new Werknemer("voornaam", null, "user@domain.com", BigDecimal.TEN);
	}
	@Test(expected = NullPointerException.class)
	public void maakEenWerknemerMetNullEmail() {
		werknemer = new Werknemer("voornaam", "familienaam", null, BigDecimal.TEN);
	}
	@Test(expected = NullPointerException.class)
	public void maakEenWerknemerMetNullSalaris() {
		werknemer = new Werknemer("voornaam", "familienaam", "user@domain.com", null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void maakEenWerknemerMetEmptyVoornaam() {
		werknemer = new Werknemer("", "familienaam", "user@domain.com", BigDecimal.TEN);
	}
	@Test(expected = IllegalArgumentException.class)
	public void maakEenWerknemerMetEmptyFamilienaam() {
		werknemer = new Werknemer("voornaam", "", "user@domain.com", BigDecimal.TEN);
	}
	@Test(expected = IllegalArgumentException.class)
	public void maakEenWerknemerMetEmptyEmail() {
		werknemer = new Werknemer("voornaam", "familienaam", "", BigDecimal.TEN);
	}
	@Test(expected = IllegalArgumentException.class)
	public void maakEenWerknemerMetIncorrectEmail() {
		werknemer = new Werknemer("voornaam", "familienaam", "user.domain.com", BigDecimal.TEN);
	}
	@Test(expected = IllegalArgumentException.class)
	public void maakEenWerknemerMetNegatiefSalaris() {
		werknemer = new Werknemer("voornaam", "familienaam", "user@domain.com", BigDecimal.valueOf(-50));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addSalarisMagNietKleinerDan1Zijn() {
		werknemer.addSalaris(BigDecimal.ZERO);
	}
	@Test(expected = IllegalArgumentException.class)
	public void addSalarisMagNietNegatiefZijn() {
		werknemer.addSalaris(BigDecimal.valueOf(-5));
	}
	@Test
	public void equalsWerknemersMetVerschillendeVoornamen(){
		werknemer2 = new Werknemer("changed", werknemer.getFamilienaam(), werknemer.getEmail(), werknemer.getSalaris());
		assertNotEquals(werknemer2, werknemer);
	}
	@Test
	public void equalsWerknemersMetVerschillendeFamilienaamnamen(){
		werknemer2 = new Werknemer(werknemer.getVoornaam(), "changed", werknemer.getEmail(), werknemer.getSalaris());
		assertNotEquals(werknemer2, werknemer);
	}
	@Test
	public void equalsWerknemersMetVerschillendeEmail(){
		werknemer2 = new Werknemer(werknemer.getVoornaam(), werknemer.getFamilienaam(), "other@other.com", werknemer.getSalaris());
		assertNotEquals(werknemer2, werknemer);
	}
	@Test
	public void equalsWerknemersMetVerschillendeSalarissen(){
		werknemer2 = new Werknemer(werknemer.getVoornaam(), werknemer.getFamilienaam(), werknemer.getEmail(), BigDecimal.ONE);
		assertEquals(werknemer2, werknemer);
	}
	@Test
	public void createWerknemerMetJobtitel(){
		werknemer = new Werknemer("voornaam", "familienaam", "email@im.be", BigDecimal.TEN, new Jobtitel("Nieuw"));
	}
	@Test(expected = NullPointerException.class)
	public void createWerknemerMetJobtitelNull(){
		werknemer = new Werknemer("voornaam", "familienaam", "email@im.be", BigDecimal.TEN, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void createWerknemerMetJobtitelEmpty(){
		werknemer = new Werknemer("voornaam", "familienaam", "email@im.be", BigDecimal.TEN, new Jobtitel(""));
	}
	@Test(expected = IllegalArgumentException.class)
	public void createWerknemerMetJobtitelParameterNull(){
		werknemer = new Werknemer("voornaam", "familienaam", "email@im.be", BigDecimal.TEN, new Jobtitel(null));
	}
}
