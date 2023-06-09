package ma.emsi.cine.repositories;

import ma.emsi.cine.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Long> {
}
