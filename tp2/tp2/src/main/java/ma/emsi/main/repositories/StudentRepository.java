package ma.emsi.main.repositories;

import jakarta.transaction.Transactional;
import ma.emsi.main.entities.Student;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByRegistrationNumber(String registrationNumber);
    List<Student> findByStillActive(boolean stillActive);
    List<Student> findByBirthday(Date birthday);
    List<Student> findByFullName(String fullName);
    List<Student> findByLastConnection(Date lastConnection);

    List<Student> deleteByFullName(String ls);
    long deleteByStillActive(boolean stillActive);
}
