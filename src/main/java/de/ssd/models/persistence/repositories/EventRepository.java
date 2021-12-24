package de.ssd.models.persistence.repositories;

import de.ssd.models.persistence.EventEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EventRepository extends CrudRepository<EventEntity, Long> {
    Collection<EventEntity> findAllByContext(String context);
}
