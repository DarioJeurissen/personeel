package be.vdab.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.datasource.TestDataSourceConfig;
import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestRepositoriesConfig.class, TestDataSourceConfig.class })
@Transactional
public class WerknemerRepositoryTest {
	@Autowired
	private WerknemerRepository werknemerRepository;
	@Autowired
	private JobtitelRepository jobtitelRepository;
	Werknemer werknemer;
	Jobtitel jobtitel;

	@Before
	public void setUp() {
		werknemer = new Werknemer("TestVoornaam", "Lastname", "email@gmail.com", BigDecimal.TEN);
		jobtitel = new Jobtitel("boss");
	}

	@Test
	public void create() {
		werknemerRepository.save(werknemer);
		assertNotEquals(0, werknemer.getId());
	}

	@Test
	public void findOne() {
		werknemerRepository.save(werknemer);
		assertEquals(werknemer, werknemerRepository.findOne(werknemer.getId()));
	}

	@Test
	public void findByChefidIsNull() {
		werknemer = new Werknemer("voornaam", "famnaam", "email@domain.com", BigDecimal.TEN, jobtitel);
		jobtitelRepository.save(jobtitel);
		werknemerRepository.save(werknemer);
		assertEquals(werknemer, werknemerRepository.findByChef(null).get());
	}

}