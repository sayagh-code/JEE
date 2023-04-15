package ma.emsi.main.repositories;

import jakarta.transaction.Transactional;
import ma.emsi.main.entities.Groupe;
import ma.emsi.main.entities.Student;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
@Transactional
public interface GroupeRepository extends JpaRepository<Groupe,Integer>{
}
