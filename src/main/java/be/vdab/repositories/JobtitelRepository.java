package be.vdab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Jobtitel;

/**
 *
 * @author Dario.Jeurissen
 *
 */

public interface JobtitelRepository extends JpaRepository<Jobtitel, Long>{
	List<Jobtitel> findAll();
	Jobtitel findOne(Long id);
}