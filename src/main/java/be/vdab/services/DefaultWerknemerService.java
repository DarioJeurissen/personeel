package be.vdab.services;

import java.util.Optional;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.entities.Werknemer;
import be.vdab.repositories.WerknemerRepository;

/**
 *
 * @author Dario.Jeurissen
 *
 */

@ReadOnlyTransactionalService
class DefaultWerknemerService implements WerknemerService {
	private final WerknemerRepository werknemerRepository;

	DefaultWerknemerService(WerknemerRepository werknemerRepository) {
		this.werknemerRepository = werknemerRepository;
	}

	@Override
	public Optional<Werknemer> findByChef(Werknemer chef) {
		return werknemerRepository.findByChef(chef);
	}
	@Override
	public Optional<Werknemer> findByChefIsNull(){
		return werknemerRepository.findByChefIsNull();
	}

	@Override
	public Optional<Werknemer> findOne(long id) {
		return Optional.ofNullable(werknemerRepository.findOne(id));
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	@Override
	public void save(Werknemer werknemer) {
		werknemerRepository.save(werknemer);
	}
}
