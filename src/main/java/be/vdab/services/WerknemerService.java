package be.vdab.services;

import java.util.Optional;

import be.vdab.entities.Werknemer;

/**
 *
 * @author Dario.Jeurissen
 *
 */
public interface WerknemerService {
	Optional<Werknemer> findByChef(Werknemer chef);
	Optional<Werknemer> findByChefIsNull();
	Optional<Werknemer> findOne(long id);
	void save(Werknemer werknemer);
}
