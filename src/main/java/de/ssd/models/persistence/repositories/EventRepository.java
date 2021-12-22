package de.ssd.models.persistence.repositories;

import de.ssd.models.persistence.EventEntity;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<EventEntity, String> {
}
