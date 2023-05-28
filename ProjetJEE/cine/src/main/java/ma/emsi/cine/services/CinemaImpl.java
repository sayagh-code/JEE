package ma.emsi.cine.services;

import jakarta.transaction.Transactional;
import ma.emsi.cine.entities.*;
import ma.emsi.cine.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaImpl implements ICinema{
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ProjectionRepository projectionRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void initVilles() {
        Stream.of("CasaBlanca","Rabat","Marrakech","Tanger").forEach(nomVille->{
            Ville ville = new Ville();
            ville.setNom(nomVille);
            villeRepository.save(ville);
        });
    }


    @Override
    public void initCinemas() {
        Ville v=villeRepository.findVilleByNom("CasaBlanca");
        cinemaRepository.save(new Cinema(null,"IMAX",3,null,v));
        cinemaRepository.save(new Cinema(null,"MegaRama",5,null,v));
        v=villeRepository.findVilleByNom("Rabat");
        cinemaRepository.save(new Cinema(null,"Renaissance",4,null,v));
        cinemaRepository.save(new Cinema(null,"Fayrouz",2,null,v));
        v=villeRepository.findVilleByNom("Marrakech");
        cinemaRepository.save(new Cinema(null,"MegaRama",3,null,v));
        cinemaRepository.save(new Cinema(null,"Leila Alaoui",1,null,v));
        v=villeRepository.findVilleByNom("Tanger");
        cinemaRepository.save(new Cinema(null,"Rif",1,null,v));
    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll().forEach(cinema -> {
            for(int i=0;i<cinema.getNombreSalles();i++){
                salleRepository.save(new Salle(null,"salle "+(i+1),20,cinema,null,null));
            }
        });
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(salle -> {
            for (int i = 0; i < salle.getNombrePlace(); i++) {
                placeRepository.save(new Place(null,i,salle,null));
            }
        });
    }

    @Override
    public void initSeances() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s -> {
            try {
                seanceRepository.save(new Seance(null,dateFormat.parse(s)));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Action","Drama","Science Fiction").forEach(cat->{
            categorieRepository.save(new Categorie(null,cat,null));
        });
    }

    @Override
    public void initFilms() {
        Categorie categorie=categorieRepository.findCategorieByNom("Science Fiction");
        filmRepository.save(new Film(null,"Avatar","avatar.jpg",null,categorie));
        filmRepository.save(new Film(null,"Starwars","starwars.jpg",null,categorie));
        categorie=categorieRepository.findCategorieByNom("Action");
        filmRepository.save(new Film(null,"Avengers Endgame","endgame.jpg",null,categorie));
        filmRepository.save(new Film(null,"Avengers Infinity War","infinityWar.jpg",null,categorie));
        categorie=categorieRepository.findCategorieByNom("Drama");
        filmRepository.save(new Film(null,"Titanic","titanic.jpg",null,categorie));
    }

    @Override
    public void initProjections() {
        villeRepository.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    filmRepository.findAll().forEach(film -> {
                        seanceRepository.findAll().forEach(seance -> {
                        projectionRepository.save(new Projection(null,new Date(),70,salle,film,null,seance));
                        });
                    });
                });
            });
        });
    }

    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(p->{
            p.getSalle().getPlaces().forEach(place -> {
                Ticket ticket = new Ticket();
                ticket.setPrix(p.getPrix());
                ticket.setReserve(false);
                ticket.setPlace(place);
                ticket.setProjection(p);
                ticketRepository.save(ticket);
            });
        });
    }
}
