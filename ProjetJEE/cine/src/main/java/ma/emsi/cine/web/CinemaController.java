package ma.emsi.cine.web;

import lombok.AllArgsConstructor;
import ma.emsi.cine.entities.Cinema;
import ma.emsi.cine.entities.Projection;
import ma.emsi.cine.entities.Salle;
import ma.emsi.cine.entities.Ville;
import ma.emsi.cine.repositories.CinemaRepository;
import ma.emsi.cine.repositories.ProjectionRepository;
import ma.emsi.cine.repositories.SalleRepository;
import ma.emsi.cine.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class CinemaController {
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private ProjectionRepository projectionRepository;
    @GetMapping("/index")
    public String cinema(Model model,
                         @RequestParam(name="ville",defaultValue="CasaBlanca") String ville,
                         @RequestParam(name = "cinema", defaultValue="0") Long cinema){
        List<Ville> villes = villeRepository.findAll();
        Ville v = villeRepository.findVilleByNom(ville);
        List<Cinema> cinemas = cinemaRepository.findCinemasByVille(v);
        Optional<Cinema> c= cinemaRepository.findById(cinema);
        List<Salle> salles = salleRepository.findSallesByCinema(c);
        List<Projection> projections = projectionRepository.findAll();
        model.addAttribute("ville",ville);
        model.addAttribute("cinema",cinema);
        model.addAttribute("villes",villes);
        model.addAttribute("cinemas",cinemas);
        model.addAttribute("salles",salles);
        model.addAttribute("projections",projections);
        return "cinema";
    }

    @GetMapping("/")
    public String Home(){
        return "redirect:/index";
    }
   /* @GetMapping(path = "/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name="id")Long id) throws Exception{
        Film f=filmRepository.findById(id).get();
        String photoName = f.getPhoto();
        File file = new File(System.getProperty("user.home")+"/Desktop/ProjetJEE/films/"+photoName);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }*/


    /*@PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){
        List<Ticket> listTickets = new ArrayList<>();
        ticketForm.getTickets().forEach(id->{
            Ticket ticket=ticketRepository.findById(id).get();
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setReserve(true);
            ticket.setCodePayment(ticketForm.getCodePayment());
            ticketRepository.save(ticket);
            listTickets.add(ticket);
        });
        return listTickets;
    }*/
}
