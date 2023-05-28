package ma.emsi.cine.repositories;

import ma.emsi.cine.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Categorie findCategorieByNom(String nom);
}
