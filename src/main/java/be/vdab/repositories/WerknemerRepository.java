package be.vdab.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Werknemer;

/**
 *
 * @author Dario.Jeurissen
 *
 */
public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
	Optional<Werknemer> findByChef(Werknemer chef);
	Optional<Werknemer> findByChefIsNull();
}
