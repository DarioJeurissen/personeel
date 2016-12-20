package be.vdab.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.datasource.TestDataSourceConfig;
import be.vdab.entities.Jobtitel;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestRepositoriesConfig.class, TestDataSourceConfig.class})
@Transactional
public class JobtitelRepositoryTest {
	@Autowired
	private JobtitelRepository jobtitelRepository;
	private Jobtitel jobtitel, jobtitel2;
	
	@Before
	public void setUp(){
		jobtitel = new Jobtitel("titel");
		jobtitel2 = new Jobtitel("titel2");
	}
	@Test
	public void create() {
		jobtitelRepository.save(jobtitel);
		assertNotEquals(0, jobtitel.getId());
	}
	@Test
	public void findOne(){
		jobtitelRepository.save(jobtitel);
		assertEquals(jobtitel, jobtitelRepository.findOne(jobtitel.getId()));
	}
	@Test
	public void findAllWith1JobTitel(){
		jobtitelRepository.save(jobtitel);
		assertEquals(1, jobtitelRepository.findAll().size());
	}
	@Test
	public void findAllWith2JobTitels(){
		jobtitelRepository.save(jobtitel);
		jobtitelRepository.save(jobtitel2);
		assertEquals(2, jobtitelRepository.findAll().size());
	}
	
}