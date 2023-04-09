package ma.emsi.main;

import ma.emsi.main.entities.Student;
import ma.emsi.main.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("*** Insertion ***");
        /*studentRepository.save(
                new Student(null,"A1","Amine",new Date(),true,null));
        studentRepository.save(
                new Student(null,"A2","Ilyas",new Date(),true,null));
        studentRepository.save(
                new Student(null,"A3","Saad",new Date(),false,null));
        studentRepository.save(
                new Student(null,"A4","Arij",new Date(),true,null));
        studentRepository.save(
                new Student(null,"A5","Lina",new Date(),false,null));

        System.out.println("*** Inserted rows ***");
        System.out.println("Count :"+ studentRepository.count());

        System.out.println("*** Display rows ***");
        List<Student> students = studentRepository.findAll();
        students.forEach(student -> {
            System.out.println(student.toString());
        });

        System.out.println("*** Get Element By Id ***");
        Student student=studentRepository.findById(3).orElse(null);
        System.out.println(student.toString());

        System.out.println("*** Update an Element");
        student.setRegistrationNumber("S3");
        studentRepository.save(student);

        System.out.println("*** Delete an Element ***");
        studentRepository.delete(student);
        System.out.println(studentRepository.count());

        studentRepository.deleteById(5);
        System.out.println(studentRepository.count());

        System.out.println("*** Select active students ***");
        List<Student> activeStudents=studentRepository. findByStillActive(true);
        activeStudents.forEach(s -> {
            System.out.println(s.toString());
        });*/
    }
}
