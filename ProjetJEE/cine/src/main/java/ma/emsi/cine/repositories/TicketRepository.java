package ma.emsi.cine.repositories;

import ma.emsi.cine.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
