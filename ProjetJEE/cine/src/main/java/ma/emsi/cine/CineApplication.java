package ma.emsi.cine;

import ma.emsi.cine.services.ICinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CineApplication implements CommandLineRunner {
    @Autowired
    private ICinema iCinema;
    public static void main(String[] args) {
        SpringApplication.run(CineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        iCinema.initVilles();
        iCinema.initCinemas();
        iCinema.initSalles();
        iCinema.initPlaces();
        iCinema.initSeances();
        iCinema.initCategories();
        iCinema.initFilms();
        iCinema.initProjections();
        iCinema.initTickets();
    }
}