package yps.systems.ai.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yps.systems.ai.model.Session;

import java.util.UUID;

@Repository
public interface ISessionRepository extends CrudRepository<Session, UUID> {
}
