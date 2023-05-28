package ma.emsi.cine.repositories;

import ma.emsi.cine.entities.Cinema;
import ma.emsi.cine.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    List<Cinema> findCinemasByVille(Ville ville);

}
