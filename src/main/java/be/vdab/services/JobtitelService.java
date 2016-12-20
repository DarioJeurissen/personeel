package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Jobtitel;

/**
 *
 * @author Dario.Jeurissen
 *
 */

public interface JobtitelService {
	List<Jobtitel> findAll();
	Optional<Jobtitel> findOne(long id);
}
