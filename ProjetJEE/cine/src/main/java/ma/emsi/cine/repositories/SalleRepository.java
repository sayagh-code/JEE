package ma.emsi.cine.repositories;

import ma.emsi.cine.entities.Cinema;
import ma.emsi.cine.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle,Long> {
    List<Salle> findSallesByCinema(Optional<Cinema> cinema);
}
